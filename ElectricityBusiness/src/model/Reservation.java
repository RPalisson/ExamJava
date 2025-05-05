package model;

import java.util.Date;
import java.util.UUID;

public class Reservation {
    public UUID id;
    public Utilisateur utilisateur;
    public Date dateDebut;
    public Date dateFin;
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
    public Date getDateDebut() {
        return dateDebut;
    }
    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public StatutReservation getStatut() {
        return statut;
    }
    public void setStatut(StatutReservation statut) {
        this.statut = statut;
    }
    public Reservation(Utilisateur utilisateur, Date dateDebut, Date dateFin) {
        this.id = java.util.UUID.randomUUID();
        this.utilisateur = utilisateur;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.statut = StatutReservation.EN_ATTENTE;
    }
}
