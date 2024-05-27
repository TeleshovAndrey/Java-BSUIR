package com.example.searchjob.controller;

import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.service.VacancyService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/vacancy")
public class VacancyController {

    public final VacancyService vacancyService;

    public VacancyController(VacancyService vacancyService) {
        this.vacancyService = vacancyService;
    }

    @GetMapping()
    public List<Vacancy> getVacancy(@RequestParam(required = false) Long id) {
        log.info("trying GET endpoint /vacancy?id=" + id);
        if (id != null) {
            List<Vacancy> vacancy = new ArrayList<Vacancy>();
            vacancy.add(vacancyService.getVacancyById(id));
            return vacancy;
        }
        return vacancyService.getAllVacancy();
    }

    @GetMapping("/find")
    public List<Vacancy> getVacancyFromSalary(@RequestParam(required = false) Long salary) {
        log.info("trying GET endpoint /vacancy/find?salary=" + salary);
        if (salary != null) {
            return vacancyService.getVacancyFromSalary(salary);
        }
        return vacancyService.getAllVacancy();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVacancy(@RequestBody Vacancy newVacancy) {
        log.info("trying POST endpoint /vacancy/add");
        vacancyService.createVacancy(newVacancy);
    }

    @PutMapping("/update/{id}")
    public Vacancy updateVacancy(@PathVariable Long id,
                                 @RequestParam(required = false) String title,
                                 @RequestParam(required = false) String description,
                                 @RequestParam(required = false) Long salary) {
        log.info("trying PUT endpoint /vacancy/update/" + id);
        return vacancyService.updateVacancy(title, id, description, salary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        log.info("trying DELETE endpoint /vacancy/delete/" + id);
        vacancyService.deleteVacancy(id);
    }

}
