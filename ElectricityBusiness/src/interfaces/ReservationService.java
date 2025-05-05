package interfaces;

import java.util.ArrayList;
import java.time.LocalDate;

import model.BorneRecharge;
import model.EtatBorne;
import model.Reservation;
import model.StatutReservation;
import model.Utilisateur;

public abstract class ReservationService {
    public static ArrayList<BorneRecharge> chercherBornesDispo(ArrayList<BorneRecharge> bornes){
        ArrayList<BorneRecharge> listeDispo = new ArrayList<BorneRecharge>();
        for(int i = 0; i<bornes.size(); i++){
            if (bornes.get(i).getEtat()==EtatBorne.DISPONIBLE) {
                listeDispo.add(bornes.get(i));
            }
        }
        return listeDispo;
    };

    public static Reservation creerReservation(Utilisateur utilisateur, BorneRecharge borne, LocalDate dateDebut, LocalDate dateFin){
        return new Reservation(utilisateur, borne, dateFin, dateFin);
    };

    public abstract void gererReservation(StatutReservation statut);
}
