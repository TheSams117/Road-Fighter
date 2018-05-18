package modelo;

import java.io.Serializable;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordoñes ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class Jugador implements Comparable<Jugador>,Serializable{
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// ATRIBUTOS
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Declaracion de canena de caracteres que representa el nombre ingresado por el jugador.
	 */
	private String nombre;
	/**
	 * Declaracion de entero que representa el puntaje obtenido por el jugador en una partida.
	 */
	private int puntaje;
	/**
	 * Declaracion de entero que representa la carretera seleccionada por el jugador en la partida.
	 */
	private int numeroCarreteraSeleccionada;
	/**
	 * Declaracion de objeto Jugador que representa el jugador siguiente en la lista enlazada.
	 */
	private Jugador nodoDerecho;
	/**
	 * Declaracion de objeto Jugador que representa el jugador anterior en la lista enlazada.
	 */
	private Jugador nodoIzquierdo;
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// 								METODOS
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// METODO: CONSTRUCTOR
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * Crea un jugador, inicializa sus atributos con los parámetro recibidos. <br>
	 * @param pNombre El nombre del jugador. 
	 * @param pPuntaje El puntaje obtenido en la partida.
	 * @param pCarreteraSeleccionada Carretera seleccionada por el jugador.
	 * @param pPlacaAutoMovilSeleccionado Automovil seleccionado por jugador
	 */	
	public Jugador(String pNombre, int pPuntaje,int pCarreteraSeleccionada) {
		nombre = pNombre;
		puntaje = pPuntaje;
		nodoDerecho = null;
		nodoIzquierdo = null;
		numeroCarreteraSeleccionada = pCarreteraSeleccionada;
	}
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// METODO: DAR(get) y CAMBIAR(set)
	// --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	/**
	 * @return El nombre del jugador.
	 */
	public String darNombre() {
		return nombre;
	}
	/**
	 * @return El puntaje del jugador.
	 */
	public int darPuntaje() {
		return puntaje;
	}
	/**
	 * Cambia el puntaje del jugador. <br>
	 * @param pNuevoPuntaje el nuevo puntaje del jugador.
	 */
	public void cambiarPuntaje(int pNuevoPuntaje) {
		puntaje=pNuevoPuntaje;
	}
	/**
	 * @return El nodo derecho (Jugadores mayores) del jugador.
	 */
	public Jugador darNodoDerecho() {
		return nodoDerecho;
	}
	/**
	 * @return El nodo izquierdo (Jugadores menores) del jugador.
	 */
	public Jugador darNodoIzquierdo() {
		return nodoIzquierdo;
	}
	/**
	 * @return El numero que representa la carretera seleccionada por el jugador.
	 */
	public int darNumeroCarreteraSeleccionada() {
		return numeroCarreteraSeleccionada;
	}
	/**
	 * Compara al jugador con el PJugador que llega por parametro por nombre. <br>
	 * @param PJugador jugador con el que se quiere comparar.
	 * @return numero>0 si PJugador es menor, numero<0 si PJugador es mayor o numero==0 si PJugador es igual.
	 */
	@Override
	public int compareTo(Jugador PJugador) {
		return this.compareTo(PJugador);
	}
	
	@Override
	public String toString() {
		return "Nombre: "+nombre+" --- Puntaje: "+puntaje;
	}
}
