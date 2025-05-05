package interfaces;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import model.Reservation;

public abstract class DocumentService {
    public static void genererRecu(Reservation reservation){
        try {
            File fichier = new File("/exports/reçu_" + reservation.getUtilisateur().getId().toString() + ".txt");
            if (!fichier.createNewFile()) {
                System.out.println("Fichier déjà existant.");
            } else{
                FileWriter crayon = new FileWriter("/exports/recu.txt");
                crayon.write(reservation.toString());
                crayon.close();
            }
          } catch (IOException e) {
            System.out.println("Erreur IOException");
            e.printStackTrace();
          }

    };
}
