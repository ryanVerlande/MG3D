
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

	float vitesse = 0.2f;
	float sensi = 1.0f;
	
	Cylindre c = new Cylindre(new Point3D(0,0,-15), 1, 2);
	c.setCouleur(Couleur.MAGENTA);
	f.ajouter(c);
		

		
		
	ArrayList<Cube> listCube = new ArrayList<>();	
	for (int i = 0; i<5; i++){
	    listCube.add(new Cube(Couleur.BLANC, new Point3D(0,0,-20), 2));
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
	    }
			
	    // pour boucler la rotation de la camera
	    /*if ( cam.getAngleX() >= 360.0f || cam.getAngleX() <= -360.0f){
	      cam.setAngleX(0.0f);
	      }*/
			
	    /*** DEPLACEMENTS ***/
	    // avant
	    if ( clavier.getZEnfoncee() ){
		cam.deplacerVersRegard(vitesse);
	    }
	      
	      // arriere
	      if ( clavier.getSEnfoncee() ){
		  cam.deplacerVersRegard(-vitesse);
	      }
	      
	      // droite
	      if ( clavier.getDEnfoncee() ){
		  cam.decalerDroite(vitesse);
	      }
	      // gauche
	      if ( clavier.getQEnfoncee() ){
		  cam.decalerGauche(vitesse);
	      }
			
	    /*** ORIENTATIONS / DIRECTIONS ***/
	    // orientation droite
	      if ( clavier.getDroiteEnfoncee() ){
		  cam.setAngleGD(cam.getAngleGD()+sensi);
		  System.out.println("Je regarde a droite..."+cam.getAngleGD());
	      }
	      // orientation gauche
	      if ( clavier.getGaucheEnfoncee() ){
	      cam.setAngleGD(cam.getAngleGD()-sensi);
	      System.out.println("Je regarde a gauche..."+cam.getAngleGD());
	      }
	      /*
	      // orientation haut
	      if ( clavier.getHautEnfoncee() ){
	      cam.setAngleY(cam.getAngleY()-sensi);
	      System.out.println("Je regarde en haut..."+cam.getAngleY());
	      }
	      // orientation bas
	      if ( clavier.getBasEnfoncee() ){
	      cam.setAngleY(cam.getAngleY()+sensi);
	      System.out.println("Je regarde en bas..."+cam.getAngleY());
	      }*/
	    f.rafraichir();
	}
		
    }
	
}
