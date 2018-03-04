
class IcoSphere extends Maillage{

    public IcoSphere(){
	super();
	add(new Sommet(-0.276385,-0.850640,-0.447215));
	add(new Sommet(0.000000,0.000000,-1.000000));
	add(new Sommet(0.723600,-0.525720,-0.447215));
	add(new Sommet(0.723600,0.525720,-0.447215));
	add(new Sommet(-0.894425,0.000000,-0.447215));
	add(new Sommet(-0.276385,0.850640,-0.447215));
	add(new Sommet(0.894425,0.000000,0.447215));
	add(new Sommet(0.276385,-0.850640,0.447215));
	add(new Sommet(-0.723600,-0.525720,0.447215));
	add(new Sommet(-0.723600,0.525720,0.447215));
	add(new Sommet(0.276385,0.850640,0.447215));
	add(new Sommet(0.000000,0.000000,1.000000));

	//face
	add(new Face(0,1,2));
	add(new Face(2,1,3));
	add(new Face(4,1,0));
	add(new Face(5,1,4));
	add(new Face(3,1,5));
	add(new Face(2,3,6));
	add(new Face(0,2,7));
	add(new Face(4,0,8));
	add(new Face(5,4,9));
	add(new Face(3,5,10));
	add(new Face(6,7,2));
	add(new Face(7,8,0));
	add(new Face(8,9,4));
	add(new Face(9,10,5));
	add(new Face(10,6,3));
	add(new Face(7,6,11));
	add(new Face(8,7,11));
	add(new Face(9,8,11));
	add(new Face(10,9,11));
	add(new Face(6,10,11));

	subdivision_faces();

	for(int i=0;i<getNbSommet();i++){
	    Vecteur3D temp = new Vecteur3D(getSommet(i).getX(),getSommet(i).getY(),getSommet(i).getZ());
	    temp.normaliser;
	    getSommet(i).setX(temp.getDx());
	    getSommet(i).setY(temp.getDy());
	    getSommet(i).setZ(temp.getDz());
	}
    }
    
    
    public IcoSphere(Point3D centre, double rayon){
	this();
	for(int i=0;i<getNbSommet();i++){
	    getSommet(i).setX(getSommet(i).getX()*rayon);
	    getSommet(i).setY(getSommet(i).getY()*rayon);
	    getSommet(i).setZ(getSommet(i).getZ()*rayon);
	}
	translater(centre.getX(),centre.getY(),centre.getZ());
    }

	
	
}
