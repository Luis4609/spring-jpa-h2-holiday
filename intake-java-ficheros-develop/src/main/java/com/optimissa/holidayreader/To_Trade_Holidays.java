package com.optimissa.holidayreader;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TO_TRADE_HOLIDAYS")
public class To_Trade_Holidays implements Serializable {

    @Id
    @Column(name = "IDCALENDAR")
    private int id;

    @Column(name = "HOLIDAY")
    private String holiday;

   // @Column(name = "TO_TRADE_CALENDAR", nullable = true)
    //private To_Trade_Calendars calendar;

    public To_Trade_Holidays() {
    }

    public To_Trade_Holidays(int i, String holiday) {
    }


    public int getId() {
        return id;
    }


    //public To_Trade_Calendars getCalendar() {
      //  return calendar;
    //}

    //public void setCalendar(To_Trade_Calendars calendar) {
      //  this.calendar = calendar;
    //}

    public void setId(int id) {
        this.id = id;
    }


    public String getHoliday() {
        return holiday;
    }


    public void setHoliday(String holiday) {
        holiday = holiday;
    }

    @Override
    public String toString() {
        return "To_Trade_Holidays [id=" + id + ", Holiday=" + holiday + "]";
    }

}
