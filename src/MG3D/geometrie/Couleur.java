package MG3D.geometrie;


public class Couleur{

    int rouge, vert, bleu;
    
    /**
     * Constantes à utiliser pour le noir.
     */
    public static final Couleur NOIR = new Couleur (0,0,0);
    /**
     * Constantes à utiliser pour le blanc.
     */
    public static final Couleur BLANC = new Couleur(255,255,255);
    /**
     * Constantes à utiliser pour le rouge.
     */
    public static final Couleur ROUGE = new Couleur(255,0,0);
    /**
     * Constantes à utiliser pour le vert.
     */
    public static final Couleur VERT = new Couleur(0,255,0);
    /**
     * Constantes à utiliser pour le bleu.
     */
    public static final Couleur BLEU = new Couleur(0,0,255);
    /**
     * Constantes à utiliser pour le cyan.
     */
    public static final Couleur CYAN = new Couleur(0,255,255);
    /**
     * Constantes à utiliser pour le gris.
     */
    public static final Couleur GRIS = new Couleur(127,127,127);
    /**
     * Constantes à utiliser pour le gris foncé.
     */
    public static final Couleur GRIS_FONCE = new Couleur(96,96,96);
    /**
     * Constantes à utiliser pour le gris clair.
     */
    public static final Couleur GRIS_CLAIR = new Couleur(158,158,158);
    /**
     * Constantes à utiliser pour le magenta.
     */
    public static final Couleur MAGENTA = new Couleur(255,0,255);
    /**
     * Constantes à utiliser pour le orange.
     */
    public static final Couleur ORANGE = new Couleur(255,127,0);
    /**
     * Constantes à utiliser pour le rose.
     */
    public static final Couleur ROSE = new Couleur(249,66,158);
    /**
     * Constantes à utiliser pour le jaune.
     */
    public static final Couleur JAUNE = new Couleur(255,255,0);

    /**
     * Création de la couleur noire.
     */
    public Couleur(){
	rouge=0;
	vert=0;
	bleu=0;
    }
    
    /**
     * Création d'une couleur personnalisée.<br />
     * Vous pouvez donner les valeurs de rouge, vert et bleu que vous souhaitez. Attention, les valeurs sont comprises entre 0 et 255.
     * @param r Valeur de rouge.
     * @param v Valeur de vert.
     * @param b Valeur de bleu.
     */
    public Couleur(int r, int v, int b){
	rouge=r;
	vert=v;
	bleu=b;
    }

    public Couleur(Couleur c){
	rouge=c.rouge;
	vert=c.vert;
	bleu=c.bleu;
    }


    /**
     * Test de la couleur afin de savoir si elle est blanche.
     * @return Vrai si (r,v,b)=(255,255,255), faux sinon.
     */
    public boolean estBlanc(){
	return (equals(Couleur.BLANC));
    }

    /**
     * Test de la couleur afin de savoir si elle est noire.
     * @return Vrai si (r,v,b)=(0,0,0), faux sinon.
     */
    public boolean estNoir(){
	return (equals(Couleur.NOIR));
    }

    /**
     * Méthode toString retournant un description de la couleur.<br />
     * La chaine de caractères retournée est de la forme "(r,v,b) = (x,x,x)".
     * @return Une chaîne de caractères décrivant la couleur.
     */
    public String toString(){
	return new String("(r,v,b)=("+getRed()+","+getGreen()+","+getBlue()+")");
    }

    public float getRed(){
	return (float)(rouge/255.0);
    }

    public float getGreen(){
	return (float)(vert/255.0);
    }

    public float getBlue(){
	return (float)(bleu/255.0);
    }

    /**
     * Méthode equals permettant de tester l'égalité entre une couleur et un objet passé en paramètre.
     * @return Vrai si l'objet passé en paramètre est une couleur dont les caractéristiques sont les mêmes que la couleur sur lequel la méthode est appelée.
     */
    public boolean equals(Object obj){
	if (obj==this) { 
            return true; 
        } 
  
        // Vérification du type du paramètre 
        if (obj instanceof Couleur) { 
            // Vérification des valeurs des attributs 
             Couleur other = (Couleur) obj; 
	     return getRed()==other.getRed() && getGreen()==other.getGreen() && getBlue()==other.getBlue();
	}
	return false;
    }
    
}
