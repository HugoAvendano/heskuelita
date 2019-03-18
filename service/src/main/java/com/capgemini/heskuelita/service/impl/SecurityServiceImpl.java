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

            logger.info("Nombre de usuario: " + student.getName());
            logger.info("Lastanem de usuario: " + student.getLastname());
            //logger.info("Fecha de nacimiento del usuario: " + student.getBirthdate().toString());
            logger.info("Tipo de documento del usuario: " + student.getDocType());
            logger.info("Nro de documento del usuario: "+ student.getIdentification());
            logger.info("Sexo del usuario: " + student.getGender());
            //logger.info("Email del usuario: " + student.getUser().getEmail());
            //logger.info("Password del usuario: " + student.getUser().getPassword());
            //logger.info("Pregunta de seguridad  del usuario: " + student.getUser().getSecQuestion());
            //logger.info("Respuesta de seguridad  del usuario: " + student.getUser().getSecAnswer());
            
            
            this.userDao.signUp(student);
        }catch (Exception e){
            logger.error("Error en el servicio de sign up");
            throw new SecurityException(e);
        }
    }
}