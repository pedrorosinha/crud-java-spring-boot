package br.com.dbserver.crud.application.controllers;

import br.com.dbserver.crud.application.modelos.Endereco;
import br.com.dbserver.crud.application.repositories.EnderecoRepository;
import br.com.dbserver.crud.application.modelos.Pessoa;
import br.com.dbserver.crud.application.repositories.PessoaRepository;
import jakarta.validation.Valid;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @PostMapping("/{pessoaId}")
    public ResponseEntity<Endereco> criarEnderecoParaPessoa(@PathVariable Integer pessoaId, @RequestBody @Valid Endereco endereco) {
        Optional<Pessoa> pessoaOptional = pessoaRepository.findById(pessoaId);
        if (pessoaOptional.isPresent()) {
            Pessoa pessoa = pessoaOptional.get();
            endereco.setPessoa(pessoa); // Associar o endereço à pessoa
            Endereco novoEndereco = enderecoRepository.save(endereco);
            return ResponseEntity.ok(novoEndereco);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
