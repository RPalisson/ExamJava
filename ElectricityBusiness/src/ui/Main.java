package ui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

import interfaces.DocumentService;
import model.*;

public class Main {

    public static void main(String[] args) throws Exception {
        boolean active = true;
        int choix = 0;

        Utilisateur utilisateur = null;
        Utilisateur utilisateurConnecte = null;
        String email;
        String motDePasse;
        String selection;
        
        Scanner input = new Scanner(System.in);

        ArrayList<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
        ArrayList<BorneRecharge> bornes = new ArrayList<BorneRecharge>();
        ArrayList<LieuRecharge> lieux = new ArrayList<LieuRecharge>();
        ArrayList<Reservation> reservations = new ArrayList<Reservation>();

        utilisateurs.add(new Utilisateur("pablo.picasso@rouge.fr", "Guernica"));
        bornes.add(new BorneRecharge(12));
        lieux.add(new LieuRecharge("27 allée des Seigles"));
        reservations.add(new Reservation(utilisateurs.get(0), bornes.get(0), LocalDate.now(), LocalDate.of(2025, 05, 25)));

        System.out.println("=== Electricity Business ===\n"
            +"1. S'inscrire\n"
            +"2. Valider l'inscription\n"
            +"3. Se connecter\n"
            +"4. Rechercher & réserver une borne\n"
            +"5. Gérer mes réservations\n"
            +"6. Administration (lieux / bornes)\n"
            +"7. Imprimer reçu réservation\n"
            +"0. Quitter\n"
            );

        while(active){ 
            System.out.println("Choisissez");
            selection = input.nextLine();
            switch (selection) {
                case "0":
                    active= false;
                    break;
            
                case "1":
                    System.out.println("Entrez un email et un mot de passe");
                    email = input.nextLine();
                    motDePasse = input.nextLine();
                    utilisateur = Utilisateur.inscription(email, motDePasse);
                    utilisateurs.add(utilisateur);
                    System.out.println("Votre code de vérificaiton est le "+ utilisateur.getCodeValidation());
                    break;
            
                case "2":
                    if (utilisateur!=null & !utilisateur.estValide) {
                        System.out.println("Entrez le code de validation");
                        utilisateur.validation(input.nextInt());
                        if (utilisateur.estValide) {
                            System.out.println("L'utilisateur a été validé");
                        } else {
                            System.out.println("Utilisateur non validé");
                        }
                    } else{
                        System.out.println("Pas d'utilisateur à valider");
                    }
                    break;
            
                case "3":
                    System.out.println("Entrez un email et un mot de passe");
                    email = input.nextLine();
                    motDePasse = input.nextLine();
                    utilisateurConnecte = Utilisateur.connexion(email, motDePasse, utilisateurs);
                    break;
            
                case "4":
                    ArrayList<BorneRecharge> bornesDispo = Reservation.chercherBornesDispo(bornes);
                    System.out.println(bornesDispo.toString());
                    if (bornesDispo.size()>0) {
                        reservations.add(Reservation.creerReservation(utilisateurConnecte, bornesDispo.get(0), LocalDate.now(), LocalDate.of(2025,06,06)));
                    }
                    break;
            
                case "5":
                    System.out.println("Voulez vous valider (1) ou annuler (2) la réservation ?");
                    choix = input.nextInt();
                    if (choix==1) {
                        reservations.get(0).gererReservation(StatutReservation.VALIDE);
                        System.out.println("Validation réussie");
                    }
                    if (choix==2) {
                        reservations.get(0).gererReservation(StatutReservation.ANNULE);
                        System.out.println("Annulation réussie");
                    }
                    break;
            
                case "6":
                    System.out.println("Voulez vous administrer un lieu (1) ou une borne (2) ?");
                    choix = input.nextInt();
                    if (choix==1) {
                        lieux.get(0).modificationLieu("26 Allée des Seigles");
                        System.out.println("Modification Lieu réussie");
                    }
                    if (choix==2) {
                        bornes.get(0).modificationBorne(7);
                        System.out.println("Modification Borne réussie");
                    }
                    break;

                case "7":
                    DocumentService.genererRecu(reservations.get(0));
                    break;

                default:
                    System.out.println("Saisie invalide, recommencez");
                    break;
            }
        }
        input.close();
    }
}
