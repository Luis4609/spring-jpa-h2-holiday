/**
 * 
 */
package com.optimissa.holidayreader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.HolidayRepository;

/**
 * @author luis.monzon
 *
 */
@RestController
@RequestMapping(value = "/holiday")
public class HolidayController {

	@Autowired
	private HolidayRepository repo;

	@GetMapping("/")
	public @ResponseBody List<Holiday> getAll() {
		return findAllHoliday();
	}

	@GetMapping(value = "/test", produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String test() {
		return "<html>\n" + "<header><title>Welcome</title></header>\n" + "<body>\n" + "Hello world 323232\n" + "</body>\n"
				+ "</html>";
	}

	/**
	 * @return
	 */
	private List<Holiday> findAllHoliday() {

		return repo.findAll();
	}
}
