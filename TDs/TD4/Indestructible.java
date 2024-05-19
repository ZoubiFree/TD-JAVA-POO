import java.awt.Color ;

class Indestructible extends Robot {

    public Indestructible (String nomImage, int x, int y, Plateau pt, Color col, String nom) {
	super(nomImage, x, y, pt, col, nom) ;
    }

    public void explose() {
    }

    // Auto-description, variable selon le type de robot
    public String autoDescription() {
	return " totalement indestructible" ;
    }

}