package com.klu.studentportfolio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/profile/{id}")
    public Map<String,Object> getProfile(@PathVariable Long id){

        User user = userRepository.findById(id).orElse(null);

        Map<String,Object> response = new HashMap<>();

        response.put("name", user.getName());
        response.put("email", user.getEmail());
        response.put("role", user.getRole());

        if(user.getRole().equals("STUDENT")){

            List<Project> projects =
                projectRepository.findByStudentName(user.getName());

            response.put("totalProjects", projects.size());
        }
        else{

            List<Project> projects =
                projectRepository.findAll();

            response.put("totalReviewed", projects.size());
        }

        return response;
    }
}