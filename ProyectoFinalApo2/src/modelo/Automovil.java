package modelo;

import java.io.Serializable;

public abstract class Automovil implements Serializable {
	
	public static final int ANCHO_IMAGEN_AUTOMOVIL=40;
	public static final int ALTO_IMAGEN_AUTOMOVIL=60;
	
	private String imagen;
	private int placa;
	private int posX;
	private int posY;
	private long velocidad;
	private Automovil automovilSiguiente;
	private Automovil automovilAnterior;
	private int anchoImagenAutomovil;
	private int alturaImagenAutomovil;
	
	public Automovil(int pPlaca,String pImagen,int pPosX,int pPosY,int pAnchoImagenAutomovil,int pAlturaImagenAutomovil,long pVelocidad) {
		placa=pPlaca;
		imagen=pImagen;
		posX=pPosX;
		posY=pPosY;
		velocidad=pVelocidad;
		anchoImagenAutomovil=pAnchoImagenAutomovil;
		alturaImagenAutomovil=pAlturaImagenAutomovil;
		automovilSiguiente=null;
		automovilAnterior=null;
	}
	
		
	public int darAnchoImagenAutomovil() {
		return anchoImagenAutomovil;
	}


	public int darAlturaImagenAutomovil() {
		return alturaImagenAutomovil;
	}


	public String darImagen() {
		return imagen;
	}

	public void cambiarImagen(String pImagen) {
		imagen = pImagen;
	}

	public int darPlaca() {
		return placa;
	}

	public int darPosX() {
		return posX;
	}

	public void cambiarPosX(int pPosX) {
		posX = pPosX;
	}

	public int darPosY() {
		return posY;
	}

	public void cambiarPosY(int pPosY) {
		posY = pPosY;
	}

	public long darVelocidad() {
		return velocidad;
	}

	public void cambiarVelocidad(long pVelocidad) {
		velocidad = pVelocidad;
	}

	public Automovil darAutomovilSiguiente() {
		return automovilSiguiente;
	}

	public void cambiarAutomovilSiguiente(Automovil pAutomovilSiguiente) {
		automovilSiguiente = pAutomovilSiguiente;
	}

	public Automovil darAutomovilAnterior() {
		return automovilAnterior;
	}

	public void cambiarAutomovilAnterior(Automovil pAutomovilAnterior) {
		automovilAnterior = pAutomovilAnterior;
	}
	
	public void aumentarVelocidad() {
		velocidad-=1;
	}
	
	public void disminuirVelocidad() {
		velocidad+=1;
	}
	
	public void moverAdelante() {
		posY-=1;
	}
	
	public void moverAtras() {
		posY+=1;
	}
	
	public void estaEnRango(Automovil pAutomovil) {
		
	}
	
}
