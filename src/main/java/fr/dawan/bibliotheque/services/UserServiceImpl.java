package fr.dawan.bibliotheque.services;

import fr.dawan.bibliotheque.dtos.UserDto;
import fr.dawan.bibliotheque.entities.Users;
import fr.dawan.bibliotheque.entities.exceptions.IdNotFoundException;
import fr.dawan.bibliotheque.mappers.UserMapper;
import fr.dawan.bibliotheque.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public Users getById(long id) {
        Users users = userRepository.findById(id).get();
        return users;
    }

    @Override
    @Transactional
    public List<Users> getAll() {
        List<Users> users = userRepository.findAll();
        return userRepository.findAll();
    }

    @Override
    @Transactional
    public List<Users> getByName(String name) {
        List<Users> users = userRepository.findByNameLike(name + "%");
        return users;
    }


    @Override
    public UserDto addUser(UserDto userDto) {
        Users users = userMapper.toEntity(userDto);

        Users savedUser = userRepository.saveAndFlush(users);

        UserDto resultUser = userMapper.toDto(savedUser);


        return resultUser;
    }

    @Override
    @Transactional
    public UserDto updateUser(UserDto userDto) {
        Users users = userRepository.findById(userDto.getId()).orElseThrow(()
                -> new IdNotFoundException(userDto.getId() + " not found"));
        userMapper.update(userDto, users);
        return userMapper.toDto(userRepository.save(users));
    }
    @Override
    @Transactional
    public void deleteById(long id) {
        if(userRepository.removeById(id) == 0) {
            throw new IdNotFoundException();
        }
    }


}
