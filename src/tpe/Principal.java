package tpe;

public class Principal {

	public static void main(String[] args) {
		
		Mazo mazo = new Mazo();
		mazo.addPocima(new PocimaValorFijo("Pocima quiero vale cuatro", 4));
		mazo.addPocima(new PocimaValorFijo("Pocima quiero vale cuatro", 4));
		mazo.addPocima(new PocimaValorFijo("Pocima numero magico", 23));
		mazo.addPocima(new PocimaValorFijo("Pocima numero magico", 23));
		mazo.addPocima(new PocimaIncremento("Pocima kriptonita", 0.25));
		mazo.addPocima(new PocimaIncremento("Pocima kriptonita", 0.25));
		mazo.addPocima(new PocimaIncremento("Pocima reductor de plomo", 0.55));
		mazo.addPocima(new PocimaIncremento("Pocima reductor de plomo", 0.55));
		mazo.addPocima(new PocimaIncremento("Pocima fortalecedora", 1.2));
		mazo.addPocima(new PocimaIncremento("Pocima fortalecedora", 1.2));
		mazo.addPocima(new PocimaIncremento("Pocima fortalecedora plus", 1.5));
		mazo.addPocima(new PocimaIncremento("Pocima fortalecedora plus", 1.5));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "fuerza", 1.35));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "fuerza", 1.35));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "peso", 1.43));
		mazo.addPocima(new PocimaSelectiva("Pocima selectiva", "peso", 1.43));
	
		Cocktail cocktail1 = new Cocktail("Cocktail");
		Cocktail cocktail2 = new Cocktail("Cocktail");		
		cocktail1.addPocima(new PocimaValorFijo("Pocima numero magico", 23));
		cocktail1.addPocima(new PocimaIncremento("Pocima reductor de plomo", 0.55));	
		cocktail2.addPocima(new PocimaSelectiva("Pocima selectiva", "fuerza", 1.35));
		cocktail2.addPocima(new PocimaIncremento("Pocima fortalecedora", 1.2));
		
		mazo.addPocima(cocktail2);
		mazo.addPocima(cocktail1);
		
		//VisorMazo.cargarMazo("superheroes.json", mazo);
		VisorMazo.cargarMazo("autos.json", mazo);
		
		
		Timbero timb1 = new Timbero();
		Timbero timb2 = new Timbero();
		
		
		Jugador jugador1 = new Jugador("Sol", timb1);
		Jugador jugador2 = new Jugador("Agus", timb2);
		
		
		Juego jugar = new Juego(mazo, jugador1, jugador2);
		jugar.jugarPrimeraRonda();
		
	}

}
