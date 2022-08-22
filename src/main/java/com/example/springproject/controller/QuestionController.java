package com.example.springproject.controller;

import com.example.springproject.dto.QuestionDTO;
import com.example.springproject.dto.ResponseDTO;
import com.example.springproject.model.QuestionEntity;
import com.example.springproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("ds-sw")
public class QuestionController {

    @Autowired
    private QuestionService service;

    @PostMapping("/question/create")
    @ResponseBody
    public ResponseEntity<?> createQuestion(@RequestBody QuestionDTO dto){ //
        try{
            String temporaryUserId="temporary-user";
            QuestionEntity entity= QuestionDTO.toEntity(dto);
            entity.setId(null);
            entity.setComment(null);
            entity.setUserId(temporaryUserId);
            List<QuestionEntity> entities=service.create(entity);
            List<QuestionDTO> dtos=entities.stream().map(QuestionDTO::new).collect(Collectors.toList());
            ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/question/retrieve")
    public ResponseEntity<?> retrieveQuestionList(){
        String temporaryUserId="temporary-user";
        List<QuestionEntity> entities = service.retrieve(temporaryUserId);
        List<QuestionDTO> dtos = entities.stream().map(QuestionDTO::new).collect(Collectors.toList());
        ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/question/{id}")
    @ResponseBody
    public QuestionEntity getQuestionInfo(@RequestParam String id){
        QuestionEntity entity= service.findById(id).orElseThrow(IllegalStateException::new);
        return entity;
    }

    @PutMapping("/question/update")
    public ResponseEntity<?> updateQuestion(@RequestBody QuestionDTO dto){
        String temporaryUserId="temporary-user";
        QuestionEntity entity= QuestionDTO.toEntity(dto);
        entity.setUserId(temporaryUserId);
        List<QuestionEntity> entities = service.update(entity);
        List<QuestionDTO> dtos = entities.stream().map(QuestionDTO::new).collect(Collectors.toList());
        ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/question/delete")
    public ResponseEntity<?> deleteQuestion(@RequestParam(value="id") String id){
        try{
            String temporaryUserId="temporary-user";
            Optional<QuestionEntity> entity=service.findById(id);
            entity.orElseThrow(IllegalStateException::new).setUserId(temporaryUserId);
            List<QuestionEntity> entities = service.delete(entity.orElseThrow(IllegalStateException::new));
            List<QuestionDTO> dtos = entities.stream().map(QuestionDTO::new).collect(Collectors.toList());
            ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);

        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<QuestionDTO> response=ResponseDTO.<QuestionDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
