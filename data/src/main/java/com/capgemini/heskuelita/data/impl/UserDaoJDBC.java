package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class UserDaoJDBC implements IUserDao {

    private Connection conn;

    public UserDaoJDBC(Connection cnn){
        super();
        this.conn = cnn;
    }

    @Override
    public User login(String userName, String password) {
        User us = null;
        try {
            System.out.println("userName:" + userName + " password: " +password );
            Statement stm = this.conn.createStatement ();

           // ResultSet resultSet = stm.executeQuery ("SELECT * from users WHERE email='" + userName + "' AND password='" + password + "'");
            ResultSet resultSet = stm.executeQuery ("select u.email , s.name_student, s.lastname from users u Inner Join student s on (u.email= s.email) where u.email= '" + userName +"' and u.password='" + password +"' ");

            while (resultSet.next ()) {

                us = new User ();
                us.setEmail (resultSet.getString ("email"));
                us.setName (resultSet.getString ("name_student"));
                us.setLastname(resultSet.getString ("lastname"));
                break;
            }

        } catch (Exception e) {

            throw new DataException (e);
        }

        if (us == null) {
            throw new DataException ("Usuario " + userName + " desconocido");
        }

        return us;



    }
}


