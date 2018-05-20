package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloAutoJugador extends Thread{
	public static final long TIEMPO_DE_REFRESCO = 9;
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloAutoJugador(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		
		while(true) {
			
			modelo.darCarreteraSeleccionada().moverAuto();
			try {
				sleep(TIEMPO_DE_REFRESCO);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ventana.refrescar();
		}
	}
}