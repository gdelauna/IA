package fr.lesprogbretons.seawar.model.actions;



import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;

// very bad programming way in my o
import static fr.lesprogbretons.seawar.screen.SeaWarMapScreen.selectedTile;
import static fr.lesprogbretons.seawar.SeaWar.seaWarController;
import static fr.lesprogbretons.seawar.SeaWar.logger;

public class MoveBoat extends Move {

	
	public MoveBoat(Boat boat, Case target) {
		super(boat,target);
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object clone() {
		MoveBoat moveOnBoat =new MoveBoat(this.getBoat(),this.getTarget());
		return moveOnBoat;
	}

	@Override
	public void apply(Partie partie) {
		

		//On se déplace
        seaWarController.selection(this.getTarget().getX(), this.getTarget().getY());
        selectedTile.setCoords(this.getTarget().getY(), this.getTarget().getX());
        //partie.unselectBateau();
        logger.debug("IAAleatoire déplacement : " + this.getTarget().getX() + ";" +this.getTarget().getY());
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Move the boat";
	}
	
	
	

}
