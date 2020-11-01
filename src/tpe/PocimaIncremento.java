package tpe;

import java.util.ArrayList;

public class PocimaIncremento extends Pocima {

	private double valorAplicado;
	
	public PocimaIncremento(String nombrePocima, double valorAplicado) {
		super(nombrePocima);
		this.valorAplicado = valorAplicado;
	}
	
	@Override
	public Carta aplicarPocima(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		
		for(Atributo atributo: atributos) {
			atributo.setValor(atributo.getValor()*valorAplicado);
		}
		
		return carta;
	}
	
	public void setValorAplicado(double valor) {
		valorAplicado = valor;
	}
	
}

