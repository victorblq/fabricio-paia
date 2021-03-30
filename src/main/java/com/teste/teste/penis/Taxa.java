package com.teste.teste.penis;

import com.teste.teste.entity.Pessoa;

public enum Taxa {
    TAXA_1(0.1),
    TAXA_2(0.2),
    TAXA_3(0.3);

    private Double valorTaxa;

    private Taxa(Double valorTaxa){
        this.valorTaxa = valorTaxa;
    }

    public void aplicarTaxa(Pessoa pessoa){
        pessoa.setSaldoContaBancaria(pessoa.getSaldoContaBancaria() - (pessoa.getSaldoContaBancaria()) * this.valorTaxa);
        pessoa.setUltimaTaxaAplicada(this);
    }
}
