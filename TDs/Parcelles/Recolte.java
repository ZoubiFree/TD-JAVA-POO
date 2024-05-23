package P2;

public class Recolte extends Activite{

private String periode;
private String matos;

    public Recolte(String nom, int coutAnnuel, Parcelle parcelle, String periode, String matos){
        super(nom, coutAnnuel, parcelle);
        this.periode = periode;
        this.matos = matos;
    }
    public int getQuantteO(){
        return (int) (200*parcelle.getSuperficie());
    }
    
}
