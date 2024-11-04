package com.mvc.prac.model.controller;

import com.mvc.prac.model.biz.BoardBiz;
import com.mvc.prac.model.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardBiz biz;

    @RequestMapping(value = "/list.do")
    public String list(Model model) {
        List<BoardDto> res = biz.selectList();
        model.addAttribute("res", res);
        return "mvclist";
    }
}
