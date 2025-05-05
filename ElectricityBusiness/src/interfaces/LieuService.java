package interfaces;

import model.LieuRecharge;

public abstract class LieuService {
    public LieuRecharge ajoutLieu(String nom){
        return new LieuRecharge(nom);
    };
    public  abstract void modificationLieu(String nom);
}
