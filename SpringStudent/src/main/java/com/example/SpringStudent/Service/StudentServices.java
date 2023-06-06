package com.example.SpringStudent.Service;

import com.example.SpringStudent.Entity.Student;
import com.example.SpringStudent.Repo.StudentRepo;
import com.example.SpringStudent.Entity.Student;
import com.example.SpringStudent.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;

    public void saveorUpdate(Student student) {

        studentRepo.save(student);
    }

    public Iterable<Student> getAllStudent() {
        return studentRepo.findAll();
    }


    public void deleteStudentService(String id) {
        studentRepo.deleteById(id);
    }

    public Student getStudentById(String studentId) {
        return studentRepo.findById(studentId).get();
    }
}
