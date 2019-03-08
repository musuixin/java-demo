package servlet;


import mysql.Check;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        System.out.println(uname+":"+upwd);
        boolean login = Check.login(uname, upwd);
        String remoteAddr = req.getRemoteAddr();
        System.out.println(remoteAddr);
        if(login){
            System.out.println(uname+"µÇÂ½");
            resp.getWriter().write("³É¹¦");
            req.getSession().setAttribute("uname",uname);
        }
        else {
            resp.getWriter().write("´íÎó");
        }
    }
}