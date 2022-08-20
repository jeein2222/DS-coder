package com.example.springproject.controller;

import com.example.springproject.dto.HealthDTO;
import com.example.springproject.dto.ResponseDTO;
import com.example.springproject.model.HealthEntity;
import com.example.springproject.service.HealthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
@RequestMapping("health")
public class HealthController {

    @Autowired
    private HealthService service;

    @PostMapping("/record/create")
    public ResponseEntity<?> createHealth(@RequestBody HealthDTO dto){ //
        try{
            String temporaryUserId="temporary-user";
            HealthEntity entity=HealthDTO.toEntity(dto);
            entity.setId(null);
            entity.setUserId(temporaryUserId);
            List<HealthEntity> entities=service.create(entity);
            List<HealthDTO> dtos=entities.stream().map(HealthDTO::new).collect(Collectors.toList());
            ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);
        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping("/record/retrieve")
    public ResponseEntity<?> retrieveHealthList(){
        String temporaryUserId="temporary-user";
        List<HealthEntity> entities = service.retrieve(temporaryUserId);
        List<HealthDTO> dtos = entities.stream().map(HealthDTO::new).collect(Collectors.toList());
        ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/record/update")
    public ResponseEntity<?> updateHealth(@RequestBody HealthDTO dto){
        String temporaryUserId="temporary-user";
        HealthEntity entity=HealthDTO.toEntity(dto);
        entity.setUserId(temporaryUserId);
        List<HealthEntity> entities = service.update(entity);
        List<HealthDTO> dtos = entities.stream().map(HealthDTO::new).collect(Collectors.toList());
        ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().data(dtos).build();
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/record/delete")
    public ResponseEntity<?> deleteHealth(@RequestParam(value="id") String id){
        try{
            String temporaryUserId="temporary-user";
            Optional<HealthEntity> entity=service.findById(id);
            entity.orElseThrow(IllegalStateException::new).setUserId(temporaryUserId);
            List<HealthEntity> entities = service.delete(entity.orElseThrow(IllegalStateException::new));
            List<HealthDTO> dtos = entities.stream().map(HealthDTO::new).collect(Collectors.toList());
            ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().data(dtos).build();
            return ResponseEntity.ok().body(response);

        }catch(Exception e){
            String error=e.getMessage();
            ResponseDTO<HealthDTO> response=ResponseDTO.<HealthDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }
}
