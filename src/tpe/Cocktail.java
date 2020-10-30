package tpe;

import java.util.ArrayList;

public class Cocktail extends Pocima {

	private ArrayList<Pocima> pocimas;
	
	public Cocktail() {
		pocimas = new ArrayList<Pocima>();
	}
	@Override
	public Carta aplicarPocima(Carta carta) {
		
		for(Pocima pocima: pocimas) {
			pocima.aplicarPocima(carta);
		}
		
		return carta;
	}

}
