public class ReadFS {

    public static void main(String[] args) {

	try {
	    /// Creer un noeud Dossier pour chaque argument passe' sur la ligne de commande.
	    for (int i = 0 ; i < args.length ; i++) {
		
		Node racine = new Dossier(args[i], 0) ;
		System.out.println("\n\nExploration de " + args[i]) ;
		racine.afficher("") ;
	    }
	    
	} catch (java.io.IOException e) {
	    /// Si exception, l'afficher.
	    System.out.println(e) ;
	}
    }

}