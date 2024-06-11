package com.ppucha.backend.repository;

import com.ppucha.backend.entity.Requeriment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequerimentRepository extends JpaRepository<Requeriment, Long>{

    List<Requeriment> findAllByOrderByCreatedAtDesc();

}
