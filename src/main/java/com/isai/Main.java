package com.isai;

import com.isai.mapstruct.mappers.PersonaMapper;
import com.isai.model_mapper.dtos.PersonaCustumDto;
import org.modelmapper.ModelMapper;
import ma.glasnost.orika.*;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import com.isai.model_mapper.dtos.PersonaDefaultDto;
import com.isai.model_mapper.entitys.Persona;
import org.modelmapper.TypeMap;

public class Main {

    public static void main(String[] args) {
        // ejemploMapearModelMapperV1();
        // ejemploMapearModelMapperV2();
        // ejemploOrikaMapperV1();
        // ejemploOrikaMapperV2();
        /* Ejemplo de MapStruct v1 */
        Persona persona = new Persona(
                1L,
                "Jhonayan",
                "OS",
                "jonmy@gmail.com",
                (byte) 25,
                'M');
        System.out.println(persona.toString());
        com.isai.mapstruct.dtos.PersonaDefaultDto personaToPersonaDefaultDto = PersonaMapper.INSTANCE
                .personaToPersonaDefaultDto(persona);
        System.out.println(personaToPersonaDefaultDto.toString());
    }

    private static void ejemploOrikaMapperV2() {
        try {
            /* Ejemplo con orika Maper personalizado */
            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
            mapperFactory.classMap(Persona.class, PersonaCustumDto.class)
                    .field("id", "idDto")
                    .field("nombre", "nombreDto")
                    .field("apellido", "apellidoDto")
                    .field("email", "emailDto")
                    .field("age", "ageDto")
                    .field("gender", "genderDto")
                    .byDefault()
                    .register();

            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            Persona persona = new Persona(
                    1L,
                    "Jhonayan",
                    "OS",
                    "jonmy@gmail.com",
                    (byte) 25,
                    'M');
            System.out.println(persona.toString());
            PersonaCustumDto personaCustumDto = mapperFacade.map(persona, PersonaCustumDto.class);
            System.out.println(personaCustumDto.toString());
        } catch (Exception e) {
            System.out.println("Error: ".concat(e.getMessage()));
        }
    }

    private static void ejemploOrikaMapperV1() {
        /* Ejemplo con OrikaMapper default */
        try {
            MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

            mapperFactory.classMap(Persona.class, PersonaDefaultDto.class);
            MapperFacade mapperFacade = mapperFactory.getMapperFacade();
            Persona persona = new Persona(
                    1L,
                    "Jhonayan",
                    "OS",
                    "jonmy@gmail.com",
                    (byte) 25,
                    'M');
            PersonaDefaultDto personaDefaultDto = mapperFacade.map(persona, PersonaDefaultDto.class);
            System.out.println(persona.toString());
            System.out.println(personaDefaultDto.toString());
        } catch (RuntimeException e) {
            System.out.println("Error: ".concat(e.getMessage()));
        }
    }

    private static void ejemploMapearModelMapperV2() {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Persona persona = new Persona(1L, "Jhonayan", "OS", "Cooreo@gmail.com", (byte) 25, 'M');
            System.out.println(persona.toString());
            TypeMap<Persona, PersonaCustumDto> propiedadesMapper = modelMapper.createTypeMap(Persona.class,
                    PersonaCustumDto.class);
            propiedadesMapper.addMapping(Persona::getId, PersonaCustumDto::setIdDto);
            propiedadesMapper.addMapping(Persona::getNombre, PersonaCustumDto::setNombreDto);
            propiedadesMapper.addMapping(Persona::getApellido, PersonaCustumDto::setApellidoDto);
            propiedadesMapper.addMapping(Persona::getEmail, PersonaCustumDto::setEmailDto);
            propiedadesMapper.addMapping(Persona::getAge, PersonaCustumDto::setAgeDto);
            propiedadesMapper.addMapping(Persona::getGender, PersonaCustumDto::setGenderDto);
            PersonaCustumDto personaCustumDto = propiedadesMapper.map(persona);
            System.out.println(personaCustumDto.toString());
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void ejemploMapearModelMapperV1() {
        ModelMapper modeloMapper = new ModelMapper();

        Persona persona = new Persona(1L, "Jhonayan", "OS", "Cooreo@gmail.com", (byte) 25, 'M');
        System.out.println(persona.toString());

        // mapemos el objeto
        PersonaDefaultDto personaDefaultDto = modeloMapper.map(persona, PersonaDefaultDto.class);

        System.out.println(personaDefaultDto);
    }
}