package com.example.th3code.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HoaDonController {
    @GetMapping("/hoa-don")
    public String home(){
        return "web/hoaDon";
    }
}