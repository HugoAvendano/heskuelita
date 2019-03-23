package com.capgemini.heskuelita.service;

import com.capgemini.heskuelita.core.beans.Student;
import com.capgemini.heskuelita.core.beans.User;




public interface ISecurityService {
    Student login (User user) throws SecurityException;
    void signUp ( Student student ) throws SecurityException;
    void editProfile (Student student) throws SecurityException;
    void deleteProfile (Student student) throws SecurityException;
}


