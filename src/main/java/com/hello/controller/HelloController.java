package com.hello.controller;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

public class HelloController extends HttpServlet {

    public HelloController() {
        System.out.println("Servlet Start");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("context-param" + config.getServletContext().getInitParameter("url"));
        System.out.println("init-param" + config.getInitParameter("driver"));
    }

    @Override
    public void destroy() {
        System.out.println("Servlet End");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
        System.out.println("get method");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("post method");
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String command = request.getParameter("command");
        System.out.println("parameter: " + command);

        PrintWriter out = response.getWriter();
        out.print("<h1 style=\"color:red\">Hello Servlet</h1>");
        out.print("<h2>servlet 라이프사이클, url mapping command : " + command + "</h2>");
        out.print("<a href='home.jsp'>Back</a>");
    }
}