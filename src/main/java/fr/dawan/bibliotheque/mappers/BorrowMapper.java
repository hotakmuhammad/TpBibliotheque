package fr.dawan.bibliotheque.mappers;

import fr.dawan.bibliotheque.dtos.BorrowDto;
import fr.dawan.bibliotheque.entities.Borrow;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants.ComponentModel;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = ComponentModel.SPRING)
public interface BorrowMapper extends GenericMapper<Borrow, BorrowDto>{




    @Mapping(source = "id", target = "id")
    @Mapping(source = "borrowDate", target = "borrowDate")
    @Mapping(source = "borrowReturnDate", target = "borrowReturnDate")
    @Mapping(source = "status", target = "status")
    //@Mapping(source = "books", target = "books")
    @Mapping(source = "user", target = "user")
    BorrowDto toDto(Borrow entity);


    @Mapping(source = "id", target = "id")
    @Mapping(source = "borrowDate", target = "borrowDate")
    @Mapping(source = "borrowReturnDate", target = "borrowReturnDate")
    @Mapping(source = "status", target = "status")
    //@Mapping(source = "books", target = "books")
    @Mapping(source = "user", target = "user")
    Borrow toEntity(BorrowDto dto);


//    @Mapping(source = "id", target = "id")
    @Mapping(source = "borrowDate", target = "borrowDate")
    @Mapping(source = "borrowReturnDate", target = "borrowReturnDate")
    @Mapping(source = "status", target = "status")
    //@Mapping(source = "books", target = "books")
    @Mapping(source = "user", target = "user")
    void update(BorrowDto dto, @MappingTarget Borrow entity);

}
