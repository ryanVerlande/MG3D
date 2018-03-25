/*********************************************************************/
/*                                                                   */
/* Copyright 2012-2017 Rémi Synave, Anthony Desitter,                */
/*                     Nicolas Dubrunfaut, Maxime Langa,             */
/*                     Guillaume Langa                               */
/*                                                                   */
/* This file is part of MG2D.                                        */
/* This library uses javazoom library piece of code                  */
/* http://www.javazoom.net                                           */
/* and can be found with this library (file jlayer1.0.1.tar.gz)      */
/*                                                                   */
/* MG2D is free software: you can redistribute it and/or modify      */
/* it under the terms of the GNU General Public License as published */
/* by the Free Software Foundation, either version 3 of the License, */
/* or (at your option) any later version.                            */
/*                                                                   */
/* Foobar is distributed in the hope that it will be useful,         */
/* but WITHOUT ANY WARRANTY; without even the implied warranty of    */
/* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the      */
/* GNU General Public License for more details.                      */
/*                                                                   */
/* You should have received a copy of the GNU General Public License */
/* along with MG2D. If not, see <http://www.gnu.org/licenses/>.      */
/*                                                                   */
/*********************************************************************/

package MG3D;

import java.awt.Graphics;
import java.awt.Dimension;

import java.util.ArrayList;

import javax.swing.JPanel;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;

import MG3D.geometrie.Objet3D;
import MG3D.geometrie.Point3D;


/**
 * Cette classe créée une zone d'affichage qui sera incorporée dans un objet de type Fenetre. Cette classe ne devrait, à priori, jamais être instanciée directement par un développeur. Cette classe intégre une liste de formes (Objet3D).<br />
 * L'utilisateur peut ajouter ou supprimer un Objet3D et effacer un Panneau en passant par la classe Fenetre. Il n'a donc pas à appliquer des méthodes sur des objets de type Panneau. Pour chaque méthode de cette classe, il existe une émthode dans la classe Fenetre qui y fait référence.
 * @author Equipe 2D, Rémi Synave
 * @version 2.2
 * @see Fenetre
 * @see Objet3D
 */
class Panneau extends GLCanvas implements GLEventListener{
	
    // Attribut //
	
    private ArrayList < Objet3D > a;
    private Camera cam;
    private GLU glu = new GLU();
    private GL2 gl;
    private GLCanvas glcanvas;
    private float h;
    private boolean actif;
	
    // Constructeur //
	
    /**
     * Crée une zone d'affichage vide.
     */
    public Panneau () {
	super();
	cam = new Camera();
	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
    	
	glcanvas = new GLCanvas(capabilities);
	glcanvas.display();
	a = new ArrayList < Objet3D > ();
	actif = false;
    }
	
    /**
     * Crée une zone d'affichage contenant la liste des formes passée en paramètre.
     * @param a Liste de formes.
     * @see Objet3D
     */
    public Panneau ( ArrayList < Objet3D > a ) {
	super();
	this.cam = new Camera();
	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
    	
	glcanvas = new GLCanvas(capabilities);
	this.a = new ArrayList<Objet3D>(a);
	this.actif = false;
    }
	
    /**
     * Crée une zone d'affichage identique à celle passée en paramètre.
     * @param p Zone d'affichage à copier.
     */
    public Panneau ( Panneau p ) {
	super();
	GLProfile profile = GLProfile.get(GLProfile.GL2);
	GLCapabilities capabilities = new GLCapabilities(profile);
	glcanvas = new GLCanvas(capabilities);
	setPreferredSize(new Dimension(p.getWidth(),p.getHeight()));
	setSize(new Dimension(p.getWidth(),p.getHeight()));
	a = p.getA();
	cam = new Camera (p.getCamera());
	actif = getActif();
    }
	
    // Accesseurs //
	
    // Getter //
	
	/**
     * Retourne la liste de formes dans la zone d'affichage.
     * <strong>Attention,</strong> la liste de formes retournée est l'ensemble des formes ajoutées à la zone d'affichage même si celle-ci n'a pas été rafraichie.
     * @return a ArrayList de Objet3D.
     * @see Fenetre#rafraichir Fenetre.rafraichir()
     * @see Objet3D
     */
    public ArrayList < Objet3D > getA () {
		
	return new ArrayList<Objet3D>(a);
    }
    
    public Camera getCamera(){
    	return cam;
    }
    
    public boolean getActif() {
		return actif;
	}
    
    // Setter //
	
    /**
     * Remplace la liste de formes acutelle de la zone d'affichage par celle passée en paramètre.
     * @param a Liste de formes.
     * @see Objet3D
     */
    public void setA ( ArrayList < Objet3D > a ) {
    	this.a = a;
    }
    
    public void setActif(boolean aactif) {
		this.actif = aactif;
	}
	
    // Méthodes //
	
    /**
     * Méthode appelée automatiquement afin d'afficher le contenu de la liste dans la zone d'affichage.<br />
     * Cette méthode ne doit pas être appelée.
     */
    public void paint ( GL2 gl ) {
	// On parcourt la ArrayList via une boucle for() qui affiche un à un le contenu de a.
	for ( int i = 0; i < a.size(); i++ ){
	    a.get( i ).afficher( gl, getActif() );
	}
    }
    
    /*public void majCam(GL2 gl){
    	cam.deplacerCamera(gl);
	}*/
    
    /**
     * @see <a href="https://docs.oracle.com/javase/7/docs/api/java/awt/Component.html#repaint()" target="_blank">Repaint de Component</a>
     */
    @Override
    public void repaint(){
	super.repaint();
	getToolkit().sync();
    }

    
	
    /**
     * Ajoute une forme à la zone d'affichage.<br />
     * @param d Objet3D.
     * @see Objet3D
     */
    public void ajouter ( Objet3D d ) {
	a.add ( d );
	repaint();
    }
	
    /**
     * Supprime une forme de la zone d'affichage.<br />
     * <strong>Attention,</strong> l'objet passé en paramètre doit être une référence pointant sur un objet présent dans la liste de formes contenue dans la zone d'affichage. Il ne faut pas que ce soit <em>simplement</em> un objet égal à l'objet qui doit être supprimé.
     * @param d Objet3D.
     * @see Objet3D
     */
    public void supprimer ( Objet3D d ) {
		
	a.remove ( d );
	repaint();
    }
	
    /**
     * Supprime toutes les formes contenues dans la zone d'affichage.
     */
    public void effacer () {
		
	a.clear();
	repaint();
    }

    /**
     * Retourne une description de la zone d'affichage et de son contenu.
     * @return Chaîne de caractères contenant la description de la zone d'affichage.
     */
    public String toString(){
	String retour=new String("Zone d'affichage contenant :\n");
	for(Objet3D d : a){
	    retour=retour.concat("\t"+d+"\n");
	}
	return retour;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
	gl = drawable.getGL().getGL2();
	gl.glClearColor( 0.0f, 0.0f, 0.0f, 0.0f );
	gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		
	gl.glMatrixMode(GL2.GL_PROJECTION);
	gl.glLoadIdentity();

	glu.gluPerspective(45.0, h, 0.1, 200);
	
	gl.glMatrixMode(GL2.GL_MODELVIEW);
	gl.glLoadIdentity();

	Point3D posCamera=cam.getPosition();
	Point3D pointRegarde=cam.pointRegarde();

	glu.gluLookAt(posCamera.getX(), posCamera.getY(), posCamera.getZ(), 
		      pointRegarde.getX(), pointRegarde.getY(), pointRegarde.getZ(),
		      0.0f, 1.0f, 0.0f);
		
		
	paint(gl);
		
	gl.glFlush();
		
		
    }

    @Override
    public void dispose(GLAutoDrawable drawable) {
	// TODO Auto-generated method stub
    }

    @Override
    public void init(GLAutoDrawable drawable) {
	final GL2 gl = drawable.getGL().getGL2();
	gl.glShadeModel(GL2.GL_SMOOTH);
	gl.glClearColor(0f, 0f, 0f, 0f);
	gl.glClearDepth(1.0f);
	gl.glEnable(GL2.GL_DEPTH_TEST);
	gl.glDepthFunc(GL2.GL_LEQUAL);
	gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    }

    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
	final GL2 gl = drawable.getGL().getGL2();
	if (height == 0) {
	    height = 1;
	}
		
	h = (float) width / (float) height;
	gl.glViewport(0, 0, width, height);
	gl.glMatrixMode(GL2.GL_PROJECTION);
	gl.glLoadIdentity();
		
	glu.gluPerspective(45.0f, h, 1.0, 20.0);
	gl.glTranslatef(0.0f, 0.0f, 0.0f);
		
	gl.glMatrixMode(GL2.GL_MODELVIEW);
	gl.glLoadIdentity();
    }
	
	
	
}
