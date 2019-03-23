package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;
import org.apache.log4j.Logger;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDao;

    private Logger logger = Logger.getLogger(SecurityServiceImpl.class);

    public SecurityServiceImpl(IUserDao userDao){
        super();
        this.userDao = userDao;
    }


    @Override
    public Student login(User user) throws SecurityException {
        Student studentLogin;
        try {
            logger.debug("Inicio del Servicio de Login");
            studentLogin = userDao.login(user.getEmail(),user.getPassword());
            logger.debug("Servicio de Login finalizado con exito");
        }catch (Exception e){
            logger.error("Error en el Servicio de Login ");
            throw new SecurityException(e);
        }
        return studentLogin;
    }

    @Override
    public void signUp(Student student) throws SecurityException {
        try{
            logger.debug("Inicio del Servicio de Sign Up");
            logger.info("Datos del usuario a registrar");
            logger.info(student);        
            this.userDao.signUp(student);
        }catch (Exception e){
            logger.error("Error en el servicio de sign up");
            throw new SecurityException(e);
        }
    }


	@Override
	public void editProfile(Student student) throws SecurityException {
		try {
			logger.debug("Inicio del Servicio de EditProfile");
			logger.info("Datos del usuario a editar");
			logger.info(student);
			this.userDao.editProfile(student);
		} catch (Exception e) {
			logger.error("Error en el servicio de Edit Profile");
			throw new SecurityException(e);
		}
		
	}


	@Override
	public void deleteProfile(Student student) throws SecurityException {
		try {
			logger.debug("Inicio del Servicio de DeleteProfile");
			logger.info("Datos del ususario a eliminar");
			logger.info(student);
			this.userDao.deleteProfile(student);
		}catch (Exception e) {
			logger.error("Error en el servicio de Delete Profile");
		}
		
	}
    
	
    
    
}