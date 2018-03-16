package MG3D;

class Tube extends Objet3D{
	
	public Tube(){
		super();
	}
	
	public Tube(double diametre, double diametreInterne, double hauteur){
		super(Couleur.NOIR);
	}
	
	public Tube(Couleur couleur, double diametre, double diametreInterne, double hauteur){
		super(couleur);
	}

	@Override
	protected void genereMaillage() {
		// TODO Auto-generated method stub
		
	}
}
