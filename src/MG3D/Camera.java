package MG3D;

import com.jogamp.opengl.GL2;

public class Camera {
	
	private float position;
	private float directionHB, directionGD;
	private float deplacementHB, deplacementGD;
	private float hauteur;
	
	public Camera(){
		position = 0.0f;
		deplacementHB = -10.0f;
		deplacementGD = -1.0f;
		directionHB = 0.0f;
		directionGD = 0.0f;
		hauteur = -1.0f;
	}
	
	public void deplacerCamera(GL2 gl){
		gl.glRotatef(directionGD, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(directionHB, 1.0f, 0.0f, 0.0f);
		gl.glTranslatef(deplacementGD, hauteur, deplacementHB);
	}

	public float getHauteur() {
		return hauteur;
	}

	public float getPosition() {
		return position;
	}

	public float getDirectionHB() {
		return directionHB;
	}

	public float getDirectionGD() {
		return directionGD;
	}

	public float getDeplacementHB() {
		return deplacementHB;
	}

	public float getDeplacementGD() {
		return deplacementGD;
	}

	public void setPosition(float position) {
		this.position = position;
	}
	
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}

	public void setDirectionHB(float directionHB) {
		this.directionHB = directionHB;
	}

	public void setDirectionGD(float directionGD) {
		this.directionGD = directionGD;
	}

	public void setDeplacementHB(float deplacementHB) {
		this.deplacementHB = deplacementHB;
	}

	public void setDeplacementGD(float deplacementGD) {
		this.deplacementGD = deplacementGD;
	}
	
}
