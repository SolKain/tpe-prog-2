package tpe;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
	private ArrayList<Carta> mazo;

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
	

	public int cantidadCartas() {
		return mazo.size();
	}

	public boolean mismosAtributos(Carta carta) {
		if(!(mazo.isEmpty())) {
			if(mazo.get(0).equals(carta)){
				return true;
			}
		} 
		return false;
		
	}
	
	public List<Carta> dameNCartas(int cantidad){
		List<Carta> cartasJugador = new ArrayList<>();
		for (int i=0; i<cantidad; i++) { // por cada carta , cantidad de veces
			Carta cartaActual = mazo.get(0);
			mazo.remove(0);
			cartasJugador.add(cartaActual);
		}
		return cartasJugador;
	}
	
}
		


