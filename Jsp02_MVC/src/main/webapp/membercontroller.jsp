<%@ page import="com.login.dto.MyMember" %>
<%@ page import="com.login.dao.MyMemberDao" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: kjs10
  Date: 24. 10. 1.
  Time: 오전 9:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setCharacterEncoding("UTF-8"); %>
<html lang="ko">
<head>
    <title>Title</title>
</head>
<body>
<%
    String command = request.getParameter("command");
    MyMemberDao dao = new MyMemberDao();

    if (command.equals("login")) {
        String myid = request.getParameter("myid");
        String mypw = request.getParameter("mypw");

        MyMember dto = dao.login(myid, mypw);

        if (dto.getMyid() != null) {
            session.setAttribute("dto", dto);
            session.setMaxInactiveInterval(60 * 60);
            if (dto.getMyrole().equals("Admin")) {
                response.sendRedirect("adminmain.jsp");
            } else if (dto.getMyrole().equals("User")) {
                response.sendRedirect("usermain.jsp");
            }
        } else {
            response.sendRedirect("logres.jsp");
        }
    } else if (command.equals("logout")) {
        session.invalidate();
        response.sendRedirect("index.jsp");
    } else if (command.equals("userlistall")) {
        List<MyMember> list = dao.selectAll();
        request.setAttribute("list", list);
        pageContext.forward("userlistall.jsp");
    } else if (command.equals("updateroleform")) {
        int myno = Integer.parseInt(request.getParameter("myno"));
        MyMember dto = dao.selectUser(myno);

        request.setAttribute("dto", dto);
        pageContext.forward("updateroleform.jsp");
    } else if (command.equals("updaterole")) {
        int myno = Integer.parseInt(request.getParameter("myno"));
        String myrole = request.getParameter("myrole");
        int res = dao.updaterole(myno, myrole);

        if (res > 0) {
            request.setAttribute("msg", "Update Successful");
            request.setAttribute("url", "membercontroller.jsp?command=userlistall");
        } else {
            request.setAttribute("msg", "Update Failed");
            request.setAttribute("url", "membercontroller.jsp?command=updateroleform&myno="+myno);
        }
        pageContext.forward("result.jsp");
    } else if (command.equals("userinfo")) {
        int myno = Integer.parseInt(request.getParameter("myno"));
        MyMember dto = dao.selectUser(myno);

        request.setAttribute("dto", dto);
        pageContext.forward("userinfo.jsp");
        
    } else if (command.equals("registform")) {
        response.sendRedirect("registform.jsp");

    } else if (command.equals("idchk")) {
        String myid = request.getParameter("myid");
        response.sendRedirect("idchk.jsp?idnotused="+dao.idChk(myid));
    } else if (command.equals("insertuser")) {
        String myid = request.getParameter("myid");
        String mypw = request.getParameter("mypw");
        String myname = request.getParameter("myname");
        String myaddr = request.getParameter("myaddr");
        String myphone = request.getParameter("myphone");
        String myemail = request.getParameter("myemail");
        MyMember dto = new MyMember();
        dto.setMyid(myid);
        dto.setMypw(mypw);
        dto.setMyname(myname);
        dto.setMyaddr(myaddr);
        dto.setMyphone(myphone);
        dto.setMyemail(myemail);
        int res = dao.insertuser(dto);
        if (res > 0) {
            request.setAttribute("msg", "Regist Successful");
            request.setAttribute("url", "index.jsp");
        } else {
            request.setAttribute("msg", "Regist Failed");
            request.setAttribute("url", "membercontroller.jsp?command=registform");
        }
        pageContext.forward("result.jsp");
    } else if (command.equals("deleteuser")) {
        int myno = Integer.parseInt(request.getParameter("myno"));
        int res = dao.deleteuser(myno);
        if (res > 0) {
            request.setAttribute("msg", "Delete Successful");
            request.setAttribute("url", "membercontroller.jsp?command=logout");
        } else {
            request.setAttribute("msg", "Delete Failed");
            request.setAttribute("url", "membercontroller.jsp?command=userinfo&myno="+myno);
        }
        pageContext.forward("result.jsp");
    }
%>
</body>
</html>
