
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
		cam.setPosition(new Point3D(0, 5, 0));
		
		float vitesse = 0.2f;
		float sensi = 1.0f;
		int isActivated = 1;
		
		Cylindre c = new Cylindre(new Point3D(-10, 0, -15), 1, 2);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(c);
		
		Cylindre c2 = new Cylindre(new Point3D(-10, 1, -10), 1, 2);
		c2.setCouleur(Couleur.ORANGE);
		f.ajouter(c2);
		
		ArrayList<Cube> listCube = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			listCube.add(new Cube(Couleur.BLANC, new Point3D(0.5, 0, -15), 2));
			listCube.get(i).translater(10+i*7, 0, 0);
			f.ajouter(listCube.get(i));
		}
		
		ArrayList<Parallelepipede> laTour = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			laTour.add(new Parallelepipede(Couleur.BLEU, new Point3D(0, 0, 20), 2, 3, 4));
			laTour.get(i).translater(0, i*3, 0);
			f.ajouter(laTour.get(i));
		}
		
		listCube.get(0).setCouleur(Couleur.ROUGE);
		listCube.get(1).setCouleur(Couleur.BLEU);
		listCube.get(2).setCouleur(Couleur.VERT);
		listCube.get(3).setCouleur(Couleur.GRIS);
//		listCube.get(4).setCouleur(Couleur.BLEU);
		
		Cone cone = new Cone(Couleur.CYAN, new Point3D(60, 0, -20), 2, 5);
		f.ajouter(cone);
		
		Maillage m = new Maillage("./fic3D/deathStar.off");
		m.setCouleur(Couleur.JAUNE);
		m.translater(5, 0, 0);
		f.ajouter(m);
		
		Maillage MG3D = new Maillage("./fic3D/3.off");
		MG3D.setCouleur(Couleur.VERT);
		MG3D.translater(60, 5, -205);
		f.ajouter(MG3D);
		
		int loin = -40;
		
		/***************************** M *****************************/
		
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(2, 0, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(2, 2, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(2, 4, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(2, 6, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(2, 8, loin), 2));
		
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(4, 6, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(6, 4, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(8, 6, loin), 2));
		
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(10, 0, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(10, 2, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(10, 4, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(10, 6, loin), 2));
		f.ajouter(new Cube(Couleur.ROUGE, new Point3D(10, 8, loin), 2));
		
		
		/***************************** G *****************************/
		
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(14, 0, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(14, 2, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(14, 4, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(14, 6, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(14, 8, loin), 2));
		
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(16, 8, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(18, 8, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(20, 8, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(22, 8, loin), 2));
		
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(16, 0, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(18, 0, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(20, 0, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(22, 0, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(22, 2, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(22, 4, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(20, 4, loin), 2));
		f.ajouter(new Cube(Couleur.BLEU, new Point3D(18, 4, loin), 2));
		
		
		/***************************** 3 *****************************/
		
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(28, 0, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(28, 2, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(28, 4, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(28, 6, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(28, 8, loin), 2));
//		
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(26, 8, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(24, 8, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(22, 8, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(20, 8, loin), 2));
//		
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(26, 0, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(24, 0, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(22, 0, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(20, 0, loin), 2));
//		
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(26, 4, loin), 2));
//		f.ajouter(new Cube(Couleur.VERT, new Point3D(24, 4, loin), 2));
		
		/***************************** D *****************************/
		
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(36, 0, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(36, 2, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(36, 4, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(36, 6, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(36, 8, loin), 2));
		
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(38, 0, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(40, 0, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(42, 0, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(38, 8, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(40, 8, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(42, 8, loin), 2));
		
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(44, 2, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(44, 4, loin), 2));
		f.ajouter(new Cube(Couleur.GRIS, new Point3D(44, 6, loin), 2));
		
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
