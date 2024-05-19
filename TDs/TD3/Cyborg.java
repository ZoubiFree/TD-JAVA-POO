import java.awt.Color ;

class Cyborg extends Robot {

    // Compter les collisions.
    private int nombreCollisions ;
    private int maxCollisions ;

    public Cyborg (String nomImage, int x, int y, Plateau pt, Color col, String nom) {
	/// Important : appel a super() compatible avec le constructeur Robot()
	super(nomImage, x, y, pt, col, nom) ;

	this.maxCollisions = 6 ;
	this.nombreCollisions = 0 ;
    }

    // Surcharge du constructeur
    public Cyborg (String nomImage, int x, int y, Plateau pt, int maxColl, Color col, String nom) {
	super(nomImage, x, y, pt, col, nom) ;

	this.maxCollisions = maxColl ;
	this.nombreCollisions = 0 ;
    }

    public void collision(Robot autre) {

	/* Change de direction. */
	this.vx = -this.vx ;
	this.vy = -this.vy ;
	
	if (++this.nombreCollisions >= this.maxCollisions) this.explose() ;
    }

    /// Auto-description, variable selon le type de robot
    public String autoDescription() {
	return " Cyborg degenere'" ;
    }
}