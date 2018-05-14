package fr.lesprogbretons.seawar.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import fr.lesprogbretons.seawar.model.boat.Boat;

/**
 * Classe joueur
 */
public class Player implements Serializable{

    //Numéro du joueur
    private int number;

    //Nombre de phares qu'il possede
    private int pharesPossedes = 0;
    
    // name of the player
    private String name;

    
    //
    private  List<Boat>  boats; 
    
    /**
     * Constructeur
     * @param number
     */
    public Player(int number) {
        this.number = number;
    }


   
    

	public Player(int number, String name) {
		// TODO Auto-generated constructor stub
    	this.name= name;
    	
	}

	public Player(int number, String name, List<Boat> boats) {
		this.number=number;
		this.name=name;
		this.boats=boats;
		
		
	}
	

    public Object clone() {
    	
    	return new Player(this.number);
    	
    }
    
    
	//Getters & Setters
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPharesPossedes() {
        return pharesPossedes;
    }

    public void setPharesPossedes(int pharesPossedes) {
        this.pharesPossedes = pharesPossedes;
    }

    @Override
    public String toString() {
        return "Player " + number +"   ";
    }
    
    public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Boat> getBoats() {
		return boats;
	}

	public void setBoats(List<Boat> boats) {
		this.boats = boats;
	}

	public void addBoat(Boat boat) {
		this.boats.add(boat);
	}
    
    
}
