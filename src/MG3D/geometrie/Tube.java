package MG3D.geometrie;

public class Tube extends Objet3D{
	
	public Tube(){
		super();
	}
	
	public Tube(double diametre, double diametreInterne, double hauteur){
		super(Couleur.NOIR);
	}

public Tube(Couleur couleur, double diametre, double diametreInterne, double hauteur){
		super(couleur);
	}
	
	public Tube(Tube t){
		super(t.getCouleur());
	}

@Override
	protected void genereMaillage() {
		// TODO Auto-generated method stub
		
	}
	
}
