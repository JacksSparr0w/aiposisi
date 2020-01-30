package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.*;
import com.aioisisi.lab2.repository.*;
import com.aioisisi.lab2.service.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase
public class AddressServiceImplTest {
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

    private RouteService routeService;
    private AddressService addressService;
    private TypeService typeService;
    private TransportService transportService;
    private UserService userService;

    private Address start;
    private Address end;
    private Type type;
    private Transport transport;
    private User vadim;
    private User diana;
    private Route route;

    @Test
    public void checkDelete(){
        routeService = new RouteServiceImpl(routeRepository, userRepository);
        typeService = new TypeServiceImpl(typeRepository, transportRepository, routeRepository);
        transportService = new TransportServiceImpl(transportRepository, routeRepository);
        userService = new UserServiceImpl(userRepository, routeRepository);
        addressService = new AddressServiceImpl(addressRepository, routeRepository);

        start = new Address();
        start.setCity("Minsk");
        start.setCountry("Belarus");
        start.setNumber(21);
        start.setStreet("vaneeva");

        end = new Address();
        start.setCity("Moscow");
        start.setCountry("Russia");
        start.setNumber(98);
        start.setStreet("masherova");

        addressService.save(start);
        addressService.save(end);

        type = new Type();
        type.setDescription("plain");

        typeService.save(type);

        transport = new Transport();
        transport.setCapacity(250);
        transport.setName("Plain-777");
        transport.setType(type);

        transportService.save(transport);

        vadim = new User();
        vadim.setLogin("Vadim");

        diana = new User();
        diana.setLogin("Diana");

        userService.save(vadim);
        userService.save(diana);

        route = new Route();
        route.setArrivalDateTime(LocalDateTime.of(2020, 2, 24, 12, 23, 45));
        route.setDepartureDateTime(LocalDateTime.of(2020, 2, 25, 12, 23, 45));
        route.setArrivalAddress(end);
        route.setDepartureAddress(start);
        route.setTransport(transport);
        List<User> users = new ArrayList<>();
        users.add(vadim);
        users.add(diana);
        route.setUsers(users);

        routeService.save(route);
        addressService.delete(start);

        int expected = 0;
        int actual = routeService.findAll().size();

        Assert.assertEquals(expected, actual);
    }
}