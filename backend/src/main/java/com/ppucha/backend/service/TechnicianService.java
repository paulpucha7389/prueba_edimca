package com.ppucha.backend.service;

import com.ppucha.backend.entity.Technician;
import com.ppucha.backend.repository.TechnicianRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnicianService {

    @Autowired
    private TechnicianRepository technicianRepository;

    public List<Technician> getAll(){
        return technicianRepository.findAll();
    }

    public ResponseEntity<?> create(Technician technician){
        return ResponseEntity.ok(technicianRepository.save(technician));
    }


}
