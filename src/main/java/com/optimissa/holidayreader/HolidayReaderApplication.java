package com.optimissa.holidayreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.repository.HolidayRepository;
import com.optimissa.reader.CsvReader;

@SpringBootApplication
public class HolidayReaderApplication {

	//Get the path from the file.properties
	//@Value("${}")
	public static String fileName = "C:\\Users\\luis.monzon\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\intake-java-ficheros-develop\\files\\festivity_currencies_YYYYMMDD.csv";
	
	private static final Logger log = LoggerFactory.getLogger(HolidayReaderApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HolidayReaderApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CalendarRepository calendarRepository, HolidayRepository holidayRepository) {
		return (args) -> {

			// Get calendar
			// fetch an individual calendar by ID
			Calendario calendar = calendarRepository.findById(10);
			log.info("Calendar found with findById(ID):");
			log.info("--------------------------------");
			log.info(calendar.toString());
			log.info("");

			// fetch all calendars
			log.info("Calendars found with findAll():");
			log.info("-------------------------------");
			for (Calendario calendars : calendarRepository.findAll()) {
				log.info(calendars.toString());
			}
			log.info("");
			

			CsvReader.readCsvWithSeparator(fileName, calendarRepository, holidayRepository);
			
			
			log.info("Calendario USD: {}", calendarRepository.findByName("USD"));

			// fetch all holidays
			log.info("Holidays found with findAllByIdCalendar():");
			log.info("-------------------------------");
			for (Holiday holidays : holidayRepository.findAllByIdCalendar(12)) {
				log.info(holidays.toString());
			}
			log.info("");

			log.info("Holiday Count {}", holidayRepository.count());

		};
	}
}
