package examenHerenciaInterfaces.main;

import java.util.Arrays;

import examenHerenciaInterfaces.clases.Mando;
import examenHerenciaInterfaces.clases.MandoAire;
import examenHerenciaInterfaces.clases.MandoAspiradora;
import examenHerenciaInterfaces.clases.MandoMiniCadenas;
import examenHerenciaInterfaces.clases.MandoTV;

public class MandosMain {
	public static void main(String[] args) {
		//Tabla de 10 mandos distintos
		Mando lista[] = new Mando[4];
		
		Mando m1 = new MandoTV("AZ", 21, 7, false, 20, 50);
		Mando m2 = new MandoMiniCadenas("AC", 21, 7, false, 20);
		Mando m3 = new MandoAire("AF", 15, 6, true, false, 16, 1);
		Mando m4 = new MandoAspiradora("AA", 12, 3, true, 2);
		
		
		//Mandos
		lista[0] = m1;
		lista[1] = m2;
		lista[2] = m3;
		lista[3] = m4;
		
		//Ordenar
		Arrays.sort(lista);
		
		//Imprimimos los contenidos del Array
		System.out.println(Arrays.toString(lista));
		
		
		//Recorremos la tabla
		for(Mando ej : lista) {
			//Si es un mando de tele
			if (ej instanceof MandoTV) {
				System.out.println(ej);
				ej.cambiarEstado();
				((MandoTV) ej).subirVolumen();
				((MandoTV) ej).bajarVolumen();
				System.out.println(ej);
			}
			//Si es un mando de minicadena
			if (ej instanceof MandoMiniCadenas) {
				System.out.println(ej);
				((MandoMiniCadenas) ej).subirVolumen();
				((MandoMiniCadenas) ej).bajarVolumen();
				System.out.println(ej);
			}
			//Si es un mando de aspiradora
			if (ej instanceof MandoAspiradora) {
				System.out.println(ej);
				((MandoAspiradora) ej).subeVelocidad();
				((MandoAspiradora) ej).bajaVelocidad();
				System.out.println(ej);
			}
			//Si es un mando de aire
			if (ej instanceof MandoAire) {
				System.out.println(ej);
				((MandoAire) ej).cambiarModo();
				((MandoAire) ej).cambiarTemperatura(23);
				((MandoAire) ej).subeVelocidad();
				((MandoAire) ej).bajaVelocidad();
				System.out.println(ej);
				
			}
		}
	}
}
