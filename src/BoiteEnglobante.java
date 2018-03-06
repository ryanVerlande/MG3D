class BoiteEnglobante {
	
	private Point3D min, max;

	public BoiteEnglobante() {
		min = new Point3D(0, 0, 0);
		max = new Point3D(0, 0, 0);
	}

	public BoiteEnglobante(Point3D mmin, Point3D mmax) {
		min = new Point3D(mmin);
		max = new Point3D(mmax);
	}

	public BoiteEnglobante(Maillage m) {
		if (m.getNbSommets() == 0)
			this();
		else {
			min = new Point3D(m.getSommet(0).getX(), m.getSommet(0).getY(), m.getSommet(0).getZ());
			max = new Point3D(m.getSommet(0).getX(), m.getSommet(0).getY(), m.getSommet(0).getZ());
			for (int i = 1; i < m.getNbSommets(); i++) {
				if (m.getSommet(i).getX() < min.getX())
					min.setX(m.getSommet(i).getX());
				if (m.getSommet(i).getX() > max.getX())
					max.setX(m.getSommet(i).getX());

				if (m.getSommet(i).getY() < min.getY())
					min.setY(m.getSommet(i).getY());
				if (m.getSommet(i).getY() > max.getY())
					max.setY(m.getSommet(i).getY());

				if (m.getSommet(i).getZ() < min.getZ())
					min.setZ(m.getSommet(i).getZ());
				if (m.getSommet(i).getZ() > max.getZ())
					max.setZ(m.getSommet(i).getZ());
			}
		}
	}
}
