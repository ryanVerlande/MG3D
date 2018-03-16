package MG3D;

class Capsule extends Objet3D {

	public Capsule() {
		super();
	}

	public Capsule(double hauteur, double rayon, double radius) {
		super(Couleur.NOIR);
	}

	public Capsule(Couleur couleur, double hauteur, double rayon, double radius) {
		super(couleur);
	}

	@Override
	protected void genereMaillage() {
		// TODO Auto-generated method stub

	}

}
