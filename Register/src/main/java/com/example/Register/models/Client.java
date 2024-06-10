package com.example.Register.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @NotBlank
    @Size(min = 5, max = 100)
    @Column(name = "name", nullable = false)
    private String name;

    // não obrigatório
    @Size(min = 0, max = 10)
    @Column(name = "fictitious", nullable = true, unique = false)
    private String fictitious;

    @NotBlank
    @Size(min = 1)
    @Column(name = "code", nullable = false, unique = true)
    private Long code;


    public Client() {
    }

    public Client(Long id, String name, String fictitious, Long code) {
        this.id = id;
        this.name = name;
        this.fictitious = fictitious;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 5, max = 100) String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 5, max = 100) String name) {
        this.name = name;
    }

    public @Size(min = 0, max = 10) String getFictitious() {
        return fictitious;
    }

    public void setFictitious(@Size(min = 0, max = 10) String fictitious) {
        this.fictitious = fictitious;
    }

    public @NotBlank @Size(min = 1) Long getCode() {
        return code;
    }

    public void setCode(@NotBlank @Size(min = 1) Long code) {
        this.code = code;
    }
}
