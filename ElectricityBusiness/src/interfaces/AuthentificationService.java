package interfaces;

import model.Utilisateur;
import java.util.ArrayList;

public abstract class AuthentificationService {
    public static Utilisateur inscription(String email, String motDePasse){
        if (email.length()>5 & motDePasse.length()>7) {
            System.out.println("Inscription réussie");
            return new Utilisateur(email, motDePasse);
        }
        System.out.println("email ou mot de passe invalide");
        return null;
    };

    public abstract void validation(int codeValidation);
    
    public static Utilisateur connexion(String email, String motDePasse, ArrayList<Utilisateur> utilisateurs){
        for(int i=0; i<utilisateurs.size(); i++){
            if (utilisateurs.get(i).getEmail().equals(email) & utilisateurs.get(i).getMotDePasse().equals(motDePasse)) {
                System.out.println("Connexion réussie");
                return utilisateurs.get(i);
            }
        }
        System.out.println("email ou mot de passe incorrect");
        return null;
    };
}
