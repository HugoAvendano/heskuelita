package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.data.IUserDao;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {

    private IUserDao userDao;


    public SecurityServiceImpl(IUserDao userDao){
        super();
        this.userDao = userDao;
    }


    @Override
    public User login(User user) throws SecurityException {
        User userLogin;
        try {
            userLogin = userDao.login(user.getEmail(),user.getPassword());
            System.out.println("Nombre de usuario: " + user.getName());
            System.out.println("Apellido de Usuario: "+ user.getLastname());
            System.out.println("Email: "+ user.getEmail());
        }catch (Exception e){
            throw new SecurityException(e);
        }
        return userLogin;
    }


    /*
    @Override
    public User login(String user, String password) throws SecurityException {
        User u;
        try {
            System.out.println("userName:" + user + " password: " +password );
            u = userDao.login(user,password);
            return u;
        }catch (Exception e){
            throw new SecurityException(e);
        }
    }
    */
}