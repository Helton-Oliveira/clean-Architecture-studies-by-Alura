package br.com.alura.codechella.application.gateways;

import br.com.alura.codechella.domain.entities.user.User;

import java.util.List;

public interface UserGatewayPersistence {

    User saveUser(User user);

    List<User> getAllUsers();
}
