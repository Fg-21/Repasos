package examenHerenciaInterfaces.clases;

import examenHerenciaInterfaces.interfaces.Volumen;

/**
 * Clase MandoTV que es hija de Mando e implementa Volumen, en ella se puede
 * cambiar tanto de canal como de volumen adicionalmente a las funciones
 * definidas en su padre
 */
public class MandoTV extends Mando implements Volumen {

	/**
	 * Canal actual de la TV controlada por el mando
	 */
	private int canal = 1;

	/**
	 * Volumen actual de la TV controlada por el mando
	 */
	private int volumen = 0;

	/**
	 * Constructor del Mando de la TV con todos sus atributos menos el precio
	 * 
	 * @param modelo  Modelo del Mando de la TV
	 * @param altura  Altura del Mando de la TV
	 * @param anchura Anchura del Mando de la TV
	 * @param onOff   Estado de la TV
	 * @param canal   Canal de la TV
	 * @param volumen Volumen de la TV
	 */
	public MandoTV(String modelo, double altura, double anchura, boolean onOff, int canal, int volumen) {
		super(modelo, altura, anchura, onOff);
		this.canal = canal;
		this.volumen = volumen;
	}

	/**
	 * Constructor del Mando de la TV con todos sus atributos
	 * 
	 * @param modelo  Modelo del Mando de la TV
	 * @param altura  Altura del Mando de la TV
	 * @param anchura Anchura del Mando de la TV
	 * @param precio  Precio del Mando de la TV. No puede ser Negativo
	 * @param onOff   Estado de la TV
	 * @param canal   Canal de la TV
	 * @param volumen Volumen de la TV
	 */
	public MandoTV(String modelo, double altura, double anchura, double precio, boolean onOff, int canal, int volumen) {
		super(modelo, altura, anchura, precio, onOff);
		this.canal = canal;
		this.volumen = volumen;

	}

	/**
	 * Getter del Canal actual de la TV
	 * 
	 * @return Devuelve el Canal actual de la TV
	 */
	public int getCanal() {
		return canal;
	}

	/**
	 * Getter del Volumen actual de la TV
	 * 
	 * @return Devuelve el Volumen actual de la TV
	 */
	public int getVolumen() {
		return volumen;
	}

	/**
	 * Metodo para cambiar el canal de la TV al pasado por parámetro, este canal no
	 * puede ser negativo
	 * 
	 * @param canal Canal a cambiar. No puede ser negativo
	 * @return True si se ha cambiado el canal y false en caso contrario
	 */
	public boolean cambiarCanal(int canal) {
		boolean changed = false;
		if (canal > 0) {
			this.canal = canal;
			changed = true;
		}
		return changed;
	}

	/**
	 * Metodo para subir el Volumen de la TV de 5 en 5
	 * 
	 * @return True si se ha podido subir el volumen (Si este no esta al máximo) y
	 *         false en caso contrario
	 */
	@Override
	public boolean subirVolumen() {
		boolean subido = false;

		if (this.volumen < 100) {
			this.volumen += 5;
			subido = true;
		}
		return subido;
	}

	/**
	 * Metodo para bajar el volumen de la TV de 5 en 5
	 * @return True si se ha podido bajar el volumen (Si este no esta al mínimo) y
	 * false en caso contrario
	 */
	@Override
	public boolean bajarVolumen() {
		boolean bajado = false;

		if (this.volumen > 0) {
			this.volumen -= 5;
			bajado = true;
		}
		return bajado;
	}

	/**
	 * Metodo para mostrar todos los atributos de MandoTV por consola
	 */
	@Override
	public String toString() {
		String res = super.toString() + " Canal: " + this.canal + " Volumen: " + this.volumen;
		return res; 
	}

}
