package com.exam.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.exam.repository.QuestionRepository;
import com.exam.model.Question;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class QuestionController {

    private final QuestionRepository repo;

    public QuestionController(QuestionRepository repo) {
        this.repo = repo;
    }

    // Add questions (one time use)
    @PostMapping("/add-question")
    public Question addQuestion(@RequestBody Question q) {
        return repo.save(q);
    }

    // Get all questions
    @GetMapping("/questions")
    public List<Question> getAll() {
        return repo.findAll();
    }
}