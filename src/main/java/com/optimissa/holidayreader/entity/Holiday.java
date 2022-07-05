/**
 *
 */
package com.optimissa.holidayreader.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author luis.monzon
 *
 */
@Entity
@Table(name = "TO_TRADE_HOLIDAYS")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "IDCALENDAR")
    private int idCalendar;

    @Column(name = "HOLIDAY")
    private Date date;

    public long getId() {
        return id;
    }

    public int getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(int idCalendar) {
        this.idCalendar = idCalendar;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /**
     *
     */
    public Holiday() {
        super();
    }

    /**
     * @param id
     * @param date
     */
    public Holiday(int id, Date date) {
        this.idCalendar = id;
        this.date = date;
    }

    /**
     * @param id
     * @param idCalendar
     * @param date
     */
    public Holiday(long id, int idCalendar, Date date) {
        this.id = id;
        this.idCalendar = idCalendar;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Holiday [id=" + idCalendar + ", date=" + date + "]";
    }

}
