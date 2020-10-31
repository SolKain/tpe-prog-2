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
		Atributo atributo = jugador1.aplicarEstrategia(c1); 
		compararCartas(c1, c2, atributo);
		mostrarPorConsola(c1, c2, atributo, numeroRonda);
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
		Atributo atributo = ganadorRonda.aplicarEstrategia(c1);
		compararCartas(c1, c2, atributo);
		numeroRonda++;

		mostrarPorConsola(c1, c2, atributo, numeroRonda);

		if(juegoTerminado()){
			obtenerGanadorTotal();
			System.out.println("Juego terminado");
		}
		else{
			jugarSiguienteRonda(); 
		}
	}
		
	public void repartirCartas(Mazo mazo, Jugador j1, Jugador j2) {
		//antes de repartir tengo que aplicar la pocima
		mazo.aplicarPocima();
		//ahora reparto
		int cantidadCartas = mazo.cantidadCartas();
		int mitad = cantidadCartas/2;
		if((cantidadCartas % 2) == 0) {
			darCantidadCartas(mazo, j1, mitad);
			darCantidadCartas(mazo, j2, mitad);
		}else {
			darCantidadCartas(mazo, j1, mitad+1);
			darCantidadCartas(mazo, j2, mitad);
		}
	}
	
	public void darCantidadCartas(Mazo mazo, Jugador jugador, int cantidad) {
		List<Carta> cartasDeJugador = mazo.dameNCartas(cantidad);	
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
			//Se mandarian atras del mazo
			System.out.println("Hubo empate en esta ronda");
			jugarSiguienteRonda();
		}

	}	
	
	
	public String mostrarPorConsola(Carta c1, Carta c2, Atributo atributo, int numeroRonda) {
		return "---Ronda numero "+ numeroRonda + "--- /n" + "El jugador " + ganadorRonda.getNombre() + " selecciona competir por el atributo " +atributo.getNombre()+"/n"+
		"La carta de " + ganadorRonda.getNombre() + " es " + c1.getPersonaje() + " con " + atributo.getNombre() + c1.valorDelAtributo(atributo.getNombre()) +"/n"+
		"La carta de " + perdedorRonda.getNombre() + " es " + c2.getPersonaje() + " con " + atributo.getNombre() + c2.valorDelAtributo(atributo.getNombre()) + "/n"+
		"Gana la ronda " + ganadorRonda.getNombre() + "/n"+
		ganadorRonda.getNombre() + "posee ahora " + ganadorRonda.getCartasSize() + " cartas y " + perdedorRonda.getNombre() + " posee ahora " + perdedorRonda.getCartasSize() + " cartas";
	}
	
}
