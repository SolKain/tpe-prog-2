package tpe;

import java.util.ArrayList;
import java.util.List;

public class Mazo {
	private ArrayList<Carta> mazo;

	public Mazo() {
		mazo = new ArrayList<>();
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
	
	public void removeCarta(Carta cc) {
		mazo.remove(cc);
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
	
}
		
		/*   SI QUISIESE RETORNAR UN MAZO
		Mazo copiaMazo = new Mazo();
		for(int i =0; i<mazo.size();i++) {
			Carta cc = mazo.get(i);
			copiaMazo.addCarta(cc);
		*/		
	

		


