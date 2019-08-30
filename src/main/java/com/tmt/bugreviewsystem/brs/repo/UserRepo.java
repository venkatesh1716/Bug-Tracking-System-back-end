package com.tmt.bugreviewsystem.brs.repo;

import com.tmt.bugreviewsystem.brs.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
