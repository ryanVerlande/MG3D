import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

abstract class Objet3D{
    //Attributs
    protected ArrayList<Sommet> sListe;
    protected ArrayList<Face> fListe;
    protected BoiteEnglobante be;

    public Objet3D(){
	sListe = new ArrayList<>();
	fListe = new ArrayList<>();
	be = null;
    }

    abstract protected void genereMaillage();

    /**
     * Ajoute un sommet a la liste de sommet
     * @param s le sommet a ajouter
     */
    public void add(Sommet s){
	sListe.add(s);
    }
	
    /**
     * Ajoute une face a la liste de face
     * @param f la face a ajouter
     */
    public void add(Face f){
	if ( (f.getS1() <= sListe.size() ) && (f.getS2() <= sListe.size() ) && (f.getS3() <= sListe.size() ) ){
	    fListe.add(f);
	    
	    //gestion des voisins
	    getSommet(f.getS1()).ajouterVoisin(f.getS2());
	    getSommet(f.getS1()).ajouterVoisin(f.getS3());
	    
	    getSommet(f.getS2()).ajouterVoisin(f.getS1());
	    getSommet(f.getS2()).ajouterVoisin(f.getS3());
	    
	    getSommet(f.getS3()).ajouterVoisin(f.getS1());
	    getSommet(f.getS3()).ajouterVoisin(f.getS2());
	}else{
	    System.out.println("Ajout impossible, l'indice de sommet n'existe pas !");
	}
    }

    /**
     * Retourne le nombre de sommets du maillage
     * @return nbSommets le nombre de sommets du maillage
     */
    public int getNbSommets(){
	return sListe.size();
    }


    public Sommet getSommet(int i){
	return sListe.get(i);
    }
	
    /**
     * Retourne le nombre de faces du maillage
     * @return nbFaces le nombre de faces du maillage
     */
    public int getNbFaces(){
	return fListe.size();
    }
	
    /**
     * Retourne le sommet dont l’indice est donne en parametre.
     * @param indiceFace l'indice du sommet recherche
     * @return la face dont l'indice est donne en parametre
     */
    public Face getFace(int indiceFace){
	return fListe.get(indiceFace);
    }

    public void translater(double dx, double dy, double dz){
	for(int i=0;i<sListe.size();i++){
	    sListe.get(i).setX(sListe.get(i).getX()+dx);
	    sListe.get(i).setY(sListe.get(i).getY()+dy);
	    sListe.get(i).setZ(sListe.get(i).getZ()+dz);
	}
    }

    /**
     * Calcul de la boite englobante.
     */
    public void calculeBoiteEnglobante(){
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
	be = new BoiteEnglobante(minX,minY,minZ,maxX,maxY,maxZ);
    }

    /**
     *  Cette methode permet de récupérer la boite englobante.
     */
    public BoiteEnglobante getBe(){
	if(be==null)
	    calculeBoiteEnglobante();
	return be;
    }
    
    /**
     * Recentre le maillage dans sa boite englobante.
     * Cette methode permet de repositionner les sommets pour que le centre de la boite englobante soit en (0,0,0).
     */
    /*public void recentrerMaillage(){
	// TODO
	}*/
    
    /**
     * Subdivision des faces en 4 sans repositionnement des sommets
     */
    public void subdivision_faces(int nbSubdiv){
	for(int i=0;i<nbSubdiv;i++)
	    subdivision_faces();
    }
    public void subdivision_faces(){
	
    }

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

    /**
     * Cette methode affiche la liste de sommets et de faces constituant le maillage
     */
    public void affichageParListe(){
	System.out.println("Sommets : ");
	for ( int i = 0; i < sListe.size(); i++ ){
	    System.out.println(i+" - "+sListe.get(i));
	}
	System.out.println("Faces : ");
	for ( int i = 0; i < fListe.size(); i++ ){
	    System.out.println(i+" - "+fListe.get(i));
	}
    }
    
    /**
     * Cette methode affiche l’ensemble des faces sous la forme de 3×3 coordonnees (x,y,z)
     */
    public void affichageSoupePolygone(){
	System.out.println("Soupe : ");
	for ( int i = 0; i < fListe.size(); i++){
	    System.out.println(i+" : "+sListe.get(fListe.get(i).getS1()) +"-"+sListe.get(fListe.get(i).getS2())+
			       "-"+sListe.get(fListe.get(i).getS3()) );
	}
    }

    /**
     * Cette méthode permet de sauver le maillage dans un fichier de type pgn
     */
    public void sauverPGN(String saveFile){
	try{
	    PrintWriter fichier =  new PrintWriter(new BufferedWriter (new FileWriter(saveFile)));
	    //fichier.println(toString());
	    fichier.println(getNbSommets()+ " " +getNbFaces());
	    for ( int i = 0; i < sListe.size(); i++ )
		fichier.println(getSommet(i).getX()+ " " + getSommet(i).getY() + " " + getSommet(i).getZ());

	    fichier.println("");
	    
	    for ( int i = 0; i < fListe.size(); i++ )
		fichier.println(getFace(i).getS1()+ " " + getFace(i).getS2() + " " + getFace(i).getS3()+ " -1");
	    
	    fichier.close();
	}catch(Exception e){
	    System.out.println("Impossible de sauvegarder le fichier "+saveFile);
	}
    }

    /**
     * Cette méthode permet de sauver le maillage dans un fichier de type stl
     */
    public void sauverSTL(String saveFile){
	try{
	    PrintWriter fichier =  new PrintWriter(new BufferedWriter (new FileWriter(saveFile)));
	    //fichier.println(toString());
	    fichier.println("solid " +getClass().toString().split(" ")[1]);
	    
	    for ( int i = 0; i < fListe.size(); i++ ){
		fichier.println("");
		fichier.println("facet normal 0 0 0");
		fichier.println("    outer loop");
		fichier.println("        vertex "+getSommet(getFace(i).getS1()).getX()+ " " + getSommet(getFace(i).getS1()).getY() + " " + getSommet(getFace(i).getS1()).getZ());
		fichier.println("        vertex "+getSommet(getFace(i).getS2()).getX()+ " " + getSommet(getFace(i).getS2()).getY() + " " + getSommet(getFace(i).getS2()).getZ());
		fichier.println("        vertex "+getSommet(getFace(i).getS3()).getX()+ " " + getSommet(getFace(i).getS3()).getY() + " " + getSommet(getFace(i).getS3()).getZ());
		fichier.println("    endloop");
		fichier.println("endfacet");
	    }
	    fichier.println("");
	    fichier.println("endsolid " +getClass().toString().split(" ")[1]);
	    fichier.close();
	}catch(Exception e){
	    System.out.println("Impossible de sauvegarder le fichier "+saveFile);
	}
    }

    /**
     * Calcule la normale à une face
     * TODO
     */
    public Vecteur3D normaleFace(int indice){
	return new Vecteur3D(0,0,0);
    }

    
    /*public void afficher(QQchose ici - le GLCanvas surement ou un truc qui s en approche){
	for(int i=0;i<fListe.size();i++){
	    glBegin(GL_TRIANGLES);
	    glVertex3f(sListe.get(fListe.get(i).getS1()).getX(),sListe.get(fListe.get(i).getS1()).getY(),sListe.get(fListe.get(i).getS1()).getZ());
	    glVertex3f(sListe.get(fListe.get(i).getS2()).getX(),sListe.get(fListe.get(i).getS2()).getY(),sListe.get(fListe.get(i).getS2()).getZ());
	    glVertex3f(sListe.get(fListe.get(i).getS3()).getX(),sListe.get(fListe.get(i).getS3()).getY(),sListe.get(fListe.get(i).getS3()).getZ());
	    glEnd();
	}
	}*/
}
