package examenHerenciaInterfaces.interfaces;

/**
 * Interfaz volumen encargada del manejo del volumen en algunos tipos de mando a distancia
 */
public interface Volumen {
	/**
	 * Sube el volumen segun el tipo de mando a distancia con el que se llame
	 * @return True si se ha podido subir el volumen, false en caso contrario
	 */
	public boolean subirVolumen();
	
	/**
	 * Baja el volumen segun el tipo de mando a distancia con el que se llame
	 * @return True si se ha podido bajar el volumen, false en caso contrario
	 */
	public boolean bajarVolumen();
}
