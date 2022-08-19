package com.example.springproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@CrossOrigin(origins="*", allowedHeaders = "*")
@Controller
@RequestMapping("health")
public class PageController {

    @GetMapping("/")
    public String home() {
        return "home";

    }

    @GetMapping("/info")
    public String info() {
        return "info";

    }
    @GetMapping("/record")
    public String record() {
        return "record";

    }

}
