package hilos;

import interfaz.VentanaJuego;
import modelo.RoadFigther;

public class HiloAutoJugador extends Thread{
	public static final long TIEMPO_DE_REFRESCO =5;
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloAutoJugador(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		while(!modelo.darCarreteraSeleccionada().darPerdio() && !modelo.darCarreteraSeleccionada().darPausa()) {
			
			modelo.darCarreteraSeleccionada().moverAuto();
			modelo.darCarreteraSeleccionada().seEstrelloContraLaBarrera();
			if(!modelo.darCarreteraSeleccionada().darPerdio()) {
				modelo.darCarreteraSeleccionada().seEstrelloContraUnAutomovil();
			}
			
			
			try {
				sleep(TIEMPO_DE_REFRESCO);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if(modelo.darCarreteraSeleccionada().darPerdio()) {
				try {
					sleep(3300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				modelo.darCarreteraSeleccionada().cambiarFinalizacionDeLaPartida(true);
				
			}
			ventana.refrescar();
		}
		
		if(modelo.darCarreteraSeleccionada().darPerdio()) {
			ventana.guardarJugador();
		}
		
	}
}