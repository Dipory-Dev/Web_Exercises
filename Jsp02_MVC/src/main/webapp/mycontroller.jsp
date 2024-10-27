<%@ page import="com.mvc.dao.MVCBoardDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mvc.dto.MVCBoardDto" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.text.ParseException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Controller Page</title>
</head>
<body>
<%
    String command = request.getParameter("command");
    System.out.println("=======================");
    System.out.println("[command]: " + command);
    System.out.println("=======================");

    MVCBoardDao dao = new MVCBoardDao();

    if (command.equals("boardlist")) {
        List<MVCBoardDto> res = dao.selectAll();

        request.setAttribute("allList", res);
        pageContext.forward("boardlist.jsp");
    } else if (command.equals("boardinsertform")) {
        response.sendRedirect("boardinsert.jsp");
    } else if (command.equals("boardinsert")) {
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        MVCBoardDto dto = new MVCBoardDto();
        dto.setWriter(writer);
        dto.setTitle(title);
        dto.setContent(content);

        int res = dao.insert(dto);

        if (res > 0) {
            request.setAttribute("msg", "Successfully added board");
            request.setAttribute("url", "mycontroller.jsp?command=boardlist");
        } else {
            request.setAttribute("msg", "Failed to add board");
            request.setAttribute("url", "mycontroller.jsp?command=boardinsertform");
        }

        pageContext.forward("result.jsp");
    } else if (command.equals("boarddetail")) {
        int seq = Integer.parseInt(request.getParameter("seq"));
        MVCBoardDto dto = dao.selectOne(seq);

        if (dto != null) {
            request.setAttribute("dto", dto);
            pageContext.forward("boarddetail.jsp");
        } else {
            System.out.println("no such Book");
        }
    } else if (command.equals("boardupdateform")) {
        int seq = Integer.parseInt(request.getParameter("seq"));
        MVCBoardDto dto = dao.selectOne(seq);
        request.setAttribute("dto", dto);
        pageContext.forward("boardupdate.jsp");
    } else if (command.equals("boardupdate")) {
        int seq = Integer.parseInt(request.getParameter("seq"));
        String writer = request.getParameter("writer");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String datestr = request.getParameter("date");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(datestr);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        MVCBoardDto dto = new MVCBoardDto(seq, writer, title, content, date);
        int res = dao.update(dto);

        if (res > 0) {
            request.setAttribute("msg", "Successfully updated board");
            request.setAttribute("url", "mycontroller.jsp?command=boarddetail&seq=" + seq);
        } else {
            request.setAttribute("msg", "Failed to add board");
            request.setAttribute("url", "mycontroller.jsp?command=boardupdateform&seq=" + seq);
        }
        pageContext.forward("result.jsp");
    } else if (command.equals("boarddelete")) {
        int seq = Integer.parseInt(request.getParameter("seq"));
        int res = dao.delete(seq);
        if (res > 0) {
            request.setAttribute("msg", "Successfully deleted board");
            request.setAttribute("url", "mycontroller.jsp?command=boardlist");
        } else {
            request.setAttribute("msg", "Failed to delete board");
            request.setAttribute("url", "mycontroller.jsp?command=boarddelete");
        }
        pageContext.forward("result.jsp");
    } else if (command.equals("muldel")) {
        String[] seq = request.getParameterValues("chk");
        int res = dao.multiDelete(seq);
        if (res > 0) {
            request.setAttribute("msg", "Successfully deleted.");
            request.setAttribute("url", "mycontroller.jsp?command=boardlist");
        } else {
            request.setAttribute("msg", "Failed to delete");
            request.setAttribute("url", "mycontroller.jsp?command=boardlist");
        }
        pageContext.forward("result.jsp");
        
    }
%>
</body>
</html>
