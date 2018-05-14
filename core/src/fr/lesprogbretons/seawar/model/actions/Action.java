package fr.lesprogbretons.seawar.model.actions;

import fr.lesprogbretons.seawar.model.Partie;

public abstract class Action {
	
	public abstract Object clone();

	public abstract void apply(Partie state);
	
	public abstract String toString();

}
