package MG3D.geometrie;

public class IcoSphere extends Objet3D {

    private Point3D centre;
    private double rayon;

    public IcoSphere() {
	super();
	centre = new Point3D(0,0,0);
	rayon=1;
	
	genereMaillage();
    }

    public IcoSphere(Point3D ccentre, double rrayon) {
	super(Couleur.NOIR);
	centre = new Point3D(ccentre);
	rayon=rrayon;
	genereMaillage();
    }
    
    public IcoSphere(Couleur couleur, Point3D ccentre, double rrayon) {
	super(couleur);
	centre = new Point3D(ccentre);
	rayon=rrayon;
	genereMaillage();
    }

    protected void genereMaillage(){
	// sommet
	add(new Sommet(-0.276385 * rayon + centre.getX(), -0.850640 * rayon + centre.getY(), -0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.000000 * rayon + centre.getX(), 0.000000 * rayon + centre.getY(), -1.000000 * rayon + centre.getZ()));
	add(new Sommet(0.723600 * rayon + centre.getX(), -0.525720 * rayon + centre.getY(), -0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.723600 * rayon + centre.getX(), 0.525720 * rayon + centre.getY(), -0.447215 * rayon + centre.getZ()));
	add(new Sommet(-0.894425 * rayon + centre.getX(), 0.000000 * rayon + centre.getY(), -0.447215 * rayon + centre.getZ()));
	add(new Sommet(-0.276385 * rayon + centre.getX(), 0.850640 * rayon + centre.getY(), -0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.894425 * rayon + centre.getX(), 0.000000 * rayon + centre.getY(), 0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.276385 * rayon + centre.getX(), -0.850640 * rayon + centre.getY(), 0.447215 * rayon + centre.getZ()));
	add(new Sommet(-0.723600 * rayon + centre.getX(), -0.525720 * rayon + centre.getY(), 0.447215 * rayon + centre.getZ()));
	add(new Sommet(-0.723600 * rayon + centre.getX(), 0.525720 * rayon + centre.getY(), 0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.276385 * rayon + centre.getX(), 0.850640 * rayon + centre.getY(), 0.447215 * rayon + centre.getZ()));
	add(new Sommet(0.000000 * rayon + centre.getX(), 0.000000 * rayon + centre.getY(), 1.000000 * rayon + centre.getZ()));

	// face
	add(new Face(0, 1, 2));
	add(new Face(2, 1, 3));
	add(new Face(4, 1, 0));
	add(new Face(5, 1, 4));
	add(new Face(3, 1, 5));
	add(new Face(2, 3, 6));
	add(new Face(0, 2, 7));
	add(new Face(4, 0, 8));
	add(new Face(5, 4, 9));
	add(new Face(3, 5, 10));
	add(new Face(6, 7, 2));
	add(new Face(7, 8, 0));
	add(new Face(8, 9, 4));
	add(new Face(9, 10, 5));
	add(new Face(10, 6, 3));
	add(new Face(7, 6, 11));
	add(new Face(8, 7, 11));
	add(new Face(9, 8, 11));
	add(new Face(10, 9, 11));
	add(new Face(6, 10, 11));

	subdivision_faces();

	for (int i = 0; i < super.getNbSommets(); i++) {
	    Vecteur3D temp = new Vecteur3D(getSommet(i).getX(), getSommet(i).getY(), getSommet(i).getZ());
	    temp.normaliser();
	    getSommet(i).setX(temp.getDx());
	    getSommet(i).setY(temp.getDy());
	    getSommet(i).setZ(temp.getDz());
	}
    }

}
