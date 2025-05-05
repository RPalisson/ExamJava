package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class LieuRecharge {
    public UUID id;
    public String nom;
    public List<BorneRecharge> bornes;


    public UUID getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public List<BorneRecharge> getBornes() {
        return bornes;
    }
    public void setBornes(List<BorneRecharge> bornes) {
        this.bornes = bornes;
    }

    public LieuRecharge(String nom) {
        this.id = java.util.UUID.randomUUID();
        this.nom = nom;
        this.bornes = new ArrayList<BorneRecharge>();
    }
}
