package com.klu.studentportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@CrossOrigin(origins = "*")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    // Upload project
    @PostMapping("/add")
    public Project addProject(@RequestBody Project project) {
        return projectRepository.save(project);
    }

    // Get all projects
    @GetMapping("/all")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    // Get project count
    @GetMapping("/count")
    public long getProjectCount() {
        return projectRepository.count();
    }
}