package MG3D.geometrie;

import java.util.ArrayList;

public class Sommet extends Point3D{

    // TODO voir s'il ne faut pas plutôt utiliser un Set, un HashSet ? Autre chose ?
    // Permet de stocker les indices des sommets voisins dans le maillage.
    private ArrayList<Integer> voisins;
    
    public Sommet(){
	super();
	voisins = new ArrayList<Integer>();
    }

    public Sommet(double x, double y, double z){
	super(x,y,z);
	voisins = new ArrayList<Integer>();
    }

    public Sommet(Sommet s){
	super(s.getX(),s.getY(),s.getZ());
	voisins = new ArrayList<Integer>();
    }

    public boolean ajouterVoisin(int indice){
	boolean contient=estVoisin(indice);
	if(!contient)
	    voisins.add(new Integer(indice));
	return !contient;
    }

    public boolean estVoisin(int indice){
	return voisins.contains(new Integer(indice));
    }
}
