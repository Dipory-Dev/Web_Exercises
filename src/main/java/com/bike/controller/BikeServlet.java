package com.bike.controller;

import com.bike.dao.BikeDao;
import com.bike.dto.BikeDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/bike")
public class BikeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String command = request.getParameter("command");
        System.out.println("[" + command + "]");
        BikeDao dao = new BikeDao();

        if (command.equals("first")) {
            response.sendRedirect("bike01.jsp");
        } else if (command.equals("first_db")) {
//            int delres = dao.delall();
//            if (delres > 0) {
//                System.out.println("Delete success");
//            } else {
//                System.out.println("Delete failed");
//            }

            String[] bikes = request.getParameterValues("bike");
            List<BikeDto> dto = new ArrayList<BikeDto>();
            for(String s : bikes) {
                String[] tmp = s.split("/");
                BikeDto tdto = new BikeDto(tmp[0], Integer.parseInt(tmp[1]), tmp[2], tmp[3]
                        , Integer.parseInt(tmp[4]), Double.parseDouble(tmp[5]), Double.parseDouble(tmp[6]));
                dto.add(tdto);
            }

            int res = dao.insert(dto);
            if (res > 0) {
                System.out.println("Insert success");
                response.sendRedirect("index.jsp");
            } else {
                System.out.println("Insert failed");
                response.sendRedirect("bike01.jsp");
            }
        } else if (command.equals("del_db")) {
            int cid = Integer.parseInt(request.getParameter("cid"));
            int deleteres = dao.delete(cid);
            if (deleteres > 0) {
                System.out.println("Delete success");
                response.sendRedirect("index.jsp");
            } else {
                System.out.println("Delete failed");
                response.sendRedirect("bike01.jsp");
            }
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
