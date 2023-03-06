package com.soomgorepeat.repeat.jpa.service;


import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.entity.Member;
import com.soomgorepeat.repeat.jpa.repository.BoardRepository;
import com.soomgorepeat.repeat.jpa.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class MemberService implements UserDetailsService {
    // javascript
    // 네트워크
    // 보안
    // 서버
    // 백엔드
    // db
    BoardRepository boardRepository;
    MemberRepository memberRepository;

    @Autowired
    public MemberService(BoardRepository boardRepository, MemberRepository memberRepository)
    {
        this.boardRepository = boardRepository;
        this.memberRepository = memberRepository;
    }
    public Page<Board> loadBoard(Integer page)
    {
        if (page == null) page = 1;
        Pageable pageable = (Pageable) PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "id"));
        Page<Board> boardPage = boardRepository.findAll(pageable);
        return boardPage;
    }

    @Transactional
    public void saveBoard(Map<String, Object> data)
    {
        // input 의 name 부분이 key / 입력한 값이 value
        Board board = new Board();
        board.setTitle(data.get("title").toString());
        board.setContent(data.get("content").toString());
        board.setDateCreated(new Date());
        Member member = memberRepository.findById(1).get();
        board.setMember(member);
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Map<String, Object> data)
    {
        Integer pk = Integer.parseInt(data.get("pk").toString());
        boardRepository.deleteById(pk);
    }

    @Transactional
    public Board loadOneBoard(Integer pk)
    {
        return boardRepository.findById(pk).get();
    }

    @Transactional
    public void modifyBoard(Map<String, Object> data)
    {
        // input 의 name 부분이 key / 입력한 값이 value
        Integer pk = Integer.parseInt(data.get("pk").toString());
        Board board = null;
        Optional<Board> optBoard = boardRepository.findById(pk);
        board = optBoard.get();
        board.setTitle(data.get("title").toString());
        board.setContent(data.get("content").toString());
        boardRepository.save(board);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Member> userEntityWrappers = memberRepository.findByName(name);
        if (userEntityWrappers.isEmpty())
        {
            throw new UsernameNotFoundException("No user");
        }
        Member memberEntityWrapper = userEntityWrappers.get();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("COMMON"));
        return new User(memberEntityWrapper.getName(), memberEntityWrapper.getPassword(), authorities);
    }

}
