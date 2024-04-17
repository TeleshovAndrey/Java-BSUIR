package com.example.searchjob.service;

import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    private final VacancyRepository vacancyRepository;

    public VacancyService(VacancyRepository vacancyRepository) {
        this.vacancyRepository = vacancyRepository;
    }

    public List<Vacancy> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    public Vacancy getVacancyById(Long id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public void createVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        Vacancy vacancyBuffer = vacancyRepository.findById(id).orElse(null);
        if (vacancyBuffer != null) vacancyRepository.deleteById(id);
    }

    public Vacancy updateVacancy(String title, Long id, String description, Long salary) {
        Vacancy existingVacancy = vacancyRepository.findById(id).orElse(null);
        if (existingVacancy != null) {
            existingVacancy.setId(id);
            existingVacancy.setTitle(title);
            existingVacancy.setSalary(salary);
            existingVacancy.setDescription(description);
            vacancyRepository.save(existingVacancy);
        }
        return existingVacancy;
    }
}