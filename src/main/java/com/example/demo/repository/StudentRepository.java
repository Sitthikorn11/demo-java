package com.example.demo.repository;

import com.example.demo.dto.Student;
import com.example.demo.entity.StudentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends CrudRepository <StudentEntity, Long > {


}
