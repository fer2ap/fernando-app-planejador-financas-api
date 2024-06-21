package com.fernando.fernando_app_planejador_financas.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;




@Controller
@RequestMapping("/api/v1/demo-controller")
@RequiredArgsConstructor
public class DemoController {
    
    @GetMapping()
    public ResponseEntity<String> helloWorld() {
        return ResponseEntity.ok("Hello World, I'm authenticated!");
    }    
}
