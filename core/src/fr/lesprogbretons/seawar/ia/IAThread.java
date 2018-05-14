package fr.lesprogbretons.seawar.ia;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.actions.PassTurn;
import fr.lesprogbretons.seawar.model.boat.Boat;
import static fr.lesprogbretons.seawar.SeaWar.seaWarController;
import static fr.lesprogbretons.seawar.screen.SeaWarMapScreen.selectedTile;
public class IAThread extends Thread{

	
	private  AbstractIA ia;
	
	private  ExecutorService executorService;
	private Partie partie;
	
	private Action choosedAction;
	
	
	public IAThread(AbstractIA ia,Partie partie, ExecutorService executorService) {
		super("Calcul");
		setName("Calcul");
		this.ia=ia;
		this.executorService=executorService;
		this.partie=partie;
		this.choosedAction=null;
		
	}
	
	public Action getActionChoice() {
		return choosedAction;
		
	}
	
	
	public void run() {
      while (true) {
          try {
        	  // action choisie
        	  
        	  List<Boat> boats=null;
        	  if(ia.getNumber()==2) {
        		  boats=partie.getMap().getBateaux2();
        		  
        	  }
        	  else {
        		  boats=partie.getMap().getBateaux1();
        	  }
      
              int cantPlay=0;
        	  
        	  for (Boat boat : boats) {
              	if (boat.getMoveAvailable() == 0 || partie.getMap().getCasesDisponibles(boat.getPosition(), 1).isEmpty()) cantPlay++;
              }
        	  
        	  if (cantPlay == boats.size()) {
        		  seaWarController.endTurn();
        	  }
        	  
        	  if (!partie.isAnyBateauSelectionne()) {
        		  int index=0;
        		  Boat boat=boats.get(index);
        	    
        	  do {
        		  
        		  	
        			partie.setBateauSelectionne(boat);
        			this.choosedAction=ia.chooseAction((Partie)partie.clone());
        			partie.unselectBateau();
        			index+=1;
        	
        		  }while (partie.getMap().getCasesDisponibles(boat.getPosition(), 1).isEmpty() || boat.getMoveAvailable() == 0);
        	  }
        	  
        	  else {
        		  
        	  }
        	  
          } catch (Exception ex) {
        	  	System.out.println(ex.getCause());
				Logger.getLogger(Partie.class.getName()).log(Level.SEVERE,null,ex);
			  }

          finally {
        	  
        	  executorService.shutdown();
        	  
          }

      }
  }
	
	
}
