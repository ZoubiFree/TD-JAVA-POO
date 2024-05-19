import java.awt.Color ;

/// TD2: les indestructibles n'explosent pas.
class Indestructible extends Robot {

    public Indestructible (String nomImage, int x, int y, Plateau pt, int num, Color col) {
	super(nomImage, x, y, pt, num, col) ;
    }

    /// Redefinition de la methode explose.
    public void explose() {
    }
}