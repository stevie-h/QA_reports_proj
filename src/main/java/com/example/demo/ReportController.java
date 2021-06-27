package com.example.demo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class ReportController
{
    private static List<ReportDTO> m_reports = new ArrayList<>();
    ReportREPO repo = new ReportREPO("jdbc:sqlite:E:\\QA_course\\SQLite\\reports_240621.db");

    @GetMapping("/report")
    public List<ReportDTO> getAllReports()
    {
        return repo.getAllReports();
    }

    @GetMapping("/report/{id}")
    public ReportDTO getReportById(@PathVariable("id") int id)
    {
        return repo.getReportById(id);
    }

    @PostMapping("/report")
    public void addReport(@RequestBody ReportDTO report)
    {
        repo.insertReport(report);
    }

    @PutMapping("/report/{id}")
    public void updateReportByID(@PathVariable("id") int id, @RequestBody ReportDTO sent)
    {
        repo.updateReport(sent,id);
    }

    @DeleteMapping("/report/{id}")
    public void deleteReportById(@PathVariable("id") int id)
    {
        repo.deleteReport(id);
    }


}
