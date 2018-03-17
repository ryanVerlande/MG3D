
import java.util.ArrayList;

import MG3D.Camera;
import MG3D.Clavier;
import MG3D.Fenetre;
import MG3D.geometrie.Couleur;
import MG3D.geometrie.Cube;
import MG3D.geometrie.Cylindre;
import MG3D.geometrie.Maillage;
import MG3D.geometrie.Point3D;

class Main {
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre("Mon appli MG3D", 1080, 720);
		Clavier clavier = f.getClavier(); 
		Camera cam = f.getCamera();
		Point3D origine = new Point3D();
		Cylindre c = new Cylindre(origine, 1, 2);
//		Maillage m = new Maillage("./fic3D/heptoroid.off");
		
		ArrayList<Cube> listCube = new ArrayList<>();
		
		// A gauche et en haut, on diminue les valeurs
		// A droite et en bas, on augmente les valeurs
		float vitesse = 0.2f;
		float sensi = 1.5f;
		
		c.translater(-3, 0, 10);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(c);
		
//		m.setCouleur(Couleur.ORANGE);
//		f.ajouter(m);
		
		
		for (int i = 0; i<5; i++){
			listCube.add(new Cube(Couleur.BLANC, origine, 2));
			listCube.get(i).translater(i*5, 0, -10);
			f.ajouter(listCube.get(i));
		}
		
		listCube.get(0).setCouleur(Couleur.BLEU);
		listCube.get(1).setCouleur(Couleur.CYAN);
		listCube.get(2).setCouleur(Couleur.ROUGE);
		listCube.get(3).setCouleur(Couleur.JAUNE);
		listCube.get(4).setCouleur(Couleur.VERT);
		
		
		// boucle de jeu
		while (true) {
			try {
				Thread.sleep(10);
			} catch (Exception err) {}
			
			if ( clavier.getEspaceTape() ){
				c.translater(0, 2, 0);
				c.setCouleur(Couleur.CYAN);
				for (int i = 0; i<10; i++){
					listCube.get(i).setCouleur(Couleur.CYAN);
				}
			}
			
			// pour boucler la rotation de la camera
//			if ( orientGD >= 360.0f || orientGD <= -360.0f){
//				orientGD = 0.0f;
//			}
			
			/*** DEPLACEMENTS ***/
			// avant
			if ( clavier.getZEnfoncee() ){
				cam.getPosition().setX(cam.getPosition().getX()+vitesse);
				System.out.println("J'avance..."+cam.getPosition().getX());
			}
			// arriere
			if ( clavier.getSEnfoncee() ){
				cam.getPosition().setX(cam.getPosition().getX()-vitesse);
				System.out.println("Je recule..."+cam.getPosition().getX());
			}
			// droite
			if ( clavier.getDEnfoncee() ){
				cam.getPosition().setY(cam.getPosition().getY()+vitesse);
				System.out.println("Je vais a droite..."+cam.getPosition().getY());
			}
			// gauche
			if ( clavier.getQEnfoncee() ){
				cam.getPosition().setY(cam.getPosition().getY()-vitesse);
				System.out.println("Je vais a gauche..."+cam.getPosition().getY());
			}
			
			/*** ORIENTATIONS / DIRECTIONS ***/
//			// orientation droite
//			if ( clavier.getDroiteEnfoncee() ){
//				orientGD+=sensi;
//				cam.setDirectionGD(orientGD);
//				System.out.println("Orientation Droite..."+cam.getDirectionGD());
//			}
//			// orientation gauche
//			if ( clavier.getGaucheEnfoncee() ){
//				orientGD-=sensi;
//				cam.setDirectionGD(orientGD);
//				System.out.println("Orientation Gauche..."+cam.getDirectionGD());
//			}
//			// orientation haut
//			if ( clavier.getHautEnfoncee() ){
//				orientHB-=sensi;
//				cam.setDirectionHB(orientHB);
//				System.out.println("Orientation Haut..."+cam.getDirectionHB());
//			}
//			// orientation bas
//			if ( clavier.getBasEnfoncee() ){
//				orientHB+=sensi;
//				cam.setDirectionHB(orientHB);
//				System.out.println("Orientation Bas..."+cam.getDirectionHB());
//			}
			f.rafraichir();
		}
		
	}
	
}
