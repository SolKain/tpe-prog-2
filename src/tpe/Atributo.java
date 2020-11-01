package tpe;

public class Atributo {

	private String nombre; 
	private double valor;
	private double valorAnterior;
	
	public Atributo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
		valorAnterior = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public double getValor() {
		return valor;
	}
	
	public double getValorAnterior() {
		return valorAnterior;
	}

	public void setValor(double valor) {
		this.valor=valor;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		Atributo otroAtr = (Atributo) obj;
		return nombre.equals(otroAtr.nombre);
	}	
	
	
}
