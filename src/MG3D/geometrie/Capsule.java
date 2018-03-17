package MG3D.geometrie;

public class Capsule extends Objet3D {

	public Capsule() {
		super();
	}

	public Capsule(double hauteur, double rayon, double radius) {
		super(Couleur.NOIR);
	}

	public Capsule(Couleur couleur, double hauteur, double rayon, double radius) {
		super(couleur);
	}

	public Capsule(Capsule c) {
		// TODO
	}

	@Override
	protected void genereMaillage() {
		// TODO Auto-generated method stub

	}

}
