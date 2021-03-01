package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import hilos.HiloAutoJugador;
import hilos.HiloAutosCarretera;
import hilos.HiloCarretera;
import hilos.HiloVelocidadAutosCarretera;
import hilos.HiloVelocidadCarretera;
import modelo.AutomovilCarretera;
import modelo.JugadorYaRegistradoException;

public class VentanaJuego extends JFrame{
	
	private VentanaSeleccion ventanaSeleccion;
	private PanelCarreteraJuego panelCarreteraJuego;
	private PanelInformacionJuego paneInformacionJuego;
	private HiloCarretera hiloCarretera;
	private HiloAutoJugador hiloAutoJugador;
	private HiloVelocidadCarretera hiloVelocidadCarretera;
	private HiloAutosCarretera hiloAutosCarretera;
	private HiloVelocidadAutosCarretera hiloVelocidadAutosCarretera;
	private boolean guardando;
		
	
	
	public VentanaJuego(VentanaSeleccion v) {
		
		ventanaSeleccion=v;
		hiloCarretera = new HiloCarretera(this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloAutoJugador = new HiloAutoJugador(this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloVelocidadCarretera = new HiloVelocidadCarretera (this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloAutosCarretera = new HiloAutosCarretera (this,ventanaSeleccion.darPrincipal().darModeloJuego());
		hiloVelocidadAutosCarretera = new HiloVelocidadAutosCarretera(this, ventanaSeleccion.darPrincipal().darModeloJuego());
		guardando=false;
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
		hiloVelocidadCarretera.start();
		hiloAutosCarretera.start();
		hiloVelocidadAutosCarretera.start();
		
	}
	
	public void refrescar() {
		paneInformacionJuego.cambiarPuntaje(ventanaSeleccion.darPuntaje());
		panelCarreteraJuego.repaint();
		paneInformacionJuego.repaint();
	}
	
	public void pausa() {
		if(!darPerdio()) {
			if(ventanaSeleccion.darPausa()) {
				ventanaSeleccion.pausa();
				hiloCarretera = new HiloCarretera(this,ventanaSeleccion.darPrincipal().darModeloJuego());
				hiloAutoJugador = new HiloAutoJugador(this,ventanaSeleccion.darPrincipal().darModeloJuego());
				hiloVelocidadCarretera = new HiloVelocidadCarretera (this,ventanaSeleccion.darPrincipal().darModeloJuego());
				hiloAutosCarretera = new HiloAutosCarretera (this,ventanaSeleccion.darPrincipal().darModeloJuego());
				hiloVelocidadAutosCarretera = new HiloVelocidadAutosCarretera(this, ventanaSeleccion.darPrincipal().darModeloJuego());
				hiloCarretera.start();
				hiloAutoJugador.start();
				hiloVelocidadCarretera.start();
				hiloAutosCarretera.start();
				hiloVelocidadAutosCarretera.start();
				detener();
				
			}else {
				ventanaSeleccion.pausa();
			}
		}
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

	public boolean darPerdio() {
		return 	ventanaSeleccion.darPerdio();
	}
	
	public void guardarJugador() {
		
		if(ventanaSeleccion.darJugadorSeleccionado()==null) {
			
			if(!guardando) {
				guardando=true;
				
				if(darPerdio() ) {
					
					String jugador = " ";
					boolean nombreCorrecto = false;
					while(!nombreCorrecto) {
						jugador=JOptionPane.showInputDialog(this, "Ingrese su nombre", "Guardar jugador nuevo", JOptionPane.INFORMATION_MESSAGE);
						if(jugador == null || jugador.equals("") || jugador.charAt(0) == ' ') {
							
						}else {
							try {
								
								ventanaSeleccion.guardarJuego(jugador,ventanaSeleccion.darPuntajeJuego() ,ventanaSeleccion.darNumeroCarretera());
								nombreCorrecto = true;
							}catch(JugadorYaRegistradoException e){
								JOptionPane.showMessageDialog(this, "Jugador ya registrado", "Registro", JOptionPane.WARNING_MESSAGE);
							}
						}
						
						
					}
					ventanaSeleccion.findeJuegoPerdido();
					ventanaSeleccion.serializar();
					cerrarVentana();
				}else {
					pausa();
					
					int deseaGuardar = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar y salir?", "Guardar y salir", JOptionPane.INFORMATION_MESSAGE);
					if(deseaGuardar==JOptionPane.YES_OPTION) {
						String jugador = " ";
						boolean nombreCorrecto = false;
						
						while(!nombreCorrecto) {
							jugador=JOptionPane.showInputDialog(this, "Ingrese su nombre", "Guardar jugador nuevo", JOptionPane.INFORMATION_MESSAGE);
							if(jugador == null || jugador.equals("") || jugador.charAt(0) == ' ') {
								
							}else {
								try {
									
									ventanaSeleccion.guardarJuego(jugador,ventanaSeleccion.darPuntajeJuego() ,ventanaSeleccion.darNumeroCarretera());
									nombreCorrecto = true;
								}catch(JugadorYaRegistradoException e){
									JOptionPane.showMessageDialog(this, "Jugador ya registrado", "Registro", JOptionPane.WARNING_MESSAGE);
								}
							}
							
							
						}
						
						ventanaSeleccion.finJuego();
						ventanaSeleccion.serializar();
						cerrarVentana();
						
					}else {
						pausa();
						detener();
					
					}
				}
				
				
				guardando=false;
				
			}
			
		}else {
			if(!guardando) {
				guardando=true;
				
				if(darPerdio() ) {
					ventanaSeleccion.darJugadorSeleccionado().cambiarPuntaje(ventanaSeleccion.darPuntajeJuego());
					ventanaSeleccion.findeJuegoPerdido();
					ventanaSeleccion.serializar();
					cerrarVentana();
				}else {
					pausa();
					int deseaGuardar = JOptionPane.showConfirmDialog(this, "¿Seguro que desea guardar y salir?", "Guardar y salir", JOptionPane.INFORMATION_MESSAGE);
					if(deseaGuardar==JOptionPane.YES_OPTION) {
						ventanaSeleccion.darJugadorSeleccionado().cambiarPuntaje(ventanaSeleccion.darPuntajeJuego());
						ventanaSeleccion.finJuego();
						ventanaSeleccion.serializar();
						cerrarVentana();
						
					}else {
						pausa();
						detener();
					
					}
				}
				
				guardando=false;
				
			}
		}
	}
	
	public void cerrarVentana() {
		ventanaSeleccion.cerrarVentana();
		dispose();
	}
	
	public boolean finalizoPartida() {
		return  ventanaSeleccion.finalizoPartida();
	}

	public ArrayList<AutomovilCarretera> darAutomovilesCarretera() {
		return ventanaSeleccion.darAutomovilesCarretera();
	}

	public String darTipo() {
		return ventanaSeleccion.darTipo();
	}

	public String darImagenAutoJugador() {
		return ventanaSeleccion.darImagenAutoJugador();
	}

	public int darPosYImagen1() {
		return ventanaSeleccion.darPosYImagen1();
	}

	public int darPosYImagen2() {
		return ventanaSeleccion.darPosYImagen2();
	}

	public int darPosXAutomovilJugador() {
		return ventanaSeleccion.darPosXAutomovilJugador();
	}
	
	public int darPosYAutomovilJugador() {
		return ventanaSeleccion.darPosYAutomovilJugador();
	}



	
	
}
