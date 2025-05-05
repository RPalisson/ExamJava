package interfaces;

import model.Utilisateur;
import java.util.ArrayList;

public abstract class AuthentificationService {
    public static Utilisateur inscription(String email, String motDePasse){
        if (email.length()>5 & motDePasse.length()>7) {
            return new Utilisateur(email, motDePasse);
        }
        System.out.println("email ou mot de passe invalide");
        return null;
    };

    public abstract void validation(int codeValidation);
    
    public static Utilisateur connexion(String email, String motDePasse, ArrayList<Utilisateur> utilisateurs){
        for(int i=0; i<utilisateurs.size(); i++){
            if (utilisateurs.get(i).getEmail()==email & utilisateurs.get(i).getMotDePasse()==motDePasse) {
                i=utilisateurs.size();
                return utilisateurs.get(i);
            }
        }
        System.out.println("email ou mot de passe incorrect");
        return null;
    };
}
