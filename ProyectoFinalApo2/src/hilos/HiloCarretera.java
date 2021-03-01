package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloCarretera extends Thread {
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloCarretera(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		
		while(!modelo.darCarreteraSeleccionada().darPerdio() && !modelo.darCarreteraSeleccionada().darPausa()) {
			
			try {
				sleep(modelo.darCarreteraSeleccionada().darVelocidad());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			modelo.darCarreteraSeleccionada().moverCarreteras();
			
		}
	}
}
