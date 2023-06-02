
public class MetodosJugador {
	
	public void seleccionarJugador() {
		
	}
	
	
	public void mostrarJugadores(Equipo equipoSeleccionado) {//case3
		for (Jugador elementoJugador : equipoSeleccionado.getPlantillaArrayList()) {
			System.out.println(elementoJugador.getIdJugador() + ": " + elementoJugador.getNombreJugador()+" "+elementoJugador.getDorsal()+" "+elementoJugador.getPosicionJugador());
		}

		System.out.println();
		}
}
