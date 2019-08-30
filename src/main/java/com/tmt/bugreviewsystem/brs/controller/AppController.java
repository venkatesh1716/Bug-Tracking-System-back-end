package com.tmt.bugreviewsystem.brs.controller;

import com.tmt.bugreviewsystem.brs.Exceptions.UserNotFoundException;
import com.tmt.bugreviewsystem.brs.Model.Login;
import com.tmt.bugreviewsystem.brs.Model.Project;
import com.tmt.bugreviewsystem.brs.Model.User;
import com.tmt.bugreviewsystem.brs.service.LoginService;
import com.tmt.bugreviewsystem.brs.service.ProjectService;
import com.tmt.bugreviewsystem.brs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @RequestMapping(value = "projects", method = RequestMethod.GET)
    public List<Project> getAllProjects() {
        System.out.println(this.getClass().getSimpleName() + " - Get all Projects details are executed.");
        return projectService.getAllProjects();
    }

    @RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
    public Project getAuthorsById(@PathVariable int id) {
        System.out.println(this.getClass().getSimpleName() + " - Get  Project by ID details are executed.");
        Optional<Project> project = projectService.getProjectById(id);
        if (!project.isPresent())
            throw new UserNotFoundException("Could not find project with id- " + id);
        return project.get();
    }

    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET)
    public Login getUserById(@PathVariable int id) {
        Optional<Login> login = loginService.getLoginById(id);
        if (!login.isPresent())
            throw new UserNotFoundException("Could not find user with id- " + id);
        return login.get();
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public List<Login> getAllUsers() {
        System.out.println(this.getClass().getSimpleName() + " - Get all users details are executed.");
        return loginService.getAllUsers();
    }

    @PostMapping("/login")
     public Map<String,Boolean> addCred(@RequestBody Login login) {
        Optional<Login> optionalLogin = loginService.validateUser(login);
        if (optionalLogin.isPresent()) {
            return Collections.singletonMap("isValid", Boolean.TRUE);
        } else {
            return Collections.singletonMap("isValid", Boolean.FALSE);
        }
    }

    @PostMapping("/projects")
    public void createProject(@RequestBody Project project) {
        projectService.addProject(project);
    }

    @RequestMapping(value = "projects/{id}", method = RequestMethod.DELETE)
    public List<Project> deleteProjectById(@PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Project with id" + id + "deleted");
        Optional<Project> project = projectService.getProjectById(id);
        if (!project.isPresent())
            throw new UserNotFoundException("Could not find Project with id- " + id);
        projectService.deleteProjectById(id);
        return projectService.getAllProjects();
    }

    @PutMapping("/projects/{id}")
    public Project updateProject(@RequestBody Project project, @PathVariable int id) throws Exception {
        System.out.println(this.getClass().getSimpleName() + " - Update Project details by id" + id + " is executed.");
        Optional<Project> project1 = projectService.getProjectById(id);
        if (!project1.isPresent())
            throw new UserNotFoundException("Could not find project with id- " + id);

        if (project.getId() == 0)
            project.setId(project1.get().getId());

        if (project.getDescr() == null || project.getDescr().isEmpty())
            project.setDescr(project1.get().getDescr());

        if (project.getAssignee() == null || project.getAssignee().isEmpty())
            project.setAssignee(project1.get().getAssignee());

        if (project.getPcode() == null)
            project.setPcode((project1.get().getPcode()));

        if (project.getStatus() == null)
            project.setStatus((project1.get().getStatus()));

        if (project.getLead1() == null)
            project.setLead1((project1.get().getLead1()));

        return projectService.updateProject(project);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) {
        userService.addUser(user);
    }
}
