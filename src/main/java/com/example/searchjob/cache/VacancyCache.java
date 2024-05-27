package com.example.searchjob.cache;

import com.example.searchjob.entity.Vacancy;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class VacancyCache {
    private final Map<Long, Vacancy> cache = new HashMap<>();

    public Vacancy get(Long id) {
        return cache.get(id);
    }

    public void put(Long id, Vacancy vacancy) {
        if (cache.size() < 10) {
            cache.put(id, vacancy);
        } else {
            cache.clear();
            cache.put(id, vacancy);
        }
    }

    public void remove(Long id) {
        cache.remove(id);
    }

    public void updateVacancyById(Long id, Vacancy vacancy) {
        if (get(id) != null) {

            remove(id);
            put(id, vacancy);
        }
    }

}
