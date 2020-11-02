package tpe;

import java.util.List;

public class Juego {
	private static final int MAXIMO_RONDAS = 20;
	private Mazo mazo;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador ganadorRonda;
	private Jugador perdedorRonda;
	private int numeroRonda;
	
	public Juego(Mazo mazo, Jugador jugador1, Jugador jugador2) {
		this.mazo = mazo;
		this.jugador1 = jugador1;
		this.ganadorRonda = jugador1;
		this.jugador2 = jugador2;
		this.perdedorRonda = jugador2;
		numeroRonda=1;
	}
	
	public void jugarPrimeraRonda(){
		mazo.mezclar();
		repartirCartas(mazo, jugador1, jugador2);

		jugarSiguienteRonda();	
	}
	
	public void jugarSiguienteRonda(){
		Carta c1 = ganadorRonda.elegirCarta();
		Carta c2 = perdedorRonda.elegirCarta();
		Atributo atributo = ganadorRonda.aplicarEstrategia(c1);
		System.out.print(mostrarPrimeraParte(c1, c2, atributo, numeroRonda));
		compararCartas(c1, c2, atributo);
		numeroRonda++;

		System.out.println(mostrarSegundaParte(c1, c2, atributo));

		if(juegoTerminado()){
			System.out.println("Juego terminado");
			System.out.println("El ganador del juego es " + obtenerGanadorTotal().getNombre());
		}
		else{
			jugarSiguienteRonda(); 
		}
	}
		
	public void repartirCartas(Mazo mazo, Jugador j1, Jugador j2) {
		mazo.aplicarPocima();
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
	
	public void compararCartas(Carta cartaGanador, Carta cartaPerdedor, Atributo atributoElegido) {

		double valorCartaGan = cartaGanador.valorDelAtributo(atributoElegido.getNombre());
		double valorCartaPer = cartaPerdedor.valorDelAtributo(atributoElegido.getNombre());
		
		if(valorCartaGan>valorCartaPer) {
			ganadorRonda.ganador(cartaPerdedor);
			perdedorRonda.perdedor(cartaPerdedor);			
		}else if(valorCartaGan<valorCartaPer) {
			perdedorRonda.ganador(cartaGanador);
			ganadorRonda.perdedor(cartaGanador);
			intercambiarGanador();
			
		} else if(valorCartaGan==valorCartaPer) {
			ganadorRonda.getCartas().mandarPrimerCartaAlFinal();
			perdedorRonda.getCartas().mandarPrimerCartaAlFinal();
			System.out.println("Hubo empate en esta ronda");
		}
	}
	
	private void intercambiarGanador() {
		Jugador jugadorTemporal = ganadorRonda;
		ganadorRonda=perdedorRonda;
		perdedorRonda=jugadorTemporal;
	}	
	
	public String mostrarPrimeraParte(Carta c1, Carta c2, Atributo atributo, int numeroRonda) {
	String linea1 = "---Ronda numero "+ numeroRonda + "--- \n" + "El jugador " + ganadorRonda.getNombre() + " selecciona competir por el atributo " +atributo.getNombre()+"\n";
	String linea2 = calcularMensaje(c1, atributo, ganadorRonda);
	String linea3 = calcularMensaje(c2, atributo, perdedorRonda);
	return linea1 + linea2 + linea3;
	}
	
	public String mostrarSegundaParte(Carta c1, Carta c2, Atributo atributo) {
		String linea1= "Gana la ronda " + ganadorRonda.getNombre() + "\n";
	    String linea2= ganadorRonda.getNombre() + " posee ahora " + ganadorRonda.getCartasSize() + " cartas y " + perdedorRonda.getNombre() + " posee ahora " + perdedorRonda.getCartasSize() + " cartas";
	    return linea1 + linea2;
	}
	
	private String calcularMensaje(Carta c1, Atributo atributo, Jugador jugador) {
		String linea2 = "La carta de " + jugador.getNombre() + " es " + c1.getPersonaje() + " con " + atributo.getNombre() +" " + c1.obtenerValorAnterior(atributo.getNombre());
		if (c1.getPocima()!=null)
			return linea2 + ", se aplico la pocima "+ c1.getPocima()+ " con valor resultante "+ c1.valorDelAtributo(atributo.getNombre())+"\n";
		return linea2 + "\n";
	}
	
}
