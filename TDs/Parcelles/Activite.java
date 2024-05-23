package P2;

import java.util.ArrayList;

public class Activite {
    private String nom;
    private ArrayList<Integer> liste;
    private int coutAnnuel;
    protected Parcelle parcelle;

    public Activite(String nom, int coutAnnuel, Parcelle parcelle){
        this.nom = nom;
        this.coutAnnuel = coutAnnuel;
        this.parcelle = parcelle;
    }


        public double getAide(){
            return 1000*this.parcelle.getSuperficie();
        }

    
}
