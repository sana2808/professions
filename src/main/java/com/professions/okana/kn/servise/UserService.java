package com.professions.okana.kn.servise;

import com.professions.okana.kn.model.User;

import java.time.LocalDate;
import java.util.List;

public interface UserService {
    int avgUserAge();

    User findByEmail(String email);


}
