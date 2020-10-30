package tpe;

public class Atributo {

	private String nombre; 
	private double valor;
	
	public Atributo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor=valor;
	}
	
	/*public boolean esMayor(Atributo a1, Atributo a2) {
		//retorna si el valor d un atributo es mayor q el d un segundo atributo
		return a1.getValor()>a2.getValor();
	}*/
	
	
	@Override
	public boolean equals(Object obj) {
		Atributo otroAtr = (Atributo) obj;
		return nombre.equals(otroAtr.nombre);
	}	
	
	
}
