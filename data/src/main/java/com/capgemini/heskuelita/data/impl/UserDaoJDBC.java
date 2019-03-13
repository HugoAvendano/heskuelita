package com.capgemini.heskuelita.data.impl;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.DataException;
import com.capgemini.heskuelita.data.IUserDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;


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

            Statement stm = this.conn.createStatement ();

           // ResultSet resultSet = stm.executeQuery ("SELECT * from users WHERE email='" + userName + "' AND password='" + password + "'");
            ResultSet resultSet = stm.executeQuery ("select u.email , s.name, s.lastname from users u Inner Join student s on (u.email= s.email) where u.email= '" + userName +"' and u.password='" + password +"' ");

            while (resultSet.next ()) {

                us = new User ();
                us.setEmail (resultSet.getString ("email"));
                us.setName (resultSet.getString ("name"));
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

    @Override
    public void signUp(Student student) {
        int r= 0;
        try{

            PreparedStatement pstmUser = this.conn.prepareStatement("INSERT INTO users VALUES (?,?,?,?)");
            pstmUser.setString(1, student.getUser().getEmail());
            pstmUser.setString(2, student.getUser().getPassword());
            pstmUser.setString(3, student.getUser().getSecQuestion());
            pstmUser.setString(4, student.getUser().getSecAnswer());

            r= pstmUser.executeUpdate();

            System.out.println("Se registro el usuario: " + r);


            PreparedStatement pstmStudent = this.conn.prepareStatement ("INSERT INTO student VALUES (default, ?, ?, ?, ?, ?, ?, ?)");
            pstmStudent.setString(1,student.getName());
            pstmStudent.setString(2,student.getLastname());
            pstmStudent.setObject(3,student.getBirthdate());
            pstmStudent.setString(4, student.getDocType());
            pstmStudent.setLong(5,student.getIdentification());
            pstmStudent.setString(6,student.getUser().getEmail());
            pstmStudent.setString(7,student.getGender());

            int p= pstmStudent.executeUpdate();
            System.out.println("Se registro el estudiante: " + r);


        }catch(Exception e){
                throw new DataException (e);
        }



    }
}


