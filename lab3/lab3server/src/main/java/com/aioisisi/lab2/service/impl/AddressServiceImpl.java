package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Address;
import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.repository.AddressRepository;
import com.aioisisi.lab2.repository.RouteRepository;
import com.aioisisi.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final RouteRepository routeRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository, RouteRepository routeRepository) {
        this.addressRepository = addressRepository;
        this.routeRepository = routeRepository;
    }

    @Override
    public Address save(Address entity) {
        addressRepository.save(entity);
        return entity;
    }

    @Override
    public Optional<Address> findById(Integer id) {
        return addressRepository.findById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return addressRepository.existsById(id);
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public void delete(Address entity) {
        List<Route> routes = routeRepository.findAllByArrivalAddressOrDepartureAddress(entity, entity);
        if (routes != null) {
            routes.forEach(routeRepository::delete);
        }
        addressRepository.delete(entity);
    }
}
