/**
 * 
 */
package com.optimissa.holidayreader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;
import com.optimissa.holidayreader.service.HolidayService;

/**
 * @author luis.monzon
 *
 */
@RestController
@RequestMapping(value = "/holiday")
public class HolidayController {

	@Autowired
	private HolidayService service;

	@Autowired
	private HolidayRepository repository;

	@GetMapping("/{id}")
	public Holiday getHoliday(@PathVariable long id) {
		return repository.findById(id);
//				.orElseThrow(() -> new HolidayNotFoundException());
	}

	@GetMapping("/all")
	public List<Holiday> getAllHoliday() {
		return service.getAll();
	}

	@GetMapping("by-calendar/{id}")
	public List<Holiday> getHolidaysByCalendar(@PathVariable int id) {
		return repository.findAllByIdCalendar(id);
	}

	@PostMapping("/")
	Holiday newHoliday(@RequestBody Holiday newHoliday) {
		return repository.save(newHoliday);
	}

//	@PutMapping("/{id}")
//	public Holiday updateHoliday(@RequestBody Holiday newHoliday, @PathVariable Long id) {
//
//		return repository.findById(id).map(holiday -> {
//			holiday.setIdCalendar(newHoliday.getIdCalendar());
//			holiday.setDate(newHoliday.getDate());
//			return repository.save(holiday);
//		}).orElseGet(() -> {
//			newHoliday.setId(id);
//			return repository.save(newHoliday);
//		});
//	}

	@PutMapping("{id}")
	public Holiday updateHoliday(@RequestBody int idCalendar, @PathVariable long id) {
		Holiday myHoliday = repository.findById(id);

		myHoliday.setIdCalendar(idCalendar);

		return repository.save(myHoliday);
	}

	@DeleteMapping("/{id}")
	public void deleteHoliday(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
