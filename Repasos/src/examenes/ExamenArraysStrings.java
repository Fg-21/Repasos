package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenArraysStrings {
//Abecedario ordenado	
	static char abecedario[][] = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	// Frases con las que vamos a jugar
	static String frases[] = {
			"las guerras seguiran mientras el color de la piel siga siendo mas importante que el de los ojos",
			"aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos menos",
			"el dinero no puede comprar la vida", "la verdadera sabiduria esta en reconocer la propia ignorancia" };

	// Frase con la que se juega
	static String fraseReal;

	// Frase codificada
	static String fraseCodificada;

	// Randomizador
	static Random rand = new Random();

	// Scanner
	static Scanner rd = new Scanner(System.in);

	public static void main(String[] args) {

		// Variable para la letra del usuario
		String letra;

		// Variable para la comprobación del código
		boolean check = false;
		
		// Variable para la comprobación de victoria
		boolean win = false;
		
		//Código de una letra
		

		// Desordenamos el array del abecedario
		desordenaAbecedario();

		// Elegimos una frase random
		fraseReal = eligeFrase();

		// Codificamos la frase
		fraseCodificada = codificaFrase();

		// Pedimos al usuario que adivine una letra del códico hasta que lo adivine
		while (win) {
			System.out.println(fraseCodificada);
			System.out.println("Di una letra para adivinar la frase");
			letra = rd.next();

			// Comprobamos si la letra está en la frase
			check = compruebaCódigo(code, letra);

			// Si está, le decimos que ha acertado, si no, le decimos que ha fallado
			if (check) {
				System.out.println("Acertaste!");
			} else {
				System.out.println("Has fallado!");
			}
			
			//Comprobamos si el jugador ha ganado
			win = sonIguales();
		}
		
		//Damos la enhorabuena al jugador
		System.out.println("¡HAS GANADO, ENHORABUENA!");
	}

	static void desordenaAbecedario() {
		// Variable auxiliar para guardar la letra a cambiar
		char letra;

		// Variable para el número aleatorio de las columnas
		int numRC;

		// Variable para el número aleatorio de las filas
		int numRF;
		// Recorremos el bucle desordenando las letras
		for (int i = 0; i < abecedario.length; i++) {
			for (int j = 0; j < abecedario[i].length; j++) {
				// Creo una posición aleatoria
				numRC = rand.nextInt(0, abecedario[0].length);
				numRF = rand.nextInt(0, abecedario.length);

				// Guardo la letra aleatoria
				letra = abecedario[numRF][numRC];

				// La sustituyo en la posición que toque
				abecedario[numRF][numRC] = abecedario[i][j];
				abecedario[i][j] = letra;
			}
		}
	}

	static String eligeFrase() {
		// Número aleatorio para desordenar la frase
		int numR;

		// Variable para la frase aleatoria
		String frase;

		// Randomizamos
		numR = rand.nextInt(0, frases.length);

		// Asignamos la frase aleatoria
		frase = frases[numR];

		return frase;
	}

	static String codificaFrase() {
		// Frase codificada
		String fraseCoded = "";

		// Contador para la busqueda
		int cont = 0;

		// Indicador para la busqueda
		boolean finded;

		// Recorremos la frase sustituyendo la letra por la posición en el abecedario
		for (int i = 0; i < fraseReal.length(); i++) {
			finded = false;
			for (int j = 0; j < abecedario.length && !finded; j++) {
				cont = 0;
				while (cont < abecedario[j].length && !finded) {
					if (fraseReal.charAt(i) == abecedario[j][cont]) {
						fraseCoded += j;
						fraseCoded += cont;

						finded = true;
					}

					cont++;
				}
			}
			fraseCoded += " ";
		}

		return fraseCoded;
	}

	// Metodo comprobar código
	static boolean compruebaCódigo(String letra) {
		// Booleano a retornar
		boolean flag;
		
		
		
		return flag;
	}
}
