
class Cone extends Objet3D{

    private double rayon, hauteur;
    
	public Cone(){
		super();
		
		// sommet
		add(new Sommet(0.000000, 1.000000, 0.000000));
		add(new Sommet(0.000000, 0.000000, 0.000000));
		add(new Sommet(0.500000, 0.000000, 0.000000));
		add(new Sommet(0.475528, 0.000000, 0.154508));
		add(new Sommet(0.404508, 0.000000, 0.293893));
		add(new Sommet(0.293893, 0.000000, 0.404508));
		add(new Sommet(0.154508, 0.000000, 0.475528));
		add(new Sommet(0.000000, 0.000000, 0.500000));
		add(new Sommet(-0.154508, 0.000000, 0.475528));
		add(new Sommet(-0.293893, 0.000000, 0.404508));
		add(new Sommet(-0.404508, 0.000000, 0.293893));
		add(new Sommet(-0.475528, 0.000000, 0.154508));
		add(new Sommet(-0.500000, 0.000000, 0.000000));
		add(new Sommet(-0.475528, 0.000000, -0.154508));
		add(new Sommet(-0.404508, 0.000000, -0.293893));
		add(new Sommet(-0.293893, 0.000000, -0.404508));
		add(new Sommet(0.000000, 0.000000, -0.500000));
		add(new Sommet(0.154508, 0.000000, -0.475528));
		add(new Sommet(0.293893, 0.000000, -0.404508));
		add(new Sommet(0.404508, 0.000000, -0.293893));
		add(new Sommet(0.475528, 0.000000, -0.154508));
		
		// face
		add(new Face(2, 0, 3));
		add(new Face(3, 1, 2));
		add(new Face(3, 0, 4));
		add(new Face(4, 1, 3));
		add(new Face(4, 0, 5));
		add(new Face(5, 1, 4));
		add(new Face(5, 0, 6));
		add(new Face(6, 1, 5));
		add(new Face(6, 0, 7));
		add(new Face(7, 1, 6));
		add(new Face(7, 0, 8));
		add(new Face(8, 1, 7));
		add(new Face(8, 0, 9));
		add(new Face(9, 1, 8));
		add(new Face(9, 0, 10));
		add(new Face(10, 1, 9));
		add(new Face(10, 0, 11));
		add(new Face(11, 1, 10));
		add(new Face(11, 0, 12));
		add(new Face(12, 1, 11));
		add(new Face(12, 0, 13));
		add(new Face(13, 1, 12));
		add(new Face(13, 0, 14));
		add(new Face(14, 1, 13));
		add(new Face(14, 0, 15));
		add(new Face(15, 1, 14));
		add(new Face(15, 0, 16));
		add(new Face(16, 1, 15));
		add(new Face(16, 0, 17));
		add(new Face(17, 1, 16));
		add(new Face(17, 0, 18));
		add(new Face(18, 1, 17));
		add(new Face(18, 0, 19));
		add(new Face(19, 1, 18));
		add(new Face(19, 0, 20));
		add(new Face(20, 1, 19));
		add(new Face(20, 0, 21));
		add(new Face(21, 1, 20));
		add(new Face(21, 0, 2));
		add(new Face(2, 1, 21));
	
	}
	
	public Cone(double rayon, double hauteur){
		super();
	}
	
	public Cone(Cone c){
		super(c);
	}
}
