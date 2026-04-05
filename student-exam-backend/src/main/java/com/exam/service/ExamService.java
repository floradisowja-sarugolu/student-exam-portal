package com.exam.service;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.ExamRequest;
import com.exam.model.StudentResult;
import com.exam.repository.StudentRepository;
import com.exam.repository.StudentResultRepository;
import com.exam.util.PdfService;

@Service
public class ExamService {

    @Autowired
    private StudentResultRepository repo;

    @Autowired
    private PdfService pdfService;

    @Autowired
    private EmailService emailService;

    public void processExam(ExamRequest request) throws Exception {

        int score = 0;

        if ("Language".equals(request.getAnswers().get("1"))) score++;
        if ("Structured Query Language".equals(request.getAnswers().get("2"))) score++;

        StudentResult result = new StudentResult();
        result.setName(request.getStudent().get("name"));
        result.setRoll(request.getStudent().get("roll"));
        result.setEmail(request.getStudent().get("email"));
        result.setScore(score);

        repo.save(result);

        File pdf = pdfService.generatePdf(result.getName(), result.getRoll(), score);

        emailService.sendEmail(result.getEmail(), pdf);
    }
}