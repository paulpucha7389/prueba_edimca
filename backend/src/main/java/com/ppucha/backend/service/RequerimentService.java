package com.ppucha.backend.service;

import com.ppucha.backend.entity.Requeriment;
import com.ppucha.backend.repository.RequerimentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class RequerimentService {
    @Autowired
    private RequerimentRepository requerimentRepository;

    public List<Requeriment> getAll(){
        return requerimentRepository.findAll();
    }

    public Optional<Requeriment> getRequestById(Long id) {
        return requerimentRepository.findById(id);
    }

    public ResponseEntity<?> create(Requeriment requeriment){
        return ResponseEntity.ok(requerimentRepository.save(requeriment));
    }

    public ResponseEntity<?> updateRequeriment(Requeriment requeriment) {
        return ResponseEntity.ok(requerimentRepository.save(requeriment));
    }

    public void deleteRequiment(Long id){
        requerimentRepository.deleteById(id);
    }
}
