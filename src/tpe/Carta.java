package tpe;

import java.util.ArrayList;

public class Carta {

	private ArrayList <Atributo> atributos;
	private String personaje;
	private Mazo mazoPerteneciente;
	
	public Carta(String personaje, Mazo mazoPerteneciente) {
		this.personaje = personaje;
		this.mazoPerteneciente = mazoPerteneciente;
		atributos = new ArrayList <Atributo>();
	}

	public ArrayList<Atributo> getAtributos() {
		return atributos;
	}

	public void setAtributos(ArrayList<Atributo> atributos) {
		this.atributos = atributos;
	}

	public String getPersonaje() {
		return personaje;
	}

	public void setPersonaje(String personaje) {
		this.personaje = personaje;
	}

	public Mazo getMazoPerteneciente() {
		return mazoPerteneciente;
	}

	public void setMazoPerteneciente(Mazo mazoPerteneciente) {
		this.mazoPerteneciente = mazoPerteneciente;
	}
	
	
}
