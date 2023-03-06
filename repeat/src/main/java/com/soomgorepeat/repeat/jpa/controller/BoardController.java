package com.soomgorepeat.repeat.jpa.controller;

import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.entity.Member;
import com.soomgorepeat.repeat.jpa.entity.RelUserBoardFavorite;
import com.soomgorepeat.repeat.jpa.repository.BoardRepository;
import com.soomgorepeat.repeat.jpa.repository.MemberRepository;
import com.soomgorepeat.repeat.jpa.repository.RelUserBoardFavoriteRepository;
import com.soomgorepeat.repeat.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.net.Authenticator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("board")
public class BoardController {

    BoardService boardService;
    MemberRepository memberRepository;
    BoardRepository boardRepository;
    RelUserBoardFavoriteRepository relUserBoardFavoriteRepository;

    @Autowired
    BoardController(BoardService boardService, MemberRepository memberRepository, BoardRepository boardRepository,
                    RelUserBoardFavoriteRepository relUserBoardFavoriteRepository){
        this.boardService = boardService;
        this.memberRepository = memberRepository;
        this.boardRepository = boardRepository;
        this.relUserBoardFavoriteRepository = relUserBoardFavoriteRepository;

    }
    @RequestMapping(value = "list", method= RequestMethod.GET)
        public String list(Model model, @RequestParam(value = "page", required=false) Integer page){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        Member member = memberRepository.findByName(name).get();
        List<RelUserBoardFavorite> relUserBoardFavorites = relUserBoardFavoriteRepository.findByMember(member);


        Page<Board> pageBoards = boardService.loadBoard(page);
        List<Board> boards = pageBoards.getContent();
//        List<Integer> total= new ArrayList<>();
//        for (int i=1; i<pageBoards.getTotalPages()+1; i++){
//            total.add(i);
//        }
        var pg =pageBoards.getPageable();
        Integer s3 = pageBoards.getTotalPages();

        model.addAttribute("board", boards);
        model.addAttribute("total", s3);
        model.addAttribute("page", pg);
        model.addAttribute("relUserBoardFavorites", relUserBoardFavorites);
        return "tl/board/board";
    }

    @RequestMapping(value = "create", method= RequestMethod.GET)
    public String create(Model model){

        return "tl/board/board_create";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create_post(Model model, @RequestParam Map<String, Object> data) {

        boardService.saveBoard(data);
        return "redirect:/board/list";
        //return "tl/board/board";
    }

    @RequestMapping(value = "view", method= RequestMethod.GET)
    public String view(Model model, @RequestParam(value = "pk", required = true) Integer pk){
        Board board= boardService.loadOneBoard(pk);
        model.addAttribute("board", board);

        return "tl/board/board_view";
    }

    @RequestMapping(value = "modify", method= RequestMethod.GET)
    public String modify(Model model, @RequestParam(value = "pk", required=true)Integer pk){

        Board board = boardService.loadOneBoard(pk);
        model.addAttribute("board", board);
        return "tl/board/board_modify";
    }

    @RequestMapping(value = "modify", method= RequestMethod.POST)
    public String modify(Model model, @RequestParam Map<String, Object> data){

        boardService.modifyBoard(data);
        return "redirect:/board/list";
    }

    @RequestMapping(value = "del", method = RequestMethod.POST)
    public String delete_board(Model model, @RequestParam Map<String, Object> data) {
        try {
            boardService.deleteBoard(data);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return "redirect:/board/list";
    }
// 브레이크포인트, 디버깅할때 데이터 넘겨주는 return쪽에 표시해서 값 확인하기





}
