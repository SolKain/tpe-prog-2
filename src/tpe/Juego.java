package tpe;

import java.util.List;
import java.util.Collections;

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
	
	//ESTE METODO ES SOLAMENTE PARA LA PRIMER RONDA
	public void jugarPrimeraRonda(){
		Collections.shuffle(mazo); 
		repartirCartas(mazo, jugador1, jugador2);
		Carta c1 = jugador1.elegirCarta();
		Carta c2 = jugador2.elegirCarta();
		Atributo a = jugador1.elegirAtributoRandom(c1); 
		compararCartas(c1, c2, a);
		Jugador ganador = getGanador(); //obtengo el ganador, y le doy la carta del perdedor
		Jugador perdedor = getPerdedor(); //obtengo el perdedor, y le saco la carta 
		mostrarPorConsola(jugador1, jugador2, c1, c2, a, ganador);
		if(juegoTerminado()){
			System.out.println("Juego terminado");
		}
		else{
			jugarSiguienteRonda(ganador, perdedor);
		}
	}
	
	//ESTE VA A SER PARA LAS SIGUIENTES RONDAS
	public void jugarSiguienteRonda(Jugador ganador, Jugador perdedor){
		Carta c1 = ganador.elegirCarta();
		Carta c2 = perdedor.elegirCarta();
		Atributo a = ganador.elegirAtributoRandom(c1);
		compararCartas(c1, c2, a);
		Jugador ganador = getGanador(); //obtengo el ganador, y le doy la carta del perdedor
		Jugador perdedor = getPerdedor(); //obtengo el perdedor, y le saco la carta q perdio
		//deberiamos aca imprimir los toString d las clases
		mostrarPorConsola(ganador, perdedor, c1, c2, a, ganador);

		if(juegoTerminado()){
			System.out.println("Juego terminado");
		}
		else{
			jugarSiguienteRonda(ganador, perdedor); 
		}
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
	
	public void compararCartas(Carta c1, Carta c2, Atributo atributoElegido) {

		double valorCarta1 = c1.valorDelAtributo(atributoElegido.getNombre());
		double valorCarta2 = c2.valorDelAtributo(atributoElegido.getNombre());
		
		if(valorCarta1>valorCarta2) {
			jugador1.ganador(c2);
			jugador2.perdedor(c2);
		}else if(valorCarta1<valorCarta2) {
			jugador2.ganador(c1);
			jugador1.perdedor(c1);
		} else if(valorCarta1==valorCarta2) {
			//mandar las cartas atras del mazo
			compararCartas(atributoElegido);
		}

		 //      elegir nuevo atributo? (COSULTAR)


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
