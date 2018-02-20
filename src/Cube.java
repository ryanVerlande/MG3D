
public class Cube extends Maillage {

	Maillage cube = new Maillage();
	
	public Cube(){
		
	}
	
	public Cube(Sommet s1, Sommet s2, Sommet s3){
		
	}
	
	public void creationCube() {
		cube.add(new Sommet(0, 0, 0));
		cube.add(new Sommet(1, 0, 0));
		cube.add(new Sommet(0, 1, 0));
		cube.add(new Sommet(1, 1, 0));
		cube.add(new Sommet(0, 0, 1));
		cube.add(new Sommet(1, 0, 1));
		cube.add(new Sommet(0, 1, 1));
		cube.add(new Sommet(1, 1, 1));
		
		cube.add(new Face(3, 1, 0));
		cube.add(new Face(2, 3, 0));
		cube.add(new Face(3, 7, 1));
		cube.add(new Face(5, 1, 7));
		cube.add(new Face(6, 5, 7));
		cube.add(new Face(5, 6, 4));
		cube.add(new Face(4, 6, 2));
		cube.add(new Face(4, 2, 0));
		cube.add(new Face(6, 7, 3));
		cube.add(new Face(3, 2, 6));
		cube.add(new Face(1, 5, 0));
		cube.add(new Face(4, 0, 5));
		
		cube.affichageSoupePolygone();
	}

}
