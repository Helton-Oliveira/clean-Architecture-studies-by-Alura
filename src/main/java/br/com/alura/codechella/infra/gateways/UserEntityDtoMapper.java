package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.UserEntity;

public class UserEntityDtoMapper {

    public UserEntity toEntity(User user) {
        return new UserEntity(user.getCpf(), user.getNome(), user.getNascimento(), user.getEmail());
    }

    public User toDomain(UserEntity user) {
        return new User(user.getCpf(), user.getNome(), user.getNascimento(), user.getEmail());
    }
}
