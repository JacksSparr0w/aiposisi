package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.Route;
import com.aioisisi.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RouteRepository  extends JpaRepository<Route, Integer> {
    @Query (nativeQuery = true, value = "select users_id from route_users where route_id = :route")
    List<Integer> findUsersByRoute(@Param("route") Integer route_id);
}
