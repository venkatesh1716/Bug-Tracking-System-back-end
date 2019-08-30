package com.tmt.bugreviewsystem.brs.service;

import com.tmt.bugreviewsystem.brs.Model.Project;
import com.tmt.bugreviewsystem.brs.repo.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService  {


    @Autowired
    ProjectRepo projectRepo;

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public Optional<Project> getProjectById(int id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project updateProject(Project project1) {
        return projectRepo.save(project1);
    }

    @Override
    public Optional<Project> deleteProjectById(int id) {
        projectRepo.deleteBookByBookID(id);
        return null;
    }

}
