package com.example.demo.controller;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class ShapeController {

    private final RestTemplate restTemplate;

    public ShapeController() {
        this.restTemplate = new RestTemplate();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/getShape")
    public String getShape(Model model) {

        String url = "https://medoro.cz/task/api/shape";

        try {
            // Vytvoření požadavku
            HttpHeaders headers = new HttpHeaders();
            HttpEntity<String> entity = new HttpEntity<>(headers);

            // Odeslání POST požadavku a získání odpovědi jako prostý text
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);

            // Získání odpovědi
            String shapeData = response.getBody();

            // Výpis odpovědi do šablony
            model.addAttribute("originalShape", shapeData);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return "index";
    }

}