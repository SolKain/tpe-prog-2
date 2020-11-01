package tpe;

public class Jugador {

	private String nombre;
	private double puntos;
	private Mazo cartas;
	private Estrategia estrategiaJuego;
	
	public Jugador(String nombre, Estrategia estrategiaJuego) {
		this.nombre = nombre; 
		puntos = 0;
		cartas = new Mazo();
		this.estrategiaJuego = estrategiaJuego;
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
	
	public Estrategia getEstrategia() {
		return estrategiaJuego;
	}
	
	//setea la estrategia para poder cambiar en tiempo de ejecucion
	public void setEstrategia(Estrategia estrategia) {
		estrategiaJuego = estrategia;
	}
	
	public Mazo getCartas(){
		return cartas;
	}
	
	/*para elegir una carta
	 *	tiene que chequear q tiene cartas
	 *		si tiene
	 *			obtenerla --> carta en indice 0 ya q siempre agarra la primera
	 */
	public Carta elegirCarta() {
		if(this.cartas!=null) {
			return this.cartas.getCarta();
		}
		return null;
	}
	
	public void addCarta(Carta carta) {
		cartas.addCarta(carta);
	}
	
	public Atributo aplicarEstrategia(Carta carta1) {
		return estrategiaJuego.elegirAtributo(carta1);
	}
	
	public void ganador(Carta cc) {
		cartas.addCarta(cc);
		cartas.mandarCartaAlFinal(cc);
	}
	
	public void perdedor(Carta cc) {
		cartas.removeCarta(cc);
	}
	
	public int getCartasSize() {
		return this.cartas.cantidadCartas();
	}
	

}
