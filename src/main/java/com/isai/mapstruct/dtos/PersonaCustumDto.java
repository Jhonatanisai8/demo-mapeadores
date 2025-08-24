package com.isai.mapstruct.dtos;

public class PersonaCustumDto {
    private Long idDto;
    private String nombreDto;
    private String apellidoDto;
    private String emailDto;
    private byte ageDto;
    private Character genderDto;

    public PersonaCustumDto() {
    }

    public PersonaCustumDto(Long idDto, String nombreDto, String apellidoDto, String emailDto, byte ageDto,
                            Character genderDto) {
        this.idDto = idDto;
        this.nombreDto = nombreDto;
        this.apellidoDto = apellidoDto;
        this.emailDto = emailDto;
        this.ageDto = ageDto;
        this.genderDto = genderDto;
    }

    public Long getIdDto() {
        return idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public String getNombreDto() {
        return nombreDto;
    }

    public void setNombreDto(String nombreDto) {
        this.nombreDto = nombreDto;
    }

    public String getApellidoDto() {
        return apellidoDto;
    }

    public void setApellidoDto(String apellidoDto) {
        this.apellidoDto = apellidoDto;
    }

    public String getEmailDto() {
        return emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public byte getAgeDto() {
        return ageDto;
    }

    public void setAgeDto(byte ageDto) {
        this.ageDto = ageDto;
    }

    public Character getGenderDto() {
        return genderDto;
    }

    public void setGenderDto(Character genderDto) {
        this.genderDto = genderDto;
    }

    @Override
    public String toString() {
        return "PersonaCustumDto{" +
                "idDto=" + idDto +
                ", nombreDto='" + nombreDto + '\'' +
                ", apellidoDto='" + apellidoDto + '\'' +
                ", emailDto='" + emailDto + '\'' +
                ", ageDto=" + ageDto +
                ", genderDto=" + genderDto +
                '}';
    }
}
