import java.util.* ;

public class LogLine {
    
    private Date date ;
    private String message ;
    private Robot emetteur ;
    private Robot tiers ;

    public LogLine(String message, Robot emetteur, Robot tiers) {
	this.date = new Date() ;
	this.message = message ;
	this.emetteur = emetteur ;
	this.tiers = tiers ;
    }

    public String toString() {
	return "[" + this.date + "] " + this.emetteur + " ==> " + this.message + " avec " + this.tiers ;
    }

    public Robot getEmetteur() { return this.emetteur ; }
    public Robot getTiers() { return this.tiers ; }
    public Date getDate() { return this.date ; }
}