package com.portfolio.romanm.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String nombre;
    @NotNull
    @Size(min = 1, max = 50, message = "no cumple con la longitud")
    private String apellido;
    @NotNull
    private String linkImgPerfil;
    @NotNull
    private String linkImgBanner;
    @NotNull
    private String profesion;
    @NotNull
    private String ubicacion;
    @NotNull
    private String acercaDeMi;
    
    private String telefono;
    private String email;

    public Persona() {
    }
    
    public Persona(String nombre, String apellido, String linkImgPerfil, String linkImgBanner, String profesion, String ubicacion, String acercaDeMi, String telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.linkImgPerfil = linkImgPerfil;
        this.linkImgBanner = linkImgBanner;
        this.profesion = profesion;
        this.ubicacion = ubicacion;
        this.acercaDeMi = acercaDeMi;
        this.telefono = telefono;
        this.email = email;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
