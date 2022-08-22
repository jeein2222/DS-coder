package com.example.springproject.service;

import com.example.springproject.model.QuestionEntity;
import com.example.springproject.persistence.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository repository;

    public List<QuestionEntity> create(final QuestionEntity entity){
        validate(entity);
        repository.save(entity);
        log.info("Entity id : {} is saved.", entity.getId());
        return repository.findByUserId(entity.getUserId());
    }

    public List<QuestionEntity> retrieve(final String userId){
        return repository.findByUserId(userId);
    }

    public Optional<QuestionEntity> findById(final String id){
        return repository.findById(id);
    }

    public List<QuestionEntity> update(final QuestionEntity entity){
        validate(entity);
        final Optional<QuestionEntity> original = repository.findById(entity.getId());
        original.ifPresent(question -> {
            question.setTitle(entity.getTitle());
            question.setQuestion(entity.getQuestion());
            question.setCode(entity.getCode());
            question.setComment(entity.getComment());
            repository.save(question);
        });
        return retrieve(entity.getUserId());
    }

    public List<QuestionEntity> delete(final QuestionEntity entity){
        validate(entity);
        try{
            repository.delete(entity);
        }catch(Exception e){
            log.error("error deleting entity ", entity.getId(), e);
            throw new RuntimeException("error deleting entity "+entity.getId());
        }
        return retrieve(entity.getUserId());
    }


    private void validate(final QuestionEntity entity){
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
