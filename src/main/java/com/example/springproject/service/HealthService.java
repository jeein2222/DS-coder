package com.example.springproject.service;

import com.example.springproject.model.HealthEntity;
import com.example.springproject.persistence.HealthRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class HealthService {

    @Autowired
    private HealthRepository repository;

    public List<HealthEntity> create(final HealthEntity entity){
        validate(entity);
        repository.save(entity);
        log.info("Entity id : {} is saved.", entity.getId());
        return repository.findByUserId(entity.getUserId());
    }

    public List<HealthEntity> retrieve(final String userId){
        return repository.findByUserId(userId);
    }

    public List<HealthEntity> update(final HealthEntity entity){
        validate(entity);
        final Optional<HealthEntity> original = repository.findById(entity.getId());
        original.ifPresent(health -> {
            health.setTitle(entity.getTitle());
            health.setTime(entity.getTime());
            health.setFood(entity.getFood());
            health.setDone(entity.isDone());
            repository.save(health);
        });
        return retrieve(entity.getUserId());
    }

    public List<HealthEntity> delete(final HealthEntity entity){
        validate(entity);
        try{
            repository.delete(entity);
        }catch(Exception e){
            log.error("error deleting entity ", entity.getId(), e);
            throw new RuntimeException("error deleting entity "+entity.getId());
        }
        return retrieve(entity.getUserId());
    }


    private void validate(final HealthEntity entity){
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
