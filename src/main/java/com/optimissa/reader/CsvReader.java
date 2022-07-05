package com.optimissa.reader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Calendar;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.optimissa.holidayreader.entity.Calendario;
import com.optimissa.holidayreader.entity.Holiday;
import com.optimissa.holidayreader.repository.CalendarRepository;
import com.optimissa.holidayreader.repository.HolidayRepository;

public class CsvReader {
	public String fileName = "C:\\Users\\luis.monzon\\Desktop\\CSVFileJava\\festivity_currencies_YYYYMMDD.csv";
	// String fileName =
	// "C:\Users\luis.monzon\Documents\workspace-spring-tool-suite-4-4.13.1.RELEASE\intake-java-ficheros-develop\files\festivity_currencies_YYYYMMDD.csv"

	public static void main(String[] args) throws IOException, CsvException {

	}

	/**
	 * @param fileName
	 */
	public static void readCsv(String fileName) {

		try (CSVReader reader = new CSVReader(new FileReader(fileName))) {
			List<String[]> r = reader.readAll();

			System.out.println(r.get(0)[0]);

			// r.forEach(x -> System.out.println(Arrays.toString(x)));

//			for (String[] strings : r) {
//
//				System.out.println(Arrays.toString(strings));
//			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

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

			List<String[]> r = reader.readAll();

			// System.out.println(r.get(0)[1]);
//			r.forEach(x -> System.out.println((x[1])));

			// Construir HOLIDAY - DATE
			r.forEach(x -> {

				System.out.println("X:LENGTH-----" + x[3].length());

				for (int i = 0; i < x[3].length(); i++) {
					if (x[3].charAt(i) == '1') {

						System.out.println("X:1-----" + x[1] + " ------ " + Integer.parseInt(x[1]));

						Calendar calendarJava = Calendar.getInstance();

						calendarJava.set(Integer.parseInt(x[1]), Integer.parseInt(x[2]), i);

						Date date = calendarJava.getTime();

						// Get the calendar by name
						Calendario calendar = repository.findByName(x[0]);

						// Build the Holiday to save into the DB
						holidayRepository.save(new Holiday(calendar.getId(), date));
					}
				}
			});

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void csvToObject(String fileName) {
		List<Holiday> beans = null;
		try {
			beans = new CsvToBeanBuilder(new FileReader(fileName)).withType(Holiday.class).build().parse();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		beans.forEach(System.out::println);
	}

}