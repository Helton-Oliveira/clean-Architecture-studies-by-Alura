package br.com.alura.codechella.domain.entities.user;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class UserTest {
    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new User("123456789-99", "Helton", LocalDate.parse("2000-11-03"), "email.test@email.com"));
    }

    @Test
    public void deveCriarUsuarioFabricaDeUsuario() {
        UserBuilder builder = new UserBuilder();
        User user = builder.withNameCpfAndBirth("Emily", "654.123.897-88",
                LocalDate.parse("2000-10-01"));
        Assertions.assertEquals( "Emily", user.getNome());

        user = builder.includeAddress("12345-999", 40, "apto 201");

        Assertions.assertEquals( "apto 201", user.getAddress().getComplement());
    }

    @Test
    public void naoDeveCriarUsuarioMenorDeIdade() {
        UserBuilder builder = new UserBuilder();

        Assertions.assertThrows(IllegalArgumentException.class,
                () ->  builder.withNameCpfAndBirth("Emily", "654.123.897-88",
                        LocalDate.parse("2015-10-01"))
        );
    }
}
