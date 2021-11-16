package com.professions.okana.kn.dao;

import com.professions.okana.kn.model.User;

import java.util.List;

public interface UserDAO {
    User findBySurname(String surname);

    int avgUserAge();

    User findByEmail(String email);


}
