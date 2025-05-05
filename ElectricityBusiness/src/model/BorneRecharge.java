package model;

import java.util.UUID;

public class BorneRecharge {
    public UUID id;
    public EtatBorne etat;
    public float tarifHoraire;


    public UUID getId() {
        return id;
    }
    public EtatBorne getEtat() {
        return etat;
    }
    public void setEtat(EtatBorne etat) {
        this.etat = etat;
    }
    public float getTarifHoraire() {
        return tarifHoraire;
    }
    public void setTarifHoraire(float tarifHoraire) {
        this.tarifHoraire = tarifHoraire;
    }


    public BorneRecharge(float tarifHoraire) {
        this.id = java.util.UUID.randomUUID();
        this.etat = EtatBorne.DISPONIBLE;
        this.tarifHoraire = tarifHoraire;
    }
}
