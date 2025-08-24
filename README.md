# Demo de Mapeadores en Java

Este proyecto demuestra el uso de diferentes bibliotecas de mapeo de objetos en Java:
- **MapStruct**: Generador de código para mapeos tipo Java Bean
- **ModelMapper**: Mapeo de objetos inteligente y automático
- **Orika**: Mapeo de objetos de alto rendimiento

## Estructura del Proyecto

```
src/main/java/com/isai/
├── Main.java                    # Punto de entrada de la aplicación
├── mapstruct/
│   ├── dtos/
│   │   ├── PersonaCustumDto.java  # DTO con mapeo personalizado
│   │   └── PersonaDefaultDto.java # DTO con mapeo por defecto
│   ├── entitys/
│   │   └── Persona.java         # Entidad principal
│   └── mappers/
│       └── PersonaMapper.java   # Interfaz de mapeo con MapStruct
```

## Dependencias

- Java 21
- Maven 3.8.1+
- MapStruct 1.6.3
- ModelMapper 3.2.4
- Orika 1.5.4

## Configuración

El proyecto utiliza Maven para la gestión de dependencias. Las dependencias principales están configuradas en el archivo `pom.xml`.

## Uso

### MapStruct

```java
// Mapeo básico
PersonaDefaultDto dto = PersonaMapper.INSTANCE.personaToPersonaDefaultDto(persona);

// Mapeo con configuración personalizada
PersonaCustumDto customDto = PersonaMapper.INSTANCE.personaToPersonaCustumDto(persona);
```

### ModelMapper

```java
ModelMapper modelMapper = new ModelMapper();
PersonaDefaultDto dto = modelMapper.map(persona, PersonaDefaultDto.class);
```

### Orika

```java
MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
mapperFactory.classMap(Persona.class, PersonaDefaultDto.class)
    .field("id", "id")
    .field("nombre", "nombre")
    .byDefault()
    .register();
    
MapperFacade mapper = mapperFactory.getMapperFacade();
PersonaDefaultDto dto = mapper.map(persona, PersonaDefaultDto.class);
```

## Ejecución

1. Clona el repositorio
2. Navega al directorio del proyecto
3. Ejecuta el siguiente comando:

```bash
mvn clean install
```

## Características

- Mapeo de objetos con diferentes estrategias
- Configuración personalizada de mapeos
- Ejemplos de uso con diferentes bibliotecas
- Proyecto Maven listo para usar

