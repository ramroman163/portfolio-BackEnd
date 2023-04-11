/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.romanm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoPersona {
    @NotBlank
    private String nombre;
    @NotBlank
    private String apellido;
    @NotBlank
    private String linkImgPerfil;
    @NotBlank
    private String linkImgBanner;
    @NotBlank
    private String profesion;
    @NotBlank
    private String ubicacion;
    @NotBlank
    private String acercaDeMi;

    public DtoPersona() {
    }

    public DtoPersona(String nombre, String apellido, String linkImgPerfil, String linkImgBanner, String profesion, String ubicacion, String acercaDeMi) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.linkImgPerfil = linkImgPerfil;
        this.linkImgBanner = linkImgBanner;
        this.profesion = profesion;
        this.ubicacion = ubicacion;
        this.acercaDeMi = acercaDeMi;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getLinkImgPerfil() {
        return linkImgPerfil;
    }

    public void setLinkImgPerfil(String linkImgPerfil) {
        this.linkImgPerfil = linkImgPerfil;
    }

    public String getLinkImgBanner() {
        return linkImgBanner;
    }

    public void setLinkImgBanner(String linkImgBanner) {
        this.linkImgBanner = linkImgBanner;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getAcercaDeMi() {
        return acercaDeMi;
    }

    public void setAcercaDeMi(String acercaDeMi) {
        this.acercaDeMi = acercaDeMi;
    }
}
