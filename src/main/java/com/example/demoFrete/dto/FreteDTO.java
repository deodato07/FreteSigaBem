package com.example.demoFrete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class FreteDTO {

    private long peso;

    private String nomeDestinatario;

    private String cepOrigem;

    private String cepDestino;


}
