package examenCRUD;

import java.util.HashSet;

public class ListaEmpleados {
	/**
	 * Lista para guardar a los empleados
	 */
 static public HashSet<Empleado> listaEmpleados = new HashSet<Empleado>();
 
 
 /**
  * Metodo que lista todos los empleados de listaEmpleados
  */
 public static void listarEmpleado() {
	 for ( Empleado empleado : listaEmpleados) {
		 System.out.println(empleado);
	 }
 }
 
 
 /**
  * Metodo que añade un empleado a la lista
  * @param e1 Empleado a añadir
  * @return Devuelve true si ha sido añadido y false en caso contrario
  */
 public static boolean añadirEmpleado(Empleado e1) {
	 boolean added = false;
	 
	 if (listaEmpleados.add(e1)) {
		 added = true;
	 }
	 
	 return added;
 }
 
 
 /**
  * Metodo que modifica la cantidad de horas extra de un empleado concreto
  * @param e1 Empleado
  * @param horas
  * @return
  */
 public static boolean modificaHorasExtra(Empleado e1) {
	 boolean modified = false;
	 
	 for (Empleado empleado : listaEmpleados) {
		 if (empleado.equals(e1)) {
			 empleado.setHorasXtra(e1.getHorasXtra());
			 modified = true;
		 }
	 }

	 return modified;
 }
 
 
 /**
  * Metodo que elimina a un empleado de la lista
  * @param e1 Empleado a eliminar
  * @return Devuelve true si lo ha eliminado correctamente y false en caso contrario
  */
 public static boolean eliminarEmpleado(Empleado e1) {
	 boolean deleted = false;
	 
	 if (listaEmpleados.remove(e1)) {
		 deleted = true;
	 }
	 
	 return deleted;
 }
}
