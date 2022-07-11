package com.example.demoFrete.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CepDTO {

    private String ddd;
    private String uf;

    public boolean ehDddIgual(String dddExterno){
        return this.ddd.equals(dddExterno);
    }

    public boolean ehUfIgual(String ufExterno){
        return this.uf.equals(ufExterno);
    }

}
