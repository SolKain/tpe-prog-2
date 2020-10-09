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

	public String getPersonaje() {
		return personaje;
	}

	public Mazo getMazoPerteneciente() {
		return mazoPerteneciente;
	}

	public void addAtributo(Atributo aa) {
		atributos.add(aa);
	}
	
	public void removeAtributo(Atributo aa) {
		atributos.remove(aa);
	}
	
	public Atributo getAtributo(String nombre) {
		for(int i = 0; i < atributos.size(); i++) {
			if(atributos.get(i).getNombre().equals(nombre)) 
				return atributos.get(i);
			}
				return null;
	}
	
	public boolean tieneAtributo(String nombre){
        Atributo aa = this.getAtributo(nombre);
        if(aa!=null) {
        	return true;
        }
        else {
        	return false;
        }
    }

	
	public int cantidadAtributos() {
		return atributos.size();
	}
	
	public double valorDelAtributo(String nombreAtributo) {
		for (Atributo atributo : atributos) {
			if (atributo.getNombre().equals(nombreAtributo)) {
				return atributo.getValor();
			}
		}
		return -1;
	}
	
	//busco atributo a traves de un indice q me llega por parametro
	public Atributo obtenerAtributoPorIndice(int indice) {
		return atributos.get(indice);
	}
	
	@Override
	public boolean equals(Object obj) {
		Carta otraCarta = (Carta) obj;
		int cantAtributos = 0;
		for (Atributo atributo : atributos) {
			if (otraCarta.atributos.contains(atributo))
				cantAtributos++;
		}
		return atributos.size()==otraCarta.atributos.size() && cantAtributos == atributos.size();
	}
	
	
}
