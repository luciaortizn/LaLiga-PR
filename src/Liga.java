import java.util.ArrayList;

public class Liga {

	private String nombreLigaString;
	private ArrayList<Equipo> ligaEquipos = new ArrayList<Equipo>();
	private int idLiga;

	public Liga(String nombreLigaString, int idLiga) {
		super();
		this.nombreLigaString = nombreLigaString;
		this.idLiga = idLiga;
	}

	public String getNombreLigaString() {
		return nombreLigaString;
	}

	public void setNombreLigaString(String nombreLigaString) {
		this.nombreLigaString = nombreLigaString;
	}

	public ArrayList<Equipo> getLigaEquipos() {
		return ligaEquipos;
	}

	public void setLigaEquipos(ArrayList<Equipo> ligaEquipos) {
		this.ligaEquipos = ligaEquipos;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	@Override
	public String toString() {
		return "Liga [nombreLigaString=" + nombreLigaString + ", ligaEquipos=" + ligaEquipos + ", idLiga=" + idLiga
				+ "]";
	}

	public void addEquipo(Equipo item) {

		ligaEquipos.add(item);

	}

	public String[][] GenerarJornada() {

		int valor = 1;
		int valor2;
		int jornadas = 0;
		int numPartidos = 0;
		boolean esPar;
		int numEquipos = ligaEquipos.size();
		String[][] enfrentamientoStrings; // = new String[jornadas][numPartidos];

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
		enfrentamientoStrings = new String[jornadas][numPartidos];

		// bucle para crear el primer equipo del enfrentamiento (local)
		for (int i = 0; i < jornadas; i++) {
			for (int j = 0; j < numPartidos; j++) {
				enfrentamientoStrings[i][j] = ligaEquipos.get(valor - 1).getNombreEquipoString();

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
						enfrentamientoStrings[i][j] += " - " + ligaEquipos.get(numEquipos - 1).getNombreEquipoString();

					} else {
						enfrentamientoStrings[i][j] += " -> Descansa";

					}
					// Crea resto de equipos visitantes
				} else {
					if (esPar) {
						valor2--;
						enfrentamientoStrings[i][j] += " - " + ligaEquipos.get(valor2 - 1).getNombreEquipoString();
						if (valor2 == 1) {
							valor2 = numEquipos;
						}

					} else {
						enfrentamientoStrings[i][j] += " - " + ligaEquipos.get(valor2 - 1).getNombreEquipoString();
						valor2--;
						if (valor2 == 0) {
							valor2 = numEquipos;
						}

					}
				}
			}
		}
		for (int i = 0; i < jornadas; i++) {
			System.out.println("Jornada " + (i + 1) + ":");
			for (int j = 0; j < numPartidos; j++) {
				System.out.print(j + ": " + enfrentamientoStrings[i][j] + "\n");
			}
			System.out.println("\n");
		}

		return enfrentamientoStrings;
	}

}