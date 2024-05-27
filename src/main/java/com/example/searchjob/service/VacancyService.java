package com.example.searchjob.service;

import com.example.searchjob.cache.VacancyCache;
import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.repository.VacancyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class VacancyService {
    private final VacancyCache vacancyCache;
    private final VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancy() {
        return vacancyRepository.findAll();
    }

    public Vacancy getVacancyById(Long id) {
        Vacancy vacancy = vacancyCache.get(id);
        if (vacancy == null) {

            Vacancy vacancyBuffer = vacancyRepository.findById(id).orElse(null);
            vacancyCache.put(id, vacancyBuffer);
            return vacancyBuffer;
        }
        return vacancy;
    }

    public void createVacancy(Vacancy vacancy) {
        vacancyRepository.save(vacancy);
    }

    public void deleteVacancy(Long id) {
        Vacancy vacancyBuffer = vacancyRepository.findById(id).orElse(null);
        if (vacancyBuffer != null) {
            vacancyRepository.deleteById(id);
        }
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

    public List<Vacancy> getVacancyFromSalary(Long salary) {
        return vacancyRepository.findVacancyFromSalary(salary);
    }
}