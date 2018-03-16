package MG3D.geometrie;


public class Face {
	
	// Attributs
	private int s1; // indice 0
	private int s2; // indice 1
	private int s3; // indice 2
	
	/**
	 * Constructeur par defaut d'une face.
	 * Cette face possede 3 sommets d'indice 0,1 et 2.
	 */
	public Face(){
		this.s1 = 0;
		this.s2 = 1;
		this.s3 = 2;
	}
	
	/**
	 * Constructeur prenant en parametre 3 entiers (indice de sommets) pour en faire une face
	 * @param s1 l'indice s1
	 * @param s2 l'indice s2
	 * @param s3 l'indice s3
	 */
	public Face(int s1, int s2, int s3){
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}
	
	/**
	 * Constructeur par copie.
	 * Construit une face à partir d'un modèle de face.
	 * @param f La face à copier.
	 */
	public Face(Face f){
		f.s1 = this.s1;
		f.s2 = this.s2;
		f.s3 = this.s3;
	}
	
	/**
	 * Retourne l'indice de sommet s1
	 * @return l'indice de sommet s1
	 */
	public int getS1() {
		return s1;
	}
	
	/**
	 * Retourne l'indice de sommet s2
	 * @return l'indice de sommet s2
	 */
	public int getS2() {
		return s2;
	}
	
	/**
	 * Retourne l'indice de sommet s3
	 * @return l'indice de sommet s3
	 */
	public int getS3() {
		return s3;
	}
	
	/**
	 * Permet de modifier la valeur de l'indice du sommet s1
	 * @param s1 l'indice de sommet s1
	 */
	public void setS1(int s1) {
		this.s1 = s1;
	}
	
	/**
	 * Permet de modifier la valeur de l'indice du sommet s2
	 * @param s2 l'indice de sommet s2
	 */
	public void setS2(int s2) {
		this.s2 = s2;
	}
	
	/**
	 * Permet de modifier la valeur de l'indice du sommet s3
	 * @param s3 l'indice de sommet s3
	 */
	public void setS3(int s3) {
		this.s3 = s3;
	}
	
	/**
	 * Retourne une description de la face.
	 * La chaine de caractere est donnee sous la forme : (s1,s2,s3).
	 * @return une chaine de caractere decrivant la face.
	 */
	public String toString() {
		return "("+getS1()+", "+getS2()+", "+getS3()+")";
	}
	
	
}
