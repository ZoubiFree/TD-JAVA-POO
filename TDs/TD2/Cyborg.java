import java.awt.Color ;

class Cyborg extends Robot {

    /// TD2 : compter les collisions.
    private int nombreCollisions ;
    private int maxCollisions ;

    public Cyborg (String nomImage, int x, int y, Plateau pt, int num, Color col) {
	/// Important : appel a super()
	super(nomImage, x, y, pt, num, col) ;

	this.maxCollisions = 6 ;
	this.nombreCollisions = 0 ;
    }

    /// Surcharge du constructeur
    public Cyborg (String nomImage, int x, int y, Plateau pt, int maxColl, int num, Color col) {
	super(nomImage, x, y, pt, num, col) ;

	this.maxCollisions = maxColl ;
	this.nombreCollisions = 0 ;
    }

    public void collision(Robot autre) {

	/* Change de direction. */
	this.vx = -this.vx ;
	this.vy = -this.vy ;
	
	if (++this.nombreCollisions >= this.maxCollisions) this.explose() ;
    }

}