package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.useCases.GetAllUsers;
import br.com.alura.codechella.application.useCases.RegisterUser;
import br.com.alura.codechella.domain.entities.user.User;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    private final RegisterUser registerUser;
    private final GetAllUsers getAllUsers;

    public UserController(RegisterUser registerUser, GetAllUsers getAllUsers) {
        this.registerUser = registerUser;
        this.getAllUsers = getAllUsers;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto dto) {
        var entitySaved = registerUser.execute(new User(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        var userDto = new UserDto(entitySaved.getCpf(), entitySaved.getNome(), entitySaved.getNascimento(), entitySaved.getEmail());
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        var users = getAllUsers.execute()
                .stream()
                .map(u -> new UserDto(u.getCpf(), u.getNome(), u.getNascimento(), u.getEmail()))
                .toList();

        return ResponseEntity.ok(users);
    }
}
