
package com.capgemini.heskuelita.data.db;


import java.util.Properties;


import com.capgemini.heskuelita.data.DataException;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import javax.imageio.spi.ServiceRegistry;


public class DBConnectionManager {

	private static SessionFactory;



	private DBConnectionManager () {
		super();
	}


	private SessionFactory buildSessionFactory(){
		try {
		/* Declaro una variable configuration para leer el archivo de configuracion
		 de hibernate para obtener los datos necesarios de la coneccion a BD*/
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");

			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySetting(configuration.getProperties()).build();

			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

		}
		catch (Exception e){
			e.printStackTrace();
			throw new DataException(e);

		}


	}





	public SessionFactory getConnection () {

	    try {

            return this.dataSource.getConnection ();

        } catch (Exception e) {

	        throw new DataException(e);
        }
	}
	
	public void closeConnection () {

	    try {

            this.dataSource.close ();

        } catch (Exception e) {

	        e.printStackTrace ();
        }

	}
}