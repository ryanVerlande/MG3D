package MG3D.geometrie;

public class Vecteur3D {

	private double dx, dy, dz;

	public Vecteur3D() {
		dx = 1.0;
		dy = 0.0;
		dz = 0.0;
	}

	public Vecteur3D(double ddx, double ddy, double ddz) {
		dx = ddx;
		dy = ddy;
		dz = ddz;
	}

	public double taille() {
		return Math.sqrt(dx * dx + dy * dy + dz * dz);
	}

	public void normaliser() {
		double taille = taille();
		if (taille == 0.0)
			throw new java.lang.RuntimeException("Impossible de normaliser le vecteur nul");

		dx /= taille;
		dy /= taille;
		dz /= taille;
	}

	public double getDx() {
		return dx;
	}

	public double getDy() {
		return dy;
	}

	public double getDz() {
		return dz;
	}

}
