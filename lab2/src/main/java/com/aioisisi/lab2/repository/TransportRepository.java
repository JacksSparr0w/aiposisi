package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository  extends JpaRepository<Transport, Integer> {
}
