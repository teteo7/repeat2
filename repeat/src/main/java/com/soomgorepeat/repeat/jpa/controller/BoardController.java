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
import java.util.Map;

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
//        List<Integer> total= new ArrayList<>();
//        for (int i=1; i<pageBoards.getTotalPages()+1; i++){
//            total.add(i);
//        }
        var pg =pageBoards.getPageable();
        Integer s3 = pageBoards.getTotalPages();

        model.addAttribute("board", boards);
        model.addAttribute("total", s3);
        model.addAttribute("page", pg);

        return "tl/board/board";
    }

    @RequestMapping(value = "create", method= RequestMethod.GET)
    public String create(Model model){

        return "tl/board/board_create";
    }

    @RequestMapping(value = "create", method= RequestMethod.POST)
    public String create(Model model, @RequestParam Map<String, Object> data){

        boardService.saveBoard(data);
        return "redirect:/board/list";
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

        boardService.deleteBoard(data);
        return "redirect:/board/list";
    }






}
