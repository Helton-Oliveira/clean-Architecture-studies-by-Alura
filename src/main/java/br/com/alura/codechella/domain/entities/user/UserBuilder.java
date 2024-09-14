package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.address.Address;

import java.time.LocalDate;

public class UserBuilder {
    private User user;

    public User withNameCpfAndBirth(String nome, String cpf, LocalDate nascimento) {
        return new User(cpf, nome, nascimento, "");
    }

    public User includeAddress(String cep, Integer number, String complement) {
         this.user.setAddress(new Address(cep, number, complement));
         return this.user;
    }
}
