package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.address.Address;

import java.time.LocalDate;
import java.time.Period;

public class User {
    private String cpf;
    private String nome;
    private LocalDate nascimento;
    private String email;
    private Address address;

    public User(String cpf, String nome, LocalDate nascimento, String email) {
        if(cpf == null || !cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")) {
            throw new IllegalArgumentException("CPF no padrão errado!");
        }

        if (!isOfLegalAge(nascimento)) {
            throw new IllegalArgumentException("ERRO! Usuario menor de idade.");
        }

        this.cpf = cpf;
        this.nome = nome;
        this.nascimento = nascimento;
        this.email = email;
    }

    private boolean isOfLegalAge(LocalDate nascimento) {
        int age = Period.between(nascimento, LocalDate.now()).getYears();
        return age > 18;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User: " +
                "cpf: '" + cpf + '\'' +
                ", nome: '" + nome + '\'' +
                ", nascimento: " + nascimento +
                ", email: '" + email ;
    }
}
