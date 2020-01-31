package com.aioisisi.lab2.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table
@Log4j2
public class Route {
    private static final String FORMAT = "YYYY/MM/DD hh:mm";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(FORMAT);
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Address departureAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Address arrivalAddress;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date departureDateTime;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date arrivalDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transport transport;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<User> users;

    @Transient
    private Date duration;

    @Transient
    private Integer freeSeats;;

    public Route() {
        this.departureAddress = new Address();
        this.arrivalAddress = new Address();
        this.users = new ArrayList<>();
        this.freeSeats = 0;
        duration = new Date(0);
    }

    public Date getDuration() {
        this.duration = new Date(arrivalDateTime.getTime() - departureDateTime.getTime());
        return duration;
    }

    public boolean addUser(User user) {
        if (getFreeSeats() > 0) {
            return users.add(user);
        } else {
            return false;
        }
    }

    public boolean isNotJoined(User user) {
        return !users.contains(user);
    }

    public Integer getFreeSeats() {
        return transport.getCapacity() - users.size();
    }

//    public void setDepartureDateTime(String departureDateTime) {
//        try {
//            this.departureDateTime = dateFormat.parse(departureDateTime);
//        } catch (ParseException e) {
//            this.departureDateTime = new Date();
//        }
//    }
//
//    public void setArrivalDateTime(String arrivalDateTime) {
//        try {
//            this.arrivalDateTime = dateFormat.parse(arrivalDateTime);
//        } catch (ParseException e) {
//            this.arrivalDateTime = new Date();
//        }
//    }
//
//    public String getDepartureDateTime() {
//        return dateFormat.format(departureDateTime);
//    }
//
//    public String getArrivalDateTime() {
//        return dateFormat.format(arrivalDateTime);
//    }

    //    private void updateDates(String dateRange) {
//        String departureDateTime = dateRange.trim().split("-")[0];
//        String arrivalDateTime = dateRange.trim().split("-")[1];
//        try {
//            this.departureDateTime = dateFormat.parse(departureDateTime);
//            this.arrivalDateTime = dateFormat.parse(arrivalDateTime);
//        } catch (ParseException e) {
//            log.log(Level.WARN, "Формат даты неправильный!");
//            this.departureDateTime = new Date();
//            this.arrivalDateTime = new Date();
//        }
//    }
}
