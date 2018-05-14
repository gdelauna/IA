package fr.lesprogbretons.seawar.model.actions;

import static fr.lesprogbretons.seawar.SeaWar.seaWarController;
import static fr.lesprogbretons.seawar.screen.SeaWarMapScreen.selectedTile;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;

public class Attack extends Move{

	
	public Attack(Boat boat,Case target) {
		super(boat,target);

		
		
	}
	
	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		return new Attack(this.getBoat(),this.getTarget());
	}

	@Override
	public void apply(Partie partie) {
		// TODO Auto-generated method stub
		 seaWarController.selection(this.getTarget().getX(), this.getTarget().getY());
         selectedTile.setCoords(this.getTarget().getY(), this.getTarget().getX());
        // partie.unselectBateau();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Shooting the enemy...";
	}

}
