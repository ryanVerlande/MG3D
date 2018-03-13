import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class Maillage extends Objet3D{
	
    //Attributs
    String fichier;
	
    /**
     * Constructeur par défaut d'un maillage.
     */
    public Maillage(){
	super();
	fichier=new String();
    }
	
    /**
     * Constructeur prenant en parametre un chemin vers un fichier .off
     * Le fichier est lu, puis ajoute le contenu de ce fichier dans la liste des sommets
     * Mais aussi dans la liste des faces
     * @param str chaine de caractere etant le chemin vers le fichier
     * @throws IOException
     */
    public Maillage(String str) {
	super();
	fichier=new String(str);
	genereMaillage();
    }

    protected void genereMaillage(){
	
	Scanner sc = null;
	
	// Lecture du fichier
	try{
	    sc = new Scanner(new File(fichier));
	}catch(IOException e){
	    System.out.println("Fichier non trouve dans le repertoire suivant le chemin : "+str+"!");
	}
	
	sc.next(); // on passe le OFF du fichier
	
	// Recuperation du nombre de sommets, de faces et d'aretes
	int nbSommets = Integer.valueOf(sc.next());
	int nbFaces = Integer.valueOf(sc.next());
	int nbAretes = Integer.valueOf(sc.next()); // ne sert a rien
		
	for (int i = 0; i < nbSommets; i++){ // boucle de sommets
	    double reel1 = Double.valueOf(sc.next());
	    double reel2 = Double.valueOf(sc.next());
	    double reel3 = Double.valueOf(sc.next());
			
	    sListe.add(new Sommet(reel1, reel2, reel3)); // ajout du sommet lu dans le fichier
	}
		
	for (int i = 0; i < nbFaces; i++){ // boucle de faces
	    sc.next(); // on evite le 3 a chaque debut de ligne
	    int entier1 = Integer.valueOf(sc.next());
	    int entier2 = Integer.valueOf(sc.next());
	    int entier3 = Integer.valueOf(sc.next());
			
	    fListe.add(new Face(entier1, entier2, entier3)); // ajout de la face lu dans le fichier
	}
		
	sc.close(); // fermeture du fichier apres lecture
		
    }
	
    /**
     * Constructeur par copie.
     * Construit un maillage a partir d'un modele de maillage.
     * @param m le maillage a copier.
     */
    public Maillage(Maillage m){
	//TODO - sûrement pas !!
	m.fListe = fListe;
	m.sListe = sListe;
    }

    
    /**
     * Cette methode affiche la liste de sommets et de faces constituant le maillage
     */
    /*public void affichageParListe(){
	System.out.println("Sommets : ");
	for ( int i = 0; i < sListe.size(); i++ ){
	    System.out.println(i+" - "+sListe.get(i));
	}
	System.out.println("Faces : ");
	for ( int i = 0; i < fListe.size(); i++ ){
	    System.out.println(i+" - "+fListe.get(i));
	}
	}*/
	
    /**
     * Cette methode affiche l’ensemble des faces sous la forme de 3×3 coordonnees (x,y,z)
     */
    /*public void affichageSoupePolygone(){
	System.out.println("Soupe : ");
	for ( int i = 0; i < fListe.size(); i++){
	    System.out.println(i+" : "+sListe.get(fListe.get(i).getS1()) +"-"+sListe.get(fListe.get(i).getS2())+
			       "-"+sListe.get(fListe.get(i).getS3()) );
	}
	}*/
	
    /**
     *  Cette methode affiche la boite englobante (alignee selon les axes).
     */
    /*public void afficheBB(){
	double maxX = sListe.get(0).getX(), maxY = sListe.get(0).getY(), maxZ = sListe.get(0).getZ();
	double minX = sListe.get(0).getX(), minY = sListe.get(0).getY(), minZ = sListe.get(0).getZ();
	for ( int i = 0; i < sListe.size(); i++ ){
	    if ( sListe.get(i).getX() > maxX ){
		maxX = sListe.get(i).getX();
	    }else if ( sListe.get(i).getX() < minX ){
		minX = sListe.get(i).getX();
	    }
	    if ( sListe.get(i).getY() > maxY ){
		maxY = sListe.get(i).getY();
	    }else if ( sListe.get(i).getY() < minY ){
		minY = sListe.get(i).getY();
	    }
	    if ( sListe.get(i).getZ() > maxZ ){
		maxZ = sListe.get(i).getZ();
	    }else if ( sListe.get(i).getZ() < minZ ){
		minZ = sListe.get(i).getZ();
	    }
	}
	System.out.println("maxX = "+maxX+" et minX = "+minX);
	System.out.println("maxY = "+maxY+" et minY = "+minY);
	System.out.println("maxZ = "+maxZ+" et minZ = "+minZ);
	}*/
	
    /**
     * Recentre le maillage dans sa boite englobante.
     * Cette methode permet de repositionner les sommets pour que le centre de la boite englobante soit en (0,0,0).
     */
    /*public void recentrerMaillage(){
	// TODO
	}*/
	
    public void translater(double dx, double dy, double dz){
	for(int i=0;i<sListe.size();i++){
	    sListe.get(i).setX(sListe.get(i).getX()+dx);
	    sListe.get(i).setY(sListe.get(i).getY()+dy);
	    sListe.get(i).setZ(sListe.get(i).getZ()+dz);
	}
    }
    
    /**
     * Subdivision des faces en 4 sans repositionnement des sommets
     */
    /*public void subdivision_faces(int nbSubdiv){
	for(int i=0;i<nbSubdiv;i++)
	    subdivision_faces();
    }
    public void subdivision_faces(){
	
    }*/

    /**
     * Subdivision de maillage par la méthode de Loop
     */
    /*public void loop(int nbSubdiv){
	for(int i=0;i<nbSubdiv;i++)
	    loop();
    }
    public void loop(){
    }*/

    /**
     * Subdivision de maillage par la méthode Butterfly
     */
    /*public void butterfly(int nbSubdiv){
	for(int i=0;i<nbSubdiv;i++)
	    butterfly();
    }
    public void butterfly(){
    }*/

     /**
     * Simplification de maillage
     */
    
    /*public void simplifier(){
    }
	
    public void tourner(){
		
    }*/
	
	
}
