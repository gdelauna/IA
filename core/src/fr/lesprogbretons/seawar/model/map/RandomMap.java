package fr.lesprogbretons.seawar.model.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.math.Vector2;

import fr.lesprogbretons.seawar.model.Orientation;
import fr.lesprogbretons.seawar.model.boat.Amiral;
import fr.lesprogbretons.seawar.model.boat.Fregate;
import fr.lesprogbretons.seawar.model.cases.CaseTerre;

/**
 * RandomMap Class is for generating randomized Map 
 * @author aghilas
 *
 */


public class RandomMap extends Grille{

	private final int hauteur=13;
	private final int largeur=11;
	private final int nbrLightHouse=3;
	
	/**
	 * Amiral / Joueur 1
	 */
	private final int posAmiralXJ1=10;
	private final int posAmiralYJ1=0;
	/**
	 * Fregate / Joueur 1
	 */
	private final int posFregXJ1=10;
	private final int posFregYJ1=1;
	
	/**
	 * Amiral / Joueur 1
	 */
	private final int posAmiralXJ2=1;
	private final int posAmiralYJ2=12;
	/**
	 * Fregate / Joueur 1
	 */
	private final int posFregXJ2=0;
	private final int posFregYJ2=12;

	private List<Integer> freeCases;
	
	
	
	public RandomMap(int hauteur, int largeur) {
		super(hauteur, largeur);
		this.freeCases=new ArrayList<Integer>();
		for (int j=0; j< hauteur*largeur; j++) { freeCases.add(j);}
		
		
		
		
		
        bateaux1.add(new Amiral(tableau[posAmiralXJ1][posAmiralYJ1], getJoueur1()));
        bateaux1.get(0).setOrientation(Orientation.SUDEST);
        
        //bateaux1.add(new Fregate(tableau[posFregXJ1][posFregYJ1], getJoueur1()));
        //bateaux1.get(1).setOrientation(Orientation.SUDEST);

        int absPosAmiralJ1=posAmiralXJ1+hauteur*posAmiralYJ1;
        freeCases.remove(absPosAmiralJ1);
		//int absPosFregJ1=posFregXJ1+hauteur*posFregYJ1;
		//freeCases.remove(absPosFregJ1);
		
		
        
        
        bateaux2.add(new Amiral(tableau[posAmiralXJ2][posAmiralYJ2], getJoueur2()));
        bateaux2.get(0).setOrientation(Orientation.NORDOUEST);
        //bateaux2.add(new Fregate(tableau[posFregXJ2][posFregYJ2], getJoueur2()));
        //bateaux2.get(1).setOrientation(Orientation.NORDOUEST);
		
        int absPosAmiralJ2=hauteur*posAmiralYJ2+posAmiralXJ2;
        freeCases.remove(absPosAmiralJ2);
		//int absPosFregJ2=hauteur*posFregYJ2+posFregXJ2;
		//freeCases.remove(absPosFregJ2);
		
		for (int i=0;i<nbrLightHouse;i++) {
			int iPhare=(int) (Math.random() * (freeCases.size() - 0.01));
			int xPhare   = (int) Math.ceil((freeCases.get(iPhare)-largeur)/hauteur);
			int yPhare   = (int) Math.ceil(freeCases.get(iPhare)%hauteur);
			if (xPhare<0) {xPhare=0;}
			if (yPhare<0) {yPhare=0;}
			tableau[yPhare][xPhare].setPhare(true);
			freeCases.remove(freeCases.get(iPhare));
		}
		
		
		for (int i=0;i<10;i++) {
			
			int iTerre=(int) (Math.random() * (freeCases.size() - 0.01));
			int   xTerre = (int) Math.ceil((freeCases.get(iTerre)-largeur)/hauteur);
			int yTerre   = (int) Math.ceil(freeCases.get(iTerre)%hauteur);
			if (xTerre<0) {xTerre=0;}
			if (yTerre<0) {yTerre=0;}
			tableau[yTerre][xTerre]=new CaseTerre(yTerre,xTerre);
			freeCases.remove(freeCases.get(iTerre));
			
		}
		
		
		
	}
	
	private void randomizePharePosition() {
		
		// put randomly the lighthouse position on the table 
				
	}
	
	private List<Integer> updateFreeCases(){
		
		
		return freeCases;
	}
	
	
	private Vector2 randomizer(){
		
		
		int x= (int) (Math.random() * (hauteur - 0.01));
		int y= (int) (Math.random() * (largeur - 0.01));
		
		return new Vector2(x,y);
		
	}
	

}
