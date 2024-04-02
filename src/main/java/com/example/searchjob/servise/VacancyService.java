package com.example.searchjob.servise;

import com.example.searchjob.entity.Vacancy;
import com.example.searchjob.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {
    @Autowired
    public VacancyRepository vacancyRepository;

    public List<Vacancy> getAllVacancy()
    {
        return vacancyRepository.findAll();
    }
    public Vacancy getUserById(Long id) {
        return vacancyRepository.findById(id).orElse(null);
    }

    public Vacancy createUser(Vacancy user) {
        return vacancyRepository.save(user);
    }

    public void deleteUser(Long id) {
        vacancyRepository.deleteById(id);
    }
}
