package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

import hilos.HiloAutoJugador;
import hilos.HiloCarretera;
import hilos.HiloVelocidad;

public class VentanaJuego extends JFrame{
	
	private VentanaSeleccion ventanaSeleccion;
	private PanelCarreteraJuego panelCarreteraJuego;
	private PanelInformacionJuego paneInformacionJuego;
	private HiloCarretera hiloCarretera;
	private HiloAutoJugador hiloAutoJugador;
	private HiloVelocidad hiloVelocidad;
	
	public VentanaJuego(VentanaSeleccion v) {
		
		ventanaSeleccion=v;
		hiloCarretera=new HiloCarretera(this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloAutoJugador=new HiloAutoJugador(this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloVelocidad= new HiloVelocidad (this,ventanaSeleccion.darPrincipal().darModeloJuego());
		this.setSize(750,550);
		this.setTitle("Juego");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		panelCarreteraJuego = new PanelCarreteraJuego(this);
		paneInformacionJuego = new PanelInformacionJuego();
		
		this.add(paneInformacionJuego, BorderLayout.EAST);
		this.add(panelCarreteraJuego,BorderLayout.CENTER);
		
		hiloCarretera.start();
		hiloAutoJugador.start();
		hiloVelocidad.start();
	}
	
	
	public void refrescar() {
		panelCarreteraJuego.repaint();
		paneInformacionJuego.repaint();
	}
	public VentanaSeleccion darVentanaSeleccion() {
		return ventanaSeleccion;
	}

	public PanelCarreteraJuego darPanelCarreteraJuego() {
		return panelCarreteraJuego;
	}

	public PanelInformacionJuego darPaneInformacionJuego() {
		return paneInformacionJuego;
	}
	public int darAnchoAutomovilSeleccionado() {
		return ventanaSeleccion.darAnchoAutoMovilSeleccionado();
	}
	public int darAlturaAutomovilSeleccionado() {
		return ventanaSeleccion.darAlturaAutomovilSeleccionado();
	}
	public void avanzar() {
		ventanaSeleccion.avanzar();
		
	}
	public void detener() {
		ventanaSeleccion.detener();
	}
	public void moverDerecha() {
		ventanaSeleccion.moverDerecha();
	}


	public void noMoverDerecha() {
		ventanaSeleccion.noMoverDerecha();		
	}


	public void moverIzquierda() {
		ventanaSeleccion.moverIzquierda();
		
	}


	public void noMoverIzquierda() {
		ventanaSeleccion.noMoverIzquierda();
		
	}
	
}
