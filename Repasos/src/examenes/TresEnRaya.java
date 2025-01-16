package examenes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {
	// tablero
	static char[][] tablero = new char[3][3];

	// objeto random
	static Random rd = new Random();

	public static void main(String[] args) {
		// Scanner
		Scanner sc = new Scanner(System.in);
		
		int turno = 0;
		
		boolean valid;
	
		char respuesta = 'y';

		int fila = 0, columna = 0;
		do {
			limpiaTablero();
			turno = jugadorInicial();

			System.out.println("Bienvenido al 3 en raya contra la mquina");

			do {
				if (turno % 2 == 0) { // Turno maquina
					System.out.println("Turno maquina");
					mueveFichaAleatoria();
					imprimeTablero();
					turno++;

				} else { // Turno usuario

					System.out.println("Turno usuario");
					imprimeTablero();
					do { // sigue preguntando mientras que la respuesta sea valida
						System.out.println("Fila");
						fila = sc.nextInt();
						System.out.println("Columna");
						columna = sc.nextInt();
						
						valid = usuarioMueveFicha(fila, columna);
						
					} while (!valid);
					turno++;
				}

			} while (esGanador() == 0 && turno < 9);

			if (esGanador() == -1) {
				System.out.println("GANÓ LA MÁQUINA");
			} else if (esGanador() == 1){
				System.out.println("GANASTEEEEEEEEEEEEE");
			} else {
				System.out.println("EMPATEEEE");
			}

			System.out.println("¿Quieres jugar otra vez? y=Sí n=No");
			respuesta = sc.next().charAt(0);

		} while (respuesta == 'y');

		System.out.println("Adiooooooooooooooos");
		sc.close();
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

		// si en la posición hay algo, se randomiza de nuevo hasta que no haya nada
		do {
			posiF = rd.nextInt(0, tablero.length);
			posiC = rd.nextInt(0, tablero[0].length);
		} while (tablero[posiF][posiC] != '-');

		// añadir X al tablero
		tablero[posiF][posiC] = 'X';

	}

	static boolean usuarioMueveFicha(int posiFU, int posiCU) {
		boolean valid = false;

		// vemos si no hay nada en medio para poner la ficha
		if (posiFU < tablero.length && posiFU >= 0 && posiCU < tablero[0].length && posiCU >= 0
				&& tablero[posiFU][posiCU] == '-') {
			// ponemos en el tablero un círculo en las coordenadas especificadas
			tablero[posiFU][posiCU] = 'O';
			valid = true;
		}

		// devolvemos si hay algo en medio o no
		return valid;
	}

	static int esGanador() {
		// variable para ver si has ganado o no
		int empate = 0;

		// recorremos el tablero comprobando si hay 3 caracteres seguidos iguales
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {

				// Comprobar "tres en raya" horizontal
				if (j <= tablero[0].length - 3) { // Asegúrate de que hay espacio para verificar hacia la derecha
					if (tablero[i][j] != '-' && tablero[i][j + 1] == tablero[i][j]
							&& tablero[i][j + 2] == tablero[i][j]) {
						return (tablero[i][j] == 'X') ? -1 : 1;
					}
				}

				// Comprobar "tres en raya" vertical
				if (i <= tablero.length - 3) { // Asegúrate de que hay espacio para verificar hacia abajo
					if (tablero[i][j] != '-' && tablero[i + 1][j] == tablero[i][j]
							&& tablero[i + 2][j] == tablero[i][j]) {
						return (tablero[i][j] == 'X') ? -1 : 1;
					}
				}

				// Comprobar "tres en raya" en la diagonal principal (↘)
				if (i <= tablero.length - 3 && j <= tablero[0].length - 3) { // Asegúrate de que hay espacio hacia la
																				// diagonal ↘
					if (tablero[i][j] != '-' && tablero[i + 1][j + 1] == tablero[i][j]
							&& tablero[i + 2][j + 2] == tablero[i][j]) {
						return (tablero[i][j] == 'X') ? -1 : 1;
					}
				}

				// Comprobar "tres en raya" en la diagonal secundaria (↙)
				if (i >= 2 && j <= tablero[0].length - 3) { // Asegúrate de que hay espacio hacia la diagonal ↙
					if (tablero[i][j] != '-' && tablero[i - 1][j + 1] == tablero[i][j]
							&& tablero[i - 2][j + 2] == tablero[i][j]) {
						return (tablero[i][j] == 'X') ? -1 : 1;
					}
				}
			}
		}

		// devolvemos la posible victoria
		return empate;
	}

	static void limpiaTablero() {
		for (int i = 0; i < tablero.length; i++) {
			Arrays.fill(tablero[i], '-');
		}

	}
}
