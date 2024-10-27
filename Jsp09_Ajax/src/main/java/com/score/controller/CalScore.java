package com.score.controller;



import org.json.simple.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


@WebServlet("/CalScore")
public class CalScore extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        int kor = Integer.parseInt(request.getParameter("kor"));
        int eng = Integer.parseInt(request.getParameter("eng"));
        int math = Integer.parseInt(request.getParameter("math"));

        int sum = kor + eng + math;
        double avg = sum / 3.0;

        String res = "{\"name\":\""+name+"\", \"sum\":"+sum+", \"avg\":"+avg+"}";
        System.out.println("Test=======" + res);
        PrintWriter out = response.getWriter();
        out.print(res);

//        JSONObject obj = new JSONObject();
//        obj.put("name", name);
//        obj.put("sum", sum);
//        obj.put("avg", avg);
//        System.out.println("Test=======2");
//        PrintWriter out = response.getWriter();
//        out.print(obj.toJSONString());





        System.out.println(name + " " + kor + " " + eng + " " + math);
        System.out.println("doGet");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
