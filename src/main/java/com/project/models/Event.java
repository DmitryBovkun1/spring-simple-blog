package com.project.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Optional;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date startDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date endDate;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date testDate;

    public Event(String title, Date startDate, Date endDate, Date testDate) {
        this.title = title;
        this.startDate = new Date(startDate.getTime());
        this.endDate = new Date(endDate.getTime());
        this.testDate = new Date(testDate.getTime());
    }

    public Event() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return Optional.ofNullable(this.startDate)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }

    public void setStartDate(Date startDate) {
        this.startDate = new Date(startDate.getTime());;
    }

    public Date getEndDate() {
        return Optional.ofNullable(this.endDate)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }

    public void setEndDate(Date endDate) {
        this.endDate = new Date(endDate.getTime());
    }

    public Date getTestDate() {
        return Optional.ofNullable(this.testDate)
                .map(Date::getTime)
                .map(Date::new)
                .orElse(null);
    }

    public void setTestDate(Date testDate) {
        this.testDate = new Date(testDate.getTime());;
    }
}
