package com.ppucha.backend.controllers;

import com.ppucha.backend.entity.Requeriment;
import com.ppucha.backend.entity.Status;
import com.ppucha.backend.service.RequerimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/requirements")
public class RequerimentController {
    @Autowired
    private RequerimentService requerimentService;

    @GetMapping("/getAll")
    public List<Requeriment> getAll(){
        return requerimentService.getAll();
    }

    @GetMapping("/getRequiremment/{id}")
    public ResponseEntity<Requeriment> getRequiremmentById(@PathVariable Long id){
        Optional<Requeriment> requeriment = requerimentService.getRequestById(id);
        if (requeriment.isPresent()){
            return ResponseEntity.ok(requeriment.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/createRequeriment")
    public ResponseEntity<?> createRequeriment(@RequestBody Requeriment requeriment){
        return ResponseEntity.ok(requerimentService.create(requeriment));
    }

    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approve(@PathVariable Long id, @RequestBody Requeriment requeriment) {
        Optional<Requeriment> request1 = requerimentService.getRequestById(id);
        if (request1.isPresent()) {
            Requeriment req = request1.get();
            req.setName(requeriment.getName());
            req.setDescription(requeriment.getDescription());
            req.setPriority(requeriment.getPriority());
            req.setStatus(Status.Aprobada);
            req.setAssignedTo(requeriment.getAssignedTo());
            req.setUpdatedAt(new Date());
            return ResponseEntity.ok(requerimentService.updateRequeriment(req));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}/assign")
    public ResponseEntity<?> assing(@PathVariable Long id, @RequestBody Requeriment requeriment){
        Optional<Requeriment> request = requerimentService.getRequestById(id);
            if (request.isPresent()) {
                Requeriment req = request.get();
                req.setName(requeriment.getName());
                req.setDescription(requeriment.getDescription());
                req.setPriority(requeriment.getPriority());
                req.setStatus(Status.Asignada);
                req.setAssignedTo(requeriment.getAssignedTo());
                req.setUpdatedAt(new Date());
                return ResponseEntity.ok(requerimentService.updateRequeriment(req));
            } else {
                return ResponseEntity.notFound().build();
            }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequimenet(@PathVariable Long id){
        requerimentService.deleteRequiment(id);
        return ResponseEntity.ok("Registro eliminado");
    }

}
