package model;

import java.time.LocalDate;
import java.util.UUID;

import interfaces.ReservationService;

public class Reservation extends ReservationService{
    public UUID id;
    public Utilisateur utilisateur;
    public BorneRecharge borne;
    public LocalDate dateDebut;
    public LocalDate dateFin;
    public StatutReservation statut;
    
    public UUID getId() {
        return id;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
    public BorneRecharge getBorneRecharge() {
        return borne;
    }
    public void setBorneRecharge(BorneRecharge borne) {
        this.borne = borne;
    }
    public LocalDate getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }
    public LocalDate getDateFin() {
        return dateFin;
    }
    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }
    public StatutReservation getStatut() {
        return statut;
    }
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
    public Reservation(Utilisateur utilisateur, BorneRecharge borne, LocalDate dateDebut, LocalDate dateFin) {
        this.id = java.util.UUID.randomUUID();
        this.utilisateur = utilisateur;
        this.borne = borne;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = StatutReservation.EN_ATTENTE;
    }

    public void gererReservation(StatutReservation statut){
        this.setStatut(statut);
        return;
    }

    @Override
    public String toString() {
        return "Reservation [id=" + id + ", utilisateur=" + utilisateur + ", borne=" + borne + ", dateDebut="
                + dateDebut + ", dateFin=" + dateFin + ", statut=" + statut + "]";
    }    
}
