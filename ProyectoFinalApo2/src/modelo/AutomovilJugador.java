package modelo;

public class AutomovilJugador extends Automovil implements IJugador {
	public static final String AUTOMOVIL_1="imagenes/carro_1.png";
	public static final int PLACA_AUTO_1=101;
	public static final String AUTOMOVIL_2="imagenes/carro_2.png";
	public static final int PLACA_AUTO_2=102;
	public static final String AUTOMOVIL_3="imagenes/carro_3.png";
	public static final int PLACA_AUTO_3=103;
	
	
	public AutomovilJugador(int pPlaca,String pImagen, int pPosX, int pPosY, long pVelocidad) {
		super(pPlaca, pImagen, pPosX, pPosY, pVelocidad);
		
	}
	
	public void moverDerecha() {
		super.cambiarPosX(super.darPosX()+1);
	}
	
	public void moverIzquierda() {
		super.cambiarPosX(super.darPosX()-1);
	}

	@Override
	public boolean estrellado(AutomovilCarretera pAutomovil) {
		// TODO Auto-generated method stub
		return false;
	}

}
