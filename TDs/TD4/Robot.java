import java.awt.Color ;

public class Robot {

    /* 
     *  Les attributs de chaque Robot. 
     */

    /** Position du robot */
    protected int x, y ;

    /** Vitesse du robot */
    protected int vx, vy ;

    /** Etat du robot */
    private boolean vivant ;

    /** Sprite (==image) representant le robot */
    private Sprite image ;
    
    /** Plateau sur lequel le robot evolue */
    private Plateau plat ;

    /** Ce robot est-il arrete' ? */
    private boolean arrete ;

    private int compteurPoints ;

    private Color coul ;

    // numero de serie
    private int noSerie ;

    private String nom ;

    // Compteur statique du nombre de robots crees
    private static int nbRobots = 0 ;

    // Compteur statique du nombre d'explosions
    public static final int maxExplosions = 3 ;
    private static int nbExplosions = 0 ;

    /// TD4 : Attributs statiques, les logs.
    /// Ne pas oublier d'initialiser.
    private static Logs logExplosions = new Logs() ;
    private static Logs logCollisions = new Logs() ;

    /* 
     *  Constructeur de Robot. 
     */

    /** Cree un nouveau robot avec l'image indiquee, a la position indiquee sur le plateau
     *  La vitesse de depart est aleatoire
     */
    public Robot (String nomImage, int init_x, int init_y, Plateau pt, Color co, String name) {
	this.x = init_x ;
	this.y = init_y ;
	this.vivant = true ;
	this.vx = this.randomV() ;
	this.vy = this.randomV() ;
	this.plat = pt ;
	this.image = pt.addSprite (nomImage, this.x, this.y) ;
	this.arrete = false ;
	this.coul = co ;
	this.noSerie = nbRobots++ ;
	this.nom = name ;
    }

    /*
     *  Methodes
     */

    // Getter statique du nombre de robots crees
    public static int robotsCrees() {
	return nbRobots ;
    }

    // Getter du numero de serie
    public int getSerial() {
	return this.noSerie ;
    }

    /** Renvoie une valeur de vitesse aleatoire */
    public int randomV() { return (int)(Math.random() * 6) - 3 ; }

    /** Recupere la largeur de l'image du robot */
    public int getLarg() { return this.image.getLarg() ; }

    /** Recupere la hauteur de l'image du robot */
    public int getHaut() { return this.image.getHaut() ; }


    /** Effectue un deplacement elementaire du robot */
    public void bouge() {

	if (this.vivant) {

	    this.compteurPoints = (this.compteurPoints + 1) % 12 ;
	    
 	    if (this.compteurPoints == 0) {
 		this.plat.setColor(this.coul) ;
 		this.plat.drawCircle(this.x, this.y, 2) ;
 	    }

	    this.x += this.vx ;
	    this.y += this.vy ;
	    	    
	    // Si le robot rejoint un bord de la fenetre, il rebondit et change de direction
	    int futurX = this.x + this.vx ;
	    int futurY = this.y + this.vy ;
	    
	    // Collision avec le bord gauche
	    if (futurX < 0) {
		this.vx = Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord droit
	    if (futurX + this.getLarg() > this.plat.getLarg()) {
		this.vx = -Math.abs(this.vx) ;
		this.vy = this.randomV() ;
	    }

	    // Collision avec le bord haut 
	    if (futurY < 0) {
		this.vy = Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }

	    // Collision avec le bord bas
	    if (futurY + this.getHaut() > this.plat.getHaut()) {
		this.vy = -Math.abs(this.vy) ;
		this.vx = this.randomV() ;
	    }
	}

	// Redessine le robot au nouvel endroit
	// Force a redessiner, meme si le robot n'a pas bouge.
	this.image.moveTo(this.x, this.y) ;

    }

    
    /** Teste si ce robot est en collision avec le robot 'autre' */
    public void testeCollision(Robot autre) {

	// Pour etre en collision, il faut une intersection sur les X ET sur les Y
	boolean enCollision = ((this.x + this.getLarg() >= autre.x) && (this.x < autre.x + autre.getLarg()) &&
			       (this.y + this.getHaut() >= autre.y) && (this.y < autre.y + autre.getHaut())) ;

	// Si on est en collision avec un robot different de soi-meme, on reagit et l'autre aussi.
	if (this.vivant && autre.vivant && (autre != this) && enCollision) {

	    // Si les deux robots sont deja arretes, on ne fait rien.
	    if (this.arrete && autre.arrete) {}
	    else {
		this.collision(autre) ;
		autre.collision(this) ;

		/// TD4 : recenser les collisions dans le log
		logCollisions.add("BOUM !", this, autre) ;
	    }
	}
    }

    // Redéfinition de toString
    public String toString() {
	return this.nom + ", " + this.autoDescription() + 
	    " (id = " + this.noSerie + 
	    " x = " + this.x + "  vx = " + this.vx +
	    " y = " + this.y + "  vy = " + this.vy + ")" ;
    }

    // Auto-description, variable selon le type de robot
    public String autoDescription() {
	return " Robot commun" ;
    }

    /** Arreter ce robot. */
    public void arreterRobot() {
	this.vx = 0 ;
	this.vy = 0 ;
	this.arrete = true ;
    }

    // Ne plus exploser apres un certain seuil.
    public void explose() {
	if (nbExplosions <= maxExplosions) {
	    this.image.playSequence(Images.explosion, false) ;
	    this.vivant = false ;
	    nbExplosions++ ;
	    
	    /// TD4 : recenser les explosions dans le log
	    logExplosions.add ("Explosion numero " + nbExplosions, this, null) ;

	    /// Afficher tous les logs.
	    System.out.println("Les logs : \n" + logExplosions + logCollisions) ;
	}
    }

    /** Reaction a une collision : on s'arrete */
    public void collision(Robot autre) {
	this.arreterRobot() ;
    }
}