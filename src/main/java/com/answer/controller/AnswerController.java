package com.answer.controller;

import com.answer.dao.AnswerDao;
import com.answer.dto.Answer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/answer.do")
public class AnswerController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String command = request.getParameter("command");
        System.out.println("[" + command + "]");

        AnswerDao dao = new AnswerDao();

        if (command.equals("list")) {
            List<Answer> res = dao.selectAll();
            request.setAttribute("res", res);
            RequestDispatcher rd = request.getRequestDispatcher("boardlist.jsp");
            rd.forward(request, response);
        } else if (command.equals("writeform")) {
            response.sendRedirect("writeform.jsp");
        } else if (command.equals("boardwrite")) {
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Answer dto = new Answer();
            dto.setTitle(title);
            dto.setContent(content);
            dto.setWriter(writer);

            int res = dao.insert(dto);
            if (res > 0) {
                request.setAttribute("msg", "Insert Success");
                request.setAttribute("url", "answer.do?command=list");
            } else {
                request.setAttribute("msg", "Insert Fail");
                request.setAttribute("url", "answer.do?command=writeform");
            }
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else if (command.equals("detail")) {
            int bno = Integer.parseInt(request.getParameter("bno"));
            Answer dto = dao.selectOne(bno);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("boarddetail.jsp");
            rd.forward(request, response);
        } else if (command.equals("updateform")) {
            int bno = Integer.parseInt(request.getParameter("bno"));
            Answer dto = dao.selectOne(bno);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("boardupdate.jsp");
            rd.forward(request, response);
        } else if (command.equals("update")) {
            int bno = Integer.parseInt(request.getParameter("bno"));
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Answer dto = new Answer();
            dto.setBno(bno);
            dto.setTitle(title);
            dto.setContent(content);
            int res = dao.update(dto);
            if (res > 0) {
                request.setAttribute("msg", "Update Success");
                request.setAttribute("url", "answer.do?command=detail&bno=" + bno);
            } else {
                request.setAttribute("msg", "Update Fail");
                request.setAttribute("url", "answer.do?command=updateform&bno=" + bno);
            }
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        } else if (command.equals("answerform")) {
            int pbno = Integer.parseInt(request.getParameter("pbno"));
            Answer dto = dao.selectOne(pbno);
            request.setAttribute("dto", dto);
            RequestDispatcher rd = request.getRequestDispatcher("answerform.jsp");
            rd.forward(request, response);
        } else if (command.equals("answerwrite")) {
            int pbno = Integer.parseInt(request.getParameter("pbno"));
            String writer = request.getParameter("writer");
            String title = request.getParameter("title");
            String content = request.getParameter("content");

            Answer pdto = dao.selectOne(pbno);


            int ures = dao.updateAnswer(pdto.getGno(), pdto.getGseq());
            if (ures > 0) {
                System.out.println("Change number success");
            } else {
                System.out.println("Change number fail / No require change number");
            }

            Answer dto = new Answer(0, pdto.getGno(), pdto.getGseq() + 1, pdto.getTitletab() + 2, title, content, writer, null);
            int ires = dao.insertAnswer(dto);

            if (ires > 0) {
                request.setAttribute("msg", "Insert Success");
                request.setAttribute("url", "answer.do?command=list");
            } else {
                request.setAttribute("msg", "Insert Fail");
                request.setAttribute("url", "answer.do?command=detail&bno=" + pdto.getBno());
            }

            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
