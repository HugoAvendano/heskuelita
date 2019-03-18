package com.capgemini.heskuelita.data;

import com.capgemini.heskuelita.core.beans.Student;


public interface IUserDao {
    Student login(String email, String password);
    void signUp(Student Student);
}

