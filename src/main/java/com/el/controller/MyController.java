package com.el.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/controller.do")
public class MyController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getParameter("command");

        if (command.equals("elpage")) {
            response.sendRedirect("basic.jsp");
        } else if (command.equals("eltest")) {
            System.out.println("eltest");
            Score sc = new Score("KJS", 100, 90, 95);
            System.out.println(sc);
            request.setAttribute("sc", sc);

            RequestDispatcher rd = request.getRequestDispatcher("eltest.jsp");
            rd.forward(request, response);
        } else if (command.equals("jstlpage")) {
            List<Score> res = new ArrayList<Score>();
            for (int i = 1; i < 6; i++) {
                Score sc = new Score("name" + i, 90 + i, 90 + i, 85 + i);
                res.add(sc);
            }

            request.setAttribute("res", res);
            RequestDispatcher rd = request.getRequestDispatcher("jstlpage.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
