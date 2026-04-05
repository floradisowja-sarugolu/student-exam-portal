package com.exam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.exam.dto.ExamRequest;
import com.exam.service.ExamService;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ExamController {

    @Autowired
    private ExamService service;

    @PostMapping("/submit")
    public String submitExam(@RequestBody ExamRequest request) {
        try {
            service.processExam(request);
            return "Success";
        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }
}