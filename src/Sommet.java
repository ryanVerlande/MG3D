
class Sommet extends Point3D{

    public Sommet(){
	super();
    }

    public Sommet(double x, double y, double z){
	super(x,y,z);
    }

    public Sommet(Sommet s){
	super(s.getX(),s.getY(),s.getZ());
    }
}
