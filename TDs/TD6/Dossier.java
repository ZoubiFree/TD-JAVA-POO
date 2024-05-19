import java.util.* ;

public class Dossier extends Node {

    // Profondeur maximale d'exploration
    private static final int maxProf = 2 ;

    // Profondeur actuelle
    private int profondeur ;

    // Sous-elements de ce dossier
    private ArrayList<Node> elements ;

    /// Le constructeur attend le chemin du dossier et la profondeur actuelle
    public Dossier(String chemin, int prof) throws java.io.IOException {
	/// La taille doit etre calculee avec des appels recursifs.
	/// Pour l'instant, on met 0 et on rectifie plus loin.
	super(0, chemin) ;
	
	this.profondeur = prof ;
	this.elements = new ArrayList<Node>() ;
	
	/// Calcul de la taille totale et remplissage de this.elements
	long total = 0 ;

	/// Parcourt tous les sous-elements (fichiers et dossiers).
	for (Iterator<String> it = FileInfo.getElements(chemin) ; it.hasNext() ; ) {
	    String path = it.next() ;
	    Node element = null ;

	    /// Ne pas creer de node supplementaire si on a depasse' la limite.
	    if (Node.nbNodes < Node.maxNodes) {

		/// Si c'est un fichier, creer un objet Fichier.
		if (FileInfo.isFile(path)) {
		    element = new Fichier(path) ;
		}
		/// Sinon, si c'est un dossier, et que la profondeur reste acceptable, creer un objet Dossier
		else if (this.profondeur < maxProf && FileInfo.isDirectory(path)) {

		    /// Noter l'appel recursif au constructeur pour construire un sous-dossier
		    /// avant de construire le dossier courant.
		    element = new Dossier(path, this.profondeur+1) ;
		}

		/// Si le node a ete initialise', l'ajouter a la liste.
		if (element != null) {
		    this.elements.add(element) ;
		    total += element.taille ;
		}
	    }
	}

	this.taille = total ;
    }

    public void afficher(String marge) {
	System.out.println(marge + "+ (DIR) " + this.nom + " [total = " + this.taille + " octets]") ;

	/// Afficher tous les sous-elements.
	for (Node node : this.elements) {
	    node.afficher(marge + "     ") ;
	}

	System.out.println("") ;
    }

}