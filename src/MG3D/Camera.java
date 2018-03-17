package MG3D;

import MG3D.geometrie.Point3D;

public class Camera {

	private Point3D position;
	private float angleHB, angleGD;

	public Camera() {
		position = new Point3D(0, 0, 0);
		angleHB = 0.0f;
		angleGD = 0.0f;
	}

	public Camera(Camera c) {
		position = new Point3D(c.getPosition());
		angleHB = c.angleHB;
		angleGD = c.angleGD;
	}
	
	public void decalerGauche(float distance) {
		double dx, dz;
		dx = Math.cos(Math.toRadians(90 - angleGD)) * distance;
		dz = -Math.sin(Math.toRadians(90 - angleGD)) * distance;
		position.setX(position.getX() + dz);
		position.setZ(position.getZ() - dx);
	}

	public void decalerDroite(float distance) {
		double dx, dz;
		dx = Math.cos(Math.toRadians(90 - angleGD)) * distance;
		dz = -Math.sin(Math.toRadians(90 - angleGD)) * distance;
		position.setX(position.getX() - dz);
		position.setZ(position.getZ() + dx);
	}

	public void deplacerVersRegard(float distance) {
		double dx, dz;
		dx = Math.cos(Math.toRadians(90 - angleGD)) * distance;
		dz = -Math.sin(Math.toRadians(90 - angleGD)) * distance;
		position.setX(position.getX() + dx);
		position.setZ(position.getZ() + dz);
	}

	public Point3D pointRegarde() {
		double x, y, z;
		x = position.getX() + Math.cos(Math.toRadians(90 - angleGD));
		y = position.getY() - Math.cos(Math.toRadians(90 - angleHB));
		z = position.getZ() - Math.sin(Math.toRadians(90 - angleGD));
		return new Point3D(x, y, z);
	}

	/*** GETTERS ***/

	public Point3D getPosition() {
		return position;
	}

	public float getAngleHB() {
		return angleHB;
	}

	public float getAngleGD() {
		return angleGD;
	}

	/*** SETTERS ***/

	public void setPosition(Point3D position) {
		this.position = new Point3D(position);
	}

	public void setAngleHB(float angleHB) {
		this.angleHB = angleHB;
	}

	public void setAngleGD(float angleGD) {
		this.angleGD = angleGD;
	}

	public String toString() {
		return new String("Camera en " + position + " regardant vers " + pointRegarde());
	}

}
