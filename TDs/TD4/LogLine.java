import java.util.* ;

public class LogLine {
    
    private Date date ;
    private String message ;
    private Robot emetteur ;
    private Robot tiers ;

    public LogLine(String message, Robot emetteur, Robot tiers) {
	/// Ce constructeur de Date() obtient la date courante.
	this.date = new Date() ;
	this.message = message ;
	this.emetteur = emetteur ;
	this.tiers = tiers ;
    }

    public String toString() {
	return "[" + this.date + "] " + this.emetteur + " ==> " + this.message + " avec " + this.tiers ;
    }

}