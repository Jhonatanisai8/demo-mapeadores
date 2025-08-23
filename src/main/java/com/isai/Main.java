package com.isai;

import org.modelmapper.ModelMapper;

import com.isai.model_mapper.dtos.PersonaDefaultDto;
import com.isai.model_mapper.entitys.Persona;

public class Main {

    // model mapper default
    public static void main(String[] args) {
        ModelMapper modeloMapper = new ModelMapper();

        Persona persona = new Persona(1L, "Jhonayan", "OS", "Cooreo@gmail.com", (byte) 25, 'M');
        System.out.println(persona.toString());

        // mapemos el objeto
        PersonaDefaultDto personaDefaultDto = modeloMapper.map(persona, PersonaDefaultDto.class);

        System.out.println(personaDefaultDto);
    }
}