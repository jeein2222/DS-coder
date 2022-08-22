package com.example.springproject.persistence;

import com.example.springproject.model.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity,String> {
    List<QuestionEntity> findByUserId(String userId);
    Optional<QuestionEntity> findById(String id);

}
