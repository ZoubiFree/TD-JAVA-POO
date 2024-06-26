/** Boucle principale de la simulation */

import java.awt.* ;

public class Anim {

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

	robots = new Robot[6] ;

	robots[0] = new Robot("Images/mini1.png", 80, 100, plat, Color.blue, "Alfred") ; 
	robots[1] = new Cyborg("Images/mini2.png", 280, 400, plat, 12, Color.yellow, "Beatrice"); 
	robots[2] = new Cyborg("Images/mini2.png", 80, 400, plat, Color.yellow, "Charles") ; 
	robots[3] = new Killer("Images/mini3.png", 280, 60, plat, Color.red, robots.length, "Dominique") ; 
	robots[4] = new Killer("Images/mini3.png", 480, 60, plat, Color.red, robots.length, "Emile") ;
	robots[5] = new Indestructible("Images/mini4.png", 420, 420, plat, Color.white, "Frank") ;

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