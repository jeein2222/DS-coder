package com.example.springproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
@RequestMapping("ds-sw")
public class PageController {

    @GetMapping("/")
    public String home() {
        return "home";

    }

    @GetMapping("/info")
    public String info() {
        return "info";

    }

    @GetMapping("/auth/login")
    public String login(){
        return "signin";
    }

    @GetMapping("/auth/join")
    public String join(){
        return "signup";
    }

    @GetMapping("/question")
    public String question_list() {
        return "question_list";

    }

    @GetMapping("/question/write")
    public String question_write() {
        return "question_wr";

    }


}
