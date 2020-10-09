package tpe;

import java.util.List;

public class Juego {
	Mazo mazo;
	Jugador jugador1;
	Jugador jugador2;
	
	public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2) {
		this.mazo = mazo;
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
	}
	public Mazo getMazo() {
		return mazo;
	}
	
	
	public void setMazo(Mazo mazo) {
		this.mazo = mazo;
	}
	public Jugador getJugador1() {
		return jugador1;
	}
	public void setJugador1(Jugador jugador1) {
		this.jugador1 = jugador1;
	}
	public Jugador getJugador2() {
		return jugador2;
	}
	public void setJugador2(Jugador jugador2) {
		this.jugador2 = jugador2;
	}
	
	
	//Repartir las cartas>>>>>
	//   necesito saber cuantas cartas hay>>>>
	//         dividirlas a la mitad>>>>
	//				asignar la primer mitad a jugador1
	//					aignar la segunda mitad a jugador2
	
	public void repartirCartas(Mazo mm, Jugador j1, Jugador j2) {
		int cantidadCartas = mm.cantidadCartas();
		int mitad = cantidadCartas/2;
		if((cantidadCartas % 2) == 0) {
			darCantidadCartas(mm, j1, mitad);
			darCantidadCartas(mm, j2, mitad);
		}else {
			darCantidadCartas(mm, j1, mitad+1);
			darCantidadCartas(mm, j2, mitad);
		}
	}
	
	public void darCantidadCartas(Mazo mm, Jugador jugador, int cantidad) {
		List<Carta> cartasDeJugador = mm.dameNCartas(cantidad);	
	}
	
	public boolean juegoTerminado() {
		return (jugador1.getCartasSize() == 0) || (jugador2.getCartasSize() == 0);
	}
	
	public void compararCartas(Atributo atributoElegido) {
		Carta cartaJ1 = jugador1.elegirCarta();
		Carta cartaJ2 = jugador2.elegirCarta();

		double valorCarta1 = cartaJ1.valorDelAtributo(atributoElegido.getNombre());
		double valorCarta2 = cartaJ2.valorDelAtributo(atributoElegido.getNombre());
		
		/*
		 * Si valor1 > valor2
		 *    j1 se lleva la carta 2 (agrega la carta 2 a su mazo)
		 *  si valor2> valor1
		 *    j2 se lleva la carta 1 (agrega la carta 1 a su mazo)
		 *  si EMPATAN 
		 *     mandar las cartas atras del maso
		 *      elegir nuevo atributo? (COSULTAR)
		 *     volver a comparar cartas
		 */

	}
	
	
	
}
