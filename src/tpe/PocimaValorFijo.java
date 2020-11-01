package tpe;

import java.util.ArrayList;

public class PocimaValorFijo extends Pocima {

	private double valorAplicado;
	
	public PocimaValorFijo(String nombrePocima, double valorAplicado) {
		super(nombrePocima);
		this.valorAplicado = valorAplicado;
	}
	
	@Override
	public Carta aplicarPocima(Carta carta) {
		ArrayList<Atributo> atributos = carta.getAtributos();
		
		for(Atributo atributo: atributos) {
			atributo.setValor(valorAplicado);
		}
		
		return carta;
	}

}
