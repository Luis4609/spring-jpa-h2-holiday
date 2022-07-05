package com.optimissa.holidayreader.service;

import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HolidayService {

    @Autowired
    private HolidayRepository repository;

    public List<Holiday> getAll() {
        return repository.findAll();
    }

    public Holiday find(String id) {

        long idLong = Long.parseLong(id);
        return repository.findById(idLong);
    }

    public Holiday create(Holiday holiday) {

        Holiday holidayToSave = repository.save(holiday);
        return holidayToSave;
    }

}
