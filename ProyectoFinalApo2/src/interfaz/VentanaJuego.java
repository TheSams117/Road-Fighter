package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;

public class VentanaJuego extends JFrame{
	private VentanaSeleccion ventanaSeleccion;
	private PanelCarreteraJuego panelCarreteraJuego;
	private PanelInformacionJuego paneInformacionJuego;
	
	public VentanaJuego(VentanaSeleccion v) {
		panelCarreteraJuego = new PanelCarreteraJuego(this);
		paneInformacionJuego = new PanelInformacionJuego();
		
		
		ventanaSeleccion=v;
		this.setSize(750,550);
		this.setTitle("Juego");
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLACK);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		this.add(paneInformacionJuego, BorderLayout.WEST);
		this.add(panelCarreteraJuego,BorderLayout.CENTER);
		
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
	
}
