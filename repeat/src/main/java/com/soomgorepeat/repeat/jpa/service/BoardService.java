package com.soomgorepeat.repeat.jpa.service;

import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.entity.Member;
import com.soomgorepeat.repeat.jpa.repository.BoardRepository;
import com.soomgorepeat.repeat.jpa.repository.MemberRepository;
import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayPutAtMetaMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Service
public class BoardService {

    BoardRepository boardRepository;
    MemberRepository memberRepository;

    @Autowired
    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository){
        this.boardRepository=boardRepository;
        this.memberRepository=memberRepository;
    }
    
    // controller로 list로 목록을 가져온후 loadBoard로 페이징 잘 적용되는지 확인 해보기
    public Page<Board> loadBoard(Integer page){
        if(page == null) page =1;
        Pageable pageable = (Pageable) PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "id"));
        Page<Board> boardPage = boardRepository.findAll(pageable);
        return boardPage;
    }

    @Transactional
    public void saveBoard(Map<String, Object> data){
        Board board = new Board();
        board.setTitle(data.get("title").toString());
        board.setContent(data.get("content").toString());
        board.setDateCreated(new Date());
        Member member = memberRepository.findById(2).get();
        board.setMember(member);
        boardRepository.save(board);
    }

    @Transactional
    public Board loadOneBoard(Integer pk){
        return boardRepository.findById(pk).get();
    }

    @Transactional
    public void modifyBoard(Map<String, Object> data){
        Integer pk = Integer.parseInt(data.get("pk").toString());
        Board board= null;
        Optional<Board> optBoard = boardRepository.findById(pk);
        board = optBoard.get();
        board.setTitle(data.get("title").toString());
        board.setContent(data.get("content").toString());
        boardRepository.save(board);
    }

    @Transactional
    public void deleteBoard(Map<String, Object> data)
    {
        Integer pk = Integer.parseInt(data.get("pk").toString());
        boardRepository.deleteById(pk);
    }


}
