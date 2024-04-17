package com.example.searchjob.service;

import com.example.searchjob.entity.Employer;
import com.example.searchjob.repository.EmployerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;

    public EmployerService(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public List<Employer> getAllEmployer() {
        return employerRepository.findAll();
    }

    public Employer getEmployerById(Long id) {
        return employerRepository.findById(id).orElse(null);
    }

    public void createEmployer(Employer employer) {
        employerRepository.save(employer);
    }

    public void deleteEmployer(Long id) {
        Employer vacancyBuffer = employerRepository.findById(id).orElse(null);
        if (vacancyBuffer != null) employerRepository.deleteById(id);
    }

    public Employer updateEmployer(String name, Long id) {
        Employer existingEmployer = employerRepository.findById(id).orElse(null);
        if (existingEmployer != null) {
            existingEmployer.setId(id);
            existingEmployer.setName(name);
            employerRepository.save(existingEmployer);
        }
        return existingEmployer;
    }
}
