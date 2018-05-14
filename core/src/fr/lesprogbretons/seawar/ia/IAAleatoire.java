package fr.lesprogbretons.seawar.ia;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.actions.Action;

import fr.lesprogbretons.seawar.model.boat.Boat;


import java.util.ArrayList;

import java.util.Random;





public class IAAleatoire extends AbstractIA {
	
    public IAAleatoire(int identifier) {
        super(identifier,"IAAleatoire");
    }


	public IAAleatoire(int identifier,String name,ArrayList<Boat> boats) {
		// TODO Auto-generated constructor stub
		super(identifier,name,boats);
	}


	@Override
	public Action chooseAction(Partie partie) {
		        Random rnd = new Random();
		        int indexAct=rnd.nextInt(partie.getPossibleActions().size());
        		return partie.getPossibleActions().get(indexAct);
        		
	
	}
		
		
		
		
		
		
			
}
