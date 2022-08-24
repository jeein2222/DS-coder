package com.example.springproject.controller;

import com.example.springproject.dto.RecordDTO;
import com.example.springproject.dto.ResponseDTO;
import com.example.springproject.model.RecordEntity;
import com.example.springproject.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("ds-sw")
public class RecordController {

    @Autowired
    private QuestionService service;

    @PostMapping("/question/create")
    @ResponseBody
    public ResponseEntity<?> createQuestion(@AuthenticationPrincipal String userId,@RequestBody RecordDTO dto){ //
        try{
            RecordEntity entity= RecordDTO.toEntity(dto);
            entity.setId(null);
            entity.setComment(null);
            entity.setUserId(userId);
            List<RecordEntity> entities=service.create(entity);
            List<RecordDTO> dtos=entities.stream().map(RecordDTO::new).collect(Collectors.toList());
            ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/question/retrieve")
    public ResponseEntity<?> retrieveQuestionList(@AuthenticationPrincipal String userId){
        List<RecordEntity> entities = service.retrieve(userId);
        List<RecordDTO> dtos = entities.stream().map(RecordDTO::new).collect(Collectors.toList());
        ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }



    @PutMapping("/question/update")
    public ResponseEntity<?> updateQuestion(@AuthenticationPrincipal String userId, @RequestBody RecordDTO dto){
        RecordEntity entity= RecordDTO.toEntity(dto);
        entity.setUserId(userId);
        List<RecordEntity> entities = service.update(entity);
        List<RecordDTO> dtos = entities.stream().map(RecordDTO::new).collect(Collectors.toList());
        ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/question/delete")
    public ResponseEntity<?> deleteQuestion(@AuthenticationPrincipal String userId, @RequestParam(value="id") String id){
        try{
            Optional<RecordEntity> entity=service.findById(id);
            entity.orElseThrow(IllegalStateException::new).setUserId(userId);
            List<RecordEntity> entities = service.delete(entity.orElseThrow(IllegalStateException::new));
            List<RecordDTO> dtos = entities.stream().map(RecordDTO::new).collect(Collectors.toList());
            ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);

        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<RecordDTO> response=ResponseDTO.<RecordDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
