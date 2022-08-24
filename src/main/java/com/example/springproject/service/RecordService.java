package com.example.springproject.service;

import com.example.springproject.model.RecordEntity;
import com.example.springproject.persistence.RecordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class RecordService {

    @Autowired
    private RecordRepository repository;

    public List<RecordEntity> create(final RecordEntity entity){
        validate(entity);
        repository.save(entity);
        log.info("Entity id : {} is saved.", entity.getId());
        return repository.findByUserId(entity.getUserId());
    }

    public List<RecordEntity> retrieve(final String userId){
        return repository.findByUserId(userId);
    }

    public Optional<RecordEntity> findById(final String id){
        return repository.findById(id);
    }

    public List<RecordEntity> update(final RecordEntity entity){
        validate(entity);
        final Optional<RecordEntity> original = repository.findById(entity.getId());
        original.ifPresent(question -> {
            question.setTitle(entity.getTitle());
            question.setQuestion(entity.getQuestion());
            question.setCode(entity.getCode());
            repository.save(question);
        });
        return retrieve(entity.getUserId());
    }

    public List<RecordEntity> delete(final RecordEntity entity){
        validate(entity);
        try{
            repository.delete(entity);
        }catch(Exception e){
            log.error("error deleting entity ", entity.getId(), e);
            throw new RuntimeException("error deleting entity "+entity.getId());
        }
        return retrieve(entity.getUserId());
    }


    private void validate(final RecordEntity entity){
        if(entity==null){
            log.warn("Entity cannot be null");
            throw new RuntimeException("Entity cannot be null");
        }
        if(entity.getUserId()==null){
            log.warn("Unknown user.");
            throw new RuntimeException("Unknown user.");
        }
    }

}
