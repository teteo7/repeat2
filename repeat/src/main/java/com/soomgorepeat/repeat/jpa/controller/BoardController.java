package com.soomgorepeat.repeat.jpa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("board")
public class BoardController {


    @RequestMapping(value = "list", method= RequestMethod.GET)
        public String list(Model model){

        return "tl/board/board";
    }



}
