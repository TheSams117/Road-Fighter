package modelo;

import java.util.ArrayList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordoñes ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class RoadFigther {
	//Atributos
	private int cantidadJugadores;
	private int cantidadCarreras;
	
	//Relaciones
	private TablaPuntajes tablaPuntajes;
	private Carretera carretera;
	private Carretera carreteraSeleccionada;
	private Jugador jugador;
	
	//Constructor
	public RoadFigther() {
		
		cantidadJugadores = 0;
		cantidadCarreras = 0;
		carretera=null;
		carreteraSeleccionada=null;
		jugador=null;
		tablaPuntajes = new TablaPuntajes();
		
	}
		
	public int darCantidadJugadores() {
		return cantidadJugadores;
	}

	public void cambiarCantidadJugadores(int pCantidadJugadores) {
		cantidadJugadores = pCantidadJugadores;
	}

	public int darCantidadCarreras() {
		return cantidadCarreras;
	}

	public void cambiarCantidadCarreras(int pCantidadCarreras) {
		cantidadCarreras = pCantidadCarreras;
	}

	public TablaPuntajes darTablaPuntajes() {
		return tablaPuntajes;
	}

	public Carretera darCarretera() {
		return carretera;
	}

	public void cambiarCarretera(Carretera pCarretera) {
		carretera = pCarretera;
	}
	
	public Carretera darCarreteraSeleccionada() {
		return carreteraSeleccionada;
	}

	public void cambiarCarreteraSeleccionada(Carretera pCarreteraSeleccionada) {
		carreteraSeleccionada = pCarreteraSeleccionada;
	}



	public Jugador darJugador() {
		return jugador;
	}



	public void cambiarJugador(Jugador pJugador) {
		jugador = pJugador;
	}
	
	public void agregarCarretera(int pAutomovil,int pCarretera) {
		
	}
	
	
	//Metodos

	public Jugador buscarJugadorPorNombre(Jugador elJugador) {
		return elJugador;
		
	}
	
	public void agregarJugador() {
		
	}
	
	public void eliminarJugador() {
		
	
	}
		
	public ArrayList<Jugador> darJugadoresOrdenadosPorNombre(){
		return null;
			
	}
	
		
	public Automovil[] darAutomovil() {
		return null;
	}
	
	public Carretera buscarCarretera(int laCarretera) {
		return null;
	}
		
	public void ordenarCarreterasLista() {
			
	}
		
	public Carretera buscarCarreteraArreglo(int laCarretera) {
		return null;
			
	}
		
	public void guardarPartida() {
			
	}
		
	public void nuevaPartida(int numero1, int numero2) {
			
	}
		
	public String[] darHistorial() {
		return null;
			
	}
}
