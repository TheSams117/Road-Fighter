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
	 * Declaracion de enetero que representa la carretera seleccionada por el jugador en la partida.
	 */
	private int carreteraSeleccionada;
	/**
	 * Declaracion de objeto Jugador que representa el jugador siguiente en la lista enlazada.
	 */
	private Jugador nodoDerecho;
	/**
	 * Declaracion de objeto Jugador que representa el jugador anterior en la lista enlazada.
	 */
	private Jugador nodoIzquierdo;
	
	private Comparador comparador;
	
	private boolean comportamientoToString;
	
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
		
		comparador = new Comparador();
		comportamientoToString = false;
		nombre = pNombre;
		puntaje = pPuntaje;
		nodoDerecho = null;
		nodoIzquierdo = null;
		carreteraSeleccionada = pCarreteraSeleccionada;
	}
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	// METODO: DAR(get) y CAMBIAR(set)
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * Nombre: darJugadorConPuntajeMenor
	 * Este metodo se encarga de retornar el Jugador con menor puntaje en el arbol binario
	 * @return Jugador con menor puntaje
	 */
	public Jugador darJugadorConPuntajeMenor() {
		return (nodoIzquierdo == null) ? this : nodoIzquierdo.darJugadorConPuntajeMenor();
	}
	

	public void cambiarPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}
	
	
	public boolean darComportamientoToString() {
		return comportamientoToString;
	}

	public void cambiarComportamientoToString(boolean comportamientoToString) {
		this.comportamientoToString = comportamientoToString;
	}

	public int darCarreteraSeleccionada() {
		return carreteraSeleccionada;
	}

	public void cambiarCarreteraSeleccionada(int carreteraSeleccionada) {
		this.carreteraSeleccionada = carreteraSeleccionada;
	}

	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Nombre: darJugadorConPuntajeMayor
	 * Este metodo se encarga de retornar el Jugador con mayor puntaje en el arbol binario
	 * @return Jugador con mayor puntaje
	 */
	public Jugador darJugadorConPuntajeMayor() {
		
		if(darNodoDerecho() == null) {
			return this;
		}else {
			return nodoDerecho.darJugadorConPuntajeMayor();
		}
		
	}
	
	/**
	 * Nombre: insertarPorPuntaje
	 * Este metodo se encarga de agregar un nuevo jugador al arbol binario por medio 
	 * del puntaje
	 * @param nuevo - Jugador que se desea añadir
	 * @post Jugador agregado al arbol binario
	 */
	public void insertarPorPuntaje(Jugador nuevo) {
		
		if(comparador.compare(this, nuevo) > 0) {
			if(nodoIzquierdo == null) {
				nodoIzquierdo = nuevo;
			}else {
				nodoIzquierdo.insertarPorPuntaje(nuevo);
			}
		}else {
			if(nodoDerecho == null) {
				nodoDerecho = nuevo;
			}else {
				nodoDerecho.insertarPorPuntaje(nuevo);
			}
		}
		
	}
	
	/**
	 * Nombre: insertarPorNombre
	 * Este metodo se encarga de agregar un nuevo jugador al arbol binario
	 * por medio del nombre
	 * @param nuevo - Jugador que se desea añadir
	 * @throws JugadorYaRegistradoException Se lanza la excepcion si el jugador ya esta registrado
	 * @post Jugador agregado al arbol binario
	 */
	public void insertarPorNombre(Jugador nuevo) throws JugadorYaRegistradoException {
		if(compareTo(nuevo)==0) {
			throw new JugadorYaRegistradoException("El jugador "+nuevo.getNombre()+" ya se encuentra registrado");
		}else if(compareTo(nuevo) > 0) {
			if(nodoIzquierdo == null) {
				nodoIzquierdo = nuevo;
			}else {
				nodoIzquierdo.insertarPorNombre(nuevo);
			}
		}else {
			if(nodoDerecho == null) {
				nodoDerecho = nuevo;
			}else {
				nodoDerecho.insertarPorNombre(nuevo);
			}
		}
		
	}
	
	/**
	 * Nombre: eliminarPorPuntaje
	 * Este metodo se encarga de eliminar el Jugador por medio del puntaje pasado como parametro y
	 * organizar el arbol para que no se desordenen los datos
	 * @param elPuntaje - Puntaje del jugador que se desea eliminar
	 * @return Retorna un jugador para insetarlo en el arbol binario
	 */
	public Jugador eliminarPorPuntaje(int elPuntaje) {
		
		if(soyHoja()) {
			return null;
		}else if(this.puntaje==elPuntaje){
			if(this.nodoDerecho==null)
				return nodoIzquierdo;
			if(this.nodoIzquierdo==null)
				return nodoDerecho;		
			Jugador sucesor= nodoDerecho.darJugadorConPuntajeMenor();
			this.nodoDerecho=nodoDerecho.eliminarPorPuntaje(sucesor.puntaje);
			sucesor.nodoIzquierdo=nodoIzquierdo;
			sucesor.nodoDerecho=nodoDerecho;
			return sucesor;
		}
		else if(this.puntaje<elPuntaje) {
			 nodoDerecho=nodoDerecho.eliminarPorPuntaje(elPuntaje);
		}
		else {
			 nodoIzquierdo=nodoIzquierdo.eliminarPorPuntaje(elPuntaje);
		}
		return this;
	}
	
	/**
	 * Nombre: elimininarPorNombre
	 * Este metodo se encarga de eliminar el Jugador por medio del nombre pasado como parametro y
	 * organizar el arbol para que no se desordenen los datos
	 * @param elNombre - Nombre del jugador que se desea eliminar
	 * @return Retorna un jugador para insetarlo en el arbol binario
	 */
	public Jugador elimininarPorNombre(String elNombre) {
		
		if(soyHoja())
			return null;
		else if(nombre.compareTo(elNombre) == 0){
			if(this.nodoDerecho==null)
				return nodoIzquierdo;
			if(this.nodoIzquierdo==null)
				return nodoDerecho;	
			Jugador sucesor= nodoDerecho.darJugadorConPuntajeMenor();
			this.nodoDerecho=nodoDerecho.elimininarPorNombre(sucesor.getNombre());
			sucesor.nodoIzquierdo=nodoIzquierdo;
			sucesor.nodoDerecho=nodoDerecho;
			return sucesor;
		}
		else if(nombre.compareTo(elNombre) < 0) {
			 nodoDerecho=nodoDerecho.elimininarPorNombre(elNombre);
		}
		else {
			 nodoIzquierdo=nodoIzquierdo.elimininarPorNombre(elNombre);
		}
		return this;
	}

	/**
	 * Nombre: buscarJugadorPorPuntaje
	 * Este metodo se encarga de buscar de buscar a un jugador por medio del puntaje
	 * @param elPuntaje - Puntaje del Jugador que se desea buscar
	 * @return Jugador con el puntaje pasado como parametro
	 */
	public Jugador buscarJugadorPorPuntaje(int elPuntaje) {
	
		if(puntaje == elPuntaje) {
			return this;
		}else if(puntaje > elPuntaje) {
			if(nodoIzquierdo == null) {
				return null;
			}else {
				return nodoIzquierdo.buscarJugadorPorPuntaje(elPuntaje);
			}
		}else {
			if(nodoDerecho == null) {
				return null;
			}else {
				return nodoDerecho.buscarJugadorPorPuntaje(elPuntaje);
			}
		}
	
	}
	
	/**
	 * Nombre: buscarJugadorPorNombre
	 * Este metodo se encarga de buscar de buscar a un jugador por medio del nombre
	 * @param elNombre - Nombre del jugador que se quiere encontrar
	 * @return Jugador con el nombre que se pasa como parametro
	 */
	public Jugador buscarJugadorPorNombre(String elNombre) {
		
		if(nombre.compareTo(elNombre) == 0) {
			return this;
		}else if(nombre.compareTo(elNombre) > 0) {
			if(nodoIzquierdo == null) {
				return null;
			}else {
				return nodoIzquierdo.buscarJugadorPorNombre(elNombre);
			}
		}else {
			if(nodoDerecho == null) {
				return null;
			}else {
				return nodoDerecho.buscarJugadorPorNombre(elNombre);
			}
		}
		
	}
	
	/**
	 * Nombre: darPuntaje
	 * Da el puntaje de un jugador
	 * @return puntaje
	 */
	public int darPuntaje() {
		return puntaje;
	}
	
	/**
	 * Nombre: darNodoDerecho
	 * Da el nodo derecho del jugador
	 * @return nodoDerecho
	 */
	public Jugador darNodoDerecho() {
		return nodoDerecho;
	}
	
	/**
	 * Nombre: darNodoIzquierdo
	 * Da el nodo izquierdo del jugador
	 * @return nodoIzquierdo
	 */
	public Jugador darNodoIzquierdo() {
		return nodoIzquierdo;
	}
	
	/**
	 * Nombre: soyHoja
	 * Da si un jugador es hoja
	 * @return Valor de tipo boolean
	 */
	public boolean soyHoja() {
		return nodoDerecho==null&&nodoIzquierdo==null;
	}

	/**
	 * Nombre: setNodoDerecho
	 * Modifica el nodo derecho de un Jugador 
	 * @param nodoDerecho - Nodo derecho a insertar
	 * @post - Nodo derecho cambiado
	 */
	public void setNodoDerecho(Jugador nodoDerecho) {
		this.nodoDerecho = nodoDerecho;
	}

	/**
	 * Nombre: setNodoIzquierdo
	 * Modifica el nodo izquiedo de un Jugador 
	 * @param nodoIzquierdo - Nodo izquierdo a insertar
	 * @post - Nodo izquiedo cambiado
	 */
	public void setNodoIzquierdo(Jugador nodoIzquierdo) {
		this.nodoIzquierdo = nodoIzquierdo;
	}
	
	/**
	 * Nombre: getComparador
	 * Permite acceder a la clase Comparador
	 * @return comparador
	 */
	public Comparador getComparador() {
		return comparador;
	}

	/**
	 * Nombre: compareTo
	 * Permite comparar por el nombre a dos Jugadores
	 * @param PJugador - jugador a quien se le desea comparar
	 * @return Valor de tipo int
	 */
	@Override
	public int compareTo(Jugador PJugador) {
		// TODO Auto-generated method stub
		return nombre.compareToIgnoreCase(PJugador.getNombre());
	}

	/**
	 * Nombre: getNombre
	 * Da el nombre de un Jugador
	 * @return nombre - Nombre del Jugador
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Nombre: inorden
	 * Este metodo se encarga de guardar los objetos de tipo Jugador en un ArrayList que se pasa
	 * como parametro
	 * @param elArreglo - ArrayList donde se van a almacenar los objetos de tipo Jugador
	 */
	public void inorden(ArrayList<Jugador> elArreglo) {
		if(this.nodoIzquierdo!=null)
			nodoIzquierdo.inorden(elArreglo);
		elArreglo.add(this);
		if(this.nodoDerecho!=null)
			nodoDerecho.inorden(elArreglo);
	}
	
	
	public void cambiarToString(Jugador raiz,boolean mostrar) {
		if(raiz!=null) {
			cambiarToString(raiz.nodoIzquierdo,mostrar);
			raiz.cambiarComportamientoToString(mostrar);
			cambiarToString(raiz.nodoDerecho,mostrar);
		}
		
	}
	public String toString() {
		String mensaje = " ";
		if(comportamientoToString) {
			mensaje = "Nombre: "+nombre+" -- Carretera: "+carreteraSeleccionada;
		}else {
			mensaje = "Nombre: "+nombre+" -- Puntaje: "+puntaje;
		}
		return mensaje;
	}
	
	
	
}
