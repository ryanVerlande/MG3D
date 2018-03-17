
import java.util.ArrayList;
import MG3D.Camera;
import MG3D.Clavier;
import MG3D.Fenetre;
import MG3D.geometrie.Cone;
import MG3D.geometrie.Couleur;
import MG3D.geometrie.Cube;
import MG3D.geometrie.Cylindre;
import MG3D.geometrie.IcoSphere;
import MG3D.geometrie.Point3D;

class Main {

	public static void main(String[] args) {
		Fenetre f = new Fenetre("Mon appli MG3D", 1080, 720);
		Clavier clavier = f.getClavier();
		Camera cam = f.getCamera();
		
		cam.setPosition(new Point3D(0, 1, 0));
		
		float vitesse = 0.2f;
		float sensi = 1.5f;

		Cylindre c = new Cylindre(new Point3D(0, 0, -15), 1, 2);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(c);

		ArrayList<Cube> listCube = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			listCube.add(new Cube(Couleur.BLANC, new Point3D(0, 0, -20), 2));
			listCube.get(i).translater(i * 5, 0, -10);
			f.ajouter(listCube.get(i));
		}

		listCube.get(0).setCouleur(Couleur.BLEU);
		listCube.get(1).setCouleur(Couleur.CYAN);
		listCube.get(2).setCouleur(Couleur.ROUGE);
		listCube.get(3).setCouleur(Couleur.JAUNE);
		listCube.get(4).setCouleur(Couleur.VERT);
		
		Cone cone = new Cone(Couleur.CYAN, new Point3D(60, 0, -20), 2, 5);
		f.ajouter(cone);
		
		// boucle de jeu
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception err) {}

			if (clavier.getEspaceTape()) {
				c.translater(0, 2, 2);
				c.setCouleur(Couleur.CYAN);
			}

			/*** DEPLACEMENTS ***/
			// avant
			if (clavier.getZEnfoncee()) {
				cam.deplacerVersRegard(vitesse);
				System.out.println("j'avance..."+cam.getPosition());
			}

			// arriere
			if (clavier.getSEnfoncee()) {
				cam.deplacerVersRegard(-vitesse);
				System.out.println("je recule..."+cam.getPosition());
			}

			// droite
			if (clavier.getDEnfoncee()) {
				cam.decalerDroite(vitesse);
				System.out.println("je vais a droite..."+cam.getPosition());
			}
			// gauche
			if (clavier.getQEnfoncee()) {
				cam.decalerGauche(vitesse);
				System.out.println("je vais a gauche..."+cam.getPosition());
			}
			
			/*** ORIENTATIONS / DIRECTIONS ***/
			// orientation droite
			if (clavier.getDroiteEnfoncee()) {
				cam.setAngleGD(cam.getAngleGD() + sensi);
				System.out.println("Je regarde a droite..." + cam.getAngleGD());
			}
			// orientation gauche
			if (clavier.getGaucheEnfoncee()) {
				cam.setAngleGD(cam.getAngleGD() - sensi);
				System.out.println("Je regarde a gauche..." + cam.getAngleGD());
			}

			// orientation haut
			if (clavier.getHautEnfoncee()) {
				cam.setAngleHB(cam.getAngleHB() - sensi);
				System.out.println("Je regarde en haut..." + cam.getAngleHB());
			}
			// orientation bas
			if (clavier.getBasEnfoncee()) {
				cam.setAngleHB(cam.getAngleHB() + sensi);
				System.out.println("Je regarde en bas..." + cam.getAngleHB());
			}

			f.rafraichir();
		}

	}

}
