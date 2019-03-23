package com.capgemini.heskuelita.web.servlet;



import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private Logger logger= Logger.getLogger(SignUpServlet.class);

    private ISecurityService securityService;

    public SignUpServlet(){
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* Obtengo la configuracuin de la app */
        ServletContext context = config.getServletContext();

        /* Obtengo la configuracion de la conexion a la base de datos */
        DBConnectionManager manager= (DBConnectionManager) context.getAttribute("db");

       try {
            this.securityService = new SecurityServiceImpl(new UserDao(manager.getSessionFactory()));
        }catch (Exception e){
           e.printStackTrace();
           throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student= new Student();
        student.setName(req.getParameter("ctrlName"));
        student.setLastname(req.getParameter("ctrlLastname"));
        //student.setBirthdate(LocalDate.parse(req.getParameter("ctrlBirthdate")));
        student.setDocType(req.getParameter("ctrlDocType"));
        student.setIdentification(Long.parseLong(req.getParameter("ctrlIdentification")));
        student.setGender(req.getParameter("ctrlGender"));

        User user= new User();
        user.setEmail(req.getParameter("ctrlEmail"));
        user.setPassword(req.getParameter("ctrlPassword"));
        user.setSecQuestion(req.getParameter("ctrlQuestion"));
        user.setSecAnswer(req.getParameter("ctrlAnswer"));
        
        student.setUser(user);

        logger.debug("Inicio del proceso de sign up...");
        logger.info("Datos del usuario a registrar");
        logger.info(student);

        try{
            /*Se realiza verificacion del registo de un nuevo estudiante  */
            this.securityService.signUp(student);
            logger.debug("Servicio de registro de estudiante finalizado con exito!!!");
            resp.sendRedirect("index.jsp");
        }catch (Exception e){
            logger.error("Error en proceso de sign up!!!");
            e.printStackTrace();
        }




    }
}
