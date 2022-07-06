package com.optimissa.holidayreader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.service.CalendarService;

@RestController
@RequestMapping(value = "/calendar")
public class CalendarController {

	@Autowired
	private CalendarService service;

	@Autowired
	private CalendarRepository repository;

	@GetMapping("/{id}")
	public Calendario getCalendar(@PathVariable String id) {
		return service.getById(id);
	}

	@GetMapping("/all")
	public List<Calendario> getAllCalendars() {
		return service.getAll();
	}

	@GetMapping("/name")
	public Calendario getCalendarByName(String name) {
		return repository.findByName(name);
	}

	@GetMapping("order-by-name")
	public List<Calendario> getAllCalendarsOrderByNameAsc() {
		return service.getAllOrderByName();
	}

	@GetMapping("order-by-name-desc")
	public List<Calendario> getAllCalendarsOrderByNameDesc() {
		return service.getAllOrderByNameDesc();
	}

	@PutMapping("/{id}")
	public Calendario updateCalendar(@RequestBody Calendario newCalendar, @PathVariable Long id) {

		return repository.findById(id)
				.map(calendar -> {
					calendar.setName(newCalendar.getName());
					return repository.save(calendar);
		}).orElseGet(() -> {
			return repository.save(newCalendar);
		});
	}

	@PostMapping("/")
	Calendario newCalendar(@RequestBody Calendario newCalendar) {
		return repository.save(newCalendar);
	}

}
