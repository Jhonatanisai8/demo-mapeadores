package com.isai;

import com.isai.model_mapper.dtos.PersonaCustumDto;
import org.modelmapper.ModelMapper;

import com.isai.model_mapper.dtos.PersonaDefaultDto;
import com.isai.model_mapper.entitys.Persona;
import org.modelmapper.TypeMap;

public class Main {

    // model mapper default
    public static void main(String[] args) {
        //ejemploMapearModelMapperV1();
        ejemploMapearModelMapperV2();
    }

    private static void ejemploMapearModelMapperV2() {
        try {
            ModelMapper modelMapper = new ModelMapper();
            Persona persona = new Persona(1L, "Jhonayan", "OS", "Cooreo@gmail.com", (byte) 25, 'M');
            System.out.println(persona.toString());
            TypeMap<Persona, PersonaCustumDto> propiedadesMapper = modelMapper.createTypeMap(Persona.class, PersonaCustumDto.class);
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