/// Important : la classe est abstraite
public abstract class Node {
    
    // Taille de chaque fichier ou dossier
    protected long taille ;

    // Nom court
    protected String nom ;

    // Chemin complet
    protected String chemin ;

    // Nombre de nodes crees
    public static int nbNodes = 0 ;

    // Nombre maximal de nodes que l'on peut creer.
    public static final int maxNodes = 100 ;


    public Node(long size, String path) {
	this.taille = size ;
	this.chemin = path ;
	this.nom = FileInfo.getName(chemin) ;
	nbNodes ++ ;
    }

    /// Cette methode abstraite doit obligatoirement etre redefinie dans les sous-classes.
    public abstract void afficher(String marge) ;

}