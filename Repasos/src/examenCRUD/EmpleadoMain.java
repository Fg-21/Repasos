package examenCRUD;

import java.util.Scanner;

public class EmpleadoMain {
public static void main(String[] args) {
//Objeto Scanner
	Scanner rd = new Scanner(System.in);
	
	//Variable para el dni del empleado
	String dni;
	
	//Variable para el nombre del empleado
	String nombre;
	
	//Variable para el sueldo base del empleado
	int sueldoBase;
	
	//Variable para las horas extra del empleado
	int horasXtra;
	
	//Variable para el valor de las horas extra de los empleados
	double iHoraXtra;
	
	//Variable para la opcion del usuario
	int opcion = 0;
	
	//Mientras que la opcion del usuario no sea 0, se ejecutara el siguiente codigo
	do {
		//Damos la bienvenida
		System.out.println("Bienvenido al sistema de gestion de Empleados");
		
		//Imprimo el menu
		menu();
		
		//Leo la opcion del usuario y limpio el buffer
		opcion = rd.nextInt();
		rd.nextLine();
		
		//Depende de lo que elija, se ejecutaran estos codigos
		switch (opcion){
		case 1 ->{
			//Añadir el empleado
			//Pedimos los datos del empleado nuevo y limpiamos el buffer cuando sea necesario
			System.out.println("DNI:");
			dni = rd.nextLine();
			System.out.println("NOMBRE:");
			nombre = rd.nextLine();
			System.out.println("SUELDO BASE:");
			sueldoBase = rd.nextInt();
			rd.nextLine();
			System.out.println("HORAS EXTRA:");
			horasXtra = rd.nextInt();
			rd.nextLine();
			
			//Construyo un objeto con los datos
			Empleado emp = new Empleado(dni, nombre, sueldoBase, horasXtra);
			
			//Inentamos añadir el usuario
			if (ListaEmpleados.añadirEmpleado(emp)) {
				System.out.println("Empleado añadido");
			} else {
				System.out.println("Empleado no añadido");
			}
		}
		case 2 ->{
			//Listamos los empleados
			ListaEmpleados.listarEmpleado();
		}
		case 3 ->{
			//Pedimos al usuario el dni del empleado al que va a modificar las horas extra
			System.out.println("DNI:");
			dni = rd.nextLine();
			
			//Pedimos tambien la nueva cantidad de horas extra y limpiamos buffer de datos
			System.out.println("NUEVA CANTIDAD DE HORAS EXTRA");
			horasXtra = rd.nextInt();
			rd.nextLine();
			
			//Construyo un objeto con el dni y las horas extra
			Empleado emp = new Empleado(dni, horasXtra);
			
			//Intentamos modificar las horas extra
			if (ListaEmpleados.modificaHorasExtra(emp)) {
				System.out.println("Horas extra modificadas");
			} else {
				System.out.println("No se modificaron las horas extra");
			}			
		}
		case 4 ->{
			//Pedimos el nuevo importe de horas extra y limpiamos buffer
			System.out.println("NUEVO IMPORTE DE HORAS EXTRA:");
			iHoraXtra = rd.nextDouble();
			rd.nextLine();
			
			//Modifico el importe de las horas extra
			Empleado.modificaImporteHorasExtra(iHoraXtra);
		}
		case 5 ->{
			//Pedimos el dni del empleado a eliminar
			System.out.println("DNI DEL EMPLEADO A ELIMINAR:");
			dni = rd.nextLine();
			
			//Creo el objeto empleado solo con el dni
			Empleado emp = new Empleado(dni);
			
			//Intento eliminar el empleado de la lista
			if (ListaEmpleados.eliminarEmpleado(emp)) {
				System.out.println("Empleado eliminado correctamente");
			} else {
				System.out.println("Empleado no eliminado");
			}
		}
		case 0 ->{
			System.out.println("Saliendo del sistema...");
		}
		}
	} while (opcion != 0);
	
	//Cierro Scanner
	rd.close();

}

public static void menu() {
	System.out.println("Seleccione una opcion");
	System.out.println("1. Añadir empleado.");
	System.out.println("2. Listar empleados.");
	System.out.println("3. Modificar horas extra.");
	System.out.println("4. Modificar importe horas extra.");
	System.out.println("5. Eliminar empleado.");
	System.out.println("0. Salir.");
}
}
