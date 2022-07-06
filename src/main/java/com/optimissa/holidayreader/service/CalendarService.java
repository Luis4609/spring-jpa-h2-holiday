package com.optimissa.holidayreader.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.repository.CalendarRepository;

@Service
public class CalendarService {

	@Autowired
	private CalendarRepository repository;

	public Calendario create(Calendario calendar) {

		Calendario calendarToSave = repository.save(calendar);
		return calendarToSave;
	}

	public Calendario getById(String id) {

		int idCalendar = Integer.parseInt(id);
		return repository.findById(idCalendar);
	}

	public Calendario getByName(String name) {
		return repository.findByName(name);
	}

	public List<Calendario> getAll() {
		return repository.findAll();
	}

	public List<Calendario> getAllOrderByName() {
		// TODO Auto-generated method stub
		return repository.findByOrderByName();
	}

	public List<Calendario> getAllOrderByNameDesc() {
		// TODO Auto-generated method stub
		return repository.findByOrderByNameDesc();
	}

}