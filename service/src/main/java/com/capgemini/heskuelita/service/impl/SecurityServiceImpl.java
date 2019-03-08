package com.capgemini.heskuelita.service.impl;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.service.ISecurityService;
import com.capgemini.heskuelita.service.SecurityException;

public class SecurityServiceImpl implements ISecurityService {



    @Override
    public void login(User user) throws SecurityException {

        if (!user.getUserName().equals("capgemini") && !user.getPassword().equals("qwerty")) {
            throw new SecurityException("Usuario invalido !!!");
        }
    }
}