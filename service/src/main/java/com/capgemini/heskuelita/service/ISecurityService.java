package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.core.beans.Student;



public interface ISecurityService {
    User login (User user) throws SecurityException;
    void signUp ( Student student ) throws SecurityException;
}


