package com.exam.dto;


import java.util.Map;

import lombok.Data;

@Data
public class ExamRequest {
    private Map<String, String> student;
    private Map<String, String> answers;
}