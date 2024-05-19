public class Fichier extends Node {

    public Fichier (String chemin) throws java.io.IOException {
	/// Important : appel a super()
	super(FileInfo.size(chemin), chemin) ;
    }

    public void afficher(String marge) {
	System.out.println(marge + "| " + this.nom + " [" + this.taille + " octets]") ;
    }

}