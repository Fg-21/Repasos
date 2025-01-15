package examenes;

import java.util.Random;
import java.util.Scanner;

public class ExamenArraysStrings {
//Abecedario ordenado	
	static char abecedario[][] = { { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i' },
			{ 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q' }, { 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' } };

	// Frases con las que vamos a jugar
	static String frases[] = {
			// "las guerras seguiran mientras el color de la piel siga siendo mas importante
			// que el de los ojos",
			// "aprende a vivir y sabras morir bien", "cada dia sabemos mas y entendemos
			// menos",
			// "el dinero no puede comprar la vida", "la verdadera sabiduria esta en
			// reconocer la propia ignorancia"
			"hola" };

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
		char letra;

		// Variable para la comprobación del código
		boolean check = false;

		// Código
		int code;

		// Desordenamos el array del abecedario
		desordenaAbecedario();

		// Elegimos una frase random
		fraseReal = eligeFrase();

		// Codificamos la frase
		fraseCodificada = codificaFrase();

		// Pedimos al usuario que adivine una letra del códico hasta que lo adivine
		while (!sonIguales()) {

			// Pedimos datos al usuario
			System.out.println(fraseCodificada);
			System.out.println("Codigo");
			code = rd.nextInt();
			System.out.println("Di una letra para adivinar la frase");
			letra = rd.next().charAt(0);

			// Comprobamos si la letra está en la frase
			check = compruebaCódigo(code, letra);

			// Si está, le decimos que ha acertado, si no, le decimos que ha fallado
			if (check) {
				System.out.println("Acertaste!");

			} else {
				System.out.println("Has fallado!");
			}
		}

		// Damos la enhorabuena al jugador
		System.out.println("¡HAS GANADO, ENHORABUENA!");
		
		//Cerramos scanner
		rd.close();
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
	static boolean compruebaCódigo(int code, char letra) {
		// Booleano a retornar
		boolean flag = false;

		// Valor de las i
		int i;

		// Valor de las j
		int j;

		// cadena para el code
		String codeString = "";

		// cadena para la letra
		String letraString = "";

		// Obtenemos las posiciones x e y de la tabla abecedario
		i = code / 10;
		j = code % 10;

		// Comprobamos si esta la letra
		if (abecedario[i][j] == letra) {
			flag = true;
		}

		// para números
		if (code < 9) {
			codeString += "0";
			// codeString += Integer.toString(code);
		}
		codeString += code;
		letraString = Character.toString(letra);

		// Reemplazamos la letra en la frase si ha acertado
		if (flag) {
			fraseCodificada = fraseCodificada.replace(codeString, letraString);
		}
		codeString = "";
		return flag;
	}

	// soniguales
	static boolean sonIguales() {
		boolean check;

		// backup frase real
		String backUpFraseReal = fraseReal;

		// backup frase coded
		String backUpFraseCodificada = fraseCodificada;
		
		//quitamos espacios
		backUpFraseCodificada =backUpFraseCodificada.replace(" ", "");
		
		//quitamos espacios
		backUpFraseReal =backUpFraseReal.replace(" ", "");

		//comprobamos si son iguales
		check = backUpFraseReal.equals(backUpFraseCodificada);
		
		//devolvemos el resultado de la comprobación
		return check;
	}
}
