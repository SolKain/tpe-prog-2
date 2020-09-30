package tpe;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private double puntos;
	
	public Jugador(String nombre) {
		this.nombre = nombre; 
		puntos =  0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPuntos() {
		return puntos;
	}


	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	
	//jugador selecciona primer carta
	//jugador selecciona atributo random
	
	
	/*para elegir una carta
	 *	tiene que chequear q tiene cartas
	 *		si tiene
	 *			obtenerla --> carta en indice 0 ya q siempre agarra la primera
	 */
	public Carta elegirCarta() {
		if(this.cartas!=null) {
			return cartas.get(0);
		}
		return null;
	}
	
	public Atributo elegirAtributoRandom(Carta c1) {
		//me va a devolver el indice d uno de los atributos
		double atributoRandom = (Math.random()* (c1.cantidadAtributos()-1));
		//debo buscar en X indice, cual es el atributo
		
	}
	
	
	
}
