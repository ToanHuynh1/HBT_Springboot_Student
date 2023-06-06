package com.example.SpringStudent.Controller;

import com.example.SpringStudent.Entity.Student;
import com.example.SpringStudent.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentServices studentServices;

    @PostMapping(value = "/save")
    public String saveStudent(@RequestBody Student student){
        studentServices.saveorUpdate(student);
        return  student.get_id();
    }

    @GetMapping(value = "/getAll")
    public Iterable<Student> getStudents(){
        return  studentServices.getAllStudent();
    }

    @Transactional
    @PutMapping("/edit/{id}")
    private Student update(@RequestBody Student student, @PathVariable(name = "id") String _id) {
        student.set_id(_id);
        studentServices.saveorUpdate(student);
        return student;
    }

    @DeleteMapping(value = "/delete/{_id}")
    public void deleteStudent(@PathVariable("_id") String _id){
        studentServices.deleteStudentService(_id);
    }

    @GetMapping("/search/{id}")
    public Student getStudents(@PathVariable(name = "id") String studentId )
    {
        return studentServices.getStudentById(studentId);
    }


}
