package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.UserGatewayPersistence;
import br.com.alura.codechella.domain.entities.user.User;
import br.com.alura.codechella.infra.persistence.UserRepository;

import java.util.List;

public class UserRepositoryImplJpa implements UserGatewayPersistence {

    private final UserRepository repository;
    private final UserEntityDtoMapper mapper;

    public UserRepositoryImplJpa(UserRepository repository, UserEntityDtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public User saveUser(User user) {
        var entity = mapper.toEntity(user);
        repository.save(entity);

        return mapper.toDomain(entity);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll().stream()
                .map(mapper::toDomain)
                .toList();
    }
}
