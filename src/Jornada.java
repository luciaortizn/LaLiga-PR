import java.util.Scanner;

public class Jornada {

	public static void main(String[] args) {

		int numEquipos;
		// Pide al usuario un numero entre 3 y 1000 y comprueba
		numEquipos = numeroEnRango();
		// Metodo que genera los enfrentamientos
		GenerarJornada(numEquipos);
	}

	public static void GenerarJornada(int numEquipos) {

		int valor = 1;
		int valor2;
		int jornadas;
		int numPartidos;
		boolean esPar;

		// Comprueba si el numero de equipos es par o impar
		if (numEquipos % 2 == 0) {
			numPartidos = numEquipos / 2;
			jornadas = numEquipos - 1;
			esPar = true;

			System.out.println("El nº de jornadas es " + (jornadas));
			System.out.println("El nº de partidos por jornada es " + numPartidos + "\n");
		} else {
			numPartidos = ((numEquipos + 1) / 2);
			jornadas = numEquipos;
			esPar = false;

			System.out.println("El nº de jornadas es " + (jornadas));
			System.out.println("El nº de partidos por jornada es " + numPartidos + "\n");
		}
		// Array con todos los enfrentamientos
		String[][] enfrentamientoStrings = new String[jornadas][numPartidos];

		// bucle para crear el primer equipo del enfrentamiento (local)
		for (int i = 0; i < jornadas; i++) {
			for (int j = 0; j < numPartidos; j++) {
				enfrentamientoStrings[i][j] = "Equipo " + (valor);
				if (valor == jornadas) {
					valor = 0;
				}
				valor++;
			}
		}

		valor2 = numEquipos;
		for (int i = 0; i < jornadas; i++) {
			for (int j = 0; j < numPartidos; j++) {
				// Crear primer equipo visitante por jornada, si impar descansa
				if (j == 0) {
					if (esPar) {
						enfrentamientoStrings[i][j] += " - " + "Equipo " + numEquipos;
					} else {
						enfrentamientoStrings[i][j] += " -> Descansa";
					}
					// Crea resto de equipos visitantes
				} else {
					valor2--;
					enfrentamientoStrings[i][j] += " - " + "Equipo " + (valor2);
					if (valor2 == 1) {
						valor2 = numEquipos;
					}
				}
			}
		}

		// Muestra los enfrentamientos por jornada
		for (int i = 0; i < jornadas; i++) {
			System.out.println("Jornada " + (i + 1) + ":");
			for (int j = 0; j < numPartidos; j++) {
				System.out.print(enfrentamientoStrings[i][j] + "\n");
			}
			System.out.println("\n");
		}
	}

	public static int numeroEnRango() {
		// Se pide en formato String para comprobar facilmente cada caracter
		String numeroString;
		// Una vez este bien se devuelve en formato int
		int numeroValido = 0;
		// rango de numeros del 0 al 9
		boolean rango;
		// Comprobar si en algun caracter hay letra se repite bucle
		boolean hayLetra;
		int longitud;

		Scanner lecScanner = new Scanner(System.in);

		do {
			rango = false;
			hayLetra = false;
			System.out.print("Introduce el número de equipos: ");
			// Lo pide y le quita espacios por si acaso
			numeroString = lecScanner.nextLine().trim();
			longitud = numeroString.length();

			for (int i = 0; i < longitud; i++) {
				if (numeroString.charAt(i) >= 48 && numeroString.charAt(i) <= 57) {
					// Si despues de comprobar las anteriores no ha encontrado letra
					// y ha llegado a la ultima lo convierte a int
					if (i == longitud - 1 && !hayLetra) {
						numeroValido = Integer.parseInt(numeroString);
						if (numeroValido >= 3 && numeroValido <= 1000) {
							rango = true;
						} else {
							rango = false;
						}
					} else {
						rango = false;
					}
				} else {
					rango = false;
					hayLetra = true;
				}
			}
			if (!rango) {
				System.out.println("Error. Introduce un numero (3-1000): \n");
			}

		} while (!rango || hayLetra);
		
		lecScanner.close();

		return numeroValido;
	}
	
}

