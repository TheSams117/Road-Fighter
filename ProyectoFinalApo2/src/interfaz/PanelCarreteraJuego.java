package interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Carretera;
import modelo.RoadFigther;

public class PanelCarreteraJuego extends JPanel implements KeyListener {
	public static final ImageIcon ESTRELLADO = new ImageIcon("imagenes/estrellado.gif");
	public static final ImageIcon ACABO = new ImageIcon("imagenes/acabo.gif");
	private VentanaJuego ventanaJuego;
	private ImageIcon imagenCarretera1;
	private ImageIcon imagenCarretera2;
	private ImageIcon imagenAutoJugador;
	private ArrayList<ImageIcon> imagenesAutosCarretera;
	
	public PanelCarreteraJuego(VentanaJuego v) {
		ventanaJuego=v;
		imagenCarretera1 = new ImageIcon(ventanaJuego.darTipo());
		imagenCarretera2 = new ImageIcon(ventanaJuego.darTipo());
		imagenAutoJugador = new ImageIcon(ventanaJuego.darImagenAutoJugador());
		
		imagenesAutosCarretera = new ArrayList<ImageIcon>();
		for (int i = 0; i < ventanaJuego.darAutomovilesCarretera().size(); i++) {
			imagenesAutosCarretera.add(new ImageIcon(ventanaJuego.darAutomovilesCarretera().get(i).darImagen()));
		}
		
		this.addKeyListener(this);
		this.setFocusable(true);
	}
	
	public void paintComponent(Graphics g) {
		try {
		int pos_Y_image1 = ventanaJuego.darPosYImagen1();
		int pos_Y_image2 = ventanaJuego.darPosYImagen2();
		
		int pos_X_automovilJugador = ventanaJuego.darPosXAutomovilJugador();
		int pos_Y_automovilJugador = ventanaJuego.darPosYAutomovilJugador();
		
		int anchoImagenAutomovilSeleccionado= ventanaJuego.darAnchoAutomovilSeleccionado();
		int alturaImagenAutomovilSeleccionado= ventanaJuego.darAlturaAutomovilSeleccionado();
		int pos_X_image=Carretera.POS_X_IMAGEN;
		
		int pos_X_automovilCarretera = 0;
		int pos_Y_automovilCarretera = 0;
		int anchoImagenAutomovilCarretera = 0;
		int alturaImagenAutomovilCarretera = 0;
		
	
		g.drawImage(imagenCarretera1.getImage(), pos_X_image, pos_Y_image1,getWidth(), getHeight(), this);
		g.drawImage(imagenCarretera2.getImage(), pos_X_image, pos_Y_image2,getWidth(), getHeight(), this);
		
		if(ventanaJuego.finalizoPartida()) {
			g.drawImage(ACABO.getImage(), 0, 0,getWidth(), getHeight(), this);
			
		}else if(ventanaJuego.darPerdio()) {
			g.drawImage(ESTRELLADO.getImage(), pos_X_automovilJugador, pos_Y_automovilJugador,anchoImagenAutomovilSeleccionado+20, alturaImagenAutomovilSeleccionado+20, this);
			
			
		}else {
			g.drawImage(imagenAutoJugador.getImage(), pos_X_automovilJugador, pos_Y_automovilJugador,anchoImagenAutomovilSeleccionado,alturaImagenAutomovilSeleccionado, this);
			
			for (int i = 0; i < ventanaJuego.darAutomovilesCarretera().size(); i++) {
				pos_X_automovilCarretera = ventanaJuego.darAutomovilesCarretera().get(i).darPosX();
				pos_Y_automovilCarretera = ventanaJuego.darAutomovilesCarretera().get(i).darPosY(); 
				anchoImagenAutomovilCarretera = ventanaJuego.darAutomovilesCarretera().get(i).darAnchoImagenAutomovil(); 
				alturaImagenAutomovilCarretera = ventanaJuego.darAutomovilesCarretera().get(i).darAlturaImagenAutomovil(); 
				g.drawImage(imagenesAutosCarretera.get(i).getImage(), pos_X_automovilCarretera, pos_Y_automovilCarretera,anchoImagenAutomovilCarretera, alturaImagenAutomovilCarretera, this);
			}
		}
		
		if(ventanaJuego.darVentanaSeleccion().darPausa()) {
			g.setFont(new Font("System",5,100));
			g.setColor(Color.RED);
			g.drawString("PAUSA", 115, 280);
		}
		}catch(Exception e){
			
		}
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			ventanaJuego.avanzar();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			ventanaJuego.moverDerecha();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			ventanaJuego.moverIzquierda();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_P) {
			ventanaJuego.pausa();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_G) {
			ventanaJuego.guardarJugador();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			ventanaJuego.detener();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			ventanaJuego.noMoverDerecha();
		}
		
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			ventanaJuego.noMoverIzquierda();
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_Z) {
			ventanaJuego.avanzar();
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			ventanaJuego.noMoverDerecha();
		}
		
	}
}
