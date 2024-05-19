import java.util.* ;

public class Logs {

    private Stack<LogLine> lignes ;
    
    public Logs() {
	this.lignes = new Stack<LogLine>() ;
    }

    // Cree et ajoute une nouvelle ligne.
    public void add(String message, Robot emetteur, Robot tiers) {
	this.lignes.push (new LogLine(message, emetteur, tiers)) ;
    }

    public String toString() {
	String buffer = "" ;

	/// Concatener toutes les lignes.
	for (LogLine ligne : this.lignes) {
	    buffer = buffer + ligne + "\n";
	}

	return buffer ;
    }

}