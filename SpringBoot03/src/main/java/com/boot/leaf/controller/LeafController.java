package com.boot.leaf.controller;

import com.boot.leaf.dto.LeafDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LeafController {

    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("hello mapping");
        model.addAttribute("name", "Thymeleaf");
        return "hello";
    }

    @GetMapping("/util")
    public String util() {
        return "utility";
    }

    @GetMapping("/expr")
    public String expression(Model model) {
        model.addAttribute("name", "Thymeleaf");
        model.addAttribute("dto", new LeafDto("Java", 22));

        List<LeafDto> list = new ArrayList<>();
        list.add(new LeafDto("Java", 22));
        list.add(new LeafDto("Spring", 7));
        list.add(new LeafDto("Python", 21));
        model.addAttribute("list", list);
        return "expression";
    }

    @GetMapping("/params")
    public String parameters(HttpSession session) {
        session.setAttribute("id", "Session Value");
        return "parameters";
    }

    @GetMapping("/static")
    public String statics() {
        return "static";
    }
}
