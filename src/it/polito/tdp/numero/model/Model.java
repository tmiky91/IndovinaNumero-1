package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;
import java.util.LinkedList;
import java.util.List;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	private List<Integer> tentativi;
	
	public Model() {
		inGioco=false;
		tentativi = new LinkedList<Integer>();
	}
	
	public void newGame() {
		// Gestisce l'inizio di una nuova partita

		// Logica del gioco
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
		inGioco=true;
		this.tentativi= new LinkedList<Integer>();
	}
	
	public int tentativo(int t) {
		//controllo  se la partita è in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita è finita!");
		}
		//controllo se l'input è nel range corretto
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero tra %d e %d",1,NMAX));
		}
		//gestisci tentativo
		this.tentativiFatti++;
		tentativi.add(t);
		if(tentativiFatti==this.TMAX) {
			//la partita è finita perchè ho esaurito i tentativi
			this.inGioco=false;
			
		}
		if(t==this.segreto) {
			//ho vinto
			this.inGioco=false;
			return 0;
		}
		if(t>this.segreto) {
			return 1;
		}
		return -1; //se t<this.segreto
		
	}
	
	public boolean tentativoValido(int t) {
		
		if(t<1 || t>NMAX) {
			return false;
		}
		else if(tentativi.contains(t)) {
			return false;
		}
		else {
			return true;
		}
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}

	public boolean isInGioco() {
		return inGioco;
	}

	public int getTMAX() {
		return TMAX;
	}
	
	

}
