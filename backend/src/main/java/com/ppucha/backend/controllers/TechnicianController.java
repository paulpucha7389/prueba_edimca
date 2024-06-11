package com.ppucha.backend.controllers;

import com.ppucha.backend.entity.Technician;
import com.ppucha.backend.service.TechnicianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/technician")
public class TechnicianController {

    @Autowired
    private TechnicianService technicianService;

    @GetMapping("getAll")
    public List<Technician> getAll(){
        return technicianService.getAll();
    }
    @PostMapping("/createTechnician")
    public ResponseEntity<?> createTechnician(@RequestBody Technician technician){
        return technicianService.create(technician);
    }
}
