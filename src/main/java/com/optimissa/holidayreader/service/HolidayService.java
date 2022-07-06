/**
 * 
 */
package com.optimissa.holidayreader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;

/**
 * @author luis.monzon
 *
 */
@Service
public class HolidayService {

	@Autowired
	private HolidayRepository repository;

	public List<Holiday> getAll() {
		return repository.findAll();
	}

	public Holiday getById(long id) {
		return repository.findById(id);
	}

//	public Holiday create(Holiday holiday) {
//
//		Holiday holidayToSave = repository.save(holiday);
//		return holidayToSave;
//	}

	public void addHoliday(int id) {
		Holiday newHoliday = new Holiday();
		newHoliday.setIdCalendar(id);
		repository.save(newHoliday);
	}

	public boolean delete(String id) {

		long idLong = Long.parseLong(id);

		if (repository.findById(idLong) == null) {
			return false;
		} else {
			repository.deleteById(idLong);
			return true;
		}

	}
}
