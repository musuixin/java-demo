package servlet;

import mysql.Check;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=UTF-8");
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String email = req.getParameter("email");
        boolean re = Check.register(uname, upwd, email);
        if(re) {
            resp.sendRedirect("SignIn.html");
        }
    }
}
