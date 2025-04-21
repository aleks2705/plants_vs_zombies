package com.epf.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/CoursEpfBack")
public class SwaggerDocsController {
    @GetMapping("/src/main/openapi.json")
    public String getOpenApi() throws IOException {
            InputStream inputStream = getClass().getResourceAsStream("/resources/openapi.json");
        if (inputStream == null) {
            throw new RuntimeException("Fichier openapi.json introuvable !");
        }
        return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
    }
}
