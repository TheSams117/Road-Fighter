package modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordoñes ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class RoadFigther {
	public static final String DIRECCION_CANTIDAD_JUGADORES = "persistencia/cantidadJugadores.dat";
	public static final String DIRECCION_CANTIDAD_CARRETERAS = "persistencia/cantidadCarreteras.dat";
	public static final String DIRECCION_PRIMER_CARRETERA = "persistencia/primerCarretera.dat";
	public static final String DIRECCION_JUGADOR_RAIZ = "persistencia/jugadorRaiz.dat";
	public static final String DIRECCION_TABLA_PUNTAJES = "persistencia/tablaPuntajes.dat";
	public static final String DIRECCION_ARCHIVO_TXT = "persistencia/texto.txt";
	//Atributos
	private int cantidadJugadores;
	private int cantidadCarreras;
	
	//Relaciones.
	private TablaPuntajes tablaPuntajes;
	private Carretera carretera;
	private Carretera carreteraSeleccionada;
	private Jugador jugador;
	private Jugador jugadorSeleccionado;
	private String archivoDetTexto;
	
	//Constructor
	public RoadFigther() throws FileNotFoundException, IOException, NumberFormatException, ClassNotFoundException {
		File cantidadJugadoresArchivo = new File(DIRECCION_CANTIDAD_JUGADORES);
		File cantidadCarreterasArchivo = new File(DIRECCION_CANTIDAD_CARRETERAS);
		File carreteraArchivo = new File(DIRECCION_PRIMER_CARRETERA);
		File jugadorArchivo = new File(DIRECCION_JUGADOR_RAIZ);
		File tablaPuntajesArchivo = new File(DIRECCION_TABLA_PUNTAJES);
		
		if(cantidadJugadoresArchivo.exists() && cantidadCarreterasArchivo.exists() && carreteraArchivo.exists() && jugadorArchivo.exists() && tablaPuntajesArchivo.exists() ) {
			
				ObjectInputStream deSerializa1 = new ObjectInputStream(new FileInputStream(cantidadJugadoresArchivo));
				cantidadJugadores= Integer.parseInt((String)deSerializa1.readObject());
				deSerializa1.close();
				
				ObjectInputStream deSerializa2 = new ObjectInputStream(new FileInputStream(cantidadCarreterasArchivo));
				cantidadCarreras= Integer.parseInt((String)deSerializa2.readObject());
				deSerializa2.close();
				
				ObjectInputStream deSerializa3 = new ObjectInputStream(new FileInputStream(carreteraArchivo));
				carretera= (Carretera) deSerializa3.readObject();
				deSerializa3.close();
				
				ObjectInputStream deSerializa4 = new ObjectInputStream(new FileInputStream(jugadorArchivo));
				jugador= (Jugador)deSerializa4.readObject();
				deSerializa4.close();
				
				ObjectInputStream deSerializa5 = new ObjectInputStream(new FileInputStream(tablaPuntajesArchivo));
				tablaPuntajes = (TablaPuntajes) deSerializa5.readObject();
				deSerializa5.close();
		
			
		
			
		}else {
			cantidadJugadores = 0;
			cantidadCarreras = 0;
			carretera=null;
			jugador=null;
			tablaPuntajes = new TablaPuntajes();
		}
		jugadorSeleccionado=null;
		carreteraSeleccionada=null;
		
		
		File archivoTxT = new File(DIRECCION_ARCHIVO_TXT);
		FileWriter escribir = new FileWriter(archivoTxT,true);
		BufferedWriter bw = new BufferedWriter(escribir);
		Calendar fecha = new GregorianCalendar();
		int ano = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH);
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora = fecha.get(Calendar.HOUR_OF_DAY);
        int minuto = fecha.get(Calendar.MINUTE);
		if(archivoTxT.exists()) {
			bw.write(dia+"/"+mes+"/"+ano+"   Hora: "+hora+":"+minuto);
			bw.newLine();
		}else {
			bw.write(dia+"/"+mes+"/"+ano+"   Hora: "+hora+":"+minuto);
			bw.newLine();
		}
		bw.close();
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
	
	public Jugador darJugadorSeleccionado() {
		return jugadorSeleccionado;
	}

	public void cambiarJugadorSeleccionado(Jugador jugadorSeleccionado) {
		this.jugadorSeleccionado = jugadorSeleccionado;
	}
	
	public void cargarPartida(Jugador pJugador) throws JugadorNoEncontradoException {
		System.out.println(buscarNombre(pJugador.getNombre()).getNombre());
		System.out.println(buscarCarretera(pJugador.darCarreteraSeleccionada())+"");
		jugadorSeleccionado = buscarNombre(pJugador.getNombre());
		carreteraSeleccionada = buscarCarretera(pJugador.darCarreteraSeleccionada());
	}
	
	public ArrayList<Carretera> listaDeCarreteras(){
		Carretera actual = carretera;
		ArrayList<Carretera> lista = new ArrayList<Carretera>();
		while(actual!=null) {
			lista.add(actual);
			actual = actual.darCarreteraSiguiente();
		}
		
		return lista;
	}
	
	public ArrayList<Carretera> darListaOrdenadaBurbuja(){
		
		Carretera actual = carretera;
		ArrayList<Carretera> lista =listaDeCarreteras();
		for (int i = lista.size();  i> 0; i--) {
			for (int j = 0; j < i-1;j++) {
				if(lista.get(j).darNumeroCarretera()>lista.get(j+1).darNumeroCarretera()) {
					Carretera temp = lista.get(j);
					lista.set(j, lista.get(j+1));
					lista.set(j+1,temp);
				}
			}
		}
		
		return lista;
	}
	
	
	public void eliminar (Jugador pJugador) {
		 eliminarJugadorPorNombre(pJugador.getNombre());
		 tablaPuntajes.eliminarJugadorTabla(pJugador.darPuntaje());
	}
	public Carretera buscarCarretera(int numeroCarretera) {
		Carretera carretera =null;
		ArrayList<Carretera> lista =darListaOrdenadaBurbuja();
		for (int i = 0; i < lista.size(); i++) {
		
				System.out.println(""+lista.get(i).darNumeroCarretera());
		}
		
		boolean encontro=false;
		int inicio=0;
		int fin=lista.size()-1;
		
		while(inicio<=fin && !encontro) {
			
			int medio=(inicio+fin)/2;
			
			if(lista.get(medio).darNumeroCarretera()==numeroCarretera) {
				carretera=lista.get(medio);
				encontro=true;
				
			}else if(lista.get(medio).darNumeroCarretera()<numeroCarretera) {
				
				inicio=medio+1;
				
			}else{
				
				fin=medio-1;
			}
			
		}
	
		return carretera;
	}

	/**
	 * Nombre: darJugador
	 * Permite dar la raiz del arbol binario
	 * @return jugador - Raiz del arbol binario
	 */
	public Jugador darJugador() {
		return jugador;
	}
	
	public void agregarJugador(String pNombre, int pPuntaje,int pCarreteraSeleccionada) throws JugadorYaRegistradoException {
		Jugador nuevo = new Jugador(pNombre,pPuntaje,pCarreteraSeleccionada);
		Jugador nuevoTabla = new Jugador(pNombre,pPuntaje,pCarreteraSeleccionada);
		agregarJugadorPorNombre(nuevo);
		tablaPuntajes.agregarJugadorATablaDePuntajes(nuevoTabla);
		
	}
	
	/**Nombre: darJugadoresOrdenadosPorNombre
	 * Da un ArrayList de Jugador
	 * @return losJugadores - ArrayList de jugadores
	 */
	public ArrayList<Jugador> darJugadoresOrdenadosPorNombre() {
		jugador.cambiarToString(jugador, true);
		ArrayList<Jugador> losJugadores= new ArrayList<Jugador>();
		jugador.inorden(losJugadores);
		ordenarJugadoresPorNombre(losJugadores);
		return losJugadores;
		
	}
	
	/**
	 * Nombre: ordenarJugadoresPorNombre
	 * Permite ordenar un ArrayList de Jugador por medio del nombre
	 * @param losJugadores - ArrayList que se desea ordenar
	 */
	public void ordenarJugadoresPorNombre(ArrayList<Jugador> losJugadores) {
		for(int i = 1; i < losJugadores.size(); i++) {
			for(int j = i; j > 0 && losJugadores.get(j-1).compareTo(losJugadores.get(j)) > 0; j--) {
				Jugador auxJugador = losJugadores.get(j);
				losJugadores.set(j, losJugadores.get(j-1));
				losJugadores.set(j-1, auxJugador);
			}
		}
	}
	
	/**
	 * Nombre: agregarJugadorPorNombre
	 * Permite agregar un Jugador por el puntaje
	 * @param elJugador - Jugador el cual se desea agregar
	 * @throws JugadorYaRegistradoException Se lanza la excepcion si el jugador ya esta registrado
	 * @post Jugador agregado al arbol binario
	 */
	public void agregarJugadorPorNombre(Jugador elJugador) throws JugadorYaRegistradoException {
		
		if(jugador == null) {
			jugador = elJugador;
		}else {
			jugador.insertarPorNombre(elJugador);
		}
		cantidadJugadores++;
		
	}
	
	/**
	 * Nombre: eliminarJugadorPorNombre
	 * Este metodo permite eliminar un Jugador del arbol
	 * por medio del nombre
	 * @param elNombre - Nombre del Jugador el cual se desea eliminar
	 * @post Jugador del arbol binario eliminado
	 */
	public void eliminarJugadorPorNombre(String elNombre) {
		
		if(jugador.getNombre().compareTo(elNombre) == 0) {
			jugador = jugador.elimininarPorNombre(elNombre);
		}else {
			jugador.elimininarPorNombre(elNombre);
		}
		cantidadJugadores--;
		
	}

	/**
	 * Nombre: buscarNombre
	 * Este metodo se encarga de llamar al metodo de la clase Jugador
	 * buscarJugadorPorNombre y lanza excepcion cuando el nombre no ha sido
	 * encontrado
	 * @param elNombre - Nombre del jugador al cual se desea buscar
	 * @return Jugador con el nombre pasado como parametro
	 * @throws JugadorNoEncontradoException Se lanza la excepcion si el jugador no es encontrado
	 */
	public Jugador buscarNombre(String elNombre) throws JugadorNoEncontradoException{
		
		if(jugador.buscarJugadorPorNombre(elNombre) == null) {
			throw new JugadorNoEncontradoException("El jugador "+elNombre+ " no ha sido encontrado");
		}else {
			return jugador.buscarJugadorPorNombre(elNombre);
		}
		
	}
	
	/**
	 * Nombre: cambiarJugador
	 * Permite cambiar la raiz de un arbol binario
	 * @param pJugador - Nueva raiz del arbol binario
	 * @post Raiz del arbol cambiada
	 */
	public void cambiarJugador(Jugador pJugador) {
		jugador = pJugador;
	}
	
	public void agregarCarretera(String pAutomovil,String pCarretera) {
		Carretera nueva = nuevaPartida(pAutomovil,pCarretera);
		carreteraSeleccionada=nueva;
		Carretera carreteraActual = carretera;
		if(carreteraActual==null) {
			carretera=nueva;
		}else {
			while(carreteraActual.darCarreteraSiguiente() != null) {
				carreteraActual=carreteraActual.darCarreteraSiguiente();
			}
			carreteraActual.cambiarCarreteraSiguiente(nueva);
		}
		
	}
	
	

		
	public Automovil[] darAutomovil() {
		return null;
	}

		
	public void ordenarCarreterasLista() {
			
	}
		
	public Carretera buscarCarreteraArreglo(int laCarretera) {
		return null;
			
	}
		
		
	public Carretera nuevaPartida(String pAuto,String pMapa) {
		int numeroCarretera = darNumeroUnicoDeCarretera();
		Carretera nueva = new Carretera(pMapa,numeroCarretera);
		nueva.cambiarAutomovilSeleccionado(pAuto);
		
		return nueva;
		
			
	}
	
	public int darNumeroUnicoDeCarretera() {
		int numero = (int) (Math.random()*(10000-0));;
	
		Carretera carreteraActual=carretera;
		if (carreteraActual==null) {
			
		}else {
			while(carreteraActual!=null) {
				if(carreteraActual.darNumeroCarretera()==numero) {
					carreteraActual=carretera;
					numero=(int) (Math.random()*(10000-0));
				}else {
					carreteraActual = carreteraActual.darCarreteraSiguiente();
				}
				System.out.println("ciclo:v" );
			}
		}
		
		return numero;
		
		
	}
		
	public String[] darHistorial() {
		return null;
			
	}

	public int darAnchoAutoMovilSeleccionado() {
		return carreteraSeleccionada.darAnchoAutoMovilSeleccionado();
	}

	public int darAlturaAutomovilSeleccionado() {
		return carreteraSeleccionada.darAlturaAutomovilSeleccionado();
	}

	public void avanzar() {
		carreteraSeleccionada.avanzar();
		
	}

	public void detener() {
		carreteraSeleccionada.detener();
		
	}
	
	public void moverDerecha() {
		carreteraSeleccionada.moverDerecha();
		
	}

	public void noMoverDerecha() {
		carreteraSeleccionada.noMoverDerecha();
		
	}

	public void moverIzquierda() {
		carreteraSeleccionada.moverIzquierda();
		
	}

	public void noMoverIzquierda() {
		carreteraSeleccionada.noMoverIzquierda();
		
	}

	public boolean darPerdio() {
		return carreteraSeleccionada.darPerdio();
	}
	
	public boolean finalizoPartida() {
		return carreteraSeleccionada.laPartidaFinalizo();
	}

	public ArrayList<AutomovilCarretera> darAutomovilesCarretera() {
		return carreteraSeleccionada.darAutomovilesCarretera();
	}

	public int darPuntaje() {
		return carreteraSeleccionada.darPuntaje();
	}

	public void pausa() {
		carreteraSeleccionada.cambiarPausa();
		
	}

	public boolean darPausa() {
		
		return carreteraSeleccionada.darPausa();
	}

	public String darTipo() {
		return carreteraSeleccionada.darTipo();
	}

	public String darImagenAutoJugador() {
		return carreteraSeleccionada.darImagenAutoJugador();
	}

	public int darPosYImagen1() {
		return carreteraSeleccionada.darPosYImagen1();
	}

	public int darPosYImagen2() {
		return carreteraSeleccionada.darPosYImagen2();
	}

	public int darPosXAutomovilJugador() {
		return carreteraSeleccionada.darPosXAutomovilJugador();
	}

	public int darPosYAutomovilJugador() {
		return carreteraSeleccionada.darPosYAutomovilJugador();
	}

	public int darPuntajeJuego() {
		return carreteraSeleccionada.darPuntaje();
	}

	public int darNumeroCarretera() {
		return carreteraSeleccionada.darNumeroCarretera();
	}
	
	public void reiniciarJuegoPerdido() {
		carreteraSeleccionada.finDePartida();
		finPartida();
	}
	
	public void finPartida() {
		carreteraSeleccionada = null;
		jugadorSeleccionado=null;
	}
	
	public void serializar() throws IOException {
		File cantidadJugadoresArchivo = new File(DIRECCION_CANTIDAD_JUGADORES);
		File cantidadCarreterasArchivo = new File(DIRECCION_CANTIDAD_CARRETERAS);
		File carreteraArchivo = new File(DIRECCION_PRIMER_CARRETERA);
		File jugadorArchivo = new File(DIRECCION_JUGADOR_RAIZ);
		File tablaPuntajesArchivo = new File(DIRECCION_TABLA_PUNTAJES);
		
		if(cantidadJugadoresArchivo.exists() && cantidadCarreterasArchivo.exists() && carreteraArchivo.exists() && jugadorArchivo.exists() && tablaPuntajesArchivo.exists() ) {
			
			ObjectOutputStream serializa1 = new ObjectOutputStream(new FileOutputStream(DIRECCION_CANTIDAD_JUGADORES));
			serializa1.writeObject(cantidadJugadores+"");
			serializa1.close();
			
			ObjectOutputStream serializa2 = new ObjectOutputStream(new FileOutputStream(DIRECCION_CANTIDAD_CARRETERAS));
			serializa2.writeObject(cantidadCarreras+"");
			serializa2.close();
			
			ObjectOutputStream serializa3 = new ObjectOutputStream(new FileOutputStream(DIRECCION_PRIMER_CARRETERA));
			serializa3.writeObject(carretera);
			serializa3.close();
	
			ObjectOutputStream serializa4 = new ObjectOutputStream(new FileOutputStream(DIRECCION_JUGADOR_RAIZ));
			serializa4.writeObject(jugador);
			serializa4.close();
	
			
			ObjectOutputStream serializa5 = new ObjectOutputStream(new FileOutputStream(DIRECCION_TABLA_PUNTAJES));
			serializa5.writeObject(tablaPuntajes);
			serializa5.close();
		
		}else {
			ObjectOutputStream serializa1 = new ObjectOutputStream(new FileOutputStream(cantidadJugadoresArchivo));
			serializa1.writeObject(cantidadJugadores+"");
			serializa1.close();
			
			ObjectOutputStream serializa2 = new ObjectOutputStream(new FileOutputStream(cantidadCarreterasArchivo));
			serializa2.writeObject(cantidadCarreras+"");
			serializa2.close();
			
			ObjectOutputStream serializa3 = new ObjectOutputStream(new FileOutputStream(carreteraArchivo));
			serializa3.writeObject(carretera);
			serializa3.close();
	
			ObjectOutputStream serializa4 = new ObjectOutputStream(new FileOutputStream(jugadorArchivo));
			serializa4.writeObject(jugador);
			serializa4.close();
	
			
			ObjectOutputStream serializa5 = new ObjectOutputStream(new FileOutputStream(tablaPuntajesArchivo));
			serializa5.writeObject(tablaPuntajes);
			serializa5.close();
		}

	}

	public ArrayList<Jugador> darJugadoresOrdenadosPorPuntaje() {
		return tablaPuntajes.darJugadoresOrdenadosMayorAMenor();
	}

	public Jugador buscarJugadorPuntaje(int puntaje) throws PuntajeNoRegistradoException {

		return tablaPuntajes.buscarPuntaje(puntaje);
	}
	
	public Jugador darJugadorConPuntajeMayor() {

		return tablaPuntajes.darJugadorConMayorPuntaje();
	}
	
	public Jugador darJugadorConPuntajeMenor() {

		return tablaPuntajes.darJugadorConMenorPuntaje();
	}
	
	public ArrayList<String> darHistorialDeEntradas() throws IOException{
		FileReader escribir = new FileReader(DIRECCION_ARCHIVO_TXT);
		BufferedReader br = new BufferedReader(escribir);
		ArrayList<String> historial = new ArrayList<String>();
		String lineal = " ";
		while((lineal=br.readLine())!=null) {
			historial.add(lineal);
			System.out.println(lineal);
		}
		
		return historial;
	}
}
