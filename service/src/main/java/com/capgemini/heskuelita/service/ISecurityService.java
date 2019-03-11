package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.core.beans.User;


public interface ISecurityService {
    User login(User user) throws SecurityException;
}



/* andando
public interface ISecurityService{
    User login(String user, String password) throws SecurityException;
}
*/

