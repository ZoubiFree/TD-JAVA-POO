import java.awt.Color ;

class Killer extends Robot {

    /// TD2: se souvenir des robots deja vus.
    private int[] dejaVus ;

    private int tolerance ;

    public Killer (String nomImage, int x, int y, Plateau pt, int num, Color col, int NbRobots) {
	super(nomImage, x, y, pt, num, col) ;

	/// Initialiser le tableau, bien noter la syntaxe : new int[taille]
	this.dejaVus = new int[NbRobots] ;
	this.tolerance = 2 ;

	// Toutes les cases a 0.
	for (int i = 0 ; i < this.dejaVus.length ; i++) this.dejaVus[i] = 0 ;
    }

    public void collision(Robot autre) {

	/* Change de direction. */
	this.vx = -this.vx ;
	this.vy = -this.vy ;

	if (++this.dejaVus[autre.getSerial()] >= this.tolerance) autre.explose() ;
    }

}