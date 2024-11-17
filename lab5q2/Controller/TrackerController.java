package com.example.lab5q2.Controller;

import com.example.lab5q2.ApiRespons.ApiResopnse;
import com.example.lab5q2.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/project")
public class TrackerController {
    ArrayList<Project> projects = new ArrayList<>();


    public ArrayList<Project> getProjects() {
        return projects;
    }

    @PostMapping("/add")
    public ApiResopnse addProject(@RequestBody Project project) {
        projects.add(project);
        return new ApiResopnse("project added");
    }

    @GetMapping("/get")
    public ArrayList<Project> getProject() {
        return projects;
    }

    @PutMapping("/update/{index}")
    public ApiResopnse updateProject(@PathVariable int index, @RequestBody Project project) {
        projects.set(index, project);
        return new ApiResopnse("project updated");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResopnse deleteProject(@PathVariable int index) {
        projects.remove(index);
        return new ApiResopnse("project deleted");
    }

    @PutMapping("/mark/{index}")
    public ApiResopnse markAsDone(@PathVariable int index) {
        if (index >= 0 && index < projects.size()) {
            Project project = projects.get(index);
            if (project.getStatus().equalsIgnoreCase("not done")) {
                project.setStatus("done");
                return new ApiResopnse("project marked as done");
            } else {
                return new ApiResopnse("project is already marked as done");
            }
        } else {
            return new ApiResopnse("project not found") ;
        }
    }

    @GetMapping("search/{title}")
    public ArrayList<Project> search(@PathVariable String title) {
        for (Project project : projects) {
            if (project.getTitle().equalsIgnoreCase(title)) {
                return projects;
            }
        }
        return projects;
    }

   @GetMapping("/all/{companyNAme}")
    public ArrayList<Project> allProject(@PathVariable String companyNAme) {
        ArrayList<Project> projects1 = new ArrayList<>();
        for (Project project : projects) {
            if (project.getCompanyName().equalsIgnoreCase(companyNAme)) {
                projects1.add(project);
                return projects1;
            }
        }
        return projects1;
    }
}









