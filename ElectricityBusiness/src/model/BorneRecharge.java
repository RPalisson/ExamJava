package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import interfaces.BorneService;

public class BorneRecharge extends BorneService{
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

    public void modificationBorne(float tarifHoraire){
        this.setTarifHoraire(tarifHoraire);
        return;
    }

    public boolean suppressionBorne(ArrayList<Reservation> reservations){
        for(int i=0; i<reservations.size(); i++){
            if (this.id==reservations.get(i).getBorneRecharge().getId() & reservations.get(i).getDateFin().isAfter(LocalDate.now())) {
                System.out.println("Suppression impossible, il y a des réservations futures");
                return false;
            }
        }
        return true;
    }
}
