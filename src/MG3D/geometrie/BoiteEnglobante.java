package MG3D.geometrie;

public class BoiteEnglobante {

	private Point3D min, max;

	public BoiteEnglobante() {
		min = new Point3D(0, 0, 0);
		max = new Point3D(0, 0, 0);
	}

	public BoiteEnglobante(Point3D mmin, Point3D mmax) {
		min = new Point3D(mmin);
		max = new Point3D(mmax);
	}

	public BoiteEnglobante(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
		min = new Point3D(minX, minY, minZ);
		max = new Point3D(maxX, maxY, maxZ);
	}

	public boolean intersection(BoiteEnglobante be) {
		boolean collision = true;
		
		if (
			 be.getMin().getX() > this.getMax().getX() ||
		     be.getMin().getY() > this.getMax().getY() ||
		     be.getMin().getZ() > this.getMax().getZ() ||
		     be.getMax().getX() < this.getMin().getX() ||
		     be.getMax().getY() < this.getMin().getY() ||
		     be.getMax().getZ() < this.getMin().getZ()
		)
			collision = false;
		
		return collision;
	}

	public Point3D getMin() {
		return min;
	}

	public Point3D getMax() {
		return max;
	}

}
