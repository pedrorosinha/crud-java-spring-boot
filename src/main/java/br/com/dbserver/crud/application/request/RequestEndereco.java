package br.com.dbserver.crud.application.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RequestEndereco(
        @NotNull
        Integer id,
        @NotBlank
        String rua,
        @NotNull
        Integer numero,
        String complemento,
        @NotBlank
        String cidade,
        @NotBlank
        String estado,
        @NotBlank
        String cep,
        @NotNull
        Integer pessoaId) {

}
