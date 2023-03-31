package com.portfolio.romanm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoExperiencia {
    @NotBlank
    private String puestoExp;
    @NotBlank
    private String lugarExp;
    @NotBlank
    private String inicioExp;
    @NotBlank
    private String finExp;
    private String linkImg;

    public DtoExperiencia() {
    }

    public DtoExperiencia(String puestoExp, String lugarExp, String inicioExp, String finExp, String linkImg) {
        this.puestoExp = puestoExp;
        this.lugarExp = lugarExp;
        this.inicioExp = inicioExp;
        this.finExp = finExp;
        this.linkImg = linkImg;
    }

    public String getPuestoExp() {
        return puestoExp;
    }

    public void setPuestoExp(String puestoExp) {
        this.puestoExp = puestoExp;
    }

    public String getLugarExp() {
        return lugarExp;
    }

    public void setLugarExp(String lugarExp) {
        this.lugarExp = lugarExp;
    }

    public String getInicioExp() {
        return inicioExp;
    }

    public void setInicioExp(String inicioExp) {
        this.inicioExp = inicioExp;
    }

    public String getFinExp() {
        return finExp;
    }

    public void setFinExp(String finExp) {
        this.finExp = finExp;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}
