package fr.lesprogbretons.seawar.ia.groupe_z;

import fr.lesprogbretons.seawar.ia.AbstractIA;
import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.ia.groupe_z.util.State;

import java.util.List;

public class IA extends AbstractIA {

    public IA(int number){
        super(number);
    }
    public IA(int number, String name){
        super(number, name);
    }
    public IA(int number, String name, List<Boat> boats){
        super(number, name, boats);
    }
    @Override

    public Action chooseAction(Partie partie) {
        State state = new State(getName(), partie);
        state.createArbre(1, partie);
        state.alphabeta(999, -999);
        return state.analyseBetterChoice(state.getAlpha());
    }


}
