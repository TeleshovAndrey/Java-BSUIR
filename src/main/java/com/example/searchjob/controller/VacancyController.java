package com.example.searchjob.controller;

import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.servise.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    @Autowired
    public VacancyService vacancyService;
    @GetMapping("/show")
    public List<Vacancy> getVacancy()
    {
        return vacancyService.getAllVacancy();
    }
}
