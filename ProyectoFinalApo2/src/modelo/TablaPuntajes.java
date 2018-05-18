/**
 * 
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordoñes ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class TablaPuntajes implements Serializable {

	//Atributos
	private int cantidadJugadoresTabla;

	//Arbol
	private TablaPuntajes izquierda;
	private TablaPuntajes derecha;
	
	//Constructor
	public TablaPuntajes() {
		
		izquierda = null;
		derecha = null;
		
	}
	
	//Metodos
	public ArrayList<Jugador> darJugadoresOrdenadosPorPuntaje(){
		return null;
		
	}
	
	public Jugador darJugadorConPuntajeMayor() {
		return null;
	}
	
	public void agregarJugadorATablaDePuntajes(Jugador elJugador) {
		
	}
	
	public void eliminarJugadorTabla(Jugador elJugador) {
		
	}
	
	public Jugador buscarJugadorPorPuntaje(int puntaje) {
		return null;
		
	}
	
	public Jugador darJugador() {
		return null;
		
	} 
}
