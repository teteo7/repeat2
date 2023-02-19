package com.soomgorepeat.repeat.jpa.controller;

import com.soomgorepeat.repeat.jpa.entity.Board;
import com.soomgorepeat.repeat.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("board")
public class BoardController {

    BoardService boardService;

    @Autowired
    BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    @RequestMapping(value = "list", method= RequestMethod.GET)
        public String list(Model model, @RequestParam(value = "page", required=false) Integer page){

        Page<Board> pageBoards = boardService.loadBoard(page);
        List<Board> boards = pageBoards.getContent();
        List<Integer> total= new ArrayList<>();
        for (int i=1; i<pageBoards.getTotalPages()+1; i++){
            total.add(i);
        }
        model.addAttribute("board", boards);
        model.addAttribute("total", total);
        model.addAttribute("page", pageBoards.getPageable());

        return "tl/board/board";
    }

    @RequestMapping(value = "create", method= RequestMethod.GET)
        public String create(Model model){

        return "tl/board/board_create";
    }

    @RequestMapping(value = "modify", method= RequestMethod.GET)
        public String modify(Model model){

        return "tl/board/board_modify";
    }

    @RequestMapping(value = "view", method= RequestMethod.GET)
        public String view(Model model){

        return "tl/board/board_view";
    }




}
