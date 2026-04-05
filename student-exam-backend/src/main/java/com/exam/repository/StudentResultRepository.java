package com.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.model.StudentResult;

public interface StudentResultRepository extends JpaRepository<StudentResult, Integer> {
}