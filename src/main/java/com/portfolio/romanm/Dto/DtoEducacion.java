package com.portfolio.romanm.Dto;

import javax.validation.constraints.NotBlank;

public class DtoEducacion {
    @NotBlank
    private String institucionEdu;
    @NotBlank
    private String tituloEdu;
    @NotBlank
    private String carreraEdu;
    @NotBlank
    private String inicioEdu;
    private String finEdu;
    private String linkImg;

    public DtoEducacion() {
    }

    public DtoEducacion(String institucionEdu, String tituloEdu, String carreraEdu, String inicioEdu, String finEdu, String linkImg) {
        this.institucionEdu = institucionEdu;
        this.tituloEdu = tituloEdu;
        this.carreraEdu = carreraEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
        this.linkImg = linkImg;
    }

    public String getInstitucionEdu() {
        return institucionEdu;
    }

    public void setInstitucionEdu(String institucionEdu) {
        this.institucionEdu = institucionEdu;
    }

    public String getTituloEdu() {
        return tituloEdu;
    }

    public void setTituloEdu(String tituloEdu) {
        this.tituloEdu = tituloEdu;
    }

    public String getCarreraEdu() {
        return carreraEdu;
    }

    public void setCarreraEdu(String carreraEdu) {
        this.carreraEdu = carreraEdu;
    }

    public String getInicioEdu() {
        return inicioEdu;
    }

    public void setInicioEdu(String inicioEdu) {
        this.inicioEdu = inicioEdu;
    }

    public String getFinEdu() {
        return finEdu;
    }

    public void setFinEdu(String finEdu) {
        this.finEdu = finEdu;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}
