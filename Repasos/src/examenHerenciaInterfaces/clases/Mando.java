package examenHerenciaInterfaces.clases;

/**
 * Clase Mando, que representa a cualquier mando a distancia, esta puede cambiar
 * si el aparato que controla esta encendido o apagado y modificar el precio del
 * mando. Además, maneja la condicion de igualdad de dos mandos, su criterio de
 * ordenacion por defecto en una lista, y la representacion basica por consola
 * de sus atributos
 */
public class Mando implements Comparable<Mando> {
	/**
	 * Modelo del mando
	 */
	private String modelo = "";
	/**
	 * Altura del mando
	 */
	private double altura;
	/**
	 * Anchura del mando
	 */
	private double anchura;
	/**
	 * Precio del mando
	 */
	private double precio;
	/**
	 * Estado del aparato que controla el mando, siendo false apagado y true
	 * encendido
	 */
	private boolean onOff;

	/**
	 * Constructor del Mando con todos sus atributos menos el precio
	 * 
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 */
	public Mando(String modelo, double altura, double anchura, boolean onOff) {
		this.modelo = modelo;
		this.altura = altura;
		this.anchura = anchura;
		this.onOff = onOff;
	}
	
	/**
	 * Constructor del Mando con todos sus atributos
	 * 
	 * @param modelo  Modelo del mando
	 * @param altura  Altura del mando
	 * @param anchura Anchura del mando
	 * @param onOff   Estado del aparato del mando
	 * @param precio  Precio del mando. No puede ser nagativo
	 */
	public Mando(String modelo, double altura, double anchura, double precio, boolean onOff) {
		this.modelo = modelo;
		this.altura = altura;
		this.anchura = anchura;
		this.precio = precio;
		this.onOff = onOff;
	}

	/**
	 * Getter del precio del mando
	 * 
	 * @return Devuelve el precio del mando
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Setter del precio del mando. No puede ser negativo
	 * 
	 * @param precio Nuevo precio del mando. No puede ser nagativo
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Getter del modelo del mando
	 * 
	 * @return Devuelve el modelo del mando
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * Getter de la altura del mando
	 * 
	 * @return Devuelve la altura del mando
	 */
	public double getAltura() {
		return altura;
	}

	/**
	 * Getter de la anchura del mando
	 * 
	 * @return Devuelve la anchura del mando
	 */
	public double getAnchura() {
		return anchura;
	}

	/**
	 * Getter del estado del aparato que controla el mando
	 * 
	 * @return Devuelve el estado del aparato que controla el mando
	 */
	public boolean isOnOff() {
		return onOff;
	}

	/**
	 * Metodo que cambia el estado del aparato que controla el mando, si esta
	 * encendido(True), lo pasamos a apagado (False) y viceversa
	 */
	public void cambiarEstado() {
		if (this.onOff == false) {
			this.onOff = true;
		} else {
			this.onOff = false;
		}
	}

	/**
	 * Metodo para definir la igualdad de dos mandos, estos son iguales si su modelo
	 * es igual
	 */
	@Override
	public boolean equals(Object obj) {
		boolean iguales = false;
		Mando m1 = (Mando) obj;

		if (this.modelo.equals(m1.modelo)) {
			iguales = true;
		}

		return iguales;
	}

	/**
	 * Metodo compareTo para definir el criterio de ordenacion por defecto de mandos
	 * en una lista. Por defecto los mandos se ordenarán alfabeticamente basandose
	 * en su modelo
	 */
	@Override
	public int compareTo(Mando o) {
		return this.modelo.compareTo(o.modelo);
	}

	
	/**
	 * Metodo para el muestreo de todos los atributos de Mando por consola
	 */
	@Override
	public String toString() {
		String res = "";
		String estado = this.onOff ? "Encendido" : "Apagado";
		res += "Modelo: " + this.modelo;
		res += " Altura: " + this.altura;
		res += " Anchura: " + this.anchura;
		res += " Estado: " + estado;
		res += " Precio: " + this.precio;
		return res;   
	}

}
