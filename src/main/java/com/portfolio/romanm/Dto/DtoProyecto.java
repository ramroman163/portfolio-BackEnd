package com.portfolio.romanm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoProyecto {
    @NotBlank
    private String nombreProyecto;
    @NotBlank
    private String descProyecto;
    private String linkProyecto;

    public DtoProyecto() {
    }

    public DtoProyecto(String nombreProyecto, String descProyecto, String linkProyecto) {
        this.nombreProyecto = nombreProyecto;
        this.descProyecto = descProyecto;
        this.linkProyecto = linkProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getDescProyecto() {
        return descProyecto;
    }

    public void setDescProyecto(String descProyecto) {
        this.descProyecto = descProyecto;
    }

    public String getLinkProyecto() {
        return linkProyecto;
    }

    public void setLinkProyecto(String linkProyecto) {
        this.linkProyecto = linkProyecto;
    }
}
