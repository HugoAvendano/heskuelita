package com.capgemini.heskuelita.web.servlet;



import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDaoJDBC;
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


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private ISecurityService securityService;

    public SignUpServlet(){
        super();
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        /* Obtengo la configuracuin de la app */
        ServletContext context = config.getServletContext();

        /* Obtengo la configuracion de la conexion a la base de datos */
        DBConnectionManager manager= (DBConnectionManager) context.getAttribute("bd");

       try {
            this.securityService = new SecurityServiceImpl(new UserDaoJDBC(manager.getConnection()));
        }catch (Exception e){
           // throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Student student= new Student();
        student.setName(req.getParameter("ctrlName"));
        student.setLastname(req.getParameter("ctrlLastname"));
        DateTimeFormatter formatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd");
        student.setBirthdate(LocalDate.parse(req.getParameter("ctrlBirthdate"),formatter));
        student.setDocType(req.getParameter("ctrlDocType"));
        student.setIdentification(Long.parseLong(req.getParameter("ctrlIdentification")));
        student.setPhone(req.getParameter("ctrlPhone"));
        student.setGender(req.getParameter("ctrlGender"));

        User userStudent= new User();
        userStudent.setEmail(req.getParameter("ctrlEmail"));
        userStudent.setPassword(req.getParameter("ctrlPassword"));
        userStudent.setSecQuestion(req.getParameter("ctrlQuestion"));
        userStudent.setSecAnswer(req.getParameter("ctrlAnswer"));
        student.setUser(userStudent);

        try{
            /*Se realiza la verificacion del registo de un nuevo estudiante  */
            this.securityService.signUp(student);
        }catch (Exception e){
            e.printStackTrace();
        }




    }
}
