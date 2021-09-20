package com.example.school.repository;

import com.example.school.entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepository extends JpaRepository<SchoolEntity, Long> {

    boolean existsByName(String name);

}
