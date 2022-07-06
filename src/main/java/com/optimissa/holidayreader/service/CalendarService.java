package com.optimissa.holidayreader.service;

import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarService {

    @Autowired
    private CalendarRepository repository;

    public Calendario getById(String id) {

        int idCalendar = Integer.parseInt(id);
        return repository.findById(idCalendar);
    }

    public List<Calendario> getAll() {
        return repository.findAll();
    }

    public Calendario create(Calendario calendar) {

        Calendario calendarToSave = repository.save(calendar);
        return calendarToSave;
    }

}
