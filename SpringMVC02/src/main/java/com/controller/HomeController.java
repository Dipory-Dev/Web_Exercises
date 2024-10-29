package com.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
public class HomeController {
    private static final Logger logger = LogManager.getLogger(HomeController.class);

    @RequestMapping(value = "/home.do", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);

        Date date = new Date();
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, locale);

        String formattedDate = df.format(date);
        model.addAttribute("serverTime", formattedDate);

        return "home";
    }

    @RequestMapping(value = "/command.do", method = RequestMethod.GET)
    public String getCommand() {
        System.out.println("getCommand() method");
        return null;
    }
}
