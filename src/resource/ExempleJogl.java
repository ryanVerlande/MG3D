package resource;

import java.awt.DisplayMode;
import java.awt.PopupMenu;

import com.jogamp.newt.Display;
import com.jogamp.newt.event.KeyEvent;
import com.jogamp.newt.event.KeyListener;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;
import com.jogamp.opengl.util.GLDrawableUtil.ReshapeGLEventListener;
import com.jogamp.opengl.util.awt.AWTGLPixelBuffer.SingleAWTGLPixelBufferProvider;

import MG3D.Clavier;
import MG3D.Fenetre;
import MG3D.Souris;

public class ExempleJogl implements GLEventListener {

	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private float rquad = 0.0f;
	public static GL2 gl;

	public static GLCanvas glcanvas;
	public static Fenetre f;
	public static Clavier c;
	public static Souris s;
	private static float deplhb = -5.0f,deplgd = 0.0f;
	private static float orientgd = 0.0f, orienthb = 0.0f;
	private static float gravite = 0.0f;
	private static float vitesse = 0.2f;
	private static float sensiH = 1.5f, sensiV = 1.0f;
	private float h;

	@Override
	public void display(GLAutoDrawable drawable) {

		gl = drawable.getGL().getGL2();
		gl.glClearColor( 0.75f, 0.75f, 0.75f, 1.0f );
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);

		// h = (float) width / (float) height;
		// gl.glViewport(0, 0, width, height);
		// On règle le point de vue
		gl.glMatrixMode(GL2.GL_PROJECTION);
		// On se met en (0,0,0)
		gl.glLoadIdentity();
		
		// On crée une caméra perspective centrée en (0,0,0)
		// d'ouverture 45 degrés, d'aspect ratio la même chose que la fenêtre
		// avec le haut en haut et une distance de clipping de 50
		// (ça, c'est de mémoire. Pas sûr que tout soit juste)
		glu.gluPerspective(45.0f, h, 1.0, 50.0);
		// si on veut deplacer la camera, on modifie la valeur de la profondeur,
		// ici depl
		
		gl.glRotatef(orientgd, 0.0f, 1.0f, 0.0f);
		gl.glRotatef(orienthb, 1.0f, 0.0f, 0.0f);
		gl.glTranslatef(deplgd, gravite, deplhb);
		
		// Si on veut faire bouger la caméra, soit on le fait ici.
		// avec des glRotate et glTranslate
		// Soit on fait bouger toute la scène (voir la fonction display)

		// Ici, on repasse en mode modélisation donc affichage de maillage
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		// On réinitialise toutes les transformations (rotation et translation)
		gl.glLoadIdentity();

		gl.glLoadIdentity();

		/*********************** 1ER CUBE A GAUCHE **************************/

		// Pour décaler le cube en arrière et ainsi le voir complétement - la
		// caméra se trouve en (0,0,0)
		// et regarde vers le Z dans le négatif je crois
		gl.glTranslatef(-2.0f, -2.0f, -10.0f);

		// // Pour faire tourner le cube de rquad degrés ou radians suivant les
		// 3
		// // axes en mêmes temps
		// gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);

		// Maillage centré en (0,0,0)
		// giving different colors to different sides
		gl.glBegin(GL2.GL_TRIANGLES);

		gl.glColor3f(1.0f, 0.0f, 0.0f); // red color
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 1.0f, 0.0f); // green color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 0.0f, 1.0f); // blue color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 1.0f, 0.0f); // yellow color
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.0f, 1.0f); // magenta color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 1.0f, 1.0f); // cyan color
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 1.0f, 1.0f); // white color
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.5f, 0.0f); // orange color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.5f, 0.5f, 0.5f); // grey color
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.75f, 0.25f, 1.0f); // violet color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom Left Of The Quad

		// A commenter/decommenter pour voir ou non l'intérieur du cube
		gl.glColor3f(0.75f, 0.25f, 0.0f); // brown color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.5f, 0.66f); // pink color
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glEnd(); // Done Drawing The Quad

		/******************** 2EME CUBE A DROITE ************************/

		gl.glLoadIdentity();

		gl.glTranslatef(2.0f, -2.0f, -10.0f);

		gl.glBegin(GL2.GL_TRIANGLES);

		gl.glColor3f(1.0f, 0.0f, 0.0f); // red color
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 1.0f, 0.0f); // green color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 0.0f, 1.0f); // blue color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 1.0f, 0.0f); // yellow color
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.0f, 1.0f); // magenta color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.0f, 1.0f, 1.0f); // cyan color
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 1.0f, 1.0f); // white color
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.5f, 0.0f); // orange color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.5f, 0.5f, 0.5f); // grey color
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom Left Of The Quad

		gl.glColor3f(0.75f, 0.25f, 1.0f); // violet color
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Bottom Left Of The Quad

		// A commenter/decommenter pour voir ou non l'intérieur du cube
		gl.glColor3f(0.75f, 0.25f, 0.0f); // brown color
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glColor3f(1.0f, 0.5f, 0.66f); // pink color
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad

		gl.glEnd(); // Done Drawing The Quad

		/****************************************************************/

		/************************** PYRAMIDE ****************************/

		 gl.glLoadIdentity();
		
		 gl.glTranslatef(5.0f, -2.0f, -10.0f);
		 
		 gl.glBegin(GL2.GL_TRIANGLES); //Draw a pyramid made up of triangles
		
		 gl.glColor3d(1.0, 0.0, 0.0); //Red
		 gl.glVertex3d(0.0, 1.0, 0.0); //Top Of Front Triangle
		 gl.glVertex3d(-1.0, -1.0, 1.0); //Left Of Front Triangle
		 gl.glVertex3d(1.0, -1.0, 1.0); //Right Of Front Triangle
		
		 gl.glColor3f(1.0f, 1.0f, 0.0f); //Yellow
		 gl.glVertex3d(0.0, 1.0, 0.0); //Top Of Right Triangle
		 gl.glVertex3d(1.0, -1.0, 1.0); //Left Of Right Triangle
		 gl.glVertex3d(1.0, -1.0, -1.0); //Right Of Right Triangle
		
		 gl.glColor3d(0.0, 1.0, 0.0); //Green
		 gl.glVertex3d(0.0, 1.0, 0.0); //Top Of Back Triangle
		 gl.glVertex3d(1.0, -1.0, -1.0); //Left Of Back Triangle
		 gl.glVertex3d(-1.0, -1.0, -1.0);//Right Of Back Triangle
		
		 gl.glColor3d(0.0, 0.0, 1.0); //Blue
		 gl.glVertex3d(0.0, 1.0, 0.0); //Top Of Left Triangle
		 gl.glVertex3d(-1.0, -1.0, -1.0);//Left Of Left Triangle
		 gl.glVertex3d(-1.0, -1.0, 1.0); //Right Of Left Triangle
		
		 gl.glEnd();
		
		/****************************************************************/
		 
		/************************ LE SOL "CUBE" *************************/ 
		
		 gl.glLoadIdentity();
			
		 gl.glTranslatef(5.0f, -13.0f, -10.0f);
		 
		//giving different colors to different sides
	      gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube
	      gl.glColor3d(0.0, 0.0, 0.5); //Blue
	      gl.glVertex3f(50.0f, 10.0f, -50.0f); // Top Right Of The Quad (Top)
	      gl.glVertex3f( -50.0f, 10.0f, -50.0f); // Top Left Of The Quad (Top)
	      gl.glVertex3f( -50.0f, 10.0f, 50.0f ); // Bottom Left Of The Quad (Top)
	      gl.glVertex3f( 50.0f, 10.0f, 50.0f ); // Bottom Right Of The Quad (Top)
	      
	      
	      
	      gl.glEnd(); // Done Drawing The Quad
		
		/****************************************************************/
		
		gl.glFlush();

		// Pour savoir ce qui est vraimet fait, il faut lire toutes les
		// informations à l'envers donc en remontant
		// Ici, affichage du maillage cube centré en (0,0,0)
		// Rotation du cube suivant les 3 axes (la rotation se fait toujours par
		// rapport à l'origine
		// Translation du cube vers l'arrière pour le voir

		// Attention de ne pas inverser rotation et translation sinon le cube
		// tournerait mais plus sur lui même mais
		// par rapport au point (0,0,-5.0)

		rquad -= 0.30f;
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
		// On règle le point de vue
		gl.glMatrixMode(GL2.GL_PROJECTION);
		// On se met en (0,0,0)
		gl.glLoadIdentity();

		// On crée une caméra perspective centrée en (0,0,0)
		// d'ouverture 45 degrés, d'aspect ratio la même chose que la fenêtre
		// avec le haut en haut et une distance de clipping de 20
		// (ça, c'est de mémoire. Pas sûr que tout soit juste)
		glu.gluPerspective(45.0f, h, 1.0, 20.0);
		// si on veut deplacer la camera, on modifie la valeur de la profondeur,
		// ici depl
		gl.glTranslatef(0.0f, 0.0f, deplhb);

		// Si on veut faire bouger la caméra, soit on le fait ici ou juste avant
		// le gluPerspective (je ne sais plus)
		// avec des glRotate et glTranslate
		// Soit on fait bouger toute la scène (voir la fonction display)

		// Ici, on repasse en mode modélisation donc affichage de maillage
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		// On réinitialise toutes les transformations (rotation et translation)
		gl.glLoadIdentity();
	}

	public static void avancerUnPasDeTemps() {
		f = new Fenetre("Maillage cubesque", 1080, 720);
		GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// The canvas
		glcanvas = new GLCanvas(capabilities);
		ExempleJogl cube = new ExempleJogl();

		glcanvas.addGLEventListener(cube);
		glcanvas.setSize(f.getWidth(), f.getHeight());

		c = f.getClavier();
		s = f.getSouris();
		f.getContentPane().add(glcanvas);

		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

	}

	public static void avancer() {
		/*** DEPLACEMENT ***/
		// Haut
		if (c.getZEnfoncee() == true) {
			deplhb += vitesse;
		}
		// Bas
		if (c.getSEnfoncee() == true) {
			deplhb -= vitesse;
		}
		// Gauche
		if (c.getQEnfoncee() == true) {
			deplgd += vitesse;
		}
		// Droite
		if (c.getDEnfoncee() == true) {
			deplgd -= vitesse;
		}
		// Saut
		if (c.getEspaceTape() == true) {
			gravite = -5.0f;
			gravite += 0.1f;
			System.out.println("GRAVITY ESPACE= " + gravite);
		}
		if (gravite < 0.0f) {
			gravite += 0.1f;
		}

		/*** ORIENTATION ***/
		// Droite
		if (c.getDroiteEnfoncee() == true) {
			orientgd += sensiH;
		}
		// Gauche
		if (c.getGaucheEnfoncee() == true) {
			orientgd -= sensiH;
		}
		// Haut
		if (c.getHautEnfoncee() == true) {
			orienthb -= sensiV;
		}
		// Bas
		if (c.getBasEnfoncee() == true) {
			orienthb += sensiV;
		}
		// rafraichit la fenetre
		glcanvas.display();
		System.out.println("DEPLACEMENT HB = " + deplhb);
		System.out.println("DEPLACEMENT GD = " + deplgd);
		System.out.println("ORIENTATION GD = " + orientgd);
		System.out.println("ORIENTATION HB = " + orienthb);
		System.out.println("GRAVITY = " + gravite);
	}
}