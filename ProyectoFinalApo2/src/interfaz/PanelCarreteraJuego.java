package interfaz;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Carretera;
import modelo.RoadFigther;

public class PanelCarreteraJuego extends JPanel implements KeyListener, MouseListener {
	private VentanaJuego ventanaJuego;
	private ImageIcon imagenCarretera1;
	private ImageIcon imagenCarretera2;
	private ImageIcon imagenAutoJugador;
	
	public PanelCarreteraJuego(VentanaJuego v) {
		ventanaJuego=v;
		imagenCarretera1 = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darTipo());
		imagenCarretera2 = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darTipo());
		imagenAutoJugador = new ImageIcon(ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darImagen());
		
		
		this.addMouseListener(this);
		this.addKeyListener(this);
	
	}
	
	public void paintComponent(Graphics g) {
		int pos_Y_image1 = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darPosYImagen1();
		int pos_Y_image2 = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darPosYImagen2();
		int pos_X_automovilJugador = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darPosX();
		int pos_Y_automovilJugador = ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada().darAutomovilSeleccionado().darPosY();
		int anchoImagenAutomovilSeleccionado= ventanaJuego.darAnchoAutomovilSeleccionado();
		int alturaImagenAutomovilSeleccionado= ventanaJuego.darAlturaAutomovilSeleccionado();
		ventanaJuego.darVentanaSeleccion().darPrincipal().darModeloJuego().darCarreteraSeleccionada();
		int pos_X_image=Carretera.POS_X_IMAGEN;
		
	
		g.drawImage(imagenCarretera1.getImage(), pos_X_image, pos_Y_image1,getWidth(), getHeight(), this);
		g.drawImage(imagenCarretera2.getImage(), pos_X_image, pos_Y_image2,getWidth(), getHeight(), this);
		g.drawImage(imagenAutoJugador.getImage(), pos_X_automovilJugador, pos_Y_automovilJugador,anchoImagenAutomovilSeleccionado,alturaImagenAutomovilSeleccionado, this);
		
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			ventanaJuego.avanzar();
			System.out.println("Usted ha presionado la tecla: "+e.getKeyText(e.getKeyCode()));
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			//ventanaJuego.
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			ventanaJuego.detener();
			System.out.println("Usted ha presionado la tecla: "+e.getKeyText(e.getKeyCode()));
		}
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		this.requestFocus();
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isFocusable(){
		return true;
	}
}
