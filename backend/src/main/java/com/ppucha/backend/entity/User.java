package com.ppucha.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "usuarios")

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long id;
    @Column(name = "nombre", length = 40, nullable = false)
    private String name;
    @Column(name = "contraseña", length = 20, nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    @Column(name = "rol", length = 20)
    private Rol rol;
}
