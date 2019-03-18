
package com.capgemini.heskuelita.data.db;


import com.capgemini.heskuelita.data.DataException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.apache.log4j.Logger;





public class DBConnectionManager {

	private static SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(DBConnectionManager.class);


	public DBConnectionManager() {
		super();
		buildSessionFactory();
	}


	private SessionFactory buildSessionFactory() {
		try {

			logger.debug("Inicio de la creacion del sessionFactoy");
			/* Declaro una variable configuration para leer el archivo de configuracion
		 	de hibernate para obtener los datos necesarios de la coneccion a BD*/

			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			logger.info("Configuracion de Hibernate cargada");


			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			logger.info("ServiceRegisty de Hibernate creado");

			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			logger.debug("SessionFactory creado exitosamente!!!");
			return sessionFactory;


		} catch (Exception e) {
			logger.error("Fallo la creacion del SessionFactory");
			e.printStackTrace();
			throw new DataException(e);
		}
	}

	public SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	public void closeSessionFactory(){
		sessionFactory.close();
	}

}
