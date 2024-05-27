package com.example.searchjob.controller;

import com.example.searchjob.entity.Employer;
import com.example.searchjob.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employers")
public class EmployerController {

    public final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/show")
    public List<Employer> getEmployer(@RequestParam(required = false) Long id) {
        log.info("trying GET endpoint employers/show?id=" + id);
        if (id != null) {
            List<Employer> employer = new ArrayList<Employer>();
            employer.add(employerService.getEmployerById(id));
            return employer;
        }
        return employerService.getAllEmployer();
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void createVacancy(@RequestBody Employer newEmployer) {
        log.info("trying POST endpoint employers/add");
        employerService.createEmployer(newEmployer);
    }

    @PutMapping("/update/{id}")
    public Employer updateVacancy(@PathVariable Long id,
                                 @RequestParam(required = false) String name) {
        log.info("trying PUT endpoint employers/update/" + id);
        return employerService.updateEmployer(name, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        log.info("trying POST endpoint employers/delete/" + id);
        employerService.deleteEmployer(id);
    }
}
