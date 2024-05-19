import java.awt.Color ;

class Killer extends Robot {

    // Se souvenir des robots deja vus.
    private int[] dejaVus ;

    private int tolerance ;

    public Killer (String nomImage, int x, int y, Plateau pt, Color col, int NbRobots, String nom) {
	super(nomImage, x, y, pt, col, nom) ;

	// Initialiser le tableau
	this.dejaVus = new int[NbRobots] ;
	this.tolerance = 2 ;

	// Toutes les cases a 0.
	for (int i = 0 ; i < this.dejaVus.length ; i++) this.dejaVus[i] = 0 ;
    }

    public void collision(Robot autre) {

	/// TD5: invoquer direBonjour
	this.direBonjour(autre) ;

	/* Change de direction. */
	this.vx = -this.vx ;
	this.vy = -this.vy ;

	if (++this.dejaVus[autre.getSerial()] >= this.tolerance) autre.explose() ;
    }

    public String autoDescription() {
	return " digne adherent de la NRA" ;
    }

}