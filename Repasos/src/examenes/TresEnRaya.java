package examenes;

import java.util.Arrays;
import java.util.Random;

public class TresEnRaya {
	// tablero
	static char[][] tablero = new char[9][9];

	// objeto random
	static Random rd = new Random();

	public static void main(String[] args) {

		// turnos de jugador
		int turno;

		// Decidmos quien empieza a jugar
		turno = jugadorInicial();

		// rellenamos el tablero con -
		for (int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], '-');
		}
		
		//damos la bienvenida
		System.out.println("¡BIENVENIDOS AL TRES EN RAYA!");
		
		// imprimimos el tablero
		imprimeTablero();

		// Si el turno es 1 juega la maquina, si es 0 juega el jugador
		if (turno == 1) {
			System.out.println("Turno de la máquina");
			mueveFichaAleatoria();
		} else {
			System.out.println("Tu turno!");
			usuarioMueveFicha();
		}

		// se sigue jugando hasta que uno de los 2 gane
		// while ( ) {

		// }

	}

	// Imprime el tablero
	static void imprimeTablero() {

		System.out.print("\t");
		// filas de coordenadas
		for (int i = 0; i < tablero.length; i++) {
			
			System.out.print(i + "\t");
		}
		System.out.println();

		// tablero raw
		for (int i = 0; i < tablero.length; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < tablero[i].length; j++) {
				System.out.print(tablero[i][j] + "\t");
			}
			System.out.println();
		}
	}

	// control de turnos
	static int jugadorInicial() {

		// turno jugador
		int turno;

		// aleatorizamos
		turno = rd.nextInt(0, 2);

		// devolvemos turno
		return turno;
	}

	static void mueveFichaAleatoria() {
		// posición filas
		int posiF;

		// posición columnas
		int posiC;

		// aleatorizamos la posición
		posiF = rd.nextInt(0, tablero.length);
		posiC = rd.nextInt(0, tablero[0].length);

		// si en la posición hay algo, se randomiza de nuevo hasta que no haya nada
		while (tablero[posiF][posiC] != '-') {
			posiF = rd.nextInt(0, tablero.length);
			posiC = rd.nextInt(0, tablero[0].length);
		}

		// añadir X al tablero
		tablero[posiF][posiC] = 'X';

	}

	static void usuarioMueveFicha() {

	}
}
