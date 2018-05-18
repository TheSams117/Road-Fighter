package modelo;

public class AutomovilCarretera extends Automovil implements ICarretera {
	
	public static final String CAMION="imagenes/enemigos/automovil_enemigo1.png";
	public static final int PLACA_CAMION_1=104;
	public static final int PLACA_CAMION_2=108;
	public static final String CARRO_AZUL="imagenes/enemigos/automovil_enemigo2.png";
	public static final int PLACA_CARRO_AZUL_1=105;
	public static final int PLACA_CARRO_AZUL_2=109;
	public static final String CARRO_ROJO="imagenes/enemigos/automovil_enemigo3.png";
	public static final int PLACA_CARRO_ROJO_1=106;
	public static final int PLACA_CARRO_ROJO_2=110;
	public static final String CARRO_AMARILLO="imagenes/enemigos/automovil_enemigo4.png";
	public static final int PLACA_CARRO_AMARILLO_1=107;
	public static final int PLACA_CARRO_AMARILLO_2=111;
	
	public AutomovilCarretera(int pPlaca,String pImagen, int pPosX, int pPosY, long pVelocidad) {
		super(pPlaca,pImagen, pPosX, pPosY, pVelocidad);
		// TODO Auto-generated constructor stub
	}
	
	public void moverAdelante() {
		
	}
	
	public void moverAtras() {
		
	}
	
	@Override
	public boolean enLaMismaPosicion(AutomovilCarretera pAutomovil) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void reiniciarMovimiento() {
		// TODO Auto-generated method stub
		
	}
}
