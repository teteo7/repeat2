package com.soomgorepeat.repeat.jpa.service;

import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.repository.BoardRepository;
import com.soomgorepeat.repeat.jpa.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class BoardService {

    BoardRepository boardRepository;
    MemberRepository memberRepository;


    public BoardService(BoardRepository boardRepository, MemberRepository memberRepository){
        this.boardRepository=boardRepository;
        this.memberRepository=memberRepository;
    }
    
    // controller로 list로 목록을 가져온후 loadBoard로 페이징 잘 적용되는지 확인 해보기
//    public Page<Board> loadBoard(Integer page){
//        if(page == null) page =1;
//        Pageable pageable = (Pageable) PageRequest.of(page - 1, 5, Sort.by(Sort.Direction.DESC, "id"));
//        Page<Board> boardPage = boardRepository.findAll(pageable);
//        return boardPage;
//    }

}
