package com.optimissa.holidayreader;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TO_TRADE_CALENDARS")
public class Calendario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "IDCALENDAR")
	private int id;

	@Column(name = "NAME")
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return name;
	}

	public void setNombre(String nombre) {
		this.name = nombre;
	}

	/**
	 * 
	 */
	public Calendario() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param nombre
	 */
	public Calendario(int id, String nombre) {
		this.id = id;
		this.name = nombre;
	}

	@Override
	public String toString() {
		return "Calendar [id=" + id + ", nombre=" + name + "]";
	}

}
