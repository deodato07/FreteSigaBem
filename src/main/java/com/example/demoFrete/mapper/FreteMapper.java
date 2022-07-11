package com.example.demoFrete.mapper;

import com.example.demoFrete.response.FreteResponse;
import com.example.demoFrete.store.Frete;

public class FreteMapper {

    public static Frete mapper(FreteResponse freteResponse){
        Frete frete = new Frete();

        frete.setPeso(freteResponse.getPeso());
        frete.setCepOrigem(freteResponse.getCepOrigem());
        frete.setCepDestino(freteResponse.getCepDestino());
        frete.setNomeDestinatario(freteResponse.getNomeDestinatario());
        frete.setValorTotalFrete(freteResponse.getVlTotalFrete());
        frete.setDataPrevistaEntrega(freteResponse.getDataPrevistaEntrega());
        frete.setDataConsulta(freteResponse.getDataConsulta());

        return frete;
    }
}
