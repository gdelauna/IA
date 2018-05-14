package fr.lesprogbretons.seawar.model.actions;

import static fr.lesprogbretons.seawar.SeaWar.seaWarController;
import static fr.lesprogbretons.seawar.screen.SeaWarMapScreen.selectedTile;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.boat.Boat;

public class PassTurn extends Move {
	private Partie partie;
	private Boat boat;
	
	public PassTurn(Boat boat) {
		super(boat,boat.getPosition());
		
		
	}
	
	@Override
	public Object clone() {
		return new PassTurn(this.getBoat());
	}

	@Override
	public void apply(Partie partie) {
		//state.endTurn();
		seaWarController.selection(this.getBoat().getPosition().getX(), this.getBoat().getPosition().getY());
        selectedTile.setCoords(this.getBoat().getPosition().getY(),this.getBoat().getPosition().getX());
        
       // partie.unselectBateau();
        System.out.println("Pass turn action");
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Prefer to withdrawing, it better ";
	}

}
