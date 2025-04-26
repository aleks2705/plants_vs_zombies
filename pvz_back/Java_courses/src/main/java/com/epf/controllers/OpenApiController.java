package com.epf.controllers;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenApiController {

    @GetMapping("/openapi.json")
    @ResponseBody
    public Resource openapi() {
        return new ClassPathResource("/openapi.json");
    }
}
