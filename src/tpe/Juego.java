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
	
	
}
