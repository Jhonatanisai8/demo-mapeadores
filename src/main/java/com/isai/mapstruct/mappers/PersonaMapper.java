package com.isai.mapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.isai.mapstruct.dtos.PersonaDefaultDto;
import com.isai.model_mapper.entitys.Persona;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDefaultDto personaToPersonaDefaultDto(Persona persona);
}
