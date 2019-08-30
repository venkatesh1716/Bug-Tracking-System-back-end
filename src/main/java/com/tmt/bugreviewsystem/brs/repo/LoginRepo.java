package com.tmt.bugreviewsystem.brs.repo;

import com.tmt.bugreviewsystem.brs.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepo extends JpaRepository<Login,Integer> {
    Optional<Login> findByUsernameAndPassword(String userName, String password);
}
