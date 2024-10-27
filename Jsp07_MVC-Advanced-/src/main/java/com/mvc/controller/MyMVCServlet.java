package com.mvc.controller;

import com.mvc.dto.MyMVC;
import com.mvc.service.MyMVCService;
import com.mvc.service.MyMVCServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet
public class MyMVCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        MyMVCService sv = new MyMVCServiceImpl();

        String command = request.getParameter("command");
        System.out.println("command: " + command);

        if (command.equals("list")) {
            List<MyMVC> res = sv.selectAll();
            request.setAttribute("res", res);
            RequestDispatcher rd = request.getRequestDispatcher("boardlist.jsp");
            rd.forward(request, response);
        } else if (command.equals("detail")) {
            int seq = Integer.parseInt(request.getParameter("seq"));
            MyMVC res = sv.selectOne(seq);
            request.setAttribute("res", res);
            RequestDispatcher rd = request.getRequestDispatcher("boarddetail.jsp");
            rd.forward(request, response);
        } else if (command.equals("writeform")) {
            response.sendRedirect("boardwrite.jsp");
        } else if (command.equals("boardwrite")) {
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            MyMVC dto = new MyMVC(writer, title, content);
            boolean res = sv.insert(dto);
            if (res == true) {
                request.setAttribute("msg", "Insert Success");
                request.setAttribute("url", "controller.do?command=list");
            } else {
                request.setAttribute("msg", "Insert Fail");
                request.setAttribute("url", "controller.do?command=writeform");
            }
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else if (command.equals("updateform")) {
            int seq = Integer.parseInt(request.getParameter("seq"));
            MyMVC dto = sv.selectOne(seq);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("updateform.jsp");
            rd.forward(request, response);
        } else if (command.equals("update")) {
            int seq = Integer.parseInt(request.getParameter("seq"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            String datestr = request.getParameter("date");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date pdate = null;

            try {
                pdate = sdf.parse(datestr);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }

            java.sql.Date date = new java.sql.Date(pdate.getTime());
            MyMVC dto = new MyMVC();
            dto.setSeq(seq);
            dto.setTitle(title);
            dto.setContent(content);
            dto.setDate(date);
            System.out.println(dto);
            boolean res = sv.update(dto);
            if (res) {
                request.setAttribute("msg", "Update Success");
                request.setAttribute("url", "controller.do?command=list");
            } else {
                request.setAttribute("msg", "Update Fail");
                request.setAttribute("url", "controller.do?command=updateform");
            }
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else if (command.equals("delete")) {
            int seq = Integer.parseInt(request.getParameter("seq"));
            boolean res = sv.delete(seq);
            if (res) {
                request.setAttribute("msg", "Delete Success");
                request.setAttribute("url", "controller.do?command=list");
            } else {
                request.setAttribute("msg", "Delete Fail");
                request.setAttribute("url", "controller.do?command=detail&seq=" + seq);
            }
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        doGet(request, response);
    }
}
