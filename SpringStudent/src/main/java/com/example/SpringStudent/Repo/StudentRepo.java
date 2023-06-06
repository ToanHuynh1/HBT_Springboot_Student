package com.example.SpringStudent.Repo;

import com.example.SpringStudent.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepo extends MongoRepository<Student, String> {
}
