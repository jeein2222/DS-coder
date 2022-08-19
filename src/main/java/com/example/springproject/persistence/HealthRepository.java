package com.example.springproject.persistence;

import com.example.springproject.model.HealthEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthRepository extends JpaRepository<HealthEntity,String> {
    List<HealthEntity> findByUserId(String userId);

}
