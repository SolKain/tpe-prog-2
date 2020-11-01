package tpe;

public class Principal {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		mazo.addPocima(new PocimaValorFijo(200));
		mazo.addPocima(new PocimaValorFijo(200));
		mazo.addPocima(new PocimaValorFijo(200));
		mazo.addPocima(new PocimaIncremento(1.5));
		mazo.addPocima(new PocimaIncremento(0.3));
		mazo.addPocima(new PocimaIncremento(1.1));
		mazo.addPocima(new PocimaSelectiva("fuerza", 1.5));
		mazo.addPocima(new PocimaSelectiva("fuerza", 0.7));
		mazo.addPocima(new PocimaSelectiva("peso", 1.2));
		mazo.addPocima(new PocimaSelectiva("peso", 0.2));

		VisorMazo.cargarMazo("superheroes.json", mazo);
		
		Ambicioso ambicioso1 = new Ambicioso();
		Ambicioso ambicioso2 = new Ambicioso();
		
		Jugador jugador1 = new Jugador("Sol", ambicioso1);
		Jugador jugador2 = new Jugador("Agus", ambicioso2);
		
		
		Juego jugar = new Juego(mazo, jugador1, jugador2);
		jugar.jugarPrimeraRonda();
		
	}

}
