package tpe;

import java.util.ArrayList;

public class Mazo {
	private int cantidad;
	private ArrayList<Carta> mazo;

	public Mazo(int cantidad) {
		this.cantidad = cantidad;
		mazo = new ArrayList<>();
	}
	
	public boolean contieneCarta(Carta cc) {
		return this.mazo.contains(cc);
	}

	public void addCarta(Carta cc) {
		if () {
			mazo.add(cc);
		} else {
			if () {
				mazo.add(cc);
			}
		}
	}

	public int cantidadCartas() {
		return this.mazo.size();
	}

	public boolean perteneceAlMazo(Carta cc) {

	}

}
