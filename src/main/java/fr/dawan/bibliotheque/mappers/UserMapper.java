package fr.dawan.bibliotheque.mappers;


import fr.dawan.bibliotheque.dtos.UserDto;
import fr.dawan.bibliotheque.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = ComponentModel.SPRING)
public interface UserMapper extends GenericMapper<Users, UserDto> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "adress", target = "adress")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "anAdult", target = "anAdult")
    @Override
    UserDto toDto(Users entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "adress", target = "adress")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "anAdult", target = "anAdult")
    @Override
    Users toEntity(UserDto dto);



    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "adress", target = "adress")
    @Mapping(source = "phoneNumber", target = "phoneNumber")
    @Mapping(source = "anAdult", target = "anAdult")
    @Override
    void update(UserDto dto, @MappingTarget Users entity);

}
