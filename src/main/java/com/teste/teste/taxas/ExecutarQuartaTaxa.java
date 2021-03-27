package com.teste.teste.taxas;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class ExecutarQuartaTaxa implements Taxa {
    @Override
    public void executar(Double valorConta) {
        System.out.println("Valor a ser deduzido da conta depois da quarta taxa: " + valorConta * 0.1);
    }
}
