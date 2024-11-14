package com.boot.jdbc.model.controller;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/myboard")
public class MyBoardController {

    @Autowired
    private MyBiz biz;

    @GetMapping("/list")
    public String selectList(Model model) {
        List<MyDto> res = biz.selectList();
        model.addAttribute("res", res);
        return "myboardlist";
    }

    @GetMapping("/detail")
    public String selectOne(Model model, int myno) {
        MyDto res = biz.selectOne(myno);
        model.addAttribute("res", res);

        return "myboarddetail";
    }
}
