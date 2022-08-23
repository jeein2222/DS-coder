package com.example.springproject.controller;

import com.example.springproject.dto.ResponseDTO;
import com.example.springproject.dto.UserDTO;
import com.example.springproject.model.UserEntity;
import com.example.springproject.security.TokenProvider;
import com.example.springproject.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("ds-sw")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TokenProvider tokenProvider;

    private PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @PostMapping("/auth/signup")
    @ResponseBody
    public ResponseEntity<?> registerUser(@RequestBody UserDTO userDTO) {
        try {
            UserEntity user = UserEntity.builder()
                    .email(userDTO.getEmail())
                    .username(userDTO.getUsername())
                    .password(passwordEncoder.encode(userDTO.getPassword()))
                    .build();
            System.out.println(user);

            UserEntity registerdUser = userService.create(user);
            UserDTO responseUserDTO = UserDTO.builder()
                    .email(registerdUser.getEmail())
                    .id(registerdUser.getId())
                    .username(registerdUser.getUsername())
                    .build();

            return ResponseEntity.ok().body(responseUserDTO);

        } catch (Exception e) {
            ResponseDTO responseDTO = ResponseDTO.builder().error(e.getMessage()).build();
            return ResponseEntity.badRequest().body(responseDTO);
        }
    }

    @PostMapping("/auth/signin")
    @ResponseBody
    public ResponseEntity<?> authenticate(@RequestBody UserDTO userDTO){
        UserEntity user=userService.getByCredentials(
                userDTO.getEmail(),
                userDTO.getPassword(),
                passwordEncoder
        );
        if(user!=null){
            final String token = tokenProvider.create(user);
            final UserDTO responseUserDTO = UserDTO.builder()
                    .email(user.getEmail())
                    .id(user.getId())
                    .token(token)
                    .build();
            return ResponseEntity.ok().body(responseUserDTO);
        }else{
            ResponseDTO responseDTO = ResponseDTO.builder().error("Login failed.").build();
            return ResponseEntity.badRequest().body(responseDTO);
        }

    }
}
