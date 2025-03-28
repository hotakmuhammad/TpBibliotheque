package fr.dawan.bibliotheque.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import fr.dawan.bibliotheque.dtos.UserDto;
import fr.dawan.bibliotheque.entities.Users;
import fr.dawan.bibliotheque.services.IUserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Slf4j

@RestController
@RequestMapping("/api/biblio")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    // Find user by id
    @GetMapping(value = "/user-by-id/{id:[0-4]}")
    public Users users(@PathVariable Long id) {
        return userService.getById(id);
    }

    // get all

    @GetMapping(value = "/users-find-all")
    public List<Users> getAll() {
        return userService.getAll();
    }

    @GetMapping(value = "/{name:[A-Za-z]+}")
    public List<Users> getByName(@PathVariable String name) {
        return userService.getByName(name); //exemple "Dubois"
    }

    // Add a user

    @PostMapping(value = "/add-user")
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }


    // update user


    @PutMapping(value = "/update-user")
    public UserDto updateUser(@RequestBody UserDto userDto) {

        System.out.println("Test api");
        return userService.updateUser(userDto);
    }
    // Deleting a user

    @DeleteMapping(value = "/delete-user/{id}")
    public String deleteById(@PathVariable long id) {

        userService.deleteById(id);
        return "L'id " + id + " est supprimé";
    }
}
