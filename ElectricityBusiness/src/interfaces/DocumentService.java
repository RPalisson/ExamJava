package interfaces;

import java.io.FileWriter;
import java.io.IOException;

import model.Reservation;

public abstract class DocumentService {
    public static void genererRecu(Reservation reservation){
        try {
            FileWriter crayon = new FileWriter("exports/recu_" + reservation.getUtilisateur().getId().toString() + ".txt");
            crayon.write(reservation.toString());
            crayon.close();
        } catch (IOException e) {
            System.out.println("Erreur IOException");
            e.printStackTrace();
          }

    };
}
