package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;

import modelo.AutomovilCarretera;
import modelo.Jugador;
import modelo.JugadorYaRegistradoException;

public class VentanaSeleccion extends JFrame {

	
	private PanelCarros panelCarros;
	private PanelMapas panelMapas;
	private PanelBotonesAtras panelBotonesAtras;
	private VentanaPrincipal principal;
	
	public VentanaSeleccion(VentanaPrincipal v) {
		principal=v;
		this.setSize(750,550);
		this.setTitle("Nueva Partida");
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setResizable(false);
		
		panelMapas= new PanelMapas(this);
		panelCarros= new PanelCarros(this);
		panelBotonesAtras= new PanelBotonesAtras(this);
		
		this.add(panelMapas,BorderLayout.NORTH);
		this.add(panelCarros, BorderLayout.CENTER);
		this.add(panelBotonesAtras, BorderLayout.SOUTH);
		
		
	}
	
	
	public PanelCarros darPanelCarros() {
		return panelCarros;
	}
	
	public PanelMapas darPanelMapas() {
		return panelMapas;
	}


	public PanelBotonesAtras darPanelBotonesAtras() {
		return panelBotonesAtras;
	}


	public VentanaPrincipal darPrincipal() {
		return principal;
	}


	public void atras() {
		this.setVisible(false);
		principal.setVisible(true);
		
	}
	
	public void siguiente() {
		VentanaJuego ventana= new VentanaJuego(this);
		ventana.setVisible(true);
		this.setVisible(false);
		
	}
	
	public void iniciarCarga() {
		siguiente();
	}


	public int darAnchoAutoMovilSeleccionado() {
		return principal.darAnchoAutoMovilSeleccionado();
	}


	public int darAlturaAutomovilSeleccionado() {
		return principal.darAlturaAutomovilSeleccionado();
	}


	public void avanzar() {
		principal.avanzar();
		
	}


	public void detener() {
		principal.detener();
	}


	public void moverDerecha() {
		principal.moverDerecha();
		
	}


	public void noMoverDerecha() {
		principal.noMoverDerecha();		
	}


	public void moverIzquierda() {
		principal.moverIzquierda();	
		
	}


	public void noMoverIzquierda() {
		principal.noMoverIzquierda();		
		
	}


	public boolean darPerdio() {
		return principal.darPerdio();
	}
	
	public boolean finalizoPartida() {
		return principal.finalizoPartida();
	}


	public ArrayList<AutomovilCarretera> darAutomovilesCarretera() {
		return principal.darAutomovilesCarretera();
	}


	public int darPuntaje() {
		return principal.darPuntaje();
		
	}


	public void pausa() {
		principal.pausa();
		
	}


	public boolean darPausa() {
		return principal.darPausa();
	}


	public String darTipo() {
		return principal.darTipo();
	}


	public String darImagenAutoJugador() {
		return principal.darImagenAutoJugador();
	}


	public int darPosYImagen1() {
		return  principal.darPosYImagen1();
	}


	public int darPosYImagen2() {
		return principal.darPosYImagen2();
	}


	public int darPosXAutomovilJugador() {
		return principal.darPosXAutomovilJugador();
	}


	public int darPosYAutomovilJugador() {
		return principal.darPosYAutomovilJugador();
	}
	
	public void guardarJuego(String pNombre, int pPuntaje, int numeroCarretera) throws JugadorYaRegistradoException {
		principal.guardarJuego(pNombre, pPuntaje, numeroCarretera);
	}


	public int darPuntajeJuego() {
		return principal.darPuntajeJuego();
	}


	public int darNumeroCarretera() {
		return principal.darNumeroCarretera();
	}


	public Jugador darJugadorSeleccionado() {
		return principal.darJugadorSeleccionado();
	}


	public void findeJuegoPerdido() {
		principal.findeJuegoPerdido();
		
	}


	public void finJuego() {
		principal.finJuego();
		
	}


	public void cerrarVentana() {
		principal.cerrarVentana();
		dispose();
		
	}


	public void serializar() {
		principal.serializar();
		
	}
}
