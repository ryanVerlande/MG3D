package MG3D;

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

    public BoiteEnglobante(double minX, double minY, double minZ, double maxX, double maxY, double maxZ){
	min = new Point3D(minX,minY,minZ);
	max = new Point3D(maxX,maxY,maxZ);
    }

    public boolean intersection(BoiteEnglobante be){
	//TODO
	return false;
    }
}
