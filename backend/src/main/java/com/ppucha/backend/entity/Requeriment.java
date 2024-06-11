package com.ppucha.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "requerimientos")

public class Requeriment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_requerimiento")
    private Long id;
    @Column( name = "nombre", nullable = false)
    private String name;
    @Column(name = "descripcion" , nullable = false)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name="prioridad", nullable = false)
    private Priority priority;
    @Column(name ="estado", nullable = false)
    private Status status;
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yy HH:mm:ss")
    private Date createdAt = new Date();
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date updatedAt = new Date();
    @Column(name = "tecnico_asignado")
    private String assignedTo;
}
