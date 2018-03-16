package MG3D;
class Pyramide extends Objet3D{
	
	public Pyramide(){
		super();
	}
	
	public Pyramide(double hauteur, double base){
		super(Couleur.NOIR);
	}
	
	public Pyramide(Couleur couleur, double hauteur, double base){
		super(couleur);
	}
	
	@Override
	protected void genereMaillage() {
		// TODO Auto-generated method stub
		
	}
	
}
