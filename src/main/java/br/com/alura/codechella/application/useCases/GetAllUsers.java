package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UserGatewayPersistence;
import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public class GetAllUsers {

    private final UserGatewayPersistence persistence;

    public GetAllUsers(UserGatewayPersistence persistence) {
        this.persistence = persistence;
    }

    public List<User> execute() {
        return persistence.getAllUsers();
    }
}
