package tpe;

import java.util.ArrayList;

public class Obstinado implements Estrategia {
	
	private String atributo;
	
	public Obstinado(String atributo) {
		this.atributo = atributo;
	}
	
	public Atributo elegirAtributo(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		
		for(Atributo atributo: atributos) {
			if(atributo.getNombre().equals(this.atributo)) {
				return atributo;
			}
		}
		
		return null;
	}
}
