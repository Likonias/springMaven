package com.example.demo.controller;

import com.example.demo.shape.Shape;
import com.example.demo.shape.ShapeCreator;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Controller
public class ShapeController {

    private final RestTemplate restTemplate;
    private ShapeCreator shapeCreator = new ShapeCreator();

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

            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> shape = objectMapper.readValue(shapeData, new TypeReference<Map<String, Object>>(){});

            Shape createdShape = shapeCreator.createShape(shape);

        } catch (Exception e) {

            e.printStackTrace();

        }

        return "index";
    }

}