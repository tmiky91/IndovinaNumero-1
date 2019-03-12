package it.polito.tdp.numero.model;

import java.security.InvalidParameterException;

public class Model {
	
	private final int NMAX = 100;
	private final int TMAX = 8;

	private int segreto;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public Model() {
		inGioco=false;
	}
	
	public void newGame() {
		// Gestisce l'inizio di una nuova partita

		// Logica del gioco
		this.segreto = (int) (Math.random() * NMAX) + 1;
		this.tentativiFatti = 0;
		inGioco=true;
	}
	
	public int tentativo(int t) {
		//controllo  se la partita � in corso
		if(!inGioco) {
			throw new IllegalStateException("La partita � finita!");
		}
		//controllo se l'input � nel range corretto
		if(!tentativoValido(t)) {
			throw new InvalidParameterException(String.format("Devi inserire un numero tra %d e %d",1,NMAX));
		}
		//gestisci tentativo
		this.tentativiFatti++;
		if(tentativiFatti==this.TMAX) {
			//la partita � finita perch� ho esaurito i tentativi
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
