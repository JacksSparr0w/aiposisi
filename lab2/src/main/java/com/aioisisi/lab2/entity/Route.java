package com.aioisisi.lab2.entity;

import lombok.Data;
import org.graalvm.compiler.lir.alloc.lsra.LinearScan;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@Entity
@Table(name = "route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address startAddress;

    @Column
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Address endAddress;

    @Column
    private LocalDateTime departureTime;

    @Column
    private LocalDateTime arrivalTime;

    @Column
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Transport transport;

    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;
}
