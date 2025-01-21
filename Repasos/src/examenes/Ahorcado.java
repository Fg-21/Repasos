package examenes;

import java.util.Random;
import java.util.Scanner;

public class Ahorcado {

	static String[] palabras = { "humanidad", "persona", "hombre", "mujer", "individuo", "cuerpo", "pierna", "cabeza",
			"familia" };

	static final int NUMINTENTOS = 7;

	static String palabraSecreta = "";

	static String palabraPista = "";

	static String noAcertadas = "";

	static int intentosRestantes = NUMINTENTOS;

	static Scanner rd = new Scanner(System.in);

	public static void main(String[] args) {

		// Condicion de victoria
		boolean win = false;

		// opción elegida de menú;
		int opcion;

		// Letra del usuario
		char letra;

		// Palabra del usuario
		String palabra;

		// Objeto scanner
		Scanner rd = new Scanner(System.in);

		// Genera palabra
		palabraSecreta = generaPalabra();

		// (Adición) Inicializamos la pista con guiones bajos
		for (int i = 0; i < palabraSecreta.length(); i++) {
			palabraPista += "_";
		}

		// Imprimimos pista
		pintaPista();

		// Mientras el jugador no haya acertado la palabra y tenga intentos restantes
		do {
			// Imprimimos menú y guardamos el resultado
			opcion = menu();

			// si elige la 1, pedimos la letra, si es la 2, la palabra
			switch (opcion) {
			case 1 -> {

				// Pido letra
				System.out.println("Introduce la letra");
				letra = rd.nextLine().toLowerCase().charAt(0);

				// Compruebo si está en la palabra
				compruebaLetra(letra);
			}
			case 2 -> {
				// Pido palabra
				System.out.println("Introduce la palabra");
				palabra = rd.nextLine();

				// Compruebo si esta la palabra
				compruebaPalabra(palabra);
			}
			default -> {
				System.out.println("¡Introduce 1 o 2!");
			}
			}
			// Imprimo pista
			pintaPista();

			// Imprimo intentos restantes
			System.out.println("Intentos restantes: " + intentosRestantes);

			// aplico condicion de victoria
			if (palabraPista.equals(palabraSecreta)) {
				win = true;
			}

		} while (!win && intentosRestantes > 0);

		// Mandamos mensaje si has ganado o perdido
		if (win) {
			System.out.println("Ganasteeeeee");
		} else {
			System.out.println("Has perdido :(");
		}

	}

	// Generación de la palabra secreta
	static String generaPalabra() {
		// Objeto random
		Random rand = new Random();

		// Palabra secreta a devolver
		String palabra;

		// Asignamos un valor aleatorio a una variable
		int randomizador = rand.nextInt(0, palabras.length);

		// asignamos la palabra aleatoria a palabra
		palabra = palabras[randomizador];

		// Devolvemos la palabra secreta
		return palabra;
	}

	// Menú
	static int menu() {
		// Numero a devolver
		int num;

		// Preguntamos si quiere introducir palabra o letra
		System.out.println("Introduce una opción");
		System.out.println("1--Letra");
		System.out.println("2--Palabra");
		num = rd.nextInt();

		// Limpio el buffer
		rd.nextLine();

		// Devolvemos el número
		return num;
	}

	// Comprobante de las letras
	static void compruebaLetra(char letra) {

		// array de char para comprobar las posiciones de las letras
		char[] array = new char[palabraSecreta.length()];

		// booleano para ver si la he encontrado
		boolean finded = false;

		// Recorro la palabra
		for (int i = 0; i < palabraSecreta.length(); i++) {
			// si encuentro la letra en palabraSecreta, desvelo la letra en palabraPista
			if (palabraSecreta.charAt(i) == letra) {
				array = palabraPista.toCharArray();
				array[i] = letra;
				palabraPista = String.valueOf(array);
				finded = true;
			}

		}

		// Si no la he encontrado antes, le resto un intento y añado la letra a las
		// letras no acertadas

		if (!finded) {
			intentosRestantes--;
			noAcertadas += letra;
		}

	}

	static void compruebaPalabra(String palabra) {

		// Si la palabra es igual a la palabra secreta, se asigna la palabra a
		// palabraPista
		if (palabra.equalsIgnoreCase(palabraSecreta)) {
			palabraPista = palabra;
		} else {
			intentosRestantes--;
		}
	}

	static void pintaPista() {
		System.out.println("Palabra a descifrar:");
		
		// Pintamos la pista
		System.out.println(palabraPista);
		
		System.out.println("Letras no acertadas:");
		// Pintamos las letras no acestradas
		System.out.println(noAcertadas);
	}

}
