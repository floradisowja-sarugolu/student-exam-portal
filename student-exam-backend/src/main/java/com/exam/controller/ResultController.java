package com.exam.controller;



import org.springframework.web.bind.annotation.*;
import com.exam.model.Result;
import com.exam.repository.ResultRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ResultController {

    private final ResultRepository repo;

    public ResultController(ResultRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/submit")
    public Result submit(@RequestBody Result r) {
        return repo.save(r);
    }

    @GetMapping("/results")
    public java.util.List<Result> getAll() {
        return repo.findAll();
    }
}
