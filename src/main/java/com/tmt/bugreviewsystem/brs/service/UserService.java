package com.tmt.bugreviewsystem.brs.service;
import com.tmt.bugreviewsystem.brs.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getUsers();

    User addUser(User user);

    Optional<User> getUserById(int id);

    User updateUser(User user);

    Optional<User> deleteUserById(int id);
}
