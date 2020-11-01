package tpe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {
	private ArrayList<Carta> mazo;
	private ArrayList<Pocima> pocimas;

	public Mazo() {
		mazo = new ArrayList<Carta>();
		pocimas = new ArrayList<Pocima>();
	}
	
	public Mazo(int cantidad) {
		mazo = new ArrayList<>();
	}
	
	public boolean contieneCarta(Carta carta) {
		return this.mazo.contains(carta);
	}

	public void addCarta(Carta carta) {
		if (mazo.isEmpty() || mismosAtributos(carta)) {
			mazo.add(carta);
		}
	}
	
	public void addPocima(Pocima pocima) {
		pocimas.add(pocima);
	}
	
	public void removeCarta(Carta cc) {
		mazo.remove(cc);
	}

	public int cantidadCartas() {
		return mazo.size();
	}

	public boolean mismosAtributos(Carta carta) {
		return (!(mazo.isEmpty()) && mazo.get(0).mismosAtributos(carta));
		
	}
	
	public List<Carta> dameNCartas(int cantidad){
		List<Carta> cartasJugador = new ArrayList<>();
		for (int i=0; i<cantidad; i++) { 
			Carta cartaActual = mazo.get(0);
			mazo.remove(0);
			cartasJugador.add(cartaActual);
		}
		return cartasJugador;
	}
	
	public Carta getCarta() {
		Carta c = mazo.get(0);	
		return c;
	}
	
	public void mezclar() {
		Collections.shuffle(mazo);
	}
	
	public void removePocima(Pocima pocima) {
		pocimas.remove(pocima);
	}
	
	public void aplicarPocima() {		
		for(Pocima pocima: pocimas) {
			int indice = (int) Math.random()*(mazo.size()-1);
			Carta carta = mazo.get(indice);
				pocima.aplicarPocima(carta);
				carta.setPocima(pocima);
		}
		pocimas.clear();
	}
	
	public void mandarCartaAlFinal(Carta carta) {
		removeCarta(carta);
		mazo.add(carta);
	}
	
}
		
		
	

		


