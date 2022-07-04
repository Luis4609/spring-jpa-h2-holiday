package com.optimissa.holidayreader;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CalendarRepository  extends CrudRepository<To_Trade_Calendars, Long> {

	List<To_Trade_Calendars> findAll();

	To_Trade_Calendars findById(int id);
}

