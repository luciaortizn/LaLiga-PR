import java.util.ArrayList;

public class Equipo {

	private String nombreEquipoString;

	private ArrayList<Jugador> plantillaArrayList = new ArrayList<Jugador>();
	
	private int idEquipo;

	private int idLiga;
	
	private int puntos;
	
	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public Equipo(String nombreEquipoString, int idEquipo, int idLiga) {
		super();
		this.nombreEquipoString = nombreEquipoString;
		this.idEquipo = idEquipo;
		this.idLiga = idLiga;
	}

	public String getNombreEquipoString() {
		return nombreEquipoString;
	}

	public void setNombreEquipoString(String nombreEquipoString) {
		this.nombreEquipoString = nombreEquipoString;
	}

	public int getIdLiga() {
		return idLiga;
	}

	public void setIdLiga(int idLiga) {
		this.idLiga = idLiga;
	}

	public ArrayList<Jugador> getPlantillaArrayList() {
		return plantillaArrayList;
	}

	public void setPlantillaArrayList(ArrayList<Jugador> plantillaArrayList) {
		this.plantillaArrayList = plantillaArrayList;
	}
	
	

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}
	
	
	public void addJugador(Jugador item) {
		plantillaArrayList.add(item);
	}

	@Override
	public String toString() {
		return "Equipo [nombreEquipoString=" + nombreEquipoString + ", plantillaArrayList=" + plantillaArrayList
				+ ", idEquipo=" + idEquipo + ", idLiga=" + idLiga + "]";
	}

	

	

}
