package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.*;

import org.junit.Before;
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

    private Address start;
    private Address end;
    private Type type;
    private Transport transport;
    private User vadim;
    private User diana;
    private Route route;

    @Before
    public void prepare(){
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

        addressRepository.save(start);
        addressRepository.save(end);

        type = new Type();
        type.setDescription("plain");

        typeRepository.save(type);

        transport = new Transport();
        transport.setCapacity(250);
        transport.setName("Plain-777");
        transport.setType(type);

        transportRepository.save(transport);

        vadim = new User();
        vadim.setLogin("Vadim");

        diana = new User();
        diana.setLogin("Diana");

        userRepository.save(vadim);
        userRepository.save(diana);

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

        routeRepository.save(route);

    }

    @Test
    public void checkCountOfUsersOnRoute(){
        int expected = 2;
        int actual = routeRepository.findUsersByRoute(route.getId()).size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkRelationsBetweenTransportAndRoute(){
        transportRepository.deleteById(transport.getId());

        int expected = 1;
        int actual = transportRepository.findAll().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkSearchingRoutesByAddress(){
        List<Route> routes = routeRepository.findAllByArrivalAddressOrDepartureAddress(start, start);

        Assert.assertEquals(1, routes.size());
    }

    @Test
    public void checkSearchingRoutesByUsersContaining(){
        List<Route> routes = routeRepository.findAllByUsersContaining(vadim);

        Assert.assertEquals(1, routes.size());
    }

    @Test
    public void checkSearchingRoutesForUser(){
        Route route1 = new Route();
        route1.setTransport(transport);
        route1.setDepartureAddress(end);
        route1.setArrivalAddress(start);
        route1.setArrivalDateTime(LocalDateTime.of(2020, 2, 24, 12, 23, 45));
        route1.setDepartureDateTime(LocalDateTime.of(2020, 2, 25, 12, 23, 45));
        List<User> userList = new ArrayList<>();
        userList.add(vadim);
        userList.add(diana);
        route1.setUsers(userList);
        routeRepository.save(route1);

        List<Integer> routes = userRepository.findRoutesByUser(vadim.getId());

        Assert.assertEquals(2, routes.size());
    }

    @Test
    public void checkSearchingByLogin() {
        Assert.assertNotNull(userRepository.findByLogin("diana"));
    }
}