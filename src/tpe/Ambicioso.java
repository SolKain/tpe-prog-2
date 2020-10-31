package tpe;

import java.util.ArrayList;

public class Ambicioso implements Estrategia {
//elige atributo con mayor valor
	
	public Atributo elegirAtributo(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		double grande = 0;
		Atributo mayor = null;
		
		for(Atributo atributo: atributos) {
			double valor = atributo.getValor();
			if(valor>grande) {
				grande = valor;
				mayor = atributo;
			}
		}
		return mayor;
	}
}
