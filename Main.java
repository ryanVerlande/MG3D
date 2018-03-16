import MG3D.*;
import MG3D.geometrie.*;

class Main {
	
	public static void main(String[] args) {
		Clavier clavier;
		Fenetre f = new Fenetre("Mon appli MG3D", 1080, 720);
		Point3D origine = new Point3D();
		Cylindre c = new Cylindre(origine, 1, 2);
		Cube cube = new Cube(Couleur.JAUNE, origine, 1.5);
		cube.translater(2, 0, 0);
		clavier = f.getClavier();
		f.ajouter(c);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(cube);
		
		// boucle de jeu
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception err) {}
			if ( clavier.getEspaceTape() ){
				c.translater(0, 2, 0);
				c.setCouleur(Couleur.CYAN);
			}
			f.rafraichir();
		}
		
	}
	
}
