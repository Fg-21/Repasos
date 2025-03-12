package examenCRUD;

import java.util.Objects;

public class Empleado {
	/**
	 * Dni del empleado
	 */
	private String dni;

	/**
	 * Nombre del empleado
	 */
	private String nombre;

	private double sueldoBase;
	
	/**
	 * Horas extra que el empleado ha trabajado
	 */
	private int horasXtra;

	/**
	 * Valor de las horas extra del empleado
	 */
	static private double importeHoraXtra;

	/**
	 * Constructor de Empleado solo con su dni
	 * @param dni Dni del empleado
	 */
	public Empleado(String dni) {
		this.dni = dni;
	}

	/**
	 * Constructor de Empleado con su DNI y las horas extra solo
	 * @param dni Dni del empleado
	 * @param horas Horas extra del empleado
	 */
	public Empleado(String dni, int horas) {
		this.dni = dni;
		if (horas >= 0) {
			this.horasXtra = horas;
		}
		
	}

	/**
	 * Constructor de Empleado con todos sus atributos
	 * 
	 * @param dni       Dni del empleado
	 * @param nombre    Nombre del empleado
	 * @param sueldoBase Sueldo base del empleado. No puede ser negativo
	 * @param horasXtra Horas extra del empleado. No pueden ser negativas
	 */
	public Empleado(String dni, String nombre, double sueldoBase, int horasXtra) {
		this.dni = dni;
		this.nombre = nombre;
		if (sueldoBase >= 0) {
			this.sueldoBase = sueldoBase;
		}
		if (horasXtra >= 0) {
			this.horasXtra = horasXtra;
		}
	}

	/**
	 * Getter del dni del Empleado
	 * 
	 * @return Devuelve el dni del Empleado
	 */
	public String getDni() {
		return dni;
	}

	/**
	 * Getter del nombre del empleado
	 * 
	 * @return Devuelve el nombre del empleado
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Setter del nombre del empleado
	 * 
	 * @param nombre Nombre nuevo del empleado
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Getter del sueldo base
	 * @return Devuelve el sueldo base del empleado
	 */
	public double getSueldoBase() {
		return sueldoBase;
	}

	/**
	 * Setter del sueldo base
	 * @param sueldoBase Nuevo sueldo base del empleado. No puede ser negativo
	 */
	public void setSueldoBase(double sueldoBase) {
		if (sueldoBase >= 0) {
			this.sueldoBase = sueldoBase;
		}
	}

	/**
	 * Getter de la cantidad de horas extra que tiene el empleado
	 * 
	 * @return Devuelve la cantidad de horas extra que tiene el empleado
	 */
	public int getHorasXtra() {
		return horasXtra;
	}

	/**
	 * Setter de las horas extra del empleado
	 * 
	 * @param horasXtra Nuevas horas extra del empleado. No deben ser negativas
	 */
	public void setHorasXtra(int horasXtra) {

		if (horasXtra >= 0) {
			this.horasXtra = horasXtra;
		}
	}

	/**
	 * Getter del importe de la hora extra
	 * 
	 * @return Devuelve el valor de la hora extra del usuario
	 */
	public static double getImporteHoraXtra() {
		return importeHoraXtra;
	}

	/**
	 * Setter del importe de la hora extra del empleado. No puede ser negativa
	 * 
	 * @param importeHoraXtra Nuevo valor de la hora extra del empleado. No puede
	 *                        ser negativo
	 */
	public static void setImporteHoraXtra(double iHoraXtra) {
		if (iHoraXtra >= 0) {
			importeHoraXtra = iHoraXtra;
		}
	}

	/**
	 * Metodo que calcula el complemento multiplicando el número de horas extras por
	 * el importe de la hora extra
	 * 
	 * @return Devuelve el complemento del empleado
	 */
	public double calcularComplemento() {
		return this.horasXtra * importeHoraXtra;
	}
	
	
	/**
	 * Metodo que calcula el sueldo bruto del Empleado
	 * @return El sueldo bruto del empleado. Sueldo base mas complemento 
	 */
	public double sueldoBruto() {
		return this.sueldoBase + this.calcularComplemento();
	}

	/**
	 * Metodo toString para imprimir la info del empleado
	 */
	@Override
	public String toString() {
		String res = "";
		res = "DNI: " + this.dni;
		res += "\nNombre: " + this.nombre;
		res += "\nSueldo Base: " + this.sueldoBase;
		res += "\nSueldo Bruto: " + this.sueldoBruto();
		res += "\nHoras Extra Trabajadas: " + this.horasXtra;
		res += "\nValor de las Horas Extra: " + importeHoraXtra;

		return res;
	}

	/**
	 * Metodo Hashcode para las busquedas en la lista de empleados
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dni);
	}

	/**
	 * Metodo equals sobrescrito de Objects para las busquedas
	 */
	@Override
	public boolean equals(Object emp) {
		boolean equal = false;
		Empleado e1 = (Empleado) emp;

		if (e1.dni.equals(this.dni)) {
			equal = true;
		}
		return equal;
	}
	
	/**
	 * Metodo que modifica el valor de la hora extra de todos los empleados
	 * @param importe Nuevo valor de la hora extra
	 */
	public static void modificaImporteHorasExtra(double importe) {
		setImporteHoraXtra(importe);
	}

}
