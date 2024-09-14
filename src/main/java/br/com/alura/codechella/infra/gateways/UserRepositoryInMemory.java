package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserGatewayPersistence;
import br.com.alura.codechella.domain.entities.user.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryInMemory implements UserGatewayPersistence {

    private List<User> users = new ArrayList<>();

    @Override
    public User saveUser(User user) {
        this.users.add(user);
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return this.users;
    }

    public void writeToFile(String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            writer.write(this.users.toString());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
