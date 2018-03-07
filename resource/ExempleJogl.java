import java.awt.DisplayMode;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import javax.swing.JFrame;
import com.jogamp.opengl.util.FPSAnimator;

public class ExempleJogl implements GLEventListener {

   public static DisplayMode dm, dm_old;
   private GLU glu = new GLU();
   private float rquad = 0.0f;
      
   @Override
   public void display( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
      gl.glLoadIdentity();

      // Pour décaler le cube en arrière et ainsi le voir complétement - la caméra se trouve en (0,0,0)
      // et regarde vers le Z dans le négatif je crois
      gl.glTranslatef( 0.0f, 0.0f, -5.0f );

      // Pour faire tourner le cube de rquad degrés ou radians suivant les 3 axes en mêmes temps
      gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f);


      // Maillage centré en (0,0,0)
      // giving different colors to different sides
      gl.glBegin(GL2.GL_TRIANGLES);
      
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); //red color 
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Right Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 0.0f, 1.0f, 0.0f ); //green color
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 0.0f, 0.0f, 1.0f ); //blue color 
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 1.0f, 1.0f, 0.0f ); //yellow color
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad

      
      gl.glColor3f( 1.0f, 0.0f, 1.0f ); //magenta color 
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 0.0f, 1.0f, 1.0f ); //cyan color
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 1.0f, 1.0f, 1.0f ); //white color 
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Top Right Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 1.0f, 0.5f, 0.0f ); //orange color
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 0.5f, 0.5f, 0.5f ); //grey color 
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Top Right Of The Quad
      gl.glVertex3f( 1.0f, 1.0f, -1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 0.75f, 0.25f, 1.0f ); //violet color
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, -1.0f ); // Bottom Left Of The Quad

      // A commenter/decommenter pour voir ou non l'intérieur du cube
      /*gl.glColor3f( 0.75f, 0.25f, 0.0f ); //brown color 
      gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad


      gl.glColor3f( 1.0f, 0.5f, 0.66f ); //pink color
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad (Front)
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad (Front)
      gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad
      */
      
      gl.glEnd(); // Done Drawing The Quad
      gl.glFlush();

      // Pour savoir ce qui est vraimet fait, il faut lire toutes les informations à l'envers donc en remontant
      // Ici, affichage du maillage cube centré en (0,0,0)
      // Rotation du cube suivant les 3 axes (la rotation se fait toujours par rapport à l'origine
      // Translation du cube vers l'arrière pour le voir

      // Attention de ne pas inverser rotation et translation sinon le cube tournerait mais plus sur lui même mais
      // par rapport au point (0,0,-5.0)
      
      rquad -= 0.30f;
   }
   
   @Override
   public void dispose( GLAutoDrawable drawable ) {
      // TODO Auto-generated method stub
   }
   
   @Override
   public void init( GLAutoDrawable drawable ) {
	
      final GL2 gl = drawable.getGL().getGL2();
      gl.glShadeModel( GL2.GL_SMOOTH );
      gl.glClearColor( 0f, 0f, 0f, 0f );
      gl.glClearDepth( 1.0f );
      gl.glEnable( GL2.GL_DEPTH_TEST );
      gl.glDepthFunc( GL2.GL_LEQUAL );
      gl.glHint( GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST );
   }
      
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
      // TODO Auto-generated method stub
      final GL2 gl = drawable.getGL().getGL2();
      if( height == 0 ){
         height = 1;
      }

      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      // On règle le point de vue
      gl.glMatrixMode( GL2.GL_PROJECTION );
      // On se met en (0,0,0)
      gl.glLoadIdentity();
      
      // On crée une caméra perspective centrée en (0,0,0)
      // d'ouverture 45 degrés, d'aspect ratio la même chose que la fenêtre avec le haut en haut et une distance de clipping de 20
      // (ça, c'est de mémoire. Pas sûr que tout soit juste)
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      // Si on veut faire bouger la caméra, soit on le fait ici ou juste avant le gluPerspective (je ne sais plus)
      // avec des glRotate et glTranslate
      // Soit on fait bouger toute la scène (voir la fonction display)

      // Ici, on repasse en mode modélisation donc affichage de maillage
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      // On réinitialise toutes les transformations (rotation et translation)
      gl.glLoadIdentity();
   }
      
   public static void main( String[] args ) {
	
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities( profile );
      
      // The canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      ExempleJogl cube = new ExempleJogl();
      
      glcanvas.addGLEventListener( cube );
      glcanvas.setSize( 700, 700 );
      
      final JFrame frame = new JFrame ( " Multicolored cube" );
      frame.getContentPane().add( glcanvas );
      frame.setSize( frame.getContentPane().getPreferredSize() );
      frame.setVisible( true );
      frame.setLocationRelativeTo(null);
      final FPSAnimator animator = new FPSAnimator(glcanvas, 300,true);
		
      animator.start();
      
      frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
   }
	
}
