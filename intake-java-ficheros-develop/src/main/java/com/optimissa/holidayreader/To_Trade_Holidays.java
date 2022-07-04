package com.optimissa.holidayreader;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TO_TRADE_HOLIDAYS")
public class To_Trade_Holidays implements Serializable {

	@Id
	@Column(name="IDCALENDAR")
	
    private To_Trade_Calendars calendar;
	
	private int id;

	@Column(name="HOLIDAY")
	private String Holiday;
	
	
	//Constructor vacío
	
	public To_Trade_Holidays() {
		
		
	}

	//Constructor
	
	public To_Trade_Holidays(To_Trade_Calendars calendar, int id, String holiday) {
		
		this.calendar = calendar;
		this.id = id;
		Holiday = holiday;
	}
	

	//Getters y Setters
	
	
	public int getId() {
		return id;
	}


	public To_Trade_Calendars getCalendar() {
		return calendar;
	}

	public void setCalendar(To_Trade_Calendars calendar) {
		this.calendar = calendar;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getHoliday() {
		return Holiday;
	}


	public void setHoliday(String holiday) {
		Holiday = holiday;
	}

	@Override
	public String toString() {
		return "To_Trade_Holidays [calendar=" + calendar + ", id=" + id + ", Holiday=" + Holiday + "]";
	}
	
}
