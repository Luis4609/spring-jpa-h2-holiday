package com.optimissa.holidayreader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.optimissa.reader.CsvReader;

@SpringBootApplication
public class HolidayReaderApplication {

	public static String fileName = "C:\\Users\\luis.monzon\\Desktop\\CSVFileJava\\festivity_currencies_YYYYMMDD.csv";

	private static final Logger log = LoggerFactory.getLogger(HolidayReaderApplication.class);

	@Autowired
	// private CalendarRepository calendarRepository;

	public static void main(String[] args) {
		SpringApplication.run(HolidayReaderApplication.class, args);

//		try {
//			CsvReader.readCsvWithSeparator(fileName, calendarRepository, holidayRepository);
//			System.out.println("READING");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

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

			// save a few customers
//			calendarRepository.save(new Calendario(99, "BCD"));
//			calendarRepository.save(new Calendario(100, "ABC"));

			// fetch all calendars
			log.info("Calendars found with findAll():");
			log.info("-------------------------------");
			for (Calendario calendars : calendarRepository.findAll()) {
				log.info(calendars.toString());
			}
			log.info("");
			CsvReader.readCsvWithSeparator(fileName, calendarRepository, holidayRepository);
			// holidayRepository);

//			Calendar calendarJava = Calendar.getInstance();
//
//			calendarJava.set(2018, 10, 10);
//
//			Date date = calendarJava.getTime();
//			
			// holidayRepository.save(new Holiday( 32, date));

//			// fetch all holidays
//			log.info("Holidays found with findAll():");
//			log.info("-------------------------------");
//			for (Holiday holidays : holidayRepository.findAll()) {
//				log.info(holidays.toString());
//			}
//			log.info("");

			// fetch all holidays
			log.info("Holidays found with findAllByIdCalendar():");
			log.info("-------------------------------");
			for (Holiday holidays : holidayRepository.findAllByIdCalendar(12)) {
				log.info(holidays.toString());
			}
			log.info("");
			
			
			System.out.println("Holiday Count: " + holidayRepository.count());

		};
	}
}
