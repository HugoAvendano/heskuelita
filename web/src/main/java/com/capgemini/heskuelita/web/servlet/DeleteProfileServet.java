package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

@WebServlet("/deleteProfile")
public class DeleteProfileServet extends HttpServlet  {
	
	private Logger logger = Logger.getLogger(DeleteProfileServet.class);
	private ISecurityService securityService;
	
	public DeleteProfileServet() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		/* Obtengo la configuracion de la app */
		ServletContext context = config.getServletContext();
		
		/*Obtengo la configuracion a la base de datos */
		DBConnectionManager manager = (DBConnectionManager) context.getAttribute("db");
		try {
			/* Inicializo el servicio de seguridad del deleteProfile cun una conexion a la base de datos*/
			this.securityService = new SecurityServiceImpl(new UserDao(manager.getSessionFactory()));
		}catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Student student = (Student)req.getSession().getAttribute("student");
		logger.debug("Inicio el proceso de eliminacion de perfil");
		logger.info("Datos del estudiantes a eliminar");
		logger.info(student);
		try {
			this.securityService.deleteProfile(student);
			logger.debug("Servicio de eliminacion de perfil de estudiante finalizado con exito!!!");
		} catch (Exception e) {
			logger.error("Error en el servicio de eliminacion del perfil del estudiante!!!");
			e.printStackTrace();
		}
	}
	
	
	
}
