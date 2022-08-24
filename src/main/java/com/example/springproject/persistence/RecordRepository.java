package com.example.springproject.persistence;

import com.example.springproject.model.RecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecordRepository extends JpaRepository<RecordEntity,String> {
    List<RecordEntity> findByUserId(String userId);
    Optional<RecordEntity> findById(String id);

}
