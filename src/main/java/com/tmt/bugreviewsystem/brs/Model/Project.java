package com.tmt.bugreviewsystem.brs.Model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@Component
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    int id;

    String pcode;
    String descr;
    String assignee;
    String lead1;
    String status;
}

