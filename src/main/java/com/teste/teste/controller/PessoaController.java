package com.teste.teste.controller;

import com.teste.teste.entity.Pessoa;
import com.teste.teste.repository.PessoaRepository;
import com.teste.teste.service.PessoaService;
import com.teste.teste.service.PessoaServiceCliente1Impl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/pessoa")
public class PessoaController {

    private final PessoaService pessoaService;
    private final PessoaRepository pessoaRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> getPessoas(){
        return ResponseEntity.ok(this.pessoaRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Pessoa> createPessoa(@RequestBody Pessoa pessoa){
        return this.pessoaService.save(pessoa);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> getPessoaById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.pessoaRepository.findById(id).orElse(new Pessoa()));
    }

    @GetMapping("/nome")
    public ResponseEntity<Pessoa> getPessoaByNome(@RequestParam("nome") String nome){
        return ResponseEntity.ok(this.pessoaRepository.findPessoaByNome(nome).get());
    }
    
    @DeleteMapping
    public ResponseEntity<Long> deletePessoa(@RequestParam("id") Long id){
        this.pessoaRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
