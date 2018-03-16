package MG3D;
class Main {
	
	public static void main(String[] args) {
		Fenetre f = new Fenetre("Mon appli MG3D", 1080, 720);
		Clavier clavier = f.getClavier(); 
		Camera cam = f.getCamera();
		Point3D origine = new Point3D();
		Cylindre c = new Cylindre(origine, 1, 2);
		Cube cube = new Cube(Couleur.JAUNE, origine, 1.5);
		float vitesse = 0.2f;
		float vitGD = cam.getDeplacementGD();
		float vitHB = cam.getDeplacementHB();
		
		cube.translater(2, 0, 0);
		c.setCouleur(Couleur.MAGENTA);
		f.ajouter(c);
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
			// avant
			if ( clavier.getZEnfoncee() ){
				vitHB+=vitesse;
				cam.setDeplacementHB(vitHB);
				System.out.println("J'avance..."+cam.getDeplacementHB());
			}
			// arriere
			if ( clavier.getSEnfoncee() ){
				vitHB-=vitesse;
				cam.setDeplacementHB(vitHB);
				System.out.println("Je recule..."+cam.getDeplacementHB());
			}
			// droite
			if ( clavier.getDEnfoncee() ){
				vitGD-=vitesse;
				cam.setDeplacementGD(vitGD);
				System.out.println("Droite..."+cam.getDeplacementGD());
			}
			// gauche
			if ( clavier.getQEnfoncee() ){
				vitGD+=vitesse;
				cam.setDeplacementGD(vitGD);
				System.out.println("Gauche..."+cam.getDeplacementGD());
			}
			f.rafraichir();
		}
		
	}
	
}
