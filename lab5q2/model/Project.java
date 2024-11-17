package com.example.lab5q2.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Project {
    private String ID;
    private String title;
    private String description;
    private String  status;
    private String companyName;
}
