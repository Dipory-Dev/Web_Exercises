package com.mvc.upgrade.model.controller;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.dto.BoardDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private BoardBiz biz;

    @RequestMapping(value = "/list.do")
    public String list(Model model) {

        logger.info("Select List");
        List<BoardDto> res = biz.selectList();
        model.addAttribute("list", res);
        return "mvclist";
    }

    @RequestMapping(value = "/detail.do")
    public String detail(Model model, int myno) {
        logger.info("Select Detail");
        model.addAttribute("dto", biz.selectOne(myno));
        return "mvcdetail";
    }

    @RequestMapping(value = "/insertform.do")
    public String insertform() {
        logger.info("Insert form");
        return "mvcinsert";
    }

    @RequestMapping(value = "/insert.do")
    public String insert(BoardDto dto) {
        logger.info("Insert");
        int res = biz.insert(dto);

        if (res > 0) {
            return "redirect:/list.do";
        } else {
            return "redirect:/insertform.do";
        }
    }
}
