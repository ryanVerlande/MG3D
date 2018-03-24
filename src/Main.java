
import java.util.ArrayList;

import MG3D.Camera;
import MG3D.Clavier;
import MG3D.Fenetre;
import MG3D.geometrie.Cone;
import MG3D.geometrie.Couleur;
import MG3D.geometrie.Cube;
import MG3D.geometrie.Cylindre;
import MG3D.geometrie.Maillage;
import MG3D.geometrie.Parallelepipede;
import MG3D.geometrie.Point3D;

class Main {

	public static void main(String[] args) {
		Fenetre f = new Fenetre("Mon appli MG3D");
		Clavier clavier = f.getClavier();
		
		Camera cam = f.getCamera();
		f.activerLignes(true);
		cam.setPosition(new Point3D(0, 2, 0));
		
		float vitesse = 0.2f;
		float sensi = 1.5f;
		int isActivated = 1;
		
		Cylindre c = new Cylindre(new Point3D(-10, 0, -15), 1, 2);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(c);
		
		Cylindre c2 = new Cylindre(new Point3D(-10, 1, -10), 1, 2);
		c2.setCouleur(Couleur.ORANGE);
		f.ajouter(c2);
		
		ArrayList<Cube> listCube = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			listCube.add(new Cube(Couleur.BLANC, new Point3D(0, 0, -20), 2));
			listCube.get(i).translater(10+i*5, 0, 0);
			f.ajouter(listCube.get(i));
		}
		
		ArrayList<Parallelepipede> laTour = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			laTour.add(new Parallelepipede(Couleur.VERT, new Point3D(0, 0, 20), 2, 3, 4));
			laTour.get(i).translater(0, i*3, 0);
			f.ajouter(laTour.get(i));
		}
		
		listCube.get(0).setCouleur(Couleur.BLEU);
		listCube.get(1).setCouleur(Couleur.CYAN);
		listCube.get(2).setCouleur(Couleur.ROUGE);
		listCube.get(3).setCouleur(Couleur.JAUNE);
		listCube.get(4).setCouleur(Couleur.VERT);
		
		Cone cone = new Cone(Couleur.CYAN, new Point3D(60, 0, -20), 2, 5);
		f.ajouter(cone);
		
		Maillage m = new Maillage("./fic3D/cow.off");
		m.setCouleur(Couleur.ROUGE);
		m.translater(30, -1, 10);
		f.ajouter(m);
		
		ArrayList<Cube> maison = new ArrayList<>();
		
		for (int i = 0; i<25; i++){
			maison.add(new Cube(new Point3D(i, 0, -40), 2));
			if ( i < 8 ){
				maison.get(i).translater(i+2, 0, 0);
			}
			if ( i >= 8 ){
				maison.get(i).translater(8+i, 0, -40-(i-2));
			}
			maison.get(i).setCouleur(Couleur.VERT);
			f.ajouter(maison.get(i));
		}
		
		
		// boucle de jeu
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception err) {}
			
			/*** Activer les lignes ou non ***/
			
			if ( clavier.getEntreeTape() ){
				if ( isActivated % 2 == 0){
					f.activerLignes(true);
				}else{
					f.activerLignes(false);
				}
				isActivated++;
				System.out.println("Lignes activees = "+isActivated);
			}
			
			/*** Intersection en cours... ***/
			if (clavier.getEspaceTape()) {
				c.translater(0, 0, 2);
				System.out.println("INTERSECTION = "+c.intersectionRapide(c2));
			}
			
			if (c.intersectionRapide(c2)){
				c2.setCouleur(Couleur.VERT);
			}else{
				c2.setCouleur(Couleur.ROUGE);
			}
			
			/*** SNAAAAAP ***/
			if (clavier.getETape()){
				f.snapShot();
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
