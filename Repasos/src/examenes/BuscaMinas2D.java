package examenes;

import java.util.Random;
import java.util.Scanner;

public class BuscaMinas2D {
	/*
	 * Crear el juego de Buscaminas pero utilizando una tabla bidimensional. El
	 * programa pedirá al usuario la posición que desea revelar. Si hay una mina en
	 * esa posición, el juego terminará. Si no hay una mina, el programa mostrará la
	 * pista para esa posición. Esta pista indica cuántas minas hay alrededor de esa
	 * posición.
	 * 
	 * El programa comenzará con un tabla de 20 posiciones y colocará 6 minas en
	 * diferentes posiciones elegidas aleatoriamente. También inicializará el tabla
	 * con todas las pistas. Ejemplo: {0,1,,1,1,,,2,,1,0,0,0}.
	 * 
	 * Este panel estará oculto para el jugador, y él/ella tendrá que adivinarlo.
	 */

	// tablero
	static char[][] tablero = new char[5][5];

	static char[][] tableroUser = new char[5][5];

	// objeto random
	static Random rand = new Random();

	// objeto scanner
	static Scanner rd = new Scanner(System.in);

	public static void main(String[] args) {

		// coords
		int posiFilas = 0, posiColumnas = 0;

		// contador de turno
		int turno = 0;

		// Inicializamos los tablero
		iniciaTablero();

		// Colocamos minas
		colocaMinas();

		// Calculamos las celdas de pista
		calculaPista();

		// Damos la bienvenida al programa
		System.out.println("BIENVENIDO AL BUSCAMINAS 2D (El buscaminas normal vamos :p)");

		

		// mientras que no gane se repite las preguntas

		do {
			
			// pinta el tablero
			pintaTablero();
			
			// Preguntas al usuario las coordenadas de la celda a liberar
			System.out.println("Fila:");
			posiFilas = rd.nextInt();

			System.out.println("Columna:");
			posiColumnas = rd.nextInt();

			jugada(posiFilas, posiColumnas);
			turno++;
		} while (jugada(posiFilas, posiColumnas) && turno < 19);
		
		if(!jugada(posiFilas, posiColumnas)) {
			System.out.println("Has perdido, mina en tu culo");
		} else {
			System.out.println("Ganaste burlarcaster");
		}

	}

	static void iniciaTablero() {
		// recorremos el tablero poniendo - en los huecos
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {
				tablero[i][j] = '-';
			}
		}
		for (int i = 0; i < tableroUser.length; i++) {
			for (int j = 0; j < tableroUser[0].length; j++) {
				tableroUser[i][j] = '-';
			}
		}

	}

	static void pintaTablero() {
		// recorremos el tablero para pintarlo
		for (int i = 0; i < tableroUser.length; i++) {
			for (int j = 0; j < tableroUser[0].length; j++) {
				System.out.print(tableroUser[i][j] + "\t");
			}
			System.out.println("");
			System.out.println("");

		}
	}

	static void colocaMinas() {
		// filas random
		int filas = 0;

		// columnas random
		int columnas = 0;

		// bucle placea una mina donde ya hay otra
		for (int i = 0; i < 6; i++) {

			// pone mina en la posición randomizada a no ser que ya haya una mina
			do {
				// randomiza posiciones
				columnas = rand.nextInt(0, tablero[0].length);
				filas = rand.nextInt(0, tablero.length);
			} while (tablero[filas][columnas] == '*');

			// asigna mina
			tablero[filas][columnas] = '*';
		}
	}

	static void calculaPista() {

		// conteo minas
		int cont = 0;

		// recorremos el tablero para poner las pistas
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[0].length; j++) {

				// mientras que no sea mina, calcula posiciones
				if (tablero[i][j] != '*') {

					// reinicio del contador
					cont = 0;

					// comprobación de minas alrededor
					// Izquierda
					if (j - 1 >= 0 && tablero[i][j - 1] == '*') {
						cont++;
					}

					// Diagonal izquierda arriba
					if (i - 1 >= 0 && j - 1 >= 0 && tablero[i - 1][j - 1] == '*') {
						cont++;
					}

					// Arriba
					if (i - 1 >= 0 && tablero[i - 1][j] == '*') {
						cont++;
					}

					// Diagonal derecha arriba
					if (i - 1 >= 0 && j + 1 < tablero[0].length && tablero[i - 1][j + 1] == '*') {
						cont++;
					}

					// Derecha
					if (j + 1 < tablero[0].length && tablero[i][j + 1] == '*') {
						cont++;
					}

					// Diagonal derecha abajo
					if (i + 1 < tablero.length && j + 1 < tablero[0].length && tablero[i + 1][j + 1] == '*') {
						cont++;
					}

					// Abajo
					if (i + 1 < tablero.length && tablero[i + 1][j] == '*') {
						cont++;
					}

					// Diagonal izquierda abajo
					if (i + 1 < tablero.length && j - 1 >= 0 && tablero[i + 1][j - 1] == '*') {
						cont++;
					}
					// añadimos la pista a la celda
					tablero[i][j] = (char) (cont + '0');

				}
			}
		}
	}

	static boolean jugada(int fila, int columna) {
		// para ver si continuas
		boolean sigue = true;

		if (tablero[fila][columna] == '*') {
			sigue = false;
		} else {
			tableroUser[fila][columna] = tablero[fila][columna];
		}

		// devolvemos booleano
		return sigue;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * int rows = tablero.length; int cols = tablero[0].length;
	 * 
	 * // Recorrer todo el tablero para calcular las pistas for (int fila = 0; fila
	 * < rows; fila++) { for (int columna = 0; columna < cols; columna++) { // Si la
	 * celda tiene una mina, no hay que hacer nada if (tablero[fila][columna] ==
	 * '*') { continue; }
	 * 
	 * int cont = 0; // Contador de minas adyacentes
	 * 
	 * // Comprobar todas las celdas adyacentes (8 direcciones) for (int i = -1; i
	 * <= 1; i++) { for (int j = -1; j <= 1; j++) { int newRow = fila + i; int
	 * newCol = columna + j;
	 * 
	 * // Comprobar si la celda está dentro del tablero y si es una mina if (newRow
	 * >= 0 && newRow < rows && newCol >= 0 && newCol < cols) { if
	 * (tablero[newRow][newCol] == '*') { cont++; } } } }
	 * 
	 * // Si hay minas adyacentes, ponemos el número correspondiente en la celda if
	 * (cont > 0) { tablero[fila][columna] = (char) (cont + '0'); } } } }
	 */
}
