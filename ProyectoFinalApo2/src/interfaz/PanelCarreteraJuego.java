package interfaz;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Carretera;
import modelo.RoadFigther;

public class PanelCarreteraJuego extends JPanel implements KeyListener{
	private VentanaJuego ventanaJuego;
	private ImageIcon imagenCarretera1;
	private ImageIcon imagenCarretera2;
	private ImageIcon imagenAutoJugador;
	
	public PanelCarreteraJuego(VentanaJuego v) {
		ventanaJuego=v;
		imagenCarretera1 = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darTipo());
		imagenCarretera2 = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darTipo());
		imagenAutoJugador = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darImagen());
	}
	
	public void paintComponent(Graphics g) {
		int pos_Y_image1 = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darPosYImagen1();
		int pos_Y_image2 = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darPosYImagen2();
		int pos_X_automovilJugador = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darPosX();
		int pos_Y_automovilJugador = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darPosY();
		
		ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada();
		int pos_X_image=Carretera.POS_X_IMAGEN;
		
	
		g.drawImage(imagenCarretera1.getImage(), pos_X_image, pos_Y_image1,getWidth(), getHeight(), this);
		g.drawImage(imagenCarretera2.getImage(), pos_X_image, pos_Y_image2,getWidth(), getHeight(), this);
		g.drawImage(imagenAutoJugador.getImage(), pos_X_automovilJugador, pos_Y_automovilJugador,40,50, this);
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
