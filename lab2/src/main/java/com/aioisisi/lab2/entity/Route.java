package com.aioisisi.lab2.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Address departureAddress;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    private Address arrivalAddress;

    @Column
    private LocalDateTime departureDateTime;

    @Column
    private LocalDateTime arrivalDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Transport transport;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

    @Transient
    private LocalTime duration;

    public LocalTime getDuration() {
        //TODO: wtf, why it's red
//        return new LocalTime.ofSecondOfDay(arrivalDateTime.getSecond() - departureDateTime.getSecond());
        return LocalTime.now();
    }

    public Route() {
        this.departureAddress = new Address();
        this.arrivalAddress = new Address();
    }
}
