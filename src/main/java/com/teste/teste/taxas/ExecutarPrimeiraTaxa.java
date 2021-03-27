package com.teste.teste.taxas;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ExecutarPrimeiraTaxa implements Taxa {
    @Override
    public void executar(Double valorConta) {
        System.out.println("Valor a ser deduzido da conta depois da primeira taxa: " + valorConta * 0.05);
    }
}
