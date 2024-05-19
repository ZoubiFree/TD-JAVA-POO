
/// Un objet 'PasTrouve' est une exception.
public class PasTrouve extends Exception {

    private String contenu ;
    
    /// Gentil constructeur
    public PasTrouve(String ct) {
	this.contenu = ct ;
    }

}