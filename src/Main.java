
class Main {
	
	public static void main(String[] args) {
		
		// Ouverture d'un fichier .off
		Maillage m = new Maillage("./fic3D/cow.off");
		m.affichageParListe();
		m.affichageSoupePolygone();
		System.out.println(/* RIEN ICI ^^ */);
		m.afficheBB();
	}
	
}
