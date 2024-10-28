package com.hello.mvc.controller;

import com.hello.mvc.model.HelloBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @Autowired
    public HelloBiz biz;

    @RequestMapping("/hello.do")
    public String getHello(Model model) {

        model.addAttribute("msg", biz.getHello());
        return "WEB-INF/views/hello.jsp";
    }

    @RequestMapping("/bye.do")
    public ModelAndView getBye(@RequestParam("name") String nickName) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("WEB-INF/views/bye.jsp");
        mav.addObject("msg", "Bye " + nickName);
        return mav;
    }
}
