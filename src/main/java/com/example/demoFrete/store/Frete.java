package com.example.demoFrete.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private double valorTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;

}
