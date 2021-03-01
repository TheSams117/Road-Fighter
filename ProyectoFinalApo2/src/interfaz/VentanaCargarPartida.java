package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Jugador;
import modelo.JugadorNoEncontradoException;

public class VentanaCargarPartida extends JFrame{

	private PanelListaJugadores listaJugadores;
	private PanelBotonesCargarPartida botonesCargar;
	
	private VentanaPrincipal principal;
	
	public VentanaCargarPartida(VentanaPrincipal v) {
		principal=v;
		this.setSize(400,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Cargar Partida");
		listaJugadores= new PanelListaJugadores(this);
		botonesCargar=new PanelBotonesCargarPartida(this);
		this.add(botonesCargar,BorderLayout.SOUTH);
		this.add(listaJugadores, BorderLayout.NORTH);
		JPanel panelAux= new JPanel();
		panelAux.setBackground(Color.BLACK);
		this.add(panelAux,BorderLayout.CENTER);
		
		
		
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		principal.setVisible(true);
		
	}
	
	public VentanaPrincipal darPrincipal() {
		return principal;
	}


	public ArrayList<Jugador> darJugadoresOrdenadosPorNombre() {
		return principal.darJugadoresOrdenadosPorNombre();
	}
	
	public void refrescarLista() {
		listaJugadores.refrescarLista();
	}

	public Jugador darSeleccion() {
		
		return listaJugadores.darSeleccionado();
	}

	public void cargarPartida(Jugador pJugador) throws JugadorNoEncontradoException {
		principal.cargarPartidaModelo(pJugador);
		
	}

	public void iniciarCarga() {
		this.setVisible(false);
		this.dispose();
		principal.setVisible(false);
		principal.iniciarCarga();
		
	}

	public Jugador buscarJugador(String jugador)throws JugadorNoEncontradoException {
		return principal.buscarJugador(jugador);
	}

	public void cambiarSeleccionEnLista(Jugador buscarJugador) {
		listaJugadores.cambiarSeleccion(buscarJugador);
		
	}

	public void eliminar(Jugador darSeleccion) {
		principal.eliminar(darSeleccion);
		
	}

	public void guardar() {
		principal.serializar();
		
	}
	
	
	
	
	
}
