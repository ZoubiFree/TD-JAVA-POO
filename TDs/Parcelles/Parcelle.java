package P2;
import java.util.*;

public class Parcelle {
    private String section;
    private int numParelle;
    private double superficie;
    private List<Activite> listeActivite;
    


    public Parcelle(String section,int numParelle, double superficie, List<Activite> listeActivite) 
    {
        this.section = section;
        this.numParelle = numParelle;
        this.superficie = superficie;
        this.listeActivite = listeActivite;
    }




    public void setNumParcelle(int numParelle) throws NegativeException {
        if (numParelle < 0){
            throw new NegativeException("PAS DE NOMBRE NEGATIF");
        }
        this.numParelle = numParelle;
    }

    @Override
    public String toString(){
        return ("Parcelle : Section "+ this.section+", numéro : "+this.numParelle);
    }

    public double getSuperficie() {
        return superficie;
    }

    public Activite maxCout(){
        int cout = 0;
        Activite activitemax = null;
        for (Activite i : listeActivite ){
            if (i.getCoutAnnuel() > cout){
                cout = i.getCoutAnnuel();
                activitemax = i;
            }
        }
        return activitemax;

    }

}