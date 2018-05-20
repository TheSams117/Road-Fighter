package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloCarretera extends Thread {
	public static final long TIEMPO_DE_CAMBIO_DE_VELOCIDAD = 180;
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloCarretera(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		
		while(true) {

			try {
					sleep(TIEMPO_DE_CAMBIO_DE_VELOCIDAD);
					modelo.darCarreteraSeleccionada().velocidad();
					
			} catch (InterruptedException e) {
					 
					e.printStackTrace();
			}
		}
	}
}
