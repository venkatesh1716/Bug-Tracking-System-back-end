package com.tmt.bugreviewsystem.brs.service;

import com.tmt.bugreviewsystem.brs.Model.Login;
import com.tmt.bugreviewsystem.brs.Model.Project;
import com.tmt.bugreviewsystem.brs.Model.User;

import java.util.List;
import java.util.Optional;

public interface LoginService {

    Optional<Login> getLoginById(int id);
    Login addCredentials(Login login);
    List<Login> getAllUsers();

    Optional<Login> validateUser(Login login);
}
