package tpe;

import java.util.ArrayList;

public class Obstinado implements Estrategia {
//elige el atributo que quiere
	
	private String atributo;
	
	public Obstinado(String atributo) {
		this.atributo = atributo;
	}
	
	//tengo que buscar el atributo con el nombre que me pasa el constructor
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
