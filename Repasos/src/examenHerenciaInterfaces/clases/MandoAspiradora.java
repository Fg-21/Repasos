package examenHerenciaInterfaces.clases;

import examenHerenciaInterfaces.interfaces.Velocidad;

/**
 * Clase MandoAspiradora, que hereda de mando e implementa velocidad. A parte de
 * los metodos de la interfaz y los que hereda no puede realizar más acciones.
 * Su velocidad maxima de aspiracion es 3
 */
public class MandoAspiradora extends Mando implements Velocidad{
	/**
	 * Velocidad de aspiracion de la aspiradora controlada por el mando
	 */
	private int velocidadAspiracion = 0;

	/**
	 * Constructor del Mando de la aspiradora con todos sus atributos menos el precio
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param velocidadAspiracion Velocidad de Aspiracion de la Aspiradora controlada por el mando
	 */
	public MandoAspiradora(String modelo, double altura, double anchura, boolean onOff, int velocidadAspiracion) {
		super(modelo, altura, anchura, onOff);
		this.velocidadAspiracion = velocidadAspiracion;

	}

	/**
	 * Constructor del Mando de la aspiradora con todos sus atributos
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param precio Precio del mando de la aspiradora
	 * @param onOff   Estado del aparato del mando
	 * @param velocidadAspiracion Velocidad de Aspiracion de la Aspiradora controlada por el mando
	 */
	public MandoAspiradora(String modelo, double altura, double anchura, double precio, boolean onOff, int velocidadAspiracion) {
		super(modelo, altura, anchura, precio, onOff);
		this.velocidadAspiracion = velocidadAspiracion;
	}

	/**
	 * Getter de la velocidad de Aspiracion de la Aspiradora controlada por el mando
	 * @return Devuelve la velocidad de Aspiracion de la Aspiradora controlada por el mando
	 */
	public int getVelocidadAspiracion() {
		return velocidadAspiracion;
	}

	/**
	 * Metodo que sube la velocidad de aspiracion de la aspiradora
	 * @return True si se ha subido y false en caso contrario
	 */
	@Override
	public boolean subeVelocidad() {
		boolean changed = false;
		if (this.velocidadAspiracion < 3) {
			this.velocidadAspiracion++;
		}
		return changed;
	}
	
	/**
	 * Metodo que baja la velocidad de aspiracion de la aspiradora
	 * @return True si se ha bajado y false en caso contrario
	 */
	@Override
	public boolean bajaVelocidad() {
		boolean changed = false;
		if (this.velocidadAspiracion > 0) {
			this.velocidadAspiracion--;
		}
		return changed;
	}
	
	
	/**
	 * Metodo para mostrar todos los atributos del mando de la aspiradora por consola
	 */
	@Override
	public String toString() {
		return super.toString() + " Velocidad De Aspiración: " + this.velocidadAspiracion;
	}
	
	

}
