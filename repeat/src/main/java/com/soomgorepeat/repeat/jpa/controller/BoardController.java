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
