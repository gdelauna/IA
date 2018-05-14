package fr.lesprogbretons.seawar.ia;


import java.util.List;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.Player;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.boat.Boat;


public abstract class AbstractIA extends Player{
	
	public  static  int TIME_TO_THINK=1000;
	private Action memorisedAction;
	

	public AbstractIA(int number) {
		super(number);
		this.memorisedAction =null;
	}
	
	
    public AbstractIA(int number,String name) {
        super(number,name);
    }

    public AbstractIA(int number, String name, List<Boat> boats) {
    	super(number, name, boats);
    	
    }
    
    public final Action getMemorizedAction() {
    	return memorisedAction;
    }
    
    
    
    public final void memoriseAction(Action action) {
    	
    	if (action !=null) {
    		
    		memorisedAction =(Action)action.clone();
    		
    	}
    	else {
    		
    		memorisedAction=action;
    		
    	}
    	
    	
    }
    
    
    
    
 //  @Override
//    public void run() {
//        while (true) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                // On réinterromp pour bien pouvoir sortir de la boucle
//                Thread.currentThread().interrupt();
//                break;
//            }
//
//            if (partie.isPlayer2()) {
//                getCoup();
//            }
//        }
//    }

    public abstract  Action chooseAction(Partie partie);

}