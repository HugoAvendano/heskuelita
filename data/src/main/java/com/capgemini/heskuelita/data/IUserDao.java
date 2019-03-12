package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.core.beans.User;
import com.capgemini.heskuelita.core.beans.Student;

public interface IUserDao {
    User login(String user, String password);
    void signUp(Student student);
}

