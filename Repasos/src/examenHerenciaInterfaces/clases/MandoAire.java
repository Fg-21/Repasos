package examenHerenciaInterfaces.clases;

import examenHerenciaInterfaces.interfaces.Velocidad;

/**
 * Clase MandoAire. Tendrá atributos extra al del padre (Mando) como son el
 * modo, la temperatura y la velocidad del ventilador. Para esta última
 * implementará la interfaz Velocidad.
 */
public class MandoAire extends Mando implements Velocidad {
	/**
	 * Modo del Aire acondicionado controlado por el mando, donde False es Frío y True es Calor. (Frio por defecto)
	 */
	private boolean modo = false;
	
	/**
	 * Temperatura del Aire acondicionado controlado por el mando
	 */
	private int temperatura;
	
	/**
	 * Velocidad del Ventilador del Aire acondicionado controlado por el mando. (0 por defecto)
	 */
	private int velocidadVentilador = 0;

	
	/**
	 * Contructor de MandoAire con todos sus atributos menos el precio
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param modo Modo del Aire
	 * @param temperatura Temperatura del Aire
	 * @param velocidadVentilador Velocidad del Ventilador del Aire
	 */
	public MandoAire(String modelo, double altura, double anchura, boolean onOff, boolean modo, int temperatura, int velocidadVentilador) {
		super(modelo, altura, anchura, onOff);
		this.modo = modo;
		this.temperatura = temperatura;
		this.velocidadVentilador = velocidadVentilador;
		
	}
	/**
	 * Contructor de MandoAire con todos sus atributos
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param modo Modo del Aire
	 * @param temperatura Temperatura del Aire
	 * @param velocidadVentilador Velocidad del Ventilador del Aire
	 * @param precio Precio del mando del aire
	 */
	public MandoAire(String modelo, double altura, double anchura, double precio, boolean onOff, boolean modo, int temperatura, int velocidadVentilador) {
		super(modelo, altura, anchura, precio, onOff);
		this.modo = modo;
		this.temperatura = temperatura;
		this.velocidadVentilador = velocidadVentilador;
	}
	
	/**
	 * Getter del modo del aire
	 * @return Devuelve el modo del aire donde false es frio y true es calor
	 */
	public boolean isModo() {
		return modo;
	}
	/**
	 * Getter de la temperatura del aire
	 * @return Devuelve la temperatura del aire
	 */
	public int getTemperatura() {
		return temperatura;
	}
	/**
	 * Getter de la velocidad del ventilador del aire
	 * @return Devuelve la velocidad del ventilador del aire
	 */
	public int getVelocidadVentilador() {
		return velocidadVentilador;
	}
	
	/**
	 * Metodo que alterna entre los dos modos del aire acondicionado (Frio y Calor)
	 */
	public void cambiarModo() {
		if(this.modo) {
			this.modo = false;
		} else {
			this.modo = true;
		}
	}
	
	
	/**
	 * Metodo para cambiar la temperatura del aire entre un rango
	 * @param nuevaTemp Nueva temperatura a ajustar. Tiene que estar entre 15º y 30º (Ambos Inclusive)
	 * @return
	 */
	public boolean cambiarTemperatura(int nuevaTemp) {
		boolean changed = false;
		if(nuevaTemp >= 15 && nuevaTemp <= 30) {
			this.temperatura = nuevaTemp;
			changed = true;
		}
		return changed;
	}
	
	
	/**
	 * Metodo que sube la velocidad del ventilador del aire
	 * @return True si se ha subido y false en caso contrario
	 */
	@Override
	public boolean subeVelocidad() {
		boolean changed = false;
		if (this.velocidadVentilador < 5) {
			this.velocidadVentilador++;
		}
		return changed;
	}
	
	/**
	 * Metodo que baja la velocidad del ventilador del aire
	 * @return True si se ha bajado y false en caso contrario
	 */
	@Override
	public boolean bajaVelocidad() {
		boolean changed = false;
		if (this.velocidadVentilador > 0) {
			this.velocidadVentilador--;
		}
		return changed;
	}
	
	@Override
	public String toString() {
		String res = super.toString();
		String modo = this.modo ? "Calor" : "Frio";
		res += " Modo: " + modo;
		res += " Temperatura: " + this.temperatura;
		res += " Velocidad del Ventilador: " + this.velocidadVentilador;
		return res;
	}
	
	
	
}
