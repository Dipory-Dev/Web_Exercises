package com.boot.jdbc.model.controller;

import com.boot.jdbc.model.biz.MyBiz;
import com.boot.jdbc.model.dto.MyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/insertform")
    public String insertForm() {
        return "myboardinsertform";
    }

    @PostMapping("insert")
    public String insert(MyDto dto) {
        int res = biz.insert(dto);
        if (res > 0) {
            return "redirect:/myboard/list";
        } else {
            return "redirect:/myboard/insertform";
        }
    }

    @GetMapping("/updateform")
    public String updateform(Model model, int myno) {
        MyDto dto = biz.selectOne(myno);
        model.addAttribute("dto", dto);
        return "myboardupdateform";
    }

    @PostMapping("/update")
    public String update(MyDto dto) {
        int res = biz.update(dto);
        if (res > 0) {
            return "redirect:/myboard/detail?myno=" + dto.getMyno();
        } else {
            return "redirect:/myboard/updateform?myno=" + dto.getMyno();
        }
    }

    @GetMapping("/delete")
    public String delete(int myno) {
        int res = biz.delete(myno);
        if (res > 0) {
            return "redirect:/myboard/list";
        } else {
            return "redirect:/myboard/detail?myno=" + myno;
        }
    }

}
