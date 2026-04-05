package com.exam.util;

import java.io.File;
import java.io.FileOutputStream;

import org.springframework.stereotype.Service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class PdfService {

    public File generatePdf(String name, String roll, int score) throws Exception {

        Document document = new Document();
        File file = new File("result.pdf");

        PdfWriter.getInstance(document, new FileOutputStream(file));

        document.open();

        document.add(new Paragraph("Student Exam Result"));
        document.add(new Paragraph("Name: " + name));
        document.add(new Paragraph("Roll: " + roll));
        document.add(new Paragraph("Score: " + score));

        document.close();

        return file;
    }
}