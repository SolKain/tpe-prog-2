package tpe;

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
		if((cantidadCartas % 2) == 0) {
			darPrimeraMitad(mm, j1);
			darSegundaMitad(mm, j2);
		}else {
			
		}
	}
	
	public void darPrimeraMitad(Mazo mm, Jugador j1) {
		int mitad = mm.cantidadCartas()/2;
		for(int i=0; i<mitad; i++) {
			Carta cc = mm.get(i);
			mm.addCarta(cc);
		}
	}
	
	public void darSegundaMitad(Mazo mm, Jugador j2) {
		
	}
	
	
}
