package tpe;

public class Jugador {

	private String nombre;
	private double puntos;
	private Mazo cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre; 
		puntos =  0;
		cartas = new Mazo();
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
	
	public Mazo getCartas(){
		return cartas;
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
			return this.cartas.getCarta();
		}
		return null;
	}
	
	/*
	 * primero me devuelvo el indice del atributoRandom
	 * 		una vez que lo obtengo
	 * 			buscar el atributo que se haya en ese indice
	 * 				(funcionalidad de carta)
	 */
	public Atributo elegirAtributoRandom(Carta c1) {
		//tuve que castear el mathRandom a int porque me devolvia un double
		int atributoRandom = (int) (Math.random()* (c1.cantidadAtributos()-1));
		Atributo atributoElegido = c1.obtenerAtributoPorIndice(atributoRandom);
		
		return atributoElegido;
	}
	
	/*
	 * persona eligio carta
	 * persona eligio atributo
	 * verificar q el jugador haya ganado
	 * agregar la carta del otro jugador a las suyas 
	 */
	
	
	public void ganador(Carta cc) {
		this.cartas.addCarta(cc);
	}
	
	public void perdedor(Carta cc) {
		this.cartas.removeCarta(cc);
	}
}
