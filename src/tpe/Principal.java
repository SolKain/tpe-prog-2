package tpe;

public class Principal {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		mazo.addPocima(new PocimaValorFijo("Valor fijo", 200));
		mazo.addPocima(new PocimaValorFijo("Valor fijo", 200));
		mazo.addPocima(new PocimaValorFijo("Valor fijo", 200));
		mazo.addPocima(new PocimaValorFijo("Valor fijo", 200));
		mazo.addPocima(new PocimaIncremento("Pocima incremento", 1.5));
		mazo.addPocima(new PocimaIncremento("Pocima incremento", 1.7));
		mazo.addPocima(new PocimaIncremento("Pocima incremento", 0.3));
		mazo.addPocima(new PocimaIncremento("Pocima incremento", 1.1));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "fuerza", 1.5));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "fuerza", 0.7));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "peso", 1.2));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "peso", 0.2));
		mazo.addPocima(new Cocktail("Pocima Cocktail"));
		mazo.addPocima(new Cocktail("Pocima Cocktail"));
		
		
		VisorMazo.cargarMazo("superheroes.json", mazo);
		
		Ambicioso ambicioso1 = new Ambicioso();
		Ambicioso ambicioso2 = new Ambicioso();
		
		Jugador jugador1 = new Jugador("Sol", ambicioso1);
		Jugador jugador2 = new Jugador("Agus", ambicioso2);
		
		
		Juego jugar = new Juego(mazo, jugador1, jugador2);
		jugar.jugarPrimeraRonda();
		
	}

}
