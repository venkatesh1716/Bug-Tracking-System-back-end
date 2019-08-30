package com.tmt.bugreviewsystem.brs.service;

import com.tmt.bugreviewsystem.brs.Model.Login;
import com.tmt.bugreviewsystem.brs.Model.User;
import com.tmt.bugreviewsystem.brs.repo.LoginRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    LoginRepo loginRepo;
    @Override
    public Optional<Login> getLoginById(int id) {
        return loginRepo.findById(id);
    }

    @Override
    public Login addCredentials(Login login) {
        return loginRepo.save(login);
    }

    @Override
    public List<Login> getAllUsers() {
        return loginRepo.findAll();
    }

    @Override
    public Optional<Login> validateUser(Login login) {
        return loginRepo.findByUsernameAndPassword(login.getUsername(), login.getPassword());
    }
}
