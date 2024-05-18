package com.example.searchjob.cache;

import com.example.searchjob.entity.Employer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class EmployerCache {
    private final Map<Long, Employer> cache = new HashMap<>();

    public Employer get(Long id) {
        return cache.get(id);
    }

    public void put(Long id, Employer employer) {
        if (cache.size() < 10) {
            cache.put(id, employer);
        }
    }

    public void remove(Long id) {
        cache.remove(id);
    }

    public void updateEmployerById(Long id, Employer employer) {
        if (get(id) != null) {

            remove(id);
            put(id, employer);
        }
    }

}
