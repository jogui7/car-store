package br.pucpr.car_store.users.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.pucpr.car_store.users.dtos.CreateUserDTO;
import br.pucpr.car_store.users.dtos.UpdateUserDTO;
import br.pucpr.car_store.users.entities.User;
import br.pucpr.car_store.users.services.UsersService;

@RestController
@RequestMapping("/users")
@EnableAutoConfiguration
public class UsersController {

    @Autowired
    UsersService usersService;
    
    @GetMapping("")
    List<User> list() {
        return usersService.list();
    } 

    @GetMapping("/{id}")
    User findById(@PathVariable Long id) {
        return usersService.findById(id);
    }

    @PostMapping("")
    User create(@RequestBody CreateUserDTO createUserDTO) {
        return usersService.create(CreateUserDTO.toEntity(createUserDTO));
    }

    @PatchMapping("/{id}")
    User update(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
        User user = this.findById(id);

        return usersService.update(UpdateUserDTO.toEntity(user, updateUserDTO));
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        usersService.deleteById(id);
    }
}
