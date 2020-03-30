package com.example.reclama.model.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "reclama.caso")
@Data
public class Caso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String nombres;

    @NotEmpty
    @Size(min = 3, max = 100)
    @Column(nullable = false, length = 100)
    private String apellidos;

    @NotEmpty(message="correo electronico VACIO No pues :(")
    @Size(min = 3)
    @Email
    //@Column(name = "correo_electronico", nullable = false, length = 70, unique = true)
    @Column(name = "correo_electronico", nullable = false, length = 70)
    private String correoElectronico;

    @NotEmpty
    @Size(min = 20, max = 250)
    @Column(nullable = false, length = 250)
    private String descripcion;

}
