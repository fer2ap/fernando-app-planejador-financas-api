package com.fernando.fernando_app_planejador_financas.demo;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fernando.fernando_app_planejador_financas.demo.Demo.Category;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/api/v1/demo")
@RequiredArgsConstructor
public class DemoController {

    @GetMapping()
    public ResponseEntity<List<Demo>> helloWorld() {
        return ResponseEntity.ok(List.of(
            new Demo(Category.FOOD, new BigDecimal("42.30"), Date.from(Instant.now())),
            new Demo(Category.CLEANING, new BigDecimal("76.21"), Date.from(Instant.now())),
            new Demo(Category.ENTERTAINMENT, new BigDecimal("31.56"), Date.from(Instant.now()))
        ));
    }
}
