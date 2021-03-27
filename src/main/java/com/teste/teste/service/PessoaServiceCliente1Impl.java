package com.teste.teste.service;

import com.teste.teste.entity.Pessoa;
import com.teste.teste.exception.ProibidoNovinhoException;
import com.teste.teste.repository.PessoaRepository;
import com.teste.teste.taxas.Taxa;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaServiceCliente1Impl implements PessoaService {

    private final PessoaRepository pessoaRepository;
    private final List<Taxa> taxas;

    public ResponseEntity<Pessoa> save(Pessoa pessoa){
        if(pessoa.getIdade() > 18){
            taxas.stream().forEach(taxa -> {taxa.executar(pessoa.getSaldoContaBancaria());});
            return ResponseEntity.ok(this.pessoaRepository.save(pessoa));
        }else{
            throw new ProibidoNovinhoException("Sai otario");
        }
    }
}
