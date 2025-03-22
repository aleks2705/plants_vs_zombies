package com.epf.controllers;

import com.epf.services.PlanteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plantes")
public class PlanteController {
    private final PlanteService planteService;

    public PlanteController(PlanteService planteService){
        this.planteService = planteService;
    }
}
