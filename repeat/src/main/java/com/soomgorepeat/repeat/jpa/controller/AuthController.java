package com.soomgorepeat.repeat.jpa.controller;

import com.soomgorepeat.repeat.jpa.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("auth")
public class AuthController {


    BoardService boardService;
    @Autowired
    AuthController(BoardService boardService)
    {
        this.boardService = boardService;
    }
    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    public String signin(Model model) {

        return "tl/auth/signin";
    }
}
