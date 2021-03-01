package modelo;

public class AutomovilCarretera extends Automovil implements ICarretera {
	public static final int ANCHO_IMAGEN_CAMION=40;
	public static final int ALTO_IMAGEN_CAMION=120;
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
	
	public AutomovilCarretera(int pPlaca,String pImagen,int pPosX,int pPosY,int pAnchoImagenAutomovil,int pAlturaImagenAutomovil,long pVelocidad) {
		super(pPlaca,pImagen, pPosX, pPosY,pAnchoImagenAutomovil,pAlturaImagenAutomovil, pVelocidad);

	}
	
	public void moverAdelante() {
		this.cambiarPosY(this.darPosY()-1);
	}
	
	public void moverAtras() {
		this.cambiarPosY(this.darPosY()+1);
	}
	
	@Override
	public boolean enLaMismaPosicion(AutomovilCarretera pAutomovil) {
		int distanciaEntreAutos = 100;
		
		int posXLimiteAutoIzquierda = super.darPosX()-distanciaEntreAutos;
		int posXLimiteAutoDerecha =  super.darPosX()+super.darAnchoImagenAutomovil()+distanciaEntreAutos;
		
		int posYLimiteAutoArriba = super.darPosY()-distanciaEntreAutos;
		int posYLimiteAutoAbajo =  super.darPosY()+super.darAlturaImagenAutomovil()+distanciaEntreAutos;
		
		int esquinaSuperiorEInferiorDerecha_X = pAutomovil.darPosX();
		int esquinaSuperiorDerechaEIzquierda_Y = pAutomovil.darPosY();
		
		int esquinaSuperiorEInferiorIzquiedar_X = pAutomovil.darPosX() + pAutomovil.darAnchoImagenAutomovil() ;
		int esquinaInferiorDerechaEIzquiedar_Y = pAutomovil.darPosY() + pAutomovil.darAlturaImagenAutomovil() ;
		
		boolean contenido = false;
//		if(posXLimiteAutoDerecha>=esquinaSuperiorEInferiorDerecha_X && posXLimiteAutoIzquierda<=esquinaSuperiorEInferiorDerecha_X ) {
//			contenido=true;
//		}else if(posXLimiteAutoDerecha>=esquinaSuperiorEInferiorIzquiedar_X && posXLimiteAutoIzquierda<=esquinaSuperiorEInferiorIzquiedar_X) {
//			contenido=true;
//		}
			
		if(posYLimiteAutoArriba<=esquinaSuperiorDerechaEIzquierda_Y && posYLimiteAutoAbajo>=esquinaSuperiorDerechaEIzquierda_Y) {
			contenido=true;
		}else if(posYLimiteAutoArriba<=esquinaInferiorDerechaEIzquiedar_Y && posYLimiteAutoAbajo>=esquinaInferiorDerechaEIzquiedar_Y) {
			contenido=true;
		}
		return contenido;
	}
	
	public boolean coalicionAutoJugador(AutomovilJugador pAutoMovilJugador) {
		boolean choque = false;
		
		int posXLimiteAutoIzquierda = this.darPosX();
		int posXLimiteAutoDerecha =  this.darPosX()+this.darAnchoImagenAutomovil();
		
		int posYLimiteAutoArriba = this.darPosY();
		int posYLimiteAutoAbajo =  this.darPosY()+this.darAlturaImagenAutomovil();
		
		int esquinaSuperiorEInferiorDerecha_X_AutomovilJugador = pAutoMovilJugador.darPosX();
		int esquinaSuperiorDerechaEIzquierda_Y_AutomovilJugador = pAutoMovilJugador.darPosY();
		
		int esquinaSuperiorEInferiorIzquiedar_X_AutomovilJugador = pAutoMovilJugador.darPosX() + pAutoMovilJugador.darAnchoImagenAutomovil() ;
		int esquinaInferiorDerechaEIzquiedar_Y_AutomovilJugador = pAutoMovilJugador.darPosY() + pAutoMovilJugador.darAlturaImagenAutomovil() ;
		
		if(posXLimiteAutoDerecha>=esquinaSuperiorEInferiorDerecha_X_AutomovilJugador && posXLimiteAutoIzquierda<=esquinaSuperiorEInferiorDerecha_X_AutomovilJugador ) {
			if(posYLimiteAutoArriba<=esquinaSuperiorDerechaEIzquierda_Y_AutomovilJugador && posYLimiteAutoAbajo>=esquinaSuperiorDerechaEIzquierda_Y_AutomovilJugador) {
				choque=true;
			}else if(posYLimiteAutoArriba<=esquinaInferiorDerechaEIzquiedar_Y_AutomovilJugador && posYLimiteAutoAbajo>=esquinaInferiorDerechaEIzquiedar_Y_AutomovilJugador) {
				choque=true;
			}
		}else if(posXLimiteAutoDerecha>=esquinaSuperiorEInferiorIzquiedar_X_AutomovilJugador && posXLimiteAutoIzquierda<=esquinaSuperiorEInferiorIzquiedar_X_AutomovilJugador) {
			if(posYLimiteAutoArriba<=esquinaSuperiorDerechaEIzquierda_Y_AutomovilJugador && posYLimiteAutoAbajo>=esquinaSuperiorDerechaEIzquierda_Y_AutomovilJugador) {
				choque=true;
			}else if(posYLimiteAutoArriba<=esquinaInferiorDerechaEIzquiedar_Y_AutomovilJugador && posYLimiteAutoAbajo>=esquinaInferiorDerechaEIzquiedar_Y_AutomovilJugador) {
				choque=true;
			}
		
		}
		
		return choque;
	}
	@Override
	public void reiniciarMovimiento() {
		// TODO Auto-generated method stub
		
	}
}
