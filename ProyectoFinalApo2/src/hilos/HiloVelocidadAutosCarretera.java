package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloVelocidadAutosCarretera extends Thread{
	public static final long TIEMPO_DE_CAMBIO_DE_VELOCIDAD = 200;
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloVelocidadAutosCarretera(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		while(!modelo.darCarreteraSeleccionada().darPerdio() && !modelo.darCarreteraSeleccionada().darPausa()) {

			try {
					sleep(TIEMPO_DE_CAMBIO_DE_VELOCIDAD);
					modelo.darCarreteraSeleccionada().velocidadAutosCarretera();
			} catch (InterruptedException e) {
					 
					e.printStackTrace();
			}
		}
	}
}
