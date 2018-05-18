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
	
	//MIRAR CLASE COMPARADOR 
	private Comparador comparador;
	
	//Arbol
	private Jugador jugadorRaiz;

	
	//Constructor
	public TablaPuntajes() {
		cantidadJugadoresTabla=0;
		comparador = new Comparador();
		jugadorRaiz = null;
	}
	
	//Este metodo recorre el arbol de jugadores y retorna un arraylist, el arraylist debe estar ordenado de mayor a menor
	public ArrayList<Jugador> darJugadoresOrdenadosPorPuntaje(){
		return null;
		
	}
	// retorna el jugador con mayor puntaje en el arbol
	public Jugador darJugadorConPuntajeMayor() {
		return null;
	}
	// retorna el jugador con menor puntaje en el arbol
	public Jugador darJugadorConPuntajeMenor() {
		return null;
	}
	// busca el jugador que teng el puntaje que llega por parametro, si no lo encuentra lanza la excepcion PuntajeNoRegistradoException
	public Jugador buscarJugadorPorPuntaje(int puntaje) {
		return null;
		
	}
	//CRITERIO PARA AGREGAR: POR MEDIO DEL PUNTAJE
	//agrega un jugador que llega por parametro al arbol, suma 1 a la variable cantidadJugadoresTabla
	public void agregarJugadorATablaDePuntajes(Jugador elJugador) {
		
	}
	
	//elimina un jugador al arbol, suma 1 a la variable cantidadJugadoresTabla (se debe recorrer toda el arbol para poder eliminar)
	public void eliminarJugadorTabla(Jugador elJugador) {
		
	}

	public Jugador darJugadorRaiz() {
		return jugadorRaiz;
		
	} 
}
