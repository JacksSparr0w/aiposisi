package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<User, Integer> {
    @Query (nativeQuery = true, value = "select route_id from route_users where users_id = :user_id")
    List<Integer> findRoutesByUser(@Param("user_id") Integer user_id);

    Optional<User> findByLogin(String login);

    Boolean existsByLogin(String login);
}
