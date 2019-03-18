package com.capgemini.heskuelita.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
import com.capgemini.heskuelita.data.impl.UserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.impl.SecurityServiceImpl;

@WebServlet("/editProfile")
public class EditProfileServlet extends HttpServlet {
	
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
		
		Student st =(Student) req.getSession().getAttribute("student");
		
		//Actualizo los datos del estudiante
		st.setName(req.getParameter("ctrlName"));
		st.setLastname(req.getParameter("ctrlLastname"));
		st.setDocType(req.getParameter("ctrlDocType"));
		st.setIdentification(Long.parseLong(req.getParameter("ctrlIdentifiaction")));
		
		
		
	}

	
	
	
	
	
	
}
