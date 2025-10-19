package com.pharmacy.stock.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.pharmacy.stock.enums.MedicamentTypesEnum;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicaments")
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "validity", nullable = false, columnDefinition = "TEXT")
    @JsonFormat(pattern = ("dd/MM/yyyy"))
    private LocalDate validity;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private MedicamentTypesEnum type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getValidity() {
        return validity;
    }

    public void setValidity(LocalDate validity) {
        this.validity = validity;
    }

    public MedicamentTypesEnum getType() {
        return type;
    }

    public void setType(MedicamentTypesEnum type) {
        this.type = type;
    }
}
