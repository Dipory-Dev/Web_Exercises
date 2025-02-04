package com.boot.crud.model.controller;


import com.boot.crud.model.biz.CRUDDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
    @Autowired
    private final CRUDDaoImpl impl;

    public BoardController(CRUDDaoImpl impl) {
        this.impl = impl;
    }

    @GetMapping("/boards")
    public String boards(Model model) {
        model.addAttribute("boards", impl.getAll());
        return "boards";
    }
}
