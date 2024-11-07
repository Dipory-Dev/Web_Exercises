package com.mvc.upgrade.model.controller;

import com.mvc.upgrade.model.biz.BoardBiz;
import com.mvc.upgrade.model.biz.MemberBiz;
import com.mvc.upgrade.model.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class MemberController {

    private Logger logger = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberBiz biz;

    @Autowired
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @RequestMapping("/loginform.do")
    public String loginForm() {
        logger.info("Login form");
        return "mvclogin";
    }

    @RequestMapping("/ajaxlogin.do")
    @ResponseBody
    public Map<String, Boolean> ajaxLogin(@RequestBody MemberDto dto, HttpSession session) {
        logger.info("LOGIN");
        System.out.println(dto.getMemberid());
        System.out.println(dto.getMemberpw());
        MemberDto res = biz.login(dto);

        boolean check = false;
        if (res != null) {
            if(encoder.matches(dto.getMemberpw(), res.getMemberpw())) {
                check = true;
                session.setAttribute("login", res);
            }
        }

        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("login", check);
        System.out.println(check);
        return map;
    }

    @RequestMapping(value = "/registerform.do")
    public String memberInsertForm() {
        logger.info("Register form");
        return "mvcregister";
    }

    @RequestMapping(value = "/register.do")
    public String memberInsert(MemberDto dto) {
        logger.info("Register");
        dto.setMemberpw(encoder.encode(dto.getMemberpw()));
        System.out.println(dto.getMemberpw());
        int res = biz.insert(dto);
        if (res > 0) {
            return "redirect:/loginform.do";
        } else {
            return "redirect:/registerform.do";
        }
    }
}
