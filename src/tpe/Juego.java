package tpe;

import java.util.List;

public class Juego {
	private static final int MAXIMO_RONDAS = 10;
	private Mazo mazo;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador ganadorRonda;
	private Jugador perdedorRonda;
	private int numeroRonda;
	
	
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
	
	//ESTE METODO ES SOLAMENTE PARA LA PRIMER RONDA
	public void jugarPrimeraRonda(){
		mazo.mezclar();
		repartirCartas(mazo, jugador1, jugador2);

		numeroRonda=0;
		jugarSiguienteRonda();

		Carta c1 = jugador1.elegirCarta();
		Carta c2 = jugador2.elegirCarta();
		Atributo a = jugador1.elegirAtributoRandom(c1); 
		compararCartas(c1, c2, a);
		mostrarPorConsola(jugador1, jugador2, c1, c2, a, ganador);
		if(juegoTerminado()){
			System.out.println("Juego terminado");
		}
		else{
			jugarSiguienteRonda();
		}
	}
	
	//ESTE VA A SER PARA LAS SIGUIENTES RONDAS
	public void jugarSiguienteRonda(){
		Carta c1 = ganadorRonda.elegirCarta();
		Carta c2 = perdedorRonda.elegirCarta();
		Atributo a = ganadorRonda.elegirAtributoRandom(c1);
		compararCartas(c1, c2, a);
		numeroRonda++;
		//deberiamos aca imprimir los toString d las clases
		mostrarPorConsola(ganador, perdedor, c1, c2, a, ganador);

		if(juegoTerminado()){
			obtenerGanadorTotal();
			System.out.println("Juego terminado");
		}
		else{
			jugarSiguienteRonda(); 
		}
	}
		
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
		for (Carta carta : cartasDeJugador) {
			jugador.addCarta(carta);
		}
	}
	
	public boolean juegoTerminado() {
		return ((perdedorRonda.getCartasSize() == 0) || (ganadorRonda.getCartasSize() == 0)|| (numeroRonda == MAXIMO_RONDAS));
	}
	
	public Jugador obtenerGanadorTotal() {
		if(numeroRonda == MAXIMO_RONDAS) {
			if(perdedorRonda.getCartasSize()<ganadorRonda.getCartasSize()){
				return ganadorRonda;
				
			}else if(perdedorRonda.getCartasSize()>ganadorRonda.getCartasSize()) {
				return perdedorRonda;
			}else {
				return null;
			}
		}else {
			if(ganadorRonda.getCartasSize()==0) {
				return perdedorRonda;
			}else {
				return ganadorRonda;
			}
		}
		
	}
	
	public void compararCartas(Carta c1, Carta c2, Atributo atributoElegido) {

		double valorCarta1 = c1.valorDelAtributo(atributoElegido.getNombre());
		double valorCarta2 = c2.valorDelAtributo(atributoElegido.getNombre());
		
		if(valorCarta1>valorCarta2) {
			jugador1.ganador(c2);
			jugador2.perdedor(c2);
			ganadorRonda=jugador1;
			perdedorRonda=jugador2;
			
		}else if(valorCarta1<valorCarta2) {
			jugador2.ganador(c1);
			jugador1.perdedor(c1);
			ganadorRonda=jugador2;
			perdedorRonda=jugador1;
			
		} else if(valorCarta1==valorCarta2) {
			//mandar las cartas atras del mazo
			//jugarSiguienteRonda()
		}

	}
		
	
	
	public String mostrarPorConsola(Jugador j1, Jugador j2, Carta c1, Carta c2, Atributo a, Jugador ganador) {
		return "El jugador " + j1.getNombre() + " selecciona competir por el atributo " +a.getNombre()+
		"La carta de " + j1.getNombre() + " es " + c1.getPersonaje() + " con " + a.getNombre() + c1.valorDelAtributo(a.getNombre()) +
		"La carta de " + j2.getNombre() + " es " + c2.getPersonaje() + " con " + a.getNombre() + c2.valorDelAtributo(a.getNombre()) +
		"Gana la ronda " + ganador.getNombre() +
		j1.getNombre() + "posee ahora " + j1.getCartasSize() + " cartas y " + j2.getNombre() + " posee ahora " + j2.getCartasSize() + " cartas";
	}
	
	
	
	/*
	 El jugador Juan selecciona competir por el atributo fuerza
La carta de Juan es Flash con fuerza 840
La carta de María es Superman con fuerza 2000
Gana la ronda María.
María posee ahora 11 cartas y Juan posee ahora 9 cartas
	 */
	
	
	
	
	
}
