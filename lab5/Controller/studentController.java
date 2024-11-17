package com.example.lab5.Controller;

import com.example.lab5.ApiRespons.ApiResopnse;
import com.example.lab5.Model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("lab5/v1/student")
public class studentController {

    ArrayList<Student> studentsList = new ArrayList<>();

    public ArrayList<Student> students() {
        return studentsList;
    }

    @PostMapping("/add")
    public ApiResopnse addStudent(@RequestBody Student student) {
     studentsList.add(student);

        return new ApiResopnse("student added");
    }

    @GetMapping("/get")
    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }
  @PutMapping("/update/{index}")
    public ApiResopnse updateStudent(@PathVariable int index,@RequestBody Student student){
        studentsList.set(index, student);
        return new ApiResopnse("student updated");
    }

    @DeleteMapping ("/delete/{index}")
    public ApiResopnse deleteStudent(@PathVariable int index) {
        studentsList.remove(index);
        return new ApiResopnse("student deleted");
    }

    @GetMapping("/honors")
    public ArrayList<Student> honors() {
        ArrayList<Student> honorsStudent = new ArrayList<>();
        for (Student student : studentsList) {
            if (student.getGPA() >= 3) {
                honorsStudent.add(student);
            }
        }
        return honorsStudent;
    }
@GetMapping("/GPA")
    public ArrayList<Student>graterGPA(){
        ArrayList<Student> bestGPA = new ArrayList<>();
        double sum = 0;
        for (Student student : studentsList) {
            sum += student.getGPA();
        }
        double average = sum / studentsList.size();

        for (Student student : studentsList) {
            if (student.getGPA() > average) {
                bestGPA.add(student);
            }
        }
        return bestGPA;
    }
}
