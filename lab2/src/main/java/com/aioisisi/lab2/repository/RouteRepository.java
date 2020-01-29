package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Integer> {
}
