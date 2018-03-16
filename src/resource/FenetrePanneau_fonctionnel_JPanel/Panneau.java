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
package resource.FenetrePanneau_fonctionnel_JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import MG3D.geometrie.Objet3D;

/**
 * Cette classe créée une zone d'affichage qui sera incorporée dans un objet de type Fenetre. Cette classe ne devrait, à priori, jamais être instanciée directement par un développeur. Cette classe intégre une liste de formes (Objet3D).<br />
 * L'utilisateur peut ajouter ou supprimer un Objet3D et effacer un Panneau en passant par la classe Fenetre. Il n'a donc pas à appliquer des méthodes sur des objets de type Panneau. Pour chaque méthode de cette classe, il existe une émthode dans la classe Fenetre qui y fait référence.
 * @author Equipe 2D, Rémi Synave
 * @version 2.2
 * @see Fenetre
 * @see Objet3D
 */
class Panneau extends JPanel {
	
    // Attribut //
	
    private ArrayList < Objet3D > a;
	
    // Constructeur //
	
    /**
     * Crée une zone d'affichage vide.
     */
    public Panneau () {
	super();
	a = new ArrayList < Objet3D > ();
    }
	
    /**
     * Crée une zone d'affichage contenant la liste des formes passée en paramètre.
     * @param a Liste de formes.
     * @see Objet3D
     */
    public Panneau ( ArrayList < Objet3D > a ) {
	super();
	this.a = new ArrayList<Objet3D>(a);
    }
	
    /**
     * Crée une zone d'affichage identique à celle passée en paramètre.
     * @param p Zone d'affichage à copier.
     */
    public Panneau ( Panneau p ) {
	super(p.getLayout(),p.isDoubleBuffered());
	setPreferredSize(new Dimension(p.getWidth(),p.getHeight()));
	setSize(new Dimension(p.getWidth(),p.getHeight()));
	a = p.getA();
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
	
    // Setter //
	
    /**
     * Remplace la liste de formes acutelle de la zone d'affichage par celle passée en paramètre.
     * @param a Liste de formes.
     * @see Objet3D
     */
    public void setA ( ArrayList < Objet3D > a ) {
		
	this.a = a;
    }
	
    // Méthodes //
	
    /**
     * Méthode appelée automatiquement afin d'afficher le contenu de la liste dans la zone d'affichage.<br />
     * Cette méthode ne doit pas être appelée.
     */
    public void paint ( Graphics g ) {
	// On parcourt la ArrayList via une boucle for() qui affiche un à un le contenu de a.
	for ( int i = 0; i < a.size(); i++ ){}
//	    a.get( i ).afficher( g );
    }
    
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
}
