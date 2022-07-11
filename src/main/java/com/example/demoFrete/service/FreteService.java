package com.example.demoFrete.service;

import com.example.demoFrete.dto.CepDTO;
import com.example.demoFrete.dto.FreteDTO;
import com.example.demoFrete.mapper.FreteMapper;
import com.example.demoFrete.repository.FreteRepository;
import com.example.demoFrete.response.FreteResponse;
import com.example.demoFrete.store.Frete;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class FreteService {

    private RestTemplate restTemplate;
    private FreteRepository repository;

    public FreteResponse calcular(FreteDTO freteDTO) {
        LocalDate hoje = LocalDate.now();
        long valorTotal = freteDTO.getPeso();

        CepDTO cepDeOrigem = buscaCep(freteDTO.getCepOrigem());
        CepDTO cepDeDestino = buscaCep(freteDTO.getCepDestino());

        FreteResponse freteResponse = new FreteResponse();
        freteResponse.setCepOrigem(freteDTO.getCepOrigem());
        freteResponse.setCepDestino(freteDTO.getCepDestino());
        freteResponse.setNomeDestinatario(freteDTO.getNomeDestinatario());
        freteResponse.setDataConsulta(hoje);
        freteResponse.setPeso(freteDTO.getPeso());

        if(cepDeOrigem.ehDddIgual( cepDeDestino.getDdd()) ){
            freteResponse.setVlTotalFrete((valorTotal - (valorTotal * 0.5)));
            freteResponse.setDataPrevistaEntrega( hoje.plusDays(1) );
        } else if(cepDeOrigem.ehUfIgual(cepDeDestino.getUf())){
            freteResponse.setVlTotalFrete((valorTotal - (valorTotal * 0.75)));
            freteResponse.setDataPrevistaEntrega(hoje.plusDays(3));
        } else{
            freteResponse.setVlTotalFrete(valorTotal);
            freteResponse.setDataPrevistaEntrega( hoje.plusDays(10) );
        }

        Frete frete = FreteMapper.mapper(freteResponse);
        repository.save(frete);

        return freteResponse;
    }


    private CepDTO buscaCep(String cep){
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);

        ResponseEntity<CepDTO> entity = restTemplate.getForEntity(url, CepDTO.class);

        return entity.getBody();
    }
}
