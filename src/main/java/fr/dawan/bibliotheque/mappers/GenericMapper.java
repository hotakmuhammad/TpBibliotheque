package fr.dawan.bibliotheque.mappers;

import org.mapstruct.MappingTarget;

public interface GenericMapper<T, TDto> {

	   TDto toDto(T entity);
	   
	   T toEntity(TDto dto);
	   
	   void update(TDto dto, @MappingTarget T entity);
}
