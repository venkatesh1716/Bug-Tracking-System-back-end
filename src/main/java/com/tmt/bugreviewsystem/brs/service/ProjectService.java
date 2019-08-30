package com.tmt.bugreviewsystem.brs.service;

import com.tmt.bugreviewsystem.brs.Model.Project;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    List<Project>  getAllProjects();

    Project addProject(Project project);

    Optional<Project> getProjectById(int id);

    Project updateProject(Project project);

    Optional<Project> deleteProjectById(int id);



}
