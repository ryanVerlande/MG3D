import java.util.ArrayList;

abstract class Objet3D{
    //Attributs
    protected ArrayList<Sommet> sListe;
    protected ArrayList<Face> fListe;

    public Objet3D(){
	sListe = new ArrayList<>();
	fListe = new ArrayList<>();
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

    /*
    public void afficher(QQchose ici - le GLCanvas surement ou un truc qui s en approche){
	for(int i=0;i<fListe.size();i++){
	    glBegin(GL_TRIANGLES);
	    glVertex3f(sListe.get(fListe.get(i).getS1()).getX(),sListe.get(fListe.get(i).getS1()).getY(),sListe.get(fListe.get(i).getS1()).getZ());
	    glVertex3f(sListe.get(fListe.get(i).getS2()).getX(),sListe.get(fListe.get(i).getS2()).getY(),sListe.get(fListe.get(i).getS2()).getZ());
	    glVertex3f(sListe.get(fListe.get(i).getS3()).getX(),sListe.get(fListe.get(i).getS3()).getY(),sListe.get(fListe.get(i).getS3()).getZ());
	    glEnd();
	}
	}*/
}
