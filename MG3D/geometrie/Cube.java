package MG3D.geometrie;

public class Cube extends Parallelepipede {

	public Cube() {
		super(new Point3D(0, 0, 0), 1, 1, 1);
	}

	public Cube(Point3D origine, double taille) {
		super(origine, taille, taille, taille);
	}
	
	public Cube(Couleur couleur, Point3D origine, double taille) {
		super(couleur, origine, taille, taille, taille);
	}

	
	public Cube(Cube c) {
		super(c);
	}

}
