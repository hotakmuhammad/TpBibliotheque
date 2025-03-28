package fr.dawan.bibliotheque.services;

import fr.dawan.bibliotheque.dtos.UserDto;
import fr.dawan.bibliotheque.entities.Users;

import java.util.List;

public interface IUserService {

    Users getById(long id);

    List<Users> getAll();

    List<Users> getByName(String name);

    void deleteById(long id);

    UserDto addUser (UserDto userDto);

    UserDto updateUser(UserDto userDto);


}
