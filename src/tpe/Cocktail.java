package tpe;

import java.util.ArrayList;

public class Cocktail extends Pocima {

	private ArrayList<Pocima> pocimas;
	
	public Cocktail(String nombrePocima) {
		super(nombrePocima);
		pocimas = new ArrayList<Pocima>();
	}
	
	public void addPocima(Pocima pocima) {
		pocimas.add(pocima);
	}
	
	@Override
	public Carta aplicarPocima(Carta carta) {
		
		for(Pocima pocima: pocimas) {
			pocima.aplicarPocima(carta);
		}
		
		return carta;
	}

}
