package MG3D;

import com.jogamp.opengl.GL2;

import MG3D.geometrie.Point3D;
import MG3D.geometrie.Vecteur3D;

public class Camera {
	
	private Point3D position;
	private float angleX, angleY, angleZ;
	
	public Camera(){
		position = new Point3D(0, 0, 0);
		angleX = 0.0f;
		angleY = 0.0f;
		angleZ = 0.0f;
	}
	
	public void deplacerCamera(GL2 gl){
		// vide du coup
	}
	
	public void calculCam(){
		
	}
	
	/*** GETTERS ***/
	
	public Point3D getPosition() {
		return position;
	}

	public float getAngleX() {
		return angleX;
	}

	public float getAngleY() {
		return angleY;
	}

	public float getAngleZ() {
		return angleZ;
	}
	
	/*** SETTERS ***/
	
	public void setPosition(Point3D position) {
		this.position = position;
	}

	public void setAngleX(float angleX) {
		this.angleX = angleX;
	}

	public void setAngleY(float angleY) {
		this.angleY = angleY;
	}

	public void setAngleZ(float angleZ) {
		this.angleZ = angleZ;
	}
	
	
}
