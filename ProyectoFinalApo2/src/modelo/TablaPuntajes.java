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
	
	/**
	 *Nombre: organizarJugadores
	 *El metodo se encarga de organizar un ArrayList de Jugador de mayor a menor puntaje
	 * @param losJugadores - ArrayList que contiene Jugador a organizar
	 * @return losJugadores - ArrayList de jugadores organizados de mayor a menor
	 */
	public ArrayList<Jugador> organizarJugadores(ArrayList<Jugador> losJugadores){
		
		for(int i = 1; i < losJugadores.size(); i++) {
			for(int j = i; j > 0 && comparador.compare(losJugadores.get(j-1), losJugadores.get(j)) < 0; j--) {
				Jugador auxJugador = losJugadores.get(j);
				losJugadores.set(j, losJugadores.get(j-1));
				losJugadores.set(j-1, auxJugador);
			}
		}
		return losJugadores;
	}
	/**
	 * Nombre: retornarJugadores
	 * Este metodo se encarga de crear el ArrayList donde se van a almacenar los Jugadores y
	 * de llamar el metodo inorden
	 * @param jugadorRaiz - Raiz del arbol binario
	 * @return losJugadores - ArrayList de jugadores(El ArrayList esta desorganizado)
	 */
	public ArrayList<Jugador> retornarJugadores(Jugador jugadorRaiz){
		
		if(jugadorRaiz == null) {
			return null;
		}else {
			ArrayList<Jugador> losJugadores = new ArrayList<Jugador>();
			inorden(jugadorRaiz, losJugadores);
			return losJugadores;
		}
		
	}
	/**
	 * Nombre: inorden
	 * Este metodo se encarga de guardar los objetos de tipo Jugador en un ArrayList que se pasa
	 * como parametro
	 * @param jugadorRaiz - Raiz del arbol binario
	 * @param losJugadores - ArrayList donde se van a almacenar los objetos de tipo Jugador
	 */
	public void inorden(Jugador jugadorRaiz, ArrayList<Jugador> losJugadores) {
		
		if(jugadorRaiz != null) {
			if(jugadorRaiz.darNodoIzquierdo() != null) {
				inorden(jugadorRaiz.darNodoIzquierdo(), losJugadores);
			}
			losJugadores.add(jugadorRaiz);
			if(jugadorRaiz.darNodoDerecho() != null) {
				inorden(jugadorRaiz.darNodoDerecho(), losJugadores);
			}
		}
		
	}
	
	
	// retorna el jugador con mayor puntaje en el arbol
	/**
	 * Nombre: darJugadorConPuntajeMayor
	 * Este metodo se encarga de retornar el Jugador con mayor puntaje en el arbol binario
	 * @param raizJugador - Raiz del arbol binario
	 * @return Jugador con mayor puntaje
	 */
	public Jugador darJugadorConPuntajeMayor(Jugador raizJugador) {
		
		if(raizJugador.darNodoDerecho() == null) {
			return raizJugador;
		}else {
			return darJugadorConPuntajeMayor(raizJugador.darNodoDerecho());
		}
		
	}
	// retorna el jugador con menor puntaje en el arbol
	/**
	 * Nombre: darJugadorConPuntajeMenor
	 * Este metodo se encarga de retornar el Jugador con menor puntaje en el arbol binario
	 * @param raizJugador - Raiz del arbol binario
	 * @return Jugador con menor puntaje
	 */
	public Jugador darJugadorConPuntajeMenor(Jugador raizJugador) {
			
		if(raizJugador.darNodoIzquierdo() == null) {
			return raizJugador;
		}else {
			return darJugadorConPuntajeMenor(raizJugador.darNodoIzquierdo());
		}
	
	}
	// busca el jugador que teng el puntaje que llega por parametro, si no lo encuentra lanza la excepcion PuntajeNoRegistradoException
	/**
	 * Nombre: buscarJugadorPorPuntaje
	 * Este metodo se encarga de buscar de buscar a un jugador por medio del puntaje
	 * @param elJugadorRaiz - Raiz del arbol
	 * @param puntaje - Puntaje del Jugador que se desea buscar
	 * @return Jugador con el puntaje pasado como parametro
	 * @throws PuntajeNoRegistradoException - Lanza Excepcion si el puntaje del no existe
	 */
	public Jugador buscarJugadorPorPuntaje(Jugador elJugadorRaiz, int puntaje) throws PuntajeNoRegistradoException  {
		
		if(elJugadorRaiz != null) {
			if(elJugadorRaiz.darPuntaje() == puntaje) {
				return elJugadorRaiz;
			}else if(elJugadorRaiz.darPuntaje() > puntaje) {
				return buscarJugadorPorPuntaje(elJugadorRaiz.darNodoIzquierdo(), puntaje);
			}else {
				return buscarJugadorPorPuntaje(elJugadorRaiz.darNodoDerecho(), puntaje);
			}
		}
		
		if(elJugadorRaiz == null) {
			throw new PuntajeNoRegistradoException("Puntaje no encontrado");
		}
		return null;
		
	}
	//CRITERIO PARA AGREGAR: POR MEDIO DEL PUNTAJE
	//agrega un jugador que llega por parametro al arbol, suma 1 a la variable cantidadJugadoresTabla
	/**
	 * Nombre: agregarJugadorATablaDePuntajes
	 * Este metodo se encarga de llamar al metodo insertar para que agrege un nuevo jugador y
	 * subir el valor de el atributo cantidadJugadoresTabla
	 * @param nuevoJugador - Jugador que se desea agregar
	 * @post En el arbol binario se agrego un Jugador
	 */
	public void agregarJugadorATablaDePuntajes(Jugador nuevoJugador) {
	
		if(jugadorRaiz == null) {
			jugadorRaiz = nuevoJugador;
		}else {
			insertar(nuevoJugador, jugadorRaiz);
		}
		
		cantidadJugadoresTabla++;
	}
	/**
	 * Nombre: insertar
	 * Este metodo se encarga de agregar un nuevo jugador al arbol binario
	 * @param nuevo - Jugador que se desea añadir
	 * @param raiz - Raiz del arbol binario
	 */
	public void insertar(Jugador nuevo, Jugador raiz) {
		
		if(comparador.compare(raiz, nuevo) > 0) {
			if(raiz.darNodoIzquierdo() == null) {
				raiz.setNodoIzquierdo(nuevo);
			}else {
				insertar(nuevo, raiz.darNodoIzquierdo());
			}
		}else {
			if(raiz.darNodoDerecho() == null) {
				raiz.setNodoDerecho(nuevo);
			}else {
				insertar(nuevo, raiz.darNodoDerecho());
			}
		}
		
	}
	
	//elimina un jugador al arbol, suma 1 a la variable cantidadJugadoresTabla (se debe recorrer toda el arbol para poder eliminar)
	/**
	 * Nombre: eliminarJugadorTabla
	 * Este metodo se encarga de insertal al arbol binario su nueva rama o hoja
	 * @param puntaje - Puntaje del jugador que se desea eliminar
	 * @post En el arbol binario se elimino un Jugador
	 */
	public void eliminarJugadorTabla(int puntaje) {
	
		if(jugadorRaiz.darPuntaje() == puntaje) {
			jugadorRaiz = null;
		}else {
			eliminar(puntaje, jugadorRaiz);
		}	
		cantidadJugadoresTabla--;
	}
	/**
	 * Nombre: eliminar
	 * Este metodo se encarga de eliminar el Jugador por medio del puntaje pasado como parametro y
	 * organizar el arbol para que no se desordenen los datos
	 * @param puntaje - Puntaje del jugador que se desea eliminar
	 * @param raiz - Raiz del arbol
	 * @return Retorna un jugador para insetarlo en el arbol binario
	 */
	public Jugador eliminar(int puntaje, Jugador raiz) {
		
		if(raiz.darNodoDerecho() == null && raiz.darNodoIzquierdo() == null) {
			return null;
		}
		if(raiz.darPuntaje() == puntaje) {
			if(raiz.darNodoIzquierdo() == null) {
				return raiz.darNodoDerecho();
			}
			if(raiz.darNodoDerecho() == null) {
				return raiz.darNodoIzquierdo();
			}
			Jugador sucesor = darJugadorConPuntajeMenor(raiz.darNodoDerecho());
			raiz.setNodoDerecho(eliminar(puntaje, raiz.darNodoDerecho()));
			sucesor.setNodoIzquierdo(raiz.darNodoIzquierdo());
			sucesor.setNodoDerecho(raiz.darNodoDerecho());
			return sucesor;
		}
		else if(raiz.darPuntaje() > puntaje) {
			raiz.setNodoIzquierdo(eliminar(puntaje, raiz.darNodoIzquierdo()));
		}else {
			raiz.setNodoDerecho(eliminar(puntaje, raiz.darNodoDerecho()));
		}
		return raiz;
	}
	
	
}
