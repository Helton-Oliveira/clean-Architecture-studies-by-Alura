package br.com.alura.codechella.application.useCases;

import br.com.alura.codechella.application.gateways.UserGatewayPersistence;
import br.com.alura.codechella.domain.entities.user.User;

public class RegisterUser {
    private final UserGatewayPersistence repository;

    public RegisterUser(UserGatewayPersistence repository) {
        this.repository = repository;
    }

   public User execute(User user) {
        return repository.saveUser(user);
    }

}
