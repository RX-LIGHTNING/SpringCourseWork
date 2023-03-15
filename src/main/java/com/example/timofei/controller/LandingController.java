package com.example.timofei.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class LandingController {
    @GetMapping("/")
    public String getLanding(){
        return "landing";
    }
}
