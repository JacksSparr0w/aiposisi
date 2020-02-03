package com.aioisisi.lab2.entity;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.SimpleDateFormat;
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Address departureAddress;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Address arrivalAddress;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date departureDateTime;

    @Column
    @DateTimeFormat(pattern = "yyyy/MM/dd hh:mm")
    private Date arrivalDateTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private Transport transport;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users;

    @Transient
    private Integer freeSeats;


    public Route() {
        this.departureAddress = new Address();
        this.arrivalAddress = new Address();
        this.users = new ArrayList<>();
        this.freeSeats = 0;
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
}
