package tpe;

public class Timbero implements Estrategia {
//elige el atributo random
	
	public Atributo elegirAtributo(Carta carta) {
		int atributoRandom = (int) (Math.random()* (carta.cantidadAtributos()-1));
		Atributo atributoElegido = carta.obtenerAtributoPorIndice(atributoRandom);
		
		return atributoElegido;
	}
}
