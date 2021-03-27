package com.teste.teste.service;

import com.teste.teste.entity.Pessoa;
import org.springframework.http.ResponseEntity;

public interface PessoaService {
    ResponseEntity<Pessoa> save(Pessoa pessoa);
}
