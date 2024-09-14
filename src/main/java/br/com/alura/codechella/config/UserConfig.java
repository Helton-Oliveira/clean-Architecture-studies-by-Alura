package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.UserGatewayPersistence;
import br.com.alura.codechella.application.useCases.GetAllUsers;
import br.com.alura.codechella.application.useCases.RegisterUser;
import br.com.alura.codechella.infra.gateways.UserEntityDtoMapper;
import br.com.alura.codechella.infra.gateways.UserRepositoryImplJpa;
import br.com.alura.codechella.infra.persistence.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Bean
    RegisterUser registerUser(UserGatewayPersistence repository) {
        return new RegisterUser(repository);
    }

    @Bean
    GetAllUsers getAllUsers(UserGatewayPersistence repository) {
        return new GetAllUsers(repository);
    }

    @Bean
    UserRepositoryImplJpa createRepositoryJpa(UserRepository repository, UserEntityDtoMapper mapper) {
        return new UserRepositoryImplJpa(repository, mapper);
    }

    @Bean
    UserEntityDtoMapper createMapper() {
        return new UserEntityDtoMapper();
    }
}
