package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.Transport;
import com.aioisisi.lab2.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransportRepository  extends JpaRepository<Transport, Integer> {
    List<Transport> findAllByType(Type type);
}
