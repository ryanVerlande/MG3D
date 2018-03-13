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
