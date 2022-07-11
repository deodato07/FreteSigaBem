package com.example.demoFrete.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class FreteResponse {

    private Long peso;
    private String cepOrigem;
    private String cepDestino;
    private String nomeDestinatario;
    private double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;


}
