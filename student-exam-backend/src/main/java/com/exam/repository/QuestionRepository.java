package com.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.exam.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}