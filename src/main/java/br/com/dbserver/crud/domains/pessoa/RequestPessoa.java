package br.com.dbserver.crud.domains.pessoa;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public record RequestPessoa(
        Integer id,
        @NotNull
        String nome,
        String cpf,
        @NotNull
        LocalDate dataNascimento) {

}
