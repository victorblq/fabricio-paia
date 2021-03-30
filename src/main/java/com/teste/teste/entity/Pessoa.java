package com.teste.teste.entity;

import com.teste.teste.penis.Taxa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private int idade;
    private Double saldoContaBancaria;
    private Taxa ultimaTaxaAplicada;
}
