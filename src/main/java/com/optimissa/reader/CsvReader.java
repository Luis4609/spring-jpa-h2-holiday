package com.optimissa.reader;

import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.optimissa.holidayreader.HolidayReaderApplication;
import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.repository.HolidayRepository;

public class CsvReader {

	private static final Logger log = LoggerFactory.getLogger(HolidayReaderApplication.class);

	/**
	 * @param fileName
	 * @param repository
	 * @param holidayRepository
	 */
	public static void readCsvWithSeparator(String fileName, CalendarRepository repository,
			HolidayRepository holidayRepository) {

		// Parse the CSV with the separator
		CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
		// reader
		try (CSVReader reader = new CSVReaderBuilder(new FileReader(fileName)).withCSVParser(csvParser).withSkipLines(1)
				.build()) {

			List<String[]> row = reader.readAll();

			//Build the Holiday after 
			row.forEach(x -> {

				for (int i = 0; i < x[3].length(); i++) {
					if (x[3].charAt(i) == '1') {

						Calendar calendarJava = Calendar.getInstance();

						calendarJava.set(Integer.parseInt(x[1]), Integer.parseInt(x[2]), i);

						Date date = calendarJava.getTime();

						// Get the calendar by name
						Calendario calendar = repository.findByName(x[0]);

						// Build the Holiday to save into the DB
						holidayRepository.save(new Holiday(calendar.getId(), date));

						log.info("Save new holiday");
					}
				}
			});

		} catch (Exception e) {
			log.warn("Exception in the CsvReader");
		}
	}

}