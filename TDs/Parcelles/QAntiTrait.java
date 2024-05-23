package P2;

public class QAntiTrait extends Activite{

private String typeInsecte;
private String ferocite;

    public QAntiTrait(String nom, int coutAnnuel, Parcelle parcelle, String typeInsecte, String ferocite){
        super(nom, coutAnnuel, parcelle);
        this.typeInsecte = typeInsecte;
        this.ferocite = ferocite;
    }


    public int getQuantteO(){
        return (int) (100*parcelle.getSuperficie());
    }
 
    @Override
    public double getAide(){
        return 1000*this.parcelle.getSuperficie() + 2000;
    }

}
