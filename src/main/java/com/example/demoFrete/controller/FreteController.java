package com.example.demoFrete.controller;

import com.example.demoFrete.dto.FreteDTO;
import com.example.demoFrete.response.FreteResponse;
import com.example.demoFrete.service.FreteService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FreteController {

    private FreteService freteService;

    public FreteController(FreteService freteService) {this.freteService = freteService;}

    @PostMapping("/frete/calcular")
    public ResponseEntity<FreteResponse> calcular(@RequestBody FreteDTO freteDTO){
        FreteResponse freteResponse = freteService.calcular(freteDTO);
        return ResponseEntity.ok(freteResponse);
    }
}
