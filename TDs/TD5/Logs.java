import java.util.* ;

// @author M. Foughali

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

	// Concatener toutes les lignes.
	for (LogLine ligne : this.lignes) {
	    buffer = buffer + ligne + "\n";
	}

	return buffer ;
    }

    /// TD5 : trouver une ligne correspondante
    /// Important : le 'throws'
    //  Principe : on dépile les logline (depuis une copie de la pile) et on s'arrête au premier trouvé.
    //  le LIFO nous assure que le premier trouvé est forcément le plus récent.
    //  La copie se fait via la méthode "clone", qui nécessite un cast (ceci devrait vous rappeler votre réponse à la première question de compréhension du TD précédent)   
    public LogLine trouveLigne(Robot emetteur, Robot tiers) throws PasTrouve {  
	LogLine line = null;
	boolean trouve = false;     
        Stack<LogLine> copie = (Stack<LogLine>)this.lignes.clone() ;

	// on s'arrête dès qu'un élément est trouvé OU la pile est vide     
	while  (!( trouve || copie.empty())) {
		line = copie.pop();
		trouve = (((line.getEmetteur() == emetteur) && (line.getTiers() == tiers))
		||
		((line.getEmetteur() == tiers) && (line.getTiers() == emetteur)));
	}
	if (!trouve)  throw (new PasTrouve("Deux inconnus")); 
	else return line ;
    }


}