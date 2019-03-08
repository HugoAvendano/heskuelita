package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService = new SecurityServiceImpl();

    public LoginServlet() {
        super();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("ctrlName"));
        user.setPassword(req.getParameter("ctrlPassword"));
        System.out.println(user.getUserName());
        System.out.println(user.getPassword());
        try {
            this.securityService.login(user);
            //HttpSession session =  new HttpSession();
            //session.setAttribute("user",user);

            resp.sendRedirect("home.jsp");
        } catch (Exception e) {
            throw new ServletException(e);
            //resp.sendRedirect("err.jsp");
        }
    }
}
