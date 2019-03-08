package servlet;

import mysql.Check;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class UnameServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        boolean sf = Check.uname(uname);
        System.out.println(sf);
        System.out.println(uname);
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().write(sf+"");

    }
}
