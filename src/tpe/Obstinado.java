package tpe;

public class Obstinado implements Estrategia {
//elige el atributo que quiere
	
	public Atributo atributo;
	
	public Obstinado(Atributo atributo) {
		this.atributo = atributo;
	}
	
	public Atributo elegirAtributo(Carta carta) {
		return atributo;
	}
}
