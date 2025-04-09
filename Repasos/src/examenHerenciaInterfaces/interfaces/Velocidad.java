package examenHerenciaInterfaces.interfaces;

/**
 * Interfaz Velocidad, que contiene el metodo de cambiar velocidad para algunos tipos de mandos a distancia
 */
public interface Velocidad {
	/**
	 * Sube la velocidad
	 * @return True si la velocidad ha subido, false en caso contrario
	 */
	public boolean subeVelocidad();
	
	/**
	 * Baja la velocidad
	 * @return True si la velocidad ha bajado, false en caso contrario
	 */
	public boolean bajaVelocidad();
}
