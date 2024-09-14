package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.domain.address.Address;

import java.time.LocalDate;

public record UserDto(
         String cpf,
         String nome,
         LocalDate nascimento,
         String email
) {
}
