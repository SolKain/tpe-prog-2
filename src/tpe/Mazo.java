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
	
	public Carta getCarta() {
		mazo.get(0);	
	}
		
		/*   SI QUISIESE RETORNAR UN MAZO
		Mazo copiaMazo = new Mazo();
		for(int i =0; i<mazo.size();i++) {
			Carta cc = mazo.get(i);
			copiaMazo.addCarta(cc);
		*/		
	}
	
}
		


