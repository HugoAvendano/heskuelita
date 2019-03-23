package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.capgemini.heskuelita.core.beans.Student;

import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
	
	private Logger logger = Logger.getLogger(EditProfileServlet.class);
	
	private ISecurityService securityService;
	
	public EditProfileServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		ServletContext context = config.getServletContext();
		
		DBConnectionManager manager = (DBConnectionManager)context.getAttribute("db");
		
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
		
		Student student =(Student) req.getSession().getAttribute("student");
			
		//Actualizo los datos del estudiante
		student.setName(req.getParameter("ctrlName"));
	    student.setLastname(req.getParameter("ctrlLastname"));
		//student.setBirthdate(LocalDate.parse(req.getParameter("ctrlBirthdate")));
		student.setDocType(req.getParameter("ctrlDocType"));
		student.setIdentification(Long.parseLong(req.getParameter("ctrlIdentification")));
		student.setGender(req.getParameter("ctrlGender"));
		student.getUser().setEmail(req.getParameter("ctrlEmail"));
		student.getUser().setPassword(req.getParameter("ctrlPassword"));
		student.getUser().setSecQuestion(req.getParameter("ctrlQuestion"));
		student.getUser().setSecAnswer(req.getParameter("ctrlAnswer"));
				
		logger.debug("Inicio del proceso de Edit Profile...");
        logger.info("Datos del usuario a modificar");
        logger.info(student);
				
		try {
			this.securityService.editProfile(student);
			logger.debug("Servicio de actualizacion de datos del  estudiante finalizado con exito!!!");
			resp.sendRedirect("index.jsp");
		} catch (Exception e) {
			logger.error("Error en el Servicio de actualizacion de datos del estudiante !!!");
			e.printStackTrace();
		}
	}
}
