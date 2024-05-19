/** Boucle principale de la simulation */

/// TD1 : la couleur
import java.awt.* ;

public class anim {

    /** Effectue une pause de la duree indiquee en millisecondes */
    public static void pause(int duree) {
	try {
	    Thread.currentThread().sleep(duree) ;
	} catch (InterruptedException e) {
	} 
    }

    /** Boucle principale */
    public void go() {
	
	Plateau plat ;
	Robot[] robots ;

	plat = new Plateau(800, 600) ;

	/// TD1 : 4eme robot
	robots = new Robot[4] ;

	/// TD1 : ajout d'une couleur a chaque robot
	robots[0] = new Robot("Images/mini1.png", 80, 100, plat, Color.red) ; 
	robots[1] = new Robot("Images/mini2.png", 480, 250, plat, Color.blue) ; 
	robots[2] = new Robot("Images/mini3.png", 280, 400, plat, Color.magenta) ; 

	//: Initialisation du 4eme robot
	robots[3] = new Robot("Images/mini4.png", 80, 400, plat, Color.yellow) ; 


	// On repete la boucle d'animation sans arret
	while (true) {

	    // On fait evoluer chaque robot
	    for (int i = 0 ; i < robots.length ; i++) {
		robots[i].bouge () ;
	    }

	    // Puis on teste les collisions deux a deux
	    for (int i = 0 ; i < robots.length ; i++) {
		for (int j = i+1 ; j < robots.length ; j++) {
		    robots[i].testeCollision(robots[j]) ;
		}
	    }

	    // Petite pause
	    this.pause(12) ;
	    
	}

    }
    

    public static void main(String[] args) {
	Anim an = new Anim() ;
	Images.init () ;
	an.go () ;
    }

}