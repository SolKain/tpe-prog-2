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
	// aca guardas en la lista cantidad de cartas
		return laLista;
	}
	
}
		


