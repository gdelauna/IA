package fr.lesprogbretons.seawar.model.actions;

import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;

public abstract class Move extends Action {
	protected final Boat boat;
	protected final Case target;
	public Move(Boat boat,Case target){
		super();
		this.boat=boat;
		this.target=target;
		
		
	}

	
	public Boat getBoat() {
		
		return boat;
		
		
	}
	
	public Case getTarget() {
		return target;
		
	}
	
	
	
}
