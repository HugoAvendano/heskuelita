package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private ISecurityService securityService;

    public LoginServlet() {
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* Obtengo la configuracion de la app */
        ServletContext context = config.getServletContext();

        /*Obtengo la conexion a la base de datos */

        DBConnectionManager  manager = (DBConnectionManager) context.getAttribute("db");

        try {
            /* Se inicializa el servicio de seguridad del login con un una coneccion a la bd  */
            this.securityService = new SecurityServiceImpl(new UserDaoJDBC(manager.getConnection()));
        }catch (Exception e){
            throw new ServletException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        /*User user = new User();
        user.setEmail(req.getParameter("ctrlName"));
        user.setPassword(req.getParameter("ctrlPassword"));
        */


        String username = req.getParameter("ctrlName");
        String password = req.getParameter("ctrlPassword");
        try {
            /* se realiza la verificacion del login */
            //this.securityService.login(user);

            User user= this.securityService.login(username,password);
            /* Se crea una session y se le setea como atributo un usuario*/
            HttpSession session =  req.getSession();
            session.setAttribute("user",user);
            resp.sendRedirect("home.jsp");
        } catch (Exception e) {
           e.printStackTrace();
           resp.sendRedirect("error.jsp");
        }
    }
}
