package com.tmt.bugreviewsystem.brs.Model;


import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "login")
public class Login {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;
    String username;
    String password;

}
