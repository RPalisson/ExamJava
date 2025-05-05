package interfaces;

import java.util.ArrayList;

import model.BorneRecharge;
import model.Reservation;

public abstract class BorneService {
    public static BorneRecharge ajoutBorne(float tarifHoraire){
        return new BorneRecharge(tarifHoraire);
    };
    public abstract void modificationBorne(float tarifHoraire);
    public abstract boolean suppressionBorne(ArrayList<Reservation> reservations);

}
