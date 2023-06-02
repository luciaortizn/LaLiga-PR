import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Gestion {
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_BLUE = "\033[34m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static final String ANSI_GREY_BACKGROUND = "\u001b[47m";

	public static void main(String[] args) {

		ArrayList<Liga> listaLigasArrayList = new ArrayList<Liga>();
		ArrayList<Equipo> listaEquipos = new ArrayList<Equipo>();

		int idsEquipos = 0;
		int idsJugadores = 0;
		int idsLigas = 0;

		Liga liga1 = new Liga("Liga1", idsLigas);
		Liga liga2 = new Liga("Liga2", 1);
		listaLigasArrayList.add(liga1);
		listaLigasArrayList.add(liga2);

		Equipo equipo1 = new Equipo("Real Madrid", 0, idsLigas);
		Equipo equipo2 = new Equipo("Barcelona", 1, idsLigas);
		Equipo equipo3 = new Equipo("Valencia", 2, idsLigas);
		Equipo equipo4 = new Equipo("Betis", 3, idsLigas);
		Equipo equipo5 = new Equipo("Getafe", 4, idsLigas);
		idsLigas = 1;
		Equipo equipo6 = new Equipo("Moscardo", 5, idsLigas);
		Equipo equipo7 = new Equipo("Arsenal", 6, idsLigas);
		Equipo equipo8 = new Equipo("PSG   ", 7, idsLigas);
		Equipo equipo9 = new Equipo("JUVENTUS", 8, idsLigas);
		Equipo equipo10 = new Equipo("Cordoba", 9, idsLigas);
		Equipo equipo11 = new Equipo("Cádiz", 10, idsLigas);

		// Prueba con puntos para ver si funciona ver clasificacion
		equipo1.setPuntos(16);
		equipo2.setPuntos(26);
		equipo3.setPuntos(16);
		equipo4.setPuntos(8);
		equipo5.setPuntos(3);

		equipo6.setPuntos(3);
		equipo7.setPuntos(6);
		equipo8.setPuntos(9);
		equipo9.setPuntos(30);
		equipo10.setPuntos(0);
		equipo11.setPuntos(10);

		liga1.addEquipo(equipo1);
		liga1.addEquipo(equipo2);
		liga1.addEquipo(equipo3);
		liga1.addEquipo(equipo4);
		liga1.addEquipo(equipo5);

		liga2.addEquipo(equipo6);
		liga2.addEquipo(equipo7);
		liga2.addEquipo(equipo8);
		liga2.addEquipo(equipo9);
		liga2.addEquipo(equipo10);
		liga2.addEquipo(equipo11);

		idsLigas = 2;

		Jugador jugador1 = new Jugador("Pepe", 1, "Delantero", idsEquipos, 0);	
		Jugador jugador4 = new Jugador("Ronaldo", 7, "Delantero", idsEquipos, 0);	
		Jugador jugador2 = new Jugador("Messi", 10, "Delantero", idsEquipos, 1);
		Jugador jugador3 = new Jugador("Pedri", 1, "Defensa", idsEquipos, 0);

		equipo1.addJugador(jugador1);
		equipo1.addJugador(jugador4);
		equipo2.addJugador(jugador2);
		equipo2.addJugador(jugador3);
		idsEquipos = 11;

		menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos, idsJugadores);

	}

	public static void menuLiga(ArrayList<Equipo> listaEquipos, ArrayList<Liga> listaLigasArrayList, int idsLigas,int idsEquipos, int idsJugadores) {

		int seleccion = 0;
		int index;
		int index2;

		String nombreLigaString;

		boolean encontrado = false;

		Liga ligaSeleccionada = null;

		int seleccionJornada = 0;
		int seleccionEnfrentamiento = 0;
		String enfrentamientosString[][] = null;
		int resultado1 = 0;
		int resultado2 = 0;
		// Case 5
		boolean encontradoClasificacion = false;
		boolean equipoMostrado = false;

		ArrayList<Liga> listaLigas = new ArrayList<Liga>();
		ArrayList<Equipo> equiposLiga = new ArrayList<Equipo>();
		ArrayList<Integer> puntosEquipos = new ArrayList<Integer>();
		ArrayList<String> nombresUsados = new ArrayList<String>();

		Scanner lecScanner = new Scanner(System.in);

		do {
			System.out.println("____________________________________________");
			System.out.println("                 MENÚ LIGA");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			System.out.println("1. Añadir Liga");
			System.out.println("2. Modificar Liga ");
			System.out.println("3. Mostrar Ligas");
			System.out.println("4. Ver enfrentamientos");
			System.out.println("5. Añadir Resultados");
			System.out.println("6. Ver clasificación");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			// System.out.print("Introduce una opción: ");

			try {
				seleccion = pedirNumero();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
			} catch (NoSuchElementException e) {
				System.out.println();
				//e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
			} catch (IllegalStateException e) {
				System.out.println();
				e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
			} catch (Exception e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
			}

			switch (seleccion) {
			case 1:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE+"       Ha seleccionado añadir Liga" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				System.out.print("Indique el nombre de la Liga: ");
				try {
					nombreLigaString = lecScanner.nextLine();

					if (nombreLigaString.length() <= 4) {
						System.out.println();
						System.out.println(ANSI_RED + "El nombre de la liga debe tener más de 4 carácteres" + ANSI_RESET);
					} else {
						index2 = 0;
						do {
							if (nombreLigaString.equals(listaLigasArrayList.get(index2).getNombreLigaString())) {
								// ligaSeleccionada = listaLigasArrayList.get(index2);
								encontrado = true;
							} else {
								index2++;
							}

						} while (!encontrado && index2 < listaLigas.size() - 1);

						if (!encontrado) {
							System.out.println();

							// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
							// idsJugadores);
							Liga liga1 = new Liga(nombreLigaString, idsLigas);
							listaLigasArrayList.add(liga1);
							idsLigas++;
							// menuEquipo(listaEquipos, listaLigasArrayList, ligaSeleccionada, idsEquipos,
							// idsJugadores);
						} else {
							System.out.println();
							System.out.println(ANSI_RED+"Lo siento, pero ya existe una liga con el nombre de '"+nombreLigaString+"'"+ANSI_RESET);
							encontrado = false;
						}
					}

				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				}

				break;
			case 2:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "     Ha seleccionado modificar Liga" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Liga elementoLiga : listaLigasArrayList) {
					System.out.println(elementoLiga.getIdLiga() + ". " + elementoLiga.getNombreLigaString());
				}

				System.out.println("____________________________________________");
				System.out.print("Introduce el nombre de la liga: ");

				try {
					nombreLigaString = lecScanner.nextLine();

					index = 0;
					do {
						if (nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())) {
							ligaSeleccionada = listaLigasArrayList.get(index);
							encontrado = true;

						} else {
							index++;
						}

					} while (!nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())|| !encontrado);

					if (encontrado) {
						// System.out.println("prueba");

						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
						menuEquipo(listaEquipos, listaLigasArrayList, ligaSeleccionada, idsEquipos, idsJugadores);
					}
				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IndexOutOfBoundsException e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				}

				break;
			case 3:
				System.out.println();
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "        Ha seleccionado mostrar Ligas" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Liga elementoLiga : listaLigasArrayList) {
					System.out.println(elementoLiga.getIdLiga() + ". " + elementoLiga.getNombreLigaString());
				}

				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
				break;
				
			case 4:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "      Ha seleccionado ver enfrentaminetos" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Liga elementoLiga : listaLigasArrayList) {
					System.out.println(elementoLiga.getIdLiga() + ": " + elementoLiga.getNombreLigaString());
				}
				System.out.println("____________________________________________");
				System.out.print("Introduce el nombre de la liga: ");

				try {

					nombreLigaString = lecScanner.nextLine();
					index = 0;
					do {
						if (nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())) {
							ligaSeleccionada = listaLigasArrayList.get(index);
							encontrado = true;
						} else {
							index++;
						}

					} while (!nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())
							|| !encontrado);
					encontrado = false;

					System.out.println("____________________________________________");
					System.out.println(ANSI_BLUE+"       Enfrentamientos "+ nombreLigaString + ANSI_RESET);
					System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
					
					enfrentamientosString = ligaSeleccionada.GenerarJornada();
					
					menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos, idsJugadores);
				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IndexOutOfBoundsException e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				}
			case 5:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "      Ha seleccionado añadir Resultados" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Liga elementoLiga : listaLigasArrayList) {
					System.out.println(elementoLiga.getIdLiga() + ": " + elementoLiga.getNombreLigaString());
				}
				System.out.println("____________________________________________");
				System.out.print("Introduce el nombre de la liga: ");

				try {

					nombreLigaString = lecScanner.nextLine();
					index = 0;
					do {
						if (nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())) {
							ligaSeleccionada = listaLigasArrayList.get(index);
							encontrado = true;
						} else {
							index++;
						}

					} while (!nombreLigaString.equals(listaLigasArrayList.get(index).getNombreLigaString())
							|| !encontrado);
					encontrado = false;

					enfrentamientosString = ligaSeleccionada.GenerarJornada();

					System.out.println("____________________________________________");
					System.out.println("Debe introducir la Jornada");
					System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

					try {
						do {
							seleccionJornada = pedirNumero();
							if (seleccionJornada > numJornadas(ligaSeleccionada.getLigaEquipos().size())
									|| seleccionJornada <= 0) {
								System.out.println("El numero introducido no corresponde con la cantidad de jornadas");
							}
						} while (seleccionJornada > numJornadas(ligaSeleccionada.getLigaEquipos().size())
								|| seleccionJornada <= 0);
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IndexOutOfBoundsException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					}

					System.out.println("____________________________________________");
					System.out.println("Debe introducir el Enfrentamiento");
					System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
					try {
						boolean valido;
						do {
							seleccionEnfrentamiento = pedirNumero();
							if (ligaSeleccionada.getLigaEquipos().size() % 2 != 0) {
								if (seleccionEnfrentamiento > numEnfrentamientos(ligaSeleccionada.getLigaEquipos().size()) || seleccionEnfrentamiento <= 0) {
									if (seleccionEnfrentamiento == 0) {
										System.out.println("El equipo local descansa en esta jornada, no se puede introducir un resultado");
									} else {
										System.out.println("El numero introducido no corresponde con la cantidad de enfrentamientos");
									}
									valido = false;
								} else {
									valido = true;
								}
							} else {
								if (seleccionEnfrentamiento > numEnfrentamientos(ligaSeleccionada.getLigaEquipos().size()) || seleccionEnfrentamiento < 0) {
									System.out.println(ANSI_RED + "El numero introducido no corresponde con la cantidad de enfrentamientos" + ANSI_RESET);
									valido = false;
								} else {
									valido = true;
								}

							}

						} while (!valido);

						System.out.println("");
						System.out.println(enfrentamientosString[seleccionJornada - 1][seleccionEnfrentamiento]);
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IndexOutOfBoundsException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					}

					System.out.println("____________________________________________");
					System.out.print("Indique el resultado local: ");
					try {
						resultado1 = lecScanner.nextInt();
						lecScanner.nextLine();

					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IndexOutOfBoundsException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					}

					System.out.println("____________________________________________");
					System.out.print("Indique el resultado visitante: ");
					try {
						resultado2 = lecScanner.nextInt();
						lecScanner.nextLine();
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (IndexOutOfBoundsException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					}
					System.out.println("");

					enfrentamientosString[seleccionJornada- 1][seleccionEnfrentamiento] = 
							enfrentamientosString[seleccionJornada- 1][seleccionEnfrentamiento] + "- " + resultado1 + " - " + resultado2;

					System.out.println(enfrentamientosString[seleccionJornada - 1][seleccionEnfrentamiento]);

					String[] result = enfrentamientosString[seleccionJornada - 1][seleccionEnfrentamiento].split("-",4);

					for (int i = 0; i < result.length; i++) {
						result[i] = result[i].trim();
					}

					try {
						index = -1;
						do {
							index++;
						} while (!ligaSeleccionada.getLigaEquipos().get(index).getNombreEquipoString()
								.equals(result[0]));

						if (resultado1 > resultado2) {
							ligaSeleccionada.getLigaEquipos().get(index)
									.setPuntos(ligaSeleccionada.getLigaEquipos().get(index).getPuntos() + 3);

						} else if (resultado1 == resultado2) {
							ligaSeleccionada.getLigaEquipos().get(index)
									.setPuntos(ligaSeleccionada.getLigaEquipos().get(index).getPuntos() + 1);

						}

						index = -1;
						do {
							index++;
						} while (!ligaSeleccionada.getLigaEquipos().get(index).getNombreEquipoString()
								.equals(result[1]));

						if (resultado2 > resultado1) {
							ligaSeleccionada.getLigaEquipos().get(index)
									.setPuntos(ligaSeleccionada.getLigaEquipos().get(index).getPuntos() + 3);

						} else if (resultado1 == resultado2) {
							ligaSeleccionada.getLigaEquipos().get(index)
									.setPuntos(ligaSeleccionada.getLigaEquipos().get(index).getPuntos() + 1);
						}
					} catch (IndexOutOfBoundsException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
						// idsJugadores);
					}
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (IndexOutOfBoundsException e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
					// idsJugadores);
				}

				break;
				
			case 6:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "Ha seleccionado ver clasificacion" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Liga elementoLiga : listaLigasArrayList) {
					System.out.println(elementoLiga.getIdLiga() + ": " + elementoLiga.getNombreLigaString());
					listaLigas.add(elementoLiga);
				}
				System.out.println("____________________________________________");
				System.out.print("Introduce el nombre de la liga: ");
				nombreLigaString = lecScanner.nextLine();

				for (Liga elementoLiga : listaLigasArrayList) {
					if (nombreLigaString.equals(elementoLiga.getNombreLigaString())) {
						ligaSeleccionada = elementoLiga;
						encontradoClasificacion = true;
					}
				}
				if (!encontradoClasificacion) {
					System.out.println(ANSI_RED + "Liga no valida" + ANSI_RESET);
					// Pongo que vuelva al menu para que no falle
					menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos, idsJugadores);
				}

				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE+"       Clasificacion "+ nombreLigaString + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				for (Equipo elementoEquipo : ligaSeleccionada.getLigaEquipos()) {
					// Guarda todos los equipos y recoge sus puntos
					equiposLiga.add(elementoEquipo);
					puntosEquipos.add(elementoEquipo.getPuntos());
				}
				// Ordenacion por puntos
				Collections.sort(puntosEquipos);
				Collections.reverse(puntosEquipos);

				// y despues muestra si no se ha mostrado ya
				System.out.println("");
				for (int j = 0; j < equiposLiga.size(); j++) {
					for (int k = 0; k < equiposLiga.size(); k++) {
						if (puntosEquipos.get(j) == equiposLiga.get(k).getPuntos()) {
							for (int i = 0; i < nombresUsados.size(); i++) {
								if (equiposLiga.get(k).getNombreEquipoString() == nombresUsados.get(i)) {
									equipoMostrado = true;
								}
							}
							if (equipoMostrado == false) {
								System.out.println(equiposLiga.get(k).getNombreEquipoString() +"           " + "	Puntos: "
										+ equiposLiga.get(k).getPuntos());
							}
							nombresUsados.add(equiposLiga.get(k).getNombreEquipoString());
							equipoMostrado = false;
						}
					}
				}

				break;
			case 7:
				
			default:
				System.out.println();
				System.out.println(ANSI_RED + "Introduce un número del 1-6" + ANSI_RESET);
				// menuLiga(listaEquipos, listaLigasArrayList, idsLigas, idsEquipos,
				// idsJugadores);
			}
		} while (seleccion != 7);
		
		//lecScanner.close();
	}

	public static void menuEquipo(ArrayList<Equipo> listaEquipos, ArrayList<Liga> listaligaArrayList,
			Liga ligaSeleccionada, int idsEquipos, int idsJugadores) {

		int seleccion = 0;
		String nombreEquipoString;
		int index = 0;
		boolean encontrado = false;

		Equipo equipoSeleccionado = null;

		Scanner lecScanner = new Scanner(System.in);
		do {
			System.out.println("____________________________________________");
			System.out.println("                MENÚ EQUIPO");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			System.out.println("1. Añadir Equipo");
			System.out.println("2. Modificar Equipo ");
			System.out.println("3. Ver Equipo");
			System.out.println("4. Salir");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

			try {
				seleccion = pedirNumero();

			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
				// idsJugadores);
			} catch (NoSuchElementException e) {
				System.out.println();
				e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
				// idsJugadores);
			} catch (IllegalStateException e) {
				System.out.println();
				e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
				// idsJugadores);
			} catch (Exception e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
				// idsJugadores);
			}

			switch (seleccion) {
			case 1:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "       Ha seleccionado añadir Equipo" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				System.out.println("____________________________________________");
				System.out.print("Indique el nombre del equipo: ");

				try {
					nombreEquipoString = lecScanner.nextLine();

					if (nombreEquipoString.length() <= 3) {
						System.out.println();
						System.out
								.println(ANSI_RED + "El nombre del equipo debe tener más de 3 carácteres" + ANSI_RESET);
					} else {
						Equipo equipo2 = new Equipo(nombreEquipoString, idsEquipos, ligaSeleccionada.getIdLiga());

						ligaSeleccionada.addEquipo(equipo2);

						idsEquipos++;
					}

					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (InputMismatchException e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					e.printStackTrace();
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				}

				break;
			case 2:
				index = 0;

				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "      Ha seleccionado modificar equipo" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				for (Equipo elementoEquipo : ligaSeleccionada.getLigaEquipos()) {
					System.out.println(elementoEquipo.getIdEquipo() + ": " + elementoEquipo.getNombreEquipoString());
				}
				System.out.println("____________________________________________");
				System.out.print("Introduce nombre del equipo: ");

				try {
					nombreEquipoString = lecScanner.nextLine();

					do {
						if (nombreEquipoString
								.equals(ligaSeleccionada.getLigaEquipos().get(index).getNombreEquipoString())) {
							equipoSeleccionado = ligaSeleccionada.getLigaEquipos().get(index);
							encontrado = true;
						} else {
							index++;
						}
					} while (!nombreEquipoString
							.equals(ligaSeleccionada.getLigaEquipos().get(index).getNombreEquipoString())
							|| !encontrado);

					if (encontrado) {
						// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
						// idsJugadores);

						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					}
				} catch (InputMismatchException e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (NoSuchElementException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (IllegalStateException e) {
					System.out.println();
					e.printStackTrace();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				}

				break;
			case 3:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "        Ha seleccionado ver equipos" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				try {
					for (Equipo elementoEquipo : ligaSeleccionada.getLigaEquipos()) {
						System.out
								.println(elementoEquipo.getIdEquipo() + ". " + elementoEquipo.getNombreEquipoString());
					}

					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error inesperado" + ANSI_RESET);
					// menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, idsEquipos,
					// idsJugadores);
				}

				break;
			case 4:
				System.out.println("____________________________________________");
				System.out.println(ANSI_RED + "           Saliste del menu equipo" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				menuLiga(listaEquipos, listaligaArrayList, index, idsEquipos, idsJugadores);
				break;
			}

		} while (seleccion != 4);

		//lecScanner.close();
	}

	public static void menuJugador(ArrayList<Equipo> listaEquipos, ArrayList<Liga> listaligaArrayList,
			Liga ligaSeleccionada, Equipo equipoSeleccionado, int idsJugadores) {
		int seleccion = 0, seleccionJugador;
		int dorsalJugador = 0;

		String nombreJugadorString = "";
		String posJugadorString = "";

		boolean jugadorCorrecto = false;
		boolean dorsalCorrecto = false;
		boolean pocicionCorrecto = false;

		Scanner lecScanner = new Scanner(System.in);
		do {
			System.out.println("____________________________________________");
			System.out.println("                MENÚ JUGADOR");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			System.out.println("1. Añadir Jugador");
			System.out.println("2. Ver Jugadores");
			System.out.println("3. Salir");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

			try {
				seleccion = pedirNumero();

			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
			} catch (NoSuchElementException e) {
				System.out.println();
				e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
			} catch (IllegalStateException e) {
				System.out.println();
				e.printStackTrace();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
			} catch (Exception e) {
				System.out.println();
				System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
				menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
			}

			switch (seleccion) {
			case 1:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "       Ha seleccionado añadir jugador" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				do {
					System.out.println();
					System.out.println("____________________________________________");
					System.out.print("Indique el nombre del jugador: ");
					try {
						nombreJugadorString = lecScanner.nextLine();

						if (nombreJugadorString.length() <= 1) {
							System.out.println();
							System.out.println(ANSI_RED + "El nombre del jugador no es correcto" + ANSI_RESET);
							System.out.println(ANSI_RED + "El nombre debe tener al menos 2 caracteres" + ANSI_RESET);
							System.out.println();
						} else {
							jugadorCorrecto = true;
						}
					} catch (InputMismatchException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					}

				} while (!jugadorCorrecto);

				do {
					System.out.println();
					System.out.println("____________________________________________");
					System.out.print("Indique el dorsal del jugador: ");

					try {
						dorsalJugador = lecScanner.nextInt();
						lecScanner.nextLine();

						if (dorsalJugador < 1 || dorsalJugador > 99) {
							System.out.println();
							System.out.println(ANSI_RED + "El dorsal del jugador no es correcto" + ANSI_RESET);
							System.out.println(
									ANSI_RED + "El dorsal debe estar comprendido entre el 1 y 99" + ANSI_RESET);
						} else {
							dorsalCorrecto = true;
						}
					} catch (InputMismatchException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					}

				} while (!dorsalCorrecto);

				do {
					System.out.println();
					System.out.println("____________________________________________");
					System.out.print("Indique la posicion del jugador: ");

					try {
						posJugadorString = lecScanner.nextLine();

						if (posJugadorString.length() <= 6) {
							System.out.println();
							System.out.println(ANSI_RED + "La posicion del jugador no es correcto" + ANSI_RESET);
							System.out.println();
						} else {
							pocicionCorrecto = true;
						}
					} catch (InputMismatchException e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (NoSuchElementException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (IllegalStateException e) {
						System.out.println();
						e.printStackTrace();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					} catch (Exception e) {
						System.out.println();
						System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
						menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado,
								idsJugadores);
					}

				} while (!pocicionCorrecto);

				Jugador jugador1 = new Jugador(nombreJugadorString, dorsalJugador, posJugadorString,
						equipoSeleccionado.getIdEquipo(), idsJugadores);

				equipoSeleccionado.addJugador(jugador1);
				idsJugadores++;

				menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);

				break;
			case 2:
				System.out.println("____________________________________________");
				System.out.println(ANSI_BLUE + "      Ha seleccionado ver Jugadores" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");

				try {
					for (Jugador elementoJugador : equipoSeleccionado.getPlantillaArrayList()) {
						System.out.println("____________________________________________");
						System.out.println("   Nombre       Dorsal      Posicion");
						System.out.println("   "+elementoJugador.getNombreJugador()
								+ "         " + elementoJugador.getDorsal() + "        "
								+ elementoJugador.getPosicionJugador());
					}

					System.out.println();
					menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
				} catch (Exception e) {
					System.out.println();
					System.out.println(ANSI_RED + "Error: " +e.getMessage() + ANSI_RESET);
					menuJugador(listaEquipos, listaligaArrayList, ligaSeleccionada, equipoSeleccionado, idsJugadores);
				}
				break;
			case 3:
				System.out.println("____________________________________________");
				System.out.println(ANSI_RED + "        Saliste del menu jugador" + ANSI_RESET);
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				menuEquipo(listaEquipos, listaligaArrayList, ligaSeleccionada, dorsalJugador, idsJugadores);
				break;
			}

		} while (seleccion != 3);

		//lecScanner.close();
	}

	public static int pedirNumero() {
		// Se pide en formato String para comprobar facilmente cada caracter
		String numeroString;
		// Una vez este bien se devuelve en formato int
		int numeroValido = 0;
		// Comprobar si en algun caracter hay letra se repite bucle
		boolean hayLetra;
		int longitud;

		Scanner lecScanner = new Scanner(System.in);

		do {
			hayLetra = false;
			System.out.print("Introduce una opción: ");
			// Lo pide y le quita espacios por si acaso
			numeroString = lecScanner.nextLine().trim();
			longitud = numeroString.length();

			for (int i = 0; i < longitud; i++) {
				if (numeroString.charAt(i) >= 48 && numeroString.charAt(i) <= 57) {
					// Si despues de comprobar las anteriores no ha encontrado letra
					// y ha llegado a la ultima lo convierte a int
					if (i == longitud - 1 && !hayLetra) {
						numeroValido = Integer.parseInt(numeroString);
					}
				} else {
					hayLetra = true;
				}
			}
			if (hayLetra) {
				System.out.println();
				System.out.println(ANSI_RED+"Has introducido una letra"+ANSI_RESET);
				System.out.println();
			}

		} while (hayLetra);

		//lecScanner.close();
		
		return numeroValido;
	}

	public static int numJornadas(int numEquipos) {
		int jornadas;

		if (numEquipos % 2 == 0) {
			jornadas = numEquipos - 1;

		} else {
			jornadas = numEquipos;
		}
		return jornadas;
	}

	public static int numEnfrentamientos(int numEquipos) {
		int numPartidos;

		if (numEquipos % 2 == 0) {
			numPartidos = numEquipos / 2;

		} else {
			numPartidos = ((numEquipos + 1) / 2);

		}
		return numPartidos;
	}

}