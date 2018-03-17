package MG3D.geometrie;

public class Cylindre extends Objet3D{

    private Point3D centreBas;
    private double rayon, hauteur;

    public Cylindre(){
	super();
	centreBas = new Point3D(0,0,0);
	rayon=1.0;
	hauteur=1.0;
	genereMaillage();
    }

    public Cylindre(Point3D ccentreBas, double rrayon, double hhauteur){
	super(Couleur.NOIR);
	System.out.println("ccentreBas ("+ccentreBas.getX()+" "+ccentreBas.getY()+" "+ccentreBas.getZ()+")" );
	centreBas = new Point3D(ccentreBas);
	System.out.println("centreBas ("+centreBas.getX()+" "+centreBas.getY()+" "+centreBas.getZ()+")" );
	rayon=rrayon;
	hauteur=hhauteur;
	genereMaillage();
    }

    public Cylindre(Couleur couleur, Point3D ccentreBas, double rrayon, double hhauteur) {
	super(couleur);
	centreBas = new Point3D(ccentreBas);
	rayon = rrayon;
	hauteur = hhauteur;
	genereMaillage();
    }

    public Cylindre(Cylindre c){
	super(c.getCouleur());
	centreBas = new Point3D(c.centreBas);
	rayon=c.rayon;
	hauteur=c.hauteur;
	genereMaillage();
    }

    protected void genereMaillage(){
	// sommets face du bas
	add(new Sommet(0.000000+centreBas.getX(), 0.00000+centreBas.getY(), 0.000000+centreBas.getZ()));
	
	add(new Sommet(1.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.000000*rayon+centreBas.getZ()));
	add(new Sommet(0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.309016*rayon+centreBas.getZ()));
	add(new Sommet(0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.587786*rayon+centreBas.getZ()));
	add(new Sommet(0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.809016*rayon+centreBas.getZ()));
	add(new Sommet(0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.951056*rayon+centreBas.getZ()));
	
	add(new Sommet(0.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 1.000000*rayon+centreBas.getZ()));
	add(new Sommet(-0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.951056*rayon+centreBas.getZ()));
	add(new Sommet(-0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.809016*rayon+centreBas.getZ()));
	add(new Sommet(-0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.587786*rayon+centreBas.getZ()));
	add(new Sommet(-0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.309016*rayon+centreBas.getZ()));
	
	add(new Sommet(-1.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY(), 0.000000*rayon+centreBas.getZ()));
	add(new Sommet(-0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.309016*rayon+centreBas.getZ()));
	add(new Sommet(-0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.587786*rayon+centreBas.getZ()));
	add(new Sommet(-0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.809016*rayon+centreBas.getZ()));
	add(new Sommet(-0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.951056*rayon+centreBas.getZ()));
	
	add(new Sommet(0.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -1.000000*rayon+centreBas.getZ()));
	add(new Sommet(0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.951056*rayon+centreBas.getZ()));
	add(new Sommet(0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.809016*rayon+centreBas.getZ()));
	add(new Sommet(0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.587786*rayon+centreBas.getZ()));
	add(new Sommet(0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY(), -0.309016*rayon+centreBas.getZ()));

		
	// face du bas
	add(new Face(2, 0, 1));
	add(new Face(3, 0, 2));
	add(new Face(4, 0, 3));
	add(new Face(5, 0, 4));
	add(new Face(6, 0, 5));
	add(new Face(7, 0, 6));
	add(new Face(8, 0, 7));
	add(new Face(9, 0, 8));
	add(new Face(10, 0, 9));
	add(new Face(11, 0, 10));
	add(new Face(12, 0, 11));
	add(new Face(13, 0, 12));
	add(new Face(14, 0, 13));
	add(new Face(15, 0, 14));
	add(new Face(16, 0, 15));
	add(new Face(17, 0, 16));
	add(new Face(18, 0, 17));
	add(new Face(19, 0, 18));
	add(new Face(20, 0, 19));
	add(new Face(1, 0, 20));

	
	// sommets face du haut
	add(new Sommet(0.000000+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.000000+centreBas.getZ()));
	
	add(new Sommet(1.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.000000*rayon+centreBas.getZ()));
	add(new Sommet(0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.309016*rayon+centreBas.getZ()));
	add(new Sommet(0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.587786*rayon+centreBas.getZ()));
	add(new Sommet(0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.809016*rayon+centreBas.getZ()));
	add(new Sommet(0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.951056*rayon+centreBas.getZ()));
	
	add(new Sommet(0.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 1.000000*rayon+centreBas.getZ()));
	add(new Sommet(-0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.951056*rayon+centreBas.getZ()));
	add(new Sommet(-0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.809016*rayon+centreBas.getZ()));
	add(new Sommet(-0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.587786*rayon+centreBas.getZ()));
	add(new Sommet(-0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.309016*rayon+centreBas.getZ()));
	
	add(new Sommet(-1.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, 0.000000*rayon+centreBas.getZ()));
	add(new Sommet(-0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.309016*rayon+centreBas.getZ()));
	add(new Sommet(-0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.587786*rayon+centreBas.getZ()));
	add(new Sommet(-0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.809016*rayon+centreBas.getZ()));
	add(new Sommet(-0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.951056*rayon+centreBas.getZ()));
	
	add(new Sommet(0.000000*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -1.000000*rayon+centreBas.getZ()));
	add(new Sommet(0.309016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.951056*rayon+centreBas.getZ()));
	add(new Sommet(0.587786*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.809016*rayon+centreBas.getZ()));
	add(new Sommet(0.809016*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.587786*rayon+centreBas.getZ()));
	add(new Sommet(0.951056*rayon+centreBas.getX(), 0.00000+centreBas.getY() + hauteur, -0.309016*rayon+centreBas.getZ()));
		
	// face du haut
	add(new Face(23, 22, 21));
	add(new Face(24, 23, 21));
	add(new Face(25, 24, 21));
	add(new Face(26, 25, 21));
	add(new Face(27, 26, 21));
	add(new Face(28, 27, 21));
	add(new Face(29, 28, 21));
	add(new Face(30, 29, 21));
	add(new Face(31, 30, 21));
	add(new Face(32, 31, 21));
	add(new Face(33, 32, 21));
	add(new Face(34, 33, 21));
	add(new Face(35, 34, 21));
	add(new Face(36, 35, 21));
	add(new Face(37, 36, 21));
	add(new Face(38, 37, 21));
	add(new Face(39, 38, 21));
	add(new Face(40, 39, 21));
	add(new Face(41, 40, 21));
	add(new Face(22, 41, 21));

	//face du cote
	for(int i=1;i<=19;i++){
	    add(new Face(i,i+21,i+1));
	    add(new Face(i+1,i+21,i+22));
	}
	add(new Face(20,41,1));
	add(new Face(1,41,22));
	    
	
    }

    // Test de la classe Cylindre
    /*public static void main(String[] args){
      Cylindre c = new Cylindre();
      c.sauverPGN("test.pgn");
      }*/
}
