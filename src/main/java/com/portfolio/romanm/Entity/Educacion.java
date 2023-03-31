package com.portfolio.romanm.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String institucionEdu;
    private String tituloEdu;
    private String carreraEdu;
    private String inicioEdu;
    private String finEdu;
    private String linkImg;

    public Educacion() {
    }

    public Educacion(String institucionEdu, String tituloEdu, String carreraEdu, String inicioEdu, String finEdu, String linkImg) {
        this.institucionEdu = institucionEdu;
        this.tituloEdu = tituloEdu;
        this.carreraEdu = carreraEdu;
        this.inicioEdu = inicioEdu;
        this.finEdu = finEdu;
        this.linkImg = linkImg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
