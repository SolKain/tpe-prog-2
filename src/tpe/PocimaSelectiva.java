package tpe;

import java.util.ArrayList;

public class PocimaSelectiva extends Pocima {

	private double incremento;
	private String nombre;
	
	public PocimaSelectiva(String nombrePocima, String nombre, double incremento) {
		super(nombrePocima);
		this.incremento = incremento;
		this.nombre = nombre;
	}
	
	@Override
	public Carta aplicarPocima(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		
		for(Atributo atributo: atributos) {
			if(atributo.getNombre().equals(nombre)) {
				atributo.setValor(atributo.getValor()*incremento);
			}
		}
		
		return carta;
	}

	public void setValorAplicado(double valor) {
		incremento = valor;
	}
}
