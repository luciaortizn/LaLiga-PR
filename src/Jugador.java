public class Jugador {
	
	private String nombreJugador;
	private int dorsal;
	private String posicionJugador;
	
	private int idEquipo;
	private int idJugador;
	
	
	
	public Jugador(String nombreJugador, int dorsal, String posicionJugador, int idEquipo, int idJugador) {
		super();
		this.nombreJugador = nombreJugador;
		this.dorsal = dorsal;
		this.posicionJugador = posicionJugador;
		this.idEquipo = idEquipo;
		this.idJugador = idJugador;
	}
	
	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}

	public String getPosicionJugador() {
		return posicionJugador;
	}

	public void setPosicionJugador(String posicionJugador) {
		this.posicionJugador = posicionJugador;
	}

	public int getIdEquipo() {
		return idEquipo;
	}

	public void setIdEquipo(int idEquipo) {
		this.idEquipo = idEquipo;
	}

	public int getIdJugador() {
		return idJugador;
	}

	public void setIdJugador(int idJugador) {
		this.idJugador = idJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}
}