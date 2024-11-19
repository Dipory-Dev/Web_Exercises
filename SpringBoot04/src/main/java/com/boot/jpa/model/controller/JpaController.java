package com.boot.jpa.model.controller;

import com.boot.jpa.model.dao.JpaDao;
import com.boot.jpa.model.entity.JpaEntity;
import oracle.jdbc.proxy.annotation.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/member")
public class JpaController {
    @Autowired
    private JpaDao dao;

    @GetMapping("/list")
    public String selectList(Model model) {
        List<JpaEntity> list = dao.findAll();
        model.addAttribute("list", list);
        System.out.println(list.size());
        return "jpalist";
    }

    @GetMapping("/insertform")
    public String insertForm() {
        return "jpainsert";
    }

    @PostMapping("/insert")
    public String insert(JpaEntity dto) {
        dto.setMydate(new Date());
        dao.save(dto);
        return "redirect:list";
    }

    @GetMapping("/detail")
    public String detail(int myno, Model model) {
        model.addAttribute("dto", dao.findByMyno(myno));
        return "jpadetail";
    }

    @GetMapping("/updateform")
    public String updateForm(int myno, Model model) {
        model.addAttribute("dto", dao.findByMyno(myno));
        return "jpaupdate";
    }

    @PostMapping("/update")
    public String update(JpaEntity dto) {
        dao.save(dto);
        return "redirect:detail?myno=" + dto.getMyno();
    }

    @GetMapping("/delete")
    public String delete(int myno) {
        dao.deleteByMyno(myno);
        return "redirect:list";
    }
}
