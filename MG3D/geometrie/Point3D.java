package MG3D.geometrie;


public class Point3D {
// ATTRIBUTS
	private double x; // abscisse
	private double y; // ordonnee
	private double z; // cote
	
	/**
	 * Constructeur par defaut d'un point.
	 * Les valeurs par defaut des coordonnees sont egales a 0.
	 */
	public Point3D(){
		this.x = 0;
		this.y = 0;
		this.z = 0;
	}
	
	/**
	 * Constructeur prenant en parametre des coordonnees.
	 * @param x l'abscisse
	 * @param y l'ordonnee
	 * @param z la cote
	 */
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	/**
	 * Construit un sommet à partir d'un modèle de sommet.
	 * @param s Le sommet à copier.
	 */
	public Point3D(Point3D p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
	}
	
	/**
	 * Retourne la valeur de l'abscisse
	 * @return x la valeur de l'abscisse
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Retourne la valeur de l'ordonnee
	 * @return y la valeur de l'ordonnee
	 */
	public double getY() {
		return y;
	}
	
	/**
	 * Retourne la valeur de la cote
	 * @return z la valeur de la cote
	 */
	public double getZ() {
		return z;
	}
	
	/**
	 * Permet de modifier la valeur de x
	 * @param x l'abscisse
	 */
	public void setX(double x) {
		this.x = x;
	}
	
	/**
	 * Permet de modifier la valeur de y
	 * @param y l'ordonnee
	 */
	public void setY(double y) {
		this.y = y;
	}
	
	/**
	 * Permet de modifier la valeur de z
	 * @param z la cote
	 */
	public void setZ(double z) {
		this.z = z;
	}

	/**
	 * Methode toString retournant une description du point
	 * La chaine de caractere retournee est sous la forme : (x;y;z)
	 * @return une chaine de caractere decrivant le point
	 */
	public String toString() {
		return "("+getX()+", "+getY()+", "+getZ()+")";
	}
}
