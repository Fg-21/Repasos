package examenes;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TresEnRaya {
	// tablero
	static char[][] tablero = new char[3][3];

	// objeto random
	static Random rd = new Random();
	
	static int movimientos = 0;

	public static void main(String[] args) {

		// turnos de jugador
		int turno;

		// Booleano para ver si el tablero está lleno
		final int LLENO = 9;

		// posicion filas usuario
		int posiFU = 0;

		// posición columna usuario
		int posiCU = 0;

		// condicion ganadora
		boolean win = false;
		
		//jugar mas
		char playMore;
		
		//limpiar tablero
		boolean limpiar = false;

		// Scanner
		Scanner sc = new Scanner(System.in);

		// se sigue jugando hasta que uno de los 2 gane o se complete el tablero
		while (!limpiar) {
			// Decidmos quien empieza a jugar
			turno = jugadorInicial();

			// rellenamos el tablero con -
			for (int i = 0; i < tablero.length; i++) {
				Arrays.fill(tablero[i], '-');
			}

			// damos la bienvenida
			System.out.println("¡BIENVENIDOS AL TRES EN RAYA!");

			while (LLENO != movimientos) {
				// Si el turno es 1 juega la maquina, si es 0 juega el jugador
				if (turno == 1) {
					System.out.println("Turno de la máquina");

					// la maquina pone ficha
					mueveFichaAleatoria();

					movimientos++;
					
					// imprimimos el tablero
					imprimeTablero();

					// Comprobamos si alguien ha ganado
					win = esGanador('X');
					
					
					//decimos quien gana
					if (win) {
						System.out.println("GANO LA MÁQUINA");
					}
					
					System.out.println("Tu turno!");

					do {
						// imprimimos el tablero
						imprimeTablero();

						// preguntamos al usuario la fila y la columna que quiere modificar
						System.out.println("Fila");
						posiFU = sc.nextInt();

						System.out.println("Columna");
						posiCU = sc.nextInt();

						// usuario mueve ficha
						usuarioMueveFicha(posiFU, posiCU);

					} while (!usuarioMueveFicha(posiFU, posiCU));

					// Comprobamos si alguien ha ganado
					win = esGanador('O');
					
					//decimos quien gana
					if (win) {
						System.out.println("GANASTEEE");
					}
					

				} else {
					System.out.println("Tu turno!");

					do {
						// imprimimos el tablero
						imprimeTablero();

						// preguntamos al usuario la fila y la columna que quiere modificar
						System.out.println("Fila");
						posiFU = sc.nextInt();

						System.out.println("Columna");
						posiCU = sc.nextInt();

						// usuario mueve ficha
						usuarioMueveFicha(posiFU, posiCU);

					} while (!usuarioMueveFicha(posiFU, posiCU));

					// Comprobamos si alguien ha ganado
					win = esGanador('O');
					
					//decimos quien gana
					if (win) {
						System.out.println("GANASTEEE");
					}
					
					System.out.println("Turno de la máquina");

					// la maquina pone ficha
					mueveFichaAleatoria();

					movimientos++;
					
					// imprimimos el tablero
					imprimeTablero();

					// Comprobamos si alguien ha ganado
					win = esGanador('X');
					
					//decimos quien gana
					if (win) {
						System.out.println("GANO LA MÁQUINA");
					}
				}

				// Comprobamos si el tablero está relleno recorriendolo
				for (int i = 0; i < tablero.length; i++) {
					for (int j = 0; j < tablero[0].length; j++) {
						if (tablero[i][j] == '-') {
							//LLENO = false;
						}
					}
				}

			}
			//Preguntamos si quiere jugar más
			System.out.println("Quieres jugar otra vez?: y=Sí, n=NO");
			playMore = sc.next().charAt(0);
			
			switch (playMore) {
			case 'y' ->{
				limpiar = limpiaTablero(playMore);
				System.out.println("ADIOOOOS");
			}
			case 'n' ->{
				System.out.println("ADIOOOOOS");
			}
			
			}
		}

		//Cierro scanner
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

	static boolean usuarioMueveFicha(int posiFU, int posiCU) {
		boolean valid = false;

		// vemos si no hay nada en medio para poner la ficha
		if (tablero[posiFU][posiCU] != '-' || posiFU < tablero.length || posiCU < tablero[0].length) {
			// ponemos en el tablero un círculo en las coordenadas especificadas
			tablero[posiFU][posiCU] = 'O';
			valid = true;
		}
		
		

		// devolvemos si hay algo en medio o no
		return valid;
	}

	static boolean esGanador(char caracter) {
		// variable para ver si has ganado o no
		boolean win = false;

		// recorremos el tablero comprobando si hay 3 caracteres seguidos iguales
		for (int i = 0; i < tablero.length; i++) {
		    for (int j = 0; j < tablero[0].length; j++) {

		        // Comprobar "tres en raya" horizontal
		        if (j <= tablero[0].length - 3) { // Asegúrate de que hay espacio para verificar hacia la derecha
		            if (tablero[i][j] == caracter && tablero[i][j + 1] == caracter && tablero[i][j + 2] == caracter) {
		                win = true;
		            }
		        }

		        // Comprobar "tres en raya" vertical
		        if (i <= tablero.length - 3) { // Asegúrate de que hay espacio para verificar hacia abajo
		            if (tablero[i][j] == caracter && tablero[i + 1][j] == caracter && tablero[i + 2][j] == caracter) {
		                win = true;
		            }
		        }

		        // Comprobar "tres en raya" en la diagonal principal (↘)
		        if (i <= tablero.length - 3 && j <= tablero[0].length - 3) { // Asegúrate de que hay espacio hacia la diagonal ↘
		            if (tablero[i][j] == caracter && tablero[i + 1][j + 1] == caracter && tablero[i + 2][j + 2] == caracter) {
		                win = true;
		            }
		        }

		        // Comprobar "tres en raya" en la diagonal secundaria (↙)
		        if (i >= 2 && j <= tablero[0].length - 3) { // Asegúrate de que hay espacio hacia la diagonal ↙
		            if (tablero[i][j] == caracter && tablero[i - 1][j + 1] == caracter && tablero[i - 2][j + 2] == caracter) {
		                win = true;
		            }
		        }
		    }
		}

		// devolvemos la posible victoria
		return win;
	}
	
	static boolean limpiaTablero(char decision) {
		boolean limpia = true;
		
		if (decision == 'y') {
			for (int i = 0; i < tablero.length; i++) {
				Arrays.fill(tablero[i], '-');
			}
			limpia = false;
		}
		
		
		
		return limpia;
	}
}
