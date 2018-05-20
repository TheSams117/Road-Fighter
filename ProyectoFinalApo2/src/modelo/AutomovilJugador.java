package modelo;

public class AutomovilJugador extends Automovil implements IJugador {
	public static final String AUTOMOVIL_1="imagenes/carro_1.png";
	public static final int PLACA_AUTO_1=101;
	public static final String AUTOMOVIL_2="imagenes/carro_2.png";
	public static final int PLACA_AUTO_2=102;
	public static final String AUTOMOVIL_3="imagenes/carro_3.png";
	public static final int PLACA_AUTO_3=103;
	
	private boolean seMovioDerecha;
	private boolean seMovioIzquierda;
	
	public AutomovilJugador(int pPlaca,String pImagen,int pPosX,int pPosY,int pAnchoImagenAutomovil,int pAlturaImagenAutomovil,long pVelocidad) {
		super(pPlaca,pImagen, pPosX, pPosY,pAnchoImagenAutomovil,pAlturaImagenAutomovil, pVelocidad);
		seMovioDerecha=false;

		seMovioDerecha=false;
		
	}
	public void moverAuto(int limiteCarreteraDerecha, int limiteCarreteraIzquierda) {
		if(seMovioDerecha==true && super.darPosX()!= limiteCarreteraDerecha ) {
			
			cambiarPosALaDerecha();
		}else if(seMovioIzquierda==true && super.darPosX()!= limiteCarreteraIzquierda) {
			cambiarPosAlaIzquierda();
		}
	}
	
	public void seMueveDerecha(int limiteDerecha) {
			seMovioDerecha=true;
		
		
	}
	
	public void noSeMueveDerecha() {
		seMovioDerecha=false;
	}
	
	
	public void seMueveIzquierda(int limiteIzquierda) {

			seMovioIzquierda=true;
		
	}
	
	public void noSeMueveIzquierda() {
		seMovioIzquierda=false;
	}
	
	
	public void cambiarPosALaDerecha() {
		super.cambiarPosX(super.darPosX()+1);
	}
	
	public void cambiarPosAlaIzquierda() {
		super.cambiarPosX(super.darPosX()-1);
	}

	@Override
	public boolean estrellado(AutomovilCarretera pAutomovil) {
		// TODO Auto-generated method stub
		return false;
	}

}
