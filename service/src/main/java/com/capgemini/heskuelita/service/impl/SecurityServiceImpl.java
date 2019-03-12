package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.Student;
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

    @Override
    public void signUp(Student student) throws SecurityException {
        try{
            this.userDao.signUp(student);
        }catch (Exception e){
            throw new SecurityException(e);
        }
    }
}