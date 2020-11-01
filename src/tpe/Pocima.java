package tpe;

public abstract class Pocima {
	
	private String nombrePocima;
	
	public Pocima(String nombrePocima) {
		this.nombrePocima = nombrePocima;
	}
	
	public abstract Carta aplicarPocima (Carta carta);
	
	public String toString() {
		return this.nombrePocima;
	}
		
	
}
