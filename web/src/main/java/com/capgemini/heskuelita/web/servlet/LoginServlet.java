package com.capgemini.heskuelita.web.servlet;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDao;
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

        /*Obtengo la configuracion de la conexion a la base de datos */

        DBConnectionManager  manager = (DBConnectionManager) context.getAttribute("db");

        try {
            /* Se inicializa el servicio de seguridad del login con un una coneccion a la bd  */
            this.securityService = new SecurityServiceImpl(new UserDao(manager.getSessionFactory()));
        }catch (Exception e){
            e.printStackTrace();
            throw new ServletException(e);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        User user = new User();
        user.setEmail(req.getParameter("ctrlName"));
        user.setPassword(req.getParameter("ctrlPassword"));


        try {
            /* se realiza la verificacion del login */
            Student student = this.securityService.login(user);
            /* Se obtiene un sesion , en que caso que no exita se crea,  y se le setea como atributo un usuario*/
            HttpSession session =  req.getSession();
            session.setAttribute("student",student);
            resp.sendRedirect("home.jsp");
        } catch (Exception e) {
           e.printStackTrace();
           resp.sendRedirect("error.jsp");
        }
    }
}
