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
	private Jugador jugadorRaiz;

	
	//Constructor.
	public TablaPuntajes() {
		cantidadJugadoresTabla=0;
		jugadorRaiz = null;
	}
	
	/**
	 * Nombre: darJugadoresOrdenadosMayorAMenor
	 * Este metodo devuelve un ArrayList de Jugador
	 * @return losJugadores - ArrayList de jugadores
	 */
	public ArrayList<Jugador> darJugadoresOrdenadosMayorAMenor(){
		jugadorRaiz.cambiarToString(jugadorRaiz, false);
		ArrayList<Jugador> losJugadores= new ArrayList<Jugador>();
		jugadorRaiz.inorden(losJugadores);
		ordenarJugadoresMayorAMenor(losJugadores);
		return losJugadores;
		
	}
	
	/**
	 * Nombre: ordenarJugadoresMayorAMenor
	 * Este metodo permite ordenar un ArrayList de Jugador de mayor a 
	 * menor puntaje
	 * @param losJugadores - ArrayList el cual se desea ordenar
	 */
	public void ordenarJugadoresMayorAMenor(ArrayList<Jugador> losJugadores) {
		
		Jugador temp=null;
		for (int i = 0; i < losJugadores.size(); i++) {
			for (int j = 0; j < losJugadores.size()-1; j++) {
				if(jugadorRaiz.getComparador().compare(losJugadores.get(j), losJugadores.get(j+1))<0) {
					temp=losJugadores.get(j);
					losJugadores.set(j,losJugadores.get(j+1));
					losJugadores.set(j+1, temp);
				}
			}
		}
		
	}

	/**
	 * Nombre: agregarJugadorATablaDePuntajes
	 * Permite agregar un Jugador al arbol binario
	 * @param elJugador - Jugador el cual se desea agregar
	 * @posr Se agrego un Jugador al arbol
	 */
	public void agregarJugadorATablaDePuntajes(Jugador elJugador) {
	
		if(jugadorRaiz == null) {
			jugadorRaiz = elJugador;
		}else {
			jugadorRaiz.insertarPorPuntaje(elJugador);
		}
		cantidadJugadoresTabla++;
		
	}
	
	/**
	 * Nombre: eliminarJugadorTabla
	 * Permite eliminar un jugador del arbol binario
	 * @param puntaje - puntaje del jugador el cual se desea
	 * eliminar
	 * @post Jugador del arbol binario eliminado
	 */
	public void eliminarJugadorTabla(int puntaje) {
	
		if(jugadorRaiz.darPuntaje() == puntaje) {
			jugadorRaiz = jugadorRaiz.eliminarPorPuntaje(puntaje);
		}else {
			jugadorRaiz.eliminarPorPuntaje(puntaje);
		}
		
		cantidadJugadoresTabla--;
	
	}
	
	/**
	 * Nombre: buscarPuntaje
	 * Llama al metodo buscarJugadorPorPuntaje de la clase Jugador y 
	 * lanza excepcion cuando el puntaje no a sido encontrado
	 * @param puntaje - Puntaje del Jugador el cual se desea buscar
	 * @return Jugador con el mismo puntaje pasado como parametro
	 * @throws PuntajeNoRegistradoException Se lanza la excepcion si el puntaje no se encuentra
	 */
	public Jugador buscarPuntaje(int puntaje)throws PuntajeNoRegistradoException{
		
		if(jugadorRaiz.buscarJugadorPorPuntaje(puntaje) == null) {
			throw new PuntajeNoRegistradoException("El puntaje "+puntaje+" no ha sido encontrado");
		}else {
			return jugadorRaiz.buscarJugadorPorPuntaje(puntaje);
		}
	}
	
	public Jugador darJugadorConMayorPuntaje() {
		return jugadorRaiz.darJugadorConPuntajeMayor();
	}
	
	public Jugador darJugadorConMenorPuntaje() {
		return jugadorRaiz.darJugadorConPuntajeMenor();
	}
}
