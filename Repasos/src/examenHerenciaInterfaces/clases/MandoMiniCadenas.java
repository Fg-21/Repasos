package examenHerenciaInterfaces.clases;

import examenHerenciaInterfaces.interfaces.Volumen;

/**
 * Clase de MandoMiniCadenas que hereda de Mando e implementa Volumen, Puede
 * cambiar el volumen a parte de los metodos definidos en la clase padre y lo
 * cambia de 10 en 10. Esta clase no tiene canal y por lo tanto no puede
 * cambiarlo.
 */
public class MandoMiniCadenas extends Mando implements Volumen{
	/**
	 * Volumen de la Mini cadena que controla el Mando. Valor por defecto en 0
	 */
	private int volumen = 0;

	/**
	 * Constructor del Mando de la Mini Cadena con todos sus atributos menos el precio
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param volumen Volumen de la Mini Cadena
	 */
	public MandoMiniCadenas(String modelo, double altura, double anchura, boolean onOff, int volumen) {
		super(modelo, altura, anchura, onOff);
		this.volumen = volumen;
	}

	/**
	 * Constructor del Mando de la Mini Cadena con trodos sus atributos
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param precio  Precio del mando. No puede ser nagativo
	 * @param volumen Volumen de la Mini Cadena
	 */
	public MandoMiniCadenas(String modelo, double altura, double anchura, double precio, boolean onOff, int volumen) {
		super(modelo, altura, anchura, precio, onOff);
		this.volumen = volumen;
	}

	/**
	 * Getter del Volumen de la Mini Cadena
	 * @return Devuelve el Volumen de la Mini Cadena
	 */
	public int getVolumen() {
		return volumen;
	}

	/**
	 * Metodo para subir el Volumen de la Mini Cadena de 10 en 10
	 * 
	 * @return True si se ha podido subir el volumen (Si este no esta al máximo) y
	 *         false en caso contrario
	 */
	@Override
	public boolean subirVolumen() {
		boolean subido = false;

		if (this.volumen < 100) {
			this.volumen += 10;
			subido = true;
		}
		return subido;
	}

	/**
	 * Metodo para bajar el volumen de la Mini Cadena de 10 en 10
	 * @return True si se ha podido bajar el volumen (Si este no esta al mínimo) y
	 * false en caso contrario
	 */
	@Override
	public boolean bajarVolumen() {
		boolean bajado = false;

		if (this.volumen > 0) {
			this.volumen -= 10;
			bajado = true;
		}
		return bajado;
	}
	
	/**
	 * Metodo para mostrar todos los atributos de MandoMiniCadena por consola
	 */
	@Override
	public String toString() {
		String res = super.toString() + " Volumen: " + this.volumen;
		return res; 
	}
	
	
}
