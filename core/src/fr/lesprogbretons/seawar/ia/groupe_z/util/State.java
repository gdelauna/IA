package fr.lesprogbretons.seawar.ia.groupe_z.util;

import fr.lesprogbretons.seawar.model.Partie;
import fr.lesprogbretons.seawar.model.Player;
import fr.lesprogbretons.seawar.model.actions.Action;
import fr.lesprogbretons.seawar.model.actions.MoveBoat;
import fr.lesprogbretons.seawar.model.boat.Boat;
import fr.lesprogbretons.seawar.model.cases.Case;
import fr.lesprogbretons.seawar.model.cases.CaseEau;
import fr.lesprogbretons.seawar.model.map.Grille;

import java.util.ArrayList;
import fr.lesprogbretons.seawar.ia.groupe_z.IA;

import static fr.lesprogbretons.seawar.SeaWar.partie;

public class State {
    private String nameIA;
    private Partie game;
    private int n;
    private boolean isTerminal;
    private ArrayList<State> fils;
    private int beta;
    private int alpha;
    private int utilite;
    private Action actionToDo;
    public State(int n, boolean t, String nameIA, Partie p){
        this.n = n;
        this.nameIA = nameIA;
        this.game = p;
        fils = new ArrayList<State>();
        isTerminal = t;
    }

    public State(String nameIA, Partie p){
        this.n = 0;
        this.nameIA = nameIA;
        this.game = p;
        fils = new ArrayList<State>();
        isTerminal = false;
    }


    private void calcUtilite(Partie partie){
        int nbPharePossedes=0, nbPhareAdverses=0;
        Grille map = partie.getMap();
        IA ia = (IA)getIA(partie, nameIA);
        Player player = getOther(partie, nameIA);
        if(isTerminal){
           nbPharePossedes = ia.getPharesPossedes();
           nbPhareAdverses = player.getPharesPossedes();
        }
        utilite = nbPharePossedes- nbPhareAdverses;
    }

    public int getBeta() {
        return beta;
    }

    public int getAlpha() {
        return alpha;
    }

    public int alphabeta(int a, int b){
        int index=0;
        State fi = null;
        if(isTerminal){
            return utilite;
        }else{
            if(isMax()){
                while(a<b && index<fils.size()){
                    fi = fils.get(index);
                    a = Math.max(a, fi.alphabeta(a,b));
                    index++;
                }
                return a;
            }else{
                while(a<b && index<fils.size()){
                    fi = fils.get(index);
                    b = Math.min(b, fi.alphabeta(a,b));
                    index++;
                }
                return b;
            }
        }
    }

    public void createArbre(int prof, Partie partie){
        Partie partieCopie;
        State fi;
        Boat boat;
        IA iaCopie;
        Case caseCopie;
        boolean isTerminal = false;
        if(prof>0){
            if(prof==1){
                isTerminal = true;
            }
            //System.out.println("Player :"+getIA(partie, nameIA)+" name:"+getIA(partie, nameIA).getName());
            boat = getIA(partie, nameIA).getBoats().get(0);
            ArrayList<Case> casesDispo = partie.getMap().getCasesDisponibles(boat.getPosition(), 1);
            for (Case c:casesDispo) {
                actionToDo = new MoveBoat(boat, c);
                partieCopie= (Partie)partie.clone();
                caseCopie = partie.getMap().getCase(c.getX(), c.getY());
                iaCopie = (IA)getIA(partieCopie, nameIA);
                if(caseCopie.isPhare()){
                    caseCopie.setPossedePhare(iaCopie);
                }
                    iaCopie.getBoats().get(0).moveBoat(caseCopie);
                fi = new State(n+1, isTerminal, nameIA, partieCopie);
                fi.calcUtilite(partieCopie);
                fils.add(fi);
            }
        }
    }

    public Action analyseBetterChoice(int alpha){
        for(State fi : fils){
            if(fi.getBeta()==alpha){
                return actionToDo;
            }
        }
        return null;
    }

    public Player getIA(Partie p, String name){
        if(p.getJoueur1().getName().equals(name)){
            return p.getJoueur1();
        }else{
            return p.getJoueur2();
        }
    }

    public Player getOther(Partie p, String name){
        if(!(p.getJoueur1().getName().equals(name))){
            return p.getJoueur1();
        }else{
            return p.getJoueur2();
        }
    }

    public boolean isMax(){
        return n%2==0;
    }

    public boolean isTerminal(){
        return isTerminal;
    }
}
