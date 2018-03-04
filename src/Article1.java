import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.FPSAnimator;
 
/**
 * Article1.java
 * author: InfoRital
 *
 * Code source du premier article.
 * Article1 implémente {@link GLEventListener} pour obtenir le méchanisme de callback
 *
 */
 
class Article1 implements GLEventListener {
 
    public static void main(String[] args) {
        /**
         * Création d'une fenêtre
         * Nous utilisons la classe Frame de AWT
         * plutôt que la classe JFrame de Swing
         * pour une question de performance
         */
        Frame frame = new Frame("Article1");
         
        /**
         * Création du Canvas OpenGL
         * pour pouvoir dessiner dessus
         */
        GLCanvas canvas = new GLCanvas();
 
        /**
         * Nous attachons ensuite le méchanisme de callback
         * à notre surface dessinable
         */
        canvas.addGLEventListener(new Article1());
         
        /**
         * Nous attachons maintenant notre
         * surface dessinable à notre fenêtre
         */
        frame.add(canvas);
         
        /**
         * Création de l'Animator
         * comme expliqué dans l'article
         */
        final Animator animator = new Animator(canvas);
         
        /**
         * Le code qui suit permet de gérer la fermeture
         * de la fenêtre par l'utilisateur
         */
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                /**
                 * Nous créons un nouveau thread autre
                 * que la queue d'évenements AWT
                 * pour être d'arrêter l'Animator avant
                 * de quitter complétement
                 */
                new Thread(new Runnable() {
                    public void run() {
                        animator.stop();
                        System.exit(0);
                    }
                }).start();
            }
        });
         
        /**
         * Nous donnons une taille à la fenêtre
         * et nous l'affichons
         */
        frame.setSize(600, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
         
        /**
         * Nous démarrons l'Animator qui
         * va se charger de faire des appels
         * à la méthode display();
         */
        animator.start();
    }
 
    /**
     * init() sera appelée une fois au début de l'animation
     * C'est dans cette méthode que nous nous chargerons de toute
     * les opérations d'initialisation
     */
    public void init(GLAutoDrawable drawable) {
         
        /**
         * GLEventListener renvoie un contexte (drawable)
         * que nous allons utiliser pour instancier un objet
         * de type GL, qui nous permettra d'utiliser
         * les fonctions OpenGL, bien que dans cet article
         * cela reste encore inutile
         */
        GL2 gl = drawable.getGL().getGL2();
 
        /**
         * Cette fonction permet de désactiver
         * la synchronisation verticale, indépendement
         * de la plateforme utilisée
         */
        gl.setSwapInterval(1);
 
    }
 
    /**
     * reshape() sera appelée si la fenêtre d'affichage est redimensionnée
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,
            int height) {
        GL2 gl = drawable.getGL().getGL2();
 
    }
    /**
     * display() sera appelée en boucle tout au long de l'application
     * par la classe Animator. C'est dans cette fonction qu'on fera
     * tout ce qui doit être affiché
     */
    public void display(GLAutoDrawable drawable) {
    	
        GL2 gl = drawable.getGL().getGL2();
        
        gl.glBegin(GL2.GL_QUADS);          // Draw a quad
        gl.glColor3f(1f,0f,0f); //red color
        gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Bottom Left Of The Quad (Top)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Bottom Right Of The Quad (Top)
  		
        gl.glColor3f( 0f,1f,0f ); //green color
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Top Right Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Top Left Of The Quad
        gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Bottom Right Of The Quad 
        
        gl.glColor3f( 0f,0f,1f ); //blue color
        gl.glVertex3f( 1.0f, 1.0f, 1.0f ); // Top Right Of The Quad (Front)
        gl.glVertex3f( -1.0f, 1.0f, 1.0f ); // Top Left Of The Quad (Front)
        gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Bottom Left Of The Quad
        gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Bottom Right Of The Quad 
        
        gl.glEnd();
     
    }
     
    /**
     * displayChanged() est appelée si le mode d'affichage par exemple
     * est modifié. Cependant nous n'implémenterons pas cette méthode.
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }
 
    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub
         
    }
 
}