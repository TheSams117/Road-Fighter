package hilos;

import interfaz.VentanaJuego;
import interfaz.VentanaPrincipal;
import modelo.RoadFigther;

public class HiloCarretera extends Thread {
	
	private VentanaJuego ventana;
	private RoadFigther modelo;
	
	public HiloCarretera(VentanaJuego pVentana,RoadFigther pModelo) {
		ventana=pVentana;
		modelo=pModelo;
	}
	
	public void run() {
		
		while(true) {
			System.out.println(modelo.darCarreteraSeleccionada().darAvanza()+"");
			if(modelo.darCarreteraSeleccionada().darAvanza()) {
				modelo.darCarreteraSeleccionada().moverImagen1();
				modelo.darCarreteraSeleccionada().moverImagen2();
				ventana.refrescar();
			
					try {
						this.sleep(0,001);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		}
			
			
		}
	}
}
