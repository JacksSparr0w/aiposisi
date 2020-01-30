package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Assert;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class RouteRepositoryTest {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void checkCountOfUsersOnRoute(){
        Address start = new Address();
        start.setCity("Minsk");
        start.setCountry("Belarus");
        start.setNumber(21);
        start.setStreet("vaneeva");

        Address end = new Address();
        start.setCity("Moscow");
        start.setCountry("Russia");
        start.setNumber(98);
        start.setStreet("masherova");

        addressRepository.save(start);
        addressRepository.save(end);

        Type type = new Type();
        type.setDescription("plain");

        typeRepository.save(type);

        Transport transport = new Transport();
        transport.setCapacity(250);
        transport.setName("Plain-777");
        transport.setType(type);

        transportRepository.save(transport);

        User vadim = new User();
        vadim.setLogin("Vadim");

        User diana = new User();
        diana.setLogin("Diana");

        userRepository.save(vadim);
        userRepository.save(diana);

        Route route = new Route();
        route.setArrivalDateTime(LocalDateTime.of(2020, 2, 24, 12, 23, 45));
        route.setDepartureDateTime(LocalDateTime.of(2020, 2, 25, 12, 23, 45));
        route.setArrivalAddress(end);
        route.setDepartureAddress(start);
        route.setTransport(transport);
        List<User> users = new ArrayList<>();
        users.add(vadim);
        users.add(diana);
        route.setUsers(users);

        routeRepository.save(route);

        int expected = 2;
        int actual = routeRepository.findUsersByRoute(route.getId()).size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkRelationsBetweenTransportAndRoute(){
        Address start = new Address();
        start.setCity("Minsk");
        start.setCountry("Belarus");
        start.setNumber(21);
        start.setStreet("vaneeva");

        Address end = new Address();
        start.setCity("Moscow");
        start.setCountry("Russia");
        start.setNumber(98);
        start.setStreet("masherova");

        addressRepository.save(start);
        addressRepository.save(end);

        Type type = new Type();
        type.setDescription("plain");

        typeRepository.save(type);

        Transport transport = new Transport();
        transport.setCapacity(250);
        transport.setName("Plain-777");
        transport.setType(type);

        transportRepository.save(transport);

        User vadim = new User();
        vadim.setLogin("Vadim");

        User diana = new User();
        diana.setLogin("Diana");

        userRepository.save(vadim);
        userRepository.save(diana);

        Route route = new Route();
        route.setArrivalDateTime(LocalDateTime.of(2020, 2, 24, 12, 23, 45));
        route.setDepartureDateTime(LocalDateTime.of(2020, 2, 25, 12, 23, 45));
        route.setArrivalAddress(end);
        route.setDepartureAddress(start);
        route.setTransport(transport);
        List<User> users = new ArrayList<>();
        users.add(vadim);
        users.add(diana);
        route.setUsers(users);

        routeRepository.save(route);

        transportRepository.deleteById(transport.getId());

        int expected = 0;
        int actual = transportRepository.findAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDeleteAddress(){
        Address start = new Address();
        start.setCity("Minsk");
        start.setCountry("Belarus");
        start.setNumber(21);
        start.setStreet("vaneeva");

        Address end = new Address();
        start.setCity("Moscow");
        start.setCountry("Russia");
        start.setNumber(98);
        start.setStreet("masherova");

        addressRepository.save(start);
        addressRepository.save(end);

        int expected = 2;
        int actual = addressRepository.findAll().size();

        Assert.assertEquals(expected, actual);
    }
}