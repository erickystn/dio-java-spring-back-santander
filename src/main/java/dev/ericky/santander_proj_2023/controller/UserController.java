package dev.ericky.santander_proj_2023.controller;


import dev.ericky.santander_proj_2023.model.User;
import dev.ericky.santander_proj_2023.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;
    public UserController(UserService userService ) {
        this.userService =userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getOne(@PathVariable Long id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody User user){

        var userCreated = userService.create(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Parte da URL atual (ex: http://localhost:8080/api/users)
                .path("/{id}") // Adiciona o ID ao path
                .buildAndExpand(userCreated.getId())
                .toUri();

        return ResponseEntity.created(location).body(userCreated);

    }
}
