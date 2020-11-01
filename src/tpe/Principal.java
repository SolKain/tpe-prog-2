package tpe;

public class Principal {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		VisorMazo visor = new VisorMazo();
		visor.cargarMazo("superheroes.json", mazo);
		
		Ambicioso ambicioso1 = new Ambicioso();
		Ambicioso ambicioso2 = new Ambicioso();
		
		Jugador jugador1 = new Jugador("Sol", ambicioso1);
		Jugador jugador2 = new Jugador("Agus", ambicioso2);
		
		
		Juego jugar = new Juego(mazo, jugador1, jugador2);
		jugar.jugarPrimeraRonda();
		jugar.jugarSiguienteRonda();
		
	}

}
