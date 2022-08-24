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

    @GetMapping("/dic")
    public String index() {
        return "dic";

    }

    @GetMapping("/auth/login")
    public String login(){
        return "login";
    }

    @GetMapping("/auth/join")
    public String join(){
        return "join";
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
