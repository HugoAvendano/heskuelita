
package com.capgemini.heskuelita.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.capgemini.heskuelita.data.db.DBConnectionManager;


@WebListener
public class AppContextListener implements ServletContextListener {


    public AppContextListener () {

        super ();
    }

	@Override
    public void contextInitialized (ServletContextEvent servletContextEvent) {


    	ServletContext ctx = servletContextEvent.getServletContext ();
    	
    	String url = ctx.getInitParameter ("DBURL");
    	String u   = ctx.getInitParameter ("DBUSER");
    	String p   = ctx.getInitParameter ("DBPWD");
        String d   = ctx.getInitParameter ("DRIVER");

    	DBConnectionManager dbManager = new DBConnectionManager (url, u, p, d);
    	ctx.setAttribute ("db", dbManager);
    }

    @Override
    public void contextDestroyed (ServletContextEvent servletContextEvent) {

    	ServletContext ctx = servletContextEvent.getServletContext ();
    	DBConnectionManager dbManager = (DBConnectionManager) ctx.getAttribute ("db");
    	dbManager.closeConnection ();
    }
}