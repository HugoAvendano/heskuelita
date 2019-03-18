package com.capgemini.heskuelita.test;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.data.db.DBConnectionManager;
//import com.capgemini.heskuelita.data.impl.UserDao;


public class Test {
	private Logger logger = Logger.getLogger(Test.class);
	DBConnectionManager dbConnMgr=new DBConnectionManager();
	Session session=null;
	Student student= null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	
	
		
		 /*Obtengo la session*/
        logger.info("Obtengo la sesion");
    	session =  dbConnMgr.getSessionFactory().openSession();

	}

	@org.junit.Test
	public void test() {
		Student student=null;
		 /*Obtengo la session*/
     
        logger.info("Configuro la query a realizar");
        Query query = session.createQuery("from Student where id_student =:id_student");
        query.setParameter("id_student",1);
        //query.setParameter("password",password);
        logger.info("Ejecuto la query");
       
        student=(Student)query.uniqueResult();
        logger.debug("Query ejecutada");

        
		 session.close();
		 Assert.assertTrue(student== null);
	}

}
