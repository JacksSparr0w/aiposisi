package com.aioisisi.lab2.repository;

import com.aioisisi.lab2.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRepository  extends JpaRepository<Type, Integer> {
}
