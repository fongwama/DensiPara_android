package cg.fongwama.densipara.model;

import java.io.Serializable;

/**
 * Created by Orion WAMBERT on 01/04/2018.
 */
public class Analyse implements Serializable {
    private Long reference;
    private String nomPatient;
    private String nomTechnicien;
    private int nbreParasite;
    private int nbreGlobuleBlanc;
    private int nbreGlobParSang;
    private int resutatAnaluse;

    public Analyse() {
        resutatAnaluse=0;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public String getNomPatient() {
        return nomPatient;
    }

    public void setNomPatient(String nomPatient) {
        this.nomPatient = nomPatient;
    }

    public String getNomTechnicien() {
        return nomTechnicien;
    }

    public void setNomTechnicien(String nomTechnicien) {
        this.nomTechnicien = nomTechnicien;
    }

    public int getNbreParasite() {
        return nbreParasite;
    }

    public void setNbreParasite(int nbreParasite) {
        this.nbreParasite = nbreParasite;
    }

    public int getNbreGlobuleBlanc() {
        return nbreGlobuleBlanc;
    }

    public void setNbreGlobuleBlanc(int nbreGlobuleBlanc) {
        this.nbreGlobuleBlanc = nbreGlobuleBlanc;
    }

    public int getResutatAnaluse() {
        return resutatAnaluse;
    }

    public void setResutatAnaluse(int resutatAnaluse) {
        this.resutatAnaluse = resutatAnaluse;
    }

    public int calculer(int nbreGlobuleBlanc,int nbreParasite ,int nbreGlobParSang){
        this.nbreGlobParSang=nbreGlobParSang;
        this.nbreGlobuleBlanc=nbreGlobuleBlanc;
        this.nbreParasite=nbreParasite;
        this.resutatAnaluse=nbreParasite*nbreGlobuleBlanc/nbreGlobParSang;
        return resutatAnaluse;
    }

    public int getNbreGlobParSang() {
        return nbreGlobParSang;
    }

    public void setNbreGlobParSang(int nbreGlobParSang) {
        this.nbreGlobParSang = nbreGlobParSang;
    }
}
