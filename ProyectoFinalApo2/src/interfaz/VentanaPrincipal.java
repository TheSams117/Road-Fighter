package interfaz;



import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;

import modelo.AutomovilCarretera;
import modelo.Jugador;
import modelo.JugadorNoEncontradoException;
import modelo.JugadorYaRegistradoException;
import modelo.PuntajeNoRegistradoException;
import modelo.RoadFigther;

public class VentanaPrincipal extends JFrame {
	
	
	private PanelBotones panelBotones;	
	private RoadFigther modeloJuego;

	public VentanaPrincipal() {
		this.setSize(500,500);
		this.setTitle("Road Figthers");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		panelBotones= new PanelBotones(this);
		try {
			modeloJuego = new RoadFigther();
		} catch (NumberFormatException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		this.add(panelBotones,BorderLayout.CENTER);	
	}
	
	public RoadFigther darModeloJuego() {
		return modeloJuego;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
	 VentanaPrincipal vp= new VentanaPrincipal();
	 vp.setVisible(true);

	}










	public void nuevaPartida() {
		VentanaSeleccion ventana= new VentanaSeleccion(this);
		ventana.setVisible(true);
		this.setVisible(false);
		
	}










	public void cargarPartida() {
		VentanaCargarPartida ventana= new VentanaCargarPartida(this);
		ventana.setVisible(true);
		ventana.refrescarLista();
		this.setVisible(false);
		
	}
	
	public void iniciarCarga() {
		VentanaSeleccion ventana= new VentanaSeleccion(this);
		ventana.siguiente();
		ventana.setVisible(false);
		this.setVisible(false);
		 
		
	}










	public void puntajes() {
		VentanaPuntajes ventana= new VentanaPuntajes(this);
		ventana.setVisible(true);
		ventana.refrescarLista();
		this.setVisible(false);
		
	}

	public void historial() {
		VentanaHistorial ventana= new VentanaHistorial(this);
		try {
			ventana.darListaHistorial().refrescarLista(modeloJuego.darHistorialDeEntradas());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ventana.setVisible(true);
		this.setVisible(false);
		
	}

	public int darAnchoAutoMovilSeleccionado() {
		
		return modeloJuego.darAnchoAutoMovilSeleccionado();
	}

	public int darAlturaAutomovilSeleccionado() {

		return modeloJuego.darAlturaAutomovilSeleccionado();
	}

	public void avanzar() {
		modeloJuego.avanzar();
		
	}

	public void detener() {
		
		modeloJuego.detener();
	}

	public void moverDerecha() {
		modeloJuego.moverDerecha();
		
	}

	public void noMoverDerecha() {
		modeloJuego.noMoverDerecha();
		
	}

	public void moverIzquierda() {
		modeloJuego.moverIzquierda();
		
	}

	public void noMoverIzquierda() {
		modeloJuego.noMoverIzquierda();
		
	}

	public boolean darPerdio() {
		return modeloJuego.darPerdio();
	}
	
	public boolean finalizoPartida() {
		return modeloJuego.finalizoPartida();
	}

	public ArrayList<AutomovilCarretera> darAutomovilesCarretera() {
		return modeloJuego.darAutomovilesCarretera();
	}

	public int darPuntaje() {
		return modeloJuego.darPuntaje();
	}

	public void pausa() {
		modeloJuego.pausa();
		
	}

	public boolean darPausa() {
		
		return modeloJuego.darPausa();
	}

	public String darTipo() {
		return modeloJuego.darTipo();
	}

	public String darImagenAutoJugador() {
		return modeloJuego.darImagenAutoJugador();
	}

	public int darPosYImagen1() {
		return modeloJuego.darPosYImagen1();
	}

	public int darPosYImagen2() {
		return modeloJuego.darPosYImagen2();
	}

	public int darPosXAutomovilJugador() {
		return modeloJuego.darPosXAutomovilJugador();
	}

	public int darPosYAutomovilJugador() {
		return modeloJuego.darPosYAutomovilJugador();
	}

	public void guardarJuego(String pNombre, int pPuntaje, int numeroCarretera) throws JugadorYaRegistradoException {
		
		 modeloJuego.agregarJugador(pNombre, pPuntaje, numeroCarretera);
	}

	public int darPuntajeJuego() {
		return  modeloJuego.darPuntajeJuego();
	}

	public int darNumeroCarretera() {
		return modeloJuego.darNumeroCarretera();
	}

	public Jugador darJugadorSeleccionado() {
		return modeloJuego.darJugadorSeleccionado();
	}

	public void findeJuegoPerdido() {
		modeloJuego.reiniciarJuegoPerdido();
		
	}
	
	public void finJuego() {
		modeloJuego.finPartida();
		
	}

	public void cerrarVentana() {
		setVisible(true);
		
	}

	public void serializar() {
		try {
			modeloJuego.serializar();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Jugador> darJugadoresOrdenadosPorNombre() {
		return modeloJuego.darJugadoresOrdenadosPorNombre();
	}

	public ArrayList<Jugador> darJugadoresOrdenadosPorPuntaje() {
		return modeloJuego.darJugadoresOrdenadosPorPuntaje();
	}

	public void cargarPartidaModelo(Jugador pJugador) throws JugadorNoEncontradoException {
		modeloJuego.cargarPartida(pJugador);
		
	}

	public Jugador buscarJugador(String jugador) throws JugadorNoEncontradoException{
		return modeloJuego.buscarNombre(jugador);
	}

	public void eliminar(Jugador darSeleccion) {
		modeloJuego.eliminar(darSeleccion);
	}

	public Jugador buscarJugadorPuntaje(int puntaje) throws PuntajeNoRegistradoException {
		return modeloJuego.buscarJugadorPuntaje(puntaje);
	}

	public Jugador darJugadorConPuntajeMayor() {
		return modeloJuego.darJugadorConPuntajeMayor();
	}
	
	public Jugador darJugadorConPuntajeMenor() {
		return modeloJuego.darJugadorConPuntajeMenor();
	}


}
