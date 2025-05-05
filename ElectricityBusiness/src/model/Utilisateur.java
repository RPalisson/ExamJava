package model;

import java.util.UUID;

import interfaces.AuthentificationService;

public class Utilisateur extends AuthentificationService{
    public UUID id;
    public String email;
    public String motDePasse;
    public int codeValidation;
    public boolean estValide;


    public UUID getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMotDePasse() {
        return motDePasse;
    }
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    public int getCodeValidation() {
        return codeValidation;
    }
    public void setCodeValidation(int codeValidation) {
        this.codeValidation = codeValidation;
    }
    public boolean isEstValide() {
        return estValide;
    }
    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public Utilisateur( String email, String motDePasse) {
        this.id = java.util.UUID.randomUUID();
        this.email = email;
        this.motDePasse = motDePasse;
        this.codeValidation = (int)(Math.random()*1000);
        this.estValide = false;
    }

    public void validation(int codeValidation){
        if (codeValidation == this.codeValidation) {
            setEstValide(true);;
        }
        return;
    }
    
    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", email=" + email + ", motDePasse=" + motDePasse + ", codeValidation="
                + codeValidation + ", estValide=" + estValide + "]";
    }
}
