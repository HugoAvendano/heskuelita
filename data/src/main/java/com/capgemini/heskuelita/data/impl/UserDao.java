package com.capgemini.heskuelita.data.impl;



import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;

import org.apache.log4j.Logger;


public class UserDao implements IUserDao {

    private SessionFactory sessionFactory;
    private Logger logger = Logger.getLogger(UserDao.class);

    public UserDao(SessionFactory sessionFactory){
        super();
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student login(String userName, String password) {
        Student student = null;
        Session session=null;
        try {

            /*Obtengo la session*/
            logger.info("Obtengo la sesion");
            session =  sessionFactory.openSession();

            logger.info("Configuro la query a realizar");
            Query query = session.createQuery("from Student where id_student=:id");
            query.setParameter("id",1);
            //query.setParameter("password",password);
            logger.info("Ejecuto la query");
           
            student=(Student)query.uniqueResult();
            logger.debug("Query ejecutada");

        } catch (Exception e) {
            logger.error("Error durante el proceso de ejecucion de la consulta");
            e.printStackTrace();
            throw new DataException (e);
        }finally {
            session.close();
        }

        if (student == null) {
            logger.debug("Consulta realizada sin resultados");
            throw new DataException ("Usuario " + userName + " desconocido");

        }
        logger.debug("Consulta resultada exitosamente con resultado");
        return student;
    }

    @Override
    public void signUp(Student student) {
        
    	Session session = null;
    	Transaction transaction = null;
    	
        try{
        	logger.info("Obtengo la session");
        	session = sessionFactory.openSession();
        	transaction = session.beginTransaction();
        	
        	logger.info("Registro el nuevo estudiante");
        	session.save(student);
        	transaction.commit();
        }catch(Exception e){
                throw new DataException (e);
        }
       }
}


