package com.optimissa.holidayreader;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TO_TRADE_CALENDARS")
public class To_Trade_Calendars implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="IDCALENDAR")
	private int id;
	@Column(name="NAME")
	private String nombre;
	
	//constructor vacío
	
	public To_Trade_Calendars() {
		
		
	}


	//constructor
	
	public To_Trade_Calendars(int id_idCalendar, String nombre) {
		
		this.id = id_idCalendar;
		this.nombre = nombre;
	}
	
	
	//Getters y Setters
	
	public int getId_idCalendar() {
		return id;
	}


	public void setId_idCalendar(int id_idCalendar) {
		this.id = id_idCalendar;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "To_Trade_Calendars [id_idCalendar=" + id + ", nombre=" + nombre + "]";
	}
	
	
	
	
}
