package br.com.alura.codechella;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.gateways.UserRepositoryInMemory;

import java.time.LocalDate;

public class UsesUsersWithFiles {

    public static void main(String[] args) {
        UserRepositoryInMemory inMemory = new UserRepositoryInMemory();

        inMemory.saveUser(new User("453.098.675-60", "Jucimara", LocalDate.parse("1995-10-02"), "jucimara@email.com"));

        inMemory.saveUser(new User("453.098.675-60", "Gerson", LocalDate.parse("1995-10-02"), "gerson@email.com"));

        inMemory.saveUser(new User("453.098.675-60", "Cassandra", LocalDate.parse("1995-10-02"), "cassandra@email.com"));

        inMemory.saveUser(new User("453.098.675-60", "Lucimara", LocalDate.parse("1995-10-02"), "lucimara@email.com"));

        //System.out.println(inMemory.getAllUsers());

        inMemory.writeToFile("users.txt");
    }
}
