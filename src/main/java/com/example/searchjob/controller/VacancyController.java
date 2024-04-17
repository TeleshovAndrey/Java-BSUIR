package com.example.searchjob.controller;

import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.service.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    public final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping("/show")
    public List<Vacancy> getVacancy(@RequestParam(required = false) Long id) {
        if (id != null) {
            List<Vacancy> vacancy = new ArrayList<Vacancy>();
            vacancy.add(vacancyService.getVacancyById(id));
            return vacancy;
        }
        return vacancyService.getAllVacancy();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVacancy(@RequestBody Vacancy newVacancy) {
        vacancyService.createVacancy(newVacancy);
    }

    @PutMapping("/update/{id}")
    public Vacancy updateVacancy(@PathVariable Long id,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) Long salary) {
        return vacancyService.updateVacancy(title, id, description, salary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        vacancyService.deleteVacancy(id);
    }
}
