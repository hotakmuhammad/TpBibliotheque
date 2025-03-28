package fr.dawan.bibliotheque.mappers;

import fr.dawan.bibliotheque.dtos.AuthorDto;
import fr.dawan.bibliotheque.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = ComponentModel.SPRING)
public interface AuthorMapper extends GenericMapper<Author, AuthorDto> {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "nationality", target = "nationality")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "bookNumbers", target = "bookNumbers")
    @Override
    AuthorDto toDto(Author entity);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "nationality", target = "nationality")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "bookNumbers", target = "bookNumbers")
    @Override
    Author toEntity(AuthorDto dto);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "dateOfBirth", target = "dateOfBirth")
    @Mapping(source = "nationality", target = "nationality")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "bookNumbers", target = "bookNumbers")
    @Override
    void update(AuthorDto dto, @MappingTarget Author entity);

}
