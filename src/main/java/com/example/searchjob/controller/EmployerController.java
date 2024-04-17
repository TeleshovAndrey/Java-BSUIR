package com.example.searchjob.controller;

import com.example.searchjob.entity.Employer;
import com.example.searchjob.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employers")
public class EmployerController {

    public final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/show")
    public List<Employer> getEmployer(@RequestParam(required = false) Long id) {
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
        employerService.createEmployer(newEmployer);
    }

    @PutMapping("/update/{id}")
    public Employer updateVacancy(@PathVariable Long id,
                                 @RequestParam(required = false) String name) {
        return employerService.updateEmployer(name, id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteVacancy(@PathVariable Long id) {
        employerService.deleteEmployer(id);
    }
}
