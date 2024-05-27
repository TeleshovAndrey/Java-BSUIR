package com.example.searchjob.repository;

import com.example.searchjob.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Long> {

    @Query("SELECT v FROM Vacancy v WHERE v.salary >= :salary")
    List<Vacancy> findVacancyFromSalary(Long salary);
}
