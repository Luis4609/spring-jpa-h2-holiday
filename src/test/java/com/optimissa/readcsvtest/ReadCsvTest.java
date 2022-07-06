/**
 * 
 */
package com.optimissa.readcsvtest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.repository.HolidayRepository;

/**
 * @author luis.monzon
 *
 */
class ReadCsvTest {

	@Autowired
	private HolidayRepository holidayRepository;
	@Autowired
	private CalendarRepository calendarRepository;

	@Test
	void checkHolidayCount() {
		assertEquals(2705, holidayRepository.count());
	}
	
	@Test
	void checkCalendarCount() {
		assertEquals(38, calendarRepository.count());
	}

}
