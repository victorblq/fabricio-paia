package com.teste.teste.service;

import com.teste.teste.entity.Pessoa;
import com.teste.teste.exception.ProibidoNovinhoException;
import com.teste.teste.penis.Taxa;
import com.teste.teste.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.EnumSet;


@Service
@RequiredArgsConstructor
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public ResponseEntity<Pessoa> save(Pessoa pessoa){
        if(pessoa.getIdade() > 18){
            EnumSet<Taxa> taxaEnumSet = EnumSet.allOf(Taxa.class);
            taxaEnumSet.stream().forEach(t -> t.aplicarTaxa(pessoa));

            return ResponseEntity.ok(this.pessoaRepository.save(pessoa));
        }else{
            throw new ProibidoNovinhoException("Sai otario");
        }
    }

}
