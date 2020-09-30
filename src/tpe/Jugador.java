package tpe;

import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private double puntos;
	private ArrayList <Carta> cartas;
	
	public Jugador(String nombre) {
		this.nombre = nombre; 
		puntos =  0;
		cartas = new ArrayList <Carta> ();
	}
	
	public ArrayList<Carta> getCartas(){
		return cartas;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPuntos() {
		return puntos;
	}

	public void setPuntos(double puntos) {
		this.puntos = puntos;
	}
	
	
	
}
