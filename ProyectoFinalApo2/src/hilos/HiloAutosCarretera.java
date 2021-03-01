package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloAutosCarretera extends Thread{
	public static final long TIEMPO_DE_REFRESCO = 6;
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloAutosCarretera(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		while(!modelo.darCarreteraSeleccionada().darPerdio() && !modelo.darCarreteraSeleccionada().darPausa()) {
			try {
				sleep(modelo.darCarreteraSeleccionada().darVelocidadAutosCarretera());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			modelo.darCarreteraSeleccionada().moverAutomovilesCarretera();
		}
	}
}
