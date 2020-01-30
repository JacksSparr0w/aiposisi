package com.aioisisi.lab2.service.impl;

import com.aioisisi.lab2.entity.Address;
import com.aioisisi.lab2.repository.AddressRepository;
import com.aioisisi.lab2.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
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
    public void deleteById(Integer id) {
        addressRepository.deleteById(id);
    }
}
