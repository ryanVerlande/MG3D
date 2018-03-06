class Parallelepipede extends Maillage {

	/**
	 * Création d'un parallélépipède par défaut.<br />
	 * Son coin inférieur se trouvera en (0,0,0) et sera de taille 3 suivant X,
	 * 1 suivant Y (la hauteur) et 2 suivant Z (la profondeur).
	 */
	public Parallelepipede() {
		super();

		add(new Sommet(0, 0, 0));
		add(new Sommet(3, 0, 0));
		add(new Sommet(0, 1, 0));
		add(new Sommet(3, 1, 0));
		add(new Sommet(0, 0, 2));
		add(new Sommet(3, 0, 2));
		add(new Sommet(0, 1, 2));
		add(new Sommet(3, 1, 2));

		add(new Face(3, 1, 0));
		add(new Face(2, 3, 0));
		add(new Face(3, 7, 1));
		add(new Face(5, 1, 7));
		add(new Face(6, 5, 7));
		add(new Face(5, 6, 4));
		add(new Face(4, 6, 2));
		add(new Face(4, 2, 0));
		add(new Face(6, 7, 3));
		add(new Face(3, 2, 6));
		add(new Face(1, 5, 0));
		add(new Face(4, 0, 5));
	}

	public Parallelepipede(Point3D origine, double tailleX, double tailleY, double tailleZ) {
		super();

		// TODO - vérifier que tailleX, tailleY et tailleZ > 0
		if (tailleX > 0 && tailleY > 0 && tailleZ > 0) {
			add(new Sommet(0, 0, 0));
			add(new Sommet(tailleX, 0, 0));
			add(new Sommet(0, tailleY, 0));
			add(new Sommet(tailleX, tailleY, 0));
			add(new Sommet(0, 0, tailleZ));
			add(new Sommet(tailleX, 0, tailleZ));
			add(new Sommet(0, tailleY, tailleZ));
			add(new Sommet(tailleX, tailleY, tailleZ));

			add(new Face(3, 1, 0));
			add(new Face(2, 3, 0));
			add(new Face(3, 7, 1));
			add(new Face(5, 1, 7));
			add(new Face(6, 5, 7));
			add(new Face(5, 6, 4));
			add(new Face(4, 6, 2));
			add(new Face(4, 2, 0));
			add(new Face(6, 7, 3));
			add(new Face(3, 2, 6));
			add(new Face(1, 5, 0));
			add(new Face(4, 0, 5));

			translater(origine.getX(), origine.getY(), origine.getZ());
		} else {
			System.out.println("ERREUR : Les valeurs doivent être positives !");
		}
	}

	public Parallelepipede(Parallelepipede p) {
		// TODO 
	}
}
