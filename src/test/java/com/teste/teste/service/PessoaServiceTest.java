package com.teste.teste.service;

import com.sun.istack.NotNull;
import com.teste.teste.entity.Pessoa;
import com.teste.teste.exception.ProibidoNovinhoException;
import com.teste.teste.penis.Taxa;
import com.teste.teste.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.EnumSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @InjectMocks
    PessoaService pessoaService;
    @Mock
    PessoaRepository pessoaRepository;

    @Test
    void testSaveMustPass(){
        Mockito.when(this.pessoaRepository.save(this.getPessoaAdicionada())).thenReturn(this.getPessoaAdicionada());

        ResponseEntity<Pessoa> response = this.pessoaService.save(this.getPessoaValid());

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void testSaveMustFailWithProibidoNovinhoException(){
        assertThrows(ProibidoNovinhoException.class, () -> {
            this.pessoaService.save(this.getPessoaNotValid());
        });
    }

    private Pessoa getPessoaValid(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Pessoa teste");
        pessoa.setIdade(20);
        pessoa.setSaldoContaBancaria(100D);

        return pessoa;
    }

    private Pessoa getPessoaAdicionada(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1L);
        pessoa.setNome("Pessoa teste");
        pessoa.setIdade(20);
        pessoa.setSaldoContaBancaria(100D);
        EnumSet<Taxa> taxaEnumSet = EnumSet.allOf(Taxa.class);
        taxaEnumSet.stream().forEach(t -> t.aplicarTaxa(pessoa));
        return pessoa;
    }

    private Pessoa getPessoaNotValid(){
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa teste invalida");
        pessoa.setIdade(15);
        pessoa.setSaldoContaBancaria(100D);
        return pessoa;
    }
}
