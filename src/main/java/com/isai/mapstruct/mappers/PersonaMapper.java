package com.isai.mapstruct.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.isai.mapstruct.dtos.PersonaCustumDto;
import com.isai.mapstruct.dtos.PersonaDefaultDto;
import com.isai.model_mapper.entitys.Persona;

@Mapper
public interface PersonaMapper {
    PersonaMapper INSTANCE = Mappers.getMapper(PersonaMapper.class);

    PersonaDefaultDto personaToPersonaDefaultDto(Persona persona);

    @Mapping(source = "id", target = "idDto")
    @Mapping(source = "nombre", target = "nombreDto")
    @Mapping(source = "apellido", target = "apellidoDto")
    @Mapping(source = "email", target = "emailDto")
    @Mapping(source = "age", target = "ageDto")
    @Mapping(source = "gender", target = "genderDto")
    PersonaCustumDto personaToPersonaCustumDto(Persona persona);
}
