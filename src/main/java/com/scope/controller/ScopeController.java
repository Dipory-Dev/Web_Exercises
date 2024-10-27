package com.scope.controller;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ws.rs.core.Application;

public class ScopeController extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("[controller]");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String reqId = (String) request.getAttribute("reqId");
        HttpSession session = request.getSession();
        String sessionId = (String) session.getAttribute("sessionId");
        ServletContext app = request.getServletContext();
        String appId = (String) app.getAttribute("appId");

        System.out.println("reqId : " + reqId);
        System.out.println("sessionId : " + sessionId);
        System.out.println("appId : " + appId);

        request.setAttribute("reqId", "reqId in servlet");
        RequestDispatcher dis = request.getRequestDispatcher("result.jsp");
        try {
            dis.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

    public void destroy() {
    }
}