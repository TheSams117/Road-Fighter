package modelo;

import java.io.Serializable;
import java.util.ArrayList;

/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 * Universidad Icesi (Cali - Colombia)    ~ 
 * Autores: Juan Sebastian Puerta Ordoñes ~ 
 * 			Jeiner Alexis Bonilla Chavez  ~ 
 * 			Sergio Andres Lozada Sanchez  ~      
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
public class Carretera implements Serializable {
	
	
	
	public static final long VELOCIDAD_MAXIMA_EN_CARRETERA = 1;
	public static final long AUMENTO_Y_DISMINUCION_DE_VELOCIDAD =1  ;
	public static final long VELOCIDAD_INICIAL = 10;
	//435
	public static final int TAMANHO_PANEL = 432;
	public static final int RANGO_DIBUJO_AUTOS_CARRETERA = 3000;
	public static final String CARRETERA_TIPO_CAMPO = "imagenes/campo.png";
	public static final int POS_Y_INICAL_DE_AUTOMOVIL_CAMPO = 450;
	public static final int POS_X_INICAL_DE_AUTOMOVIL_CAMPO = 350;
	public static final int LIMITE_DERECHA_CAMPO = 468;
	public static final int LIMITE_IZQUIERDA_CAMPO = 240;
	
	public static final String CARRETERA_TIPO_PUENTE = "imagenes/puente.png";
	public static final int POS_Y_INICAL_DE_AUTOMOVIL_PUENTE = 450;
	public static final int POS_X_INICAL_DE_AUTOMOVIL_PUENTE = 255;
	public static final int LIMITE_DERECHA_PUENTE = 370;
	public static final int LIMITE_IZQUIERDA_PUENTE = 140;
	
	public static final String CARRETERA_TIPO_PLAYA = "imagenes/playa.png";
	public static final int POS_Y_INICAL_DE_AUTOMOVIL_PLAYA = 450;
	public static final int POS_X_INICAL_DE_AUTOMOVIL_PLAYA = 176;
	public static final int LIMITE_DERECHA_PLAYA = 229;
	public static final int LIMITE_IZQUIERDA_PLAYA = 136;
	
	public static final String CARRETERA_TIPO_CANHON = "imagenes/cañon.png";
	public static final int POS_Y_INICAL_DE_AUTOMOVIL_CANHON = 450;
	public static final int POS_X_INICAL_DE_AUTOMOVIL_CANHON = 343;
	public static final int LIMITE_DERECHA_CANHON = 428;
	public static final int LIMITE_IZQUIERDA_CANHON = 268;
	
	public static final int AUTOMOVIL_ROJO = 1;
	public static final int AUTOMOVIL_AZUL = 2;
	public static final int AUTOMOVIL_AMARILLO = 3;
	
	public static final int POS_X_IMAGEN = 0;
	
	private String tipo;
	private int puntaje;
	private long velocidadCarretera;
	private long velocidadAutosCarretera;
	private boolean perdio;
	private boolean finDeLaPartida;
	private boolean pausa;
	private boolean avanza;
	private int cantidadAutomovilesJugador;
	private int cantidadAutomovilesCarretera;
	private int numeroCarretera;
	private int posYImagen1;
	private int posYImagen2;
	private int limiteCarreteraDerecha;
	private int limiteCarreteraIzquierda;
	private AutomovilJugador automovilSeleccionado;
	private Carretera carreteraSiguiente;
	private Carretera carreteraAnterior;
	private Automovil[] automoviles;
	
	public Carretera(String pCarretera,int pNumeroCarretera){
		
		automoviles = new Automovil[2];
		velocidadCarretera=VELOCIDAD_INICIAL;
		velocidadAutosCarretera=VELOCIDAD_MAXIMA_EN_CARRETERA;
		finDeLaPartida=false;
		perdio=false;
		pausa=false;
		puntaje=0;
		
		if(pCarretera.equals(CARRETERA_TIPO_CAMPO)) {
			
			tipo=CARRETERA_TIPO_CAMPO;
			
			automoviles[0] = new AutomovilJugador(AutomovilJugador.PLACA_AUTO_2,AutomovilJugador.AUTOMOVIL_2,POS_X_INICAL_DE_AUTOMOVIL_CAMPO,POS_Y_INICAL_DE_AUTOMOVIL_CAMPO,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL);
			automoviles[0].cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_3,AutomovilJugador.AUTOMOVIL_3,POS_X_INICAL_DE_AUTOMOVIL_CAMPO,POS_Y_INICAL_DE_AUTOMOVIL_CAMPO,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			automoviles[0].darAutomovilSiguiente().cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_1,AutomovilJugador.AUTOMOVIL_1,POS_X_INICAL_DE_AUTOMOVIL_CAMPO,POS_Y_INICAL_DE_AUTOMOVIL_CAMPO,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			limiteCarreteraDerecha=LIMITE_DERECHA_CAMPO;
		    limiteCarreteraIzquierda=LIMITE_IZQUIERDA_CAMPO;
		    
		}else if(pCarretera.equals(CARRETERA_TIPO_PUENTE)) {
			tipo=CARRETERA_TIPO_PUENTE;
			
			automoviles[0] = new AutomovilJugador(AutomovilJugador.PLACA_AUTO_2,AutomovilJugador.AUTOMOVIL_2,POS_X_INICAL_DE_AUTOMOVIL_PUENTE,POS_Y_INICAL_DE_AUTOMOVIL_PUENTE,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL);
			automoviles[0].cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_3,AutomovilJugador.AUTOMOVIL_3,POS_X_INICAL_DE_AUTOMOVIL_PUENTE,POS_Y_INICAL_DE_AUTOMOVIL_PUENTE,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			automoviles[0].darAutomovilSiguiente().cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_1,AutomovilJugador.AUTOMOVIL_1,POS_X_INICAL_DE_AUTOMOVIL_PUENTE,POS_Y_INICAL_DE_AUTOMOVIL_PUENTE,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			limiteCarreteraDerecha=LIMITE_DERECHA_PUENTE;
		    limiteCarreteraIzquierda=LIMITE_IZQUIERDA_PUENTE;
		    
		}else if(pCarretera.equals(CARRETERA_TIPO_PLAYA)) {
			tipo=CARRETERA_TIPO_PLAYA;
			
			automoviles[0] = new AutomovilJugador(AutomovilJugador.PLACA_AUTO_2,AutomovilJugador.AUTOMOVIL_2,POS_X_INICAL_DE_AUTOMOVIL_PLAYA,POS_Y_INICAL_DE_AUTOMOVIL_PLAYA,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL);
			automoviles[0].cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_3,AutomovilJugador.AUTOMOVIL_3,POS_X_INICAL_DE_AUTOMOVIL_PLAYA,POS_Y_INICAL_DE_AUTOMOVIL_PLAYA,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			automoviles[0].darAutomovilSiguiente().cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_1,AutomovilJugador.AUTOMOVIL_1,POS_X_INICAL_DE_AUTOMOVIL_PLAYA,POS_Y_INICAL_DE_AUTOMOVIL_PLAYA,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			
			limiteCarreteraDerecha=LIMITE_DERECHA_PLAYA;
		    limiteCarreteraIzquierda=LIMITE_IZQUIERDA_PLAYA;
		    
		}else if(pCarretera.equals(CARRETERA_TIPO_CANHON)) {
			tipo=CARRETERA_TIPO_CANHON;
			
			automoviles[0] = new AutomovilJugador(AutomovilJugador.PLACA_AUTO_2,AutomovilJugador.AUTOMOVIL_2,POS_X_INICAL_DE_AUTOMOVIL_CANHON,POS_Y_INICAL_DE_AUTOMOVIL_CANHON,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL);
			automoviles[0].cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_3,AutomovilJugador.AUTOMOVIL_3,POS_X_INICAL_DE_AUTOMOVIL_CANHON,POS_Y_INICAL_DE_AUTOMOVIL_CANHON,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			automoviles[0].darAutomovilSiguiente().cambiarAutomovilSiguiente(new AutomovilJugador(AutomovilJugador.PLACA_AUTO_1,AutomovilJugador.AUTOMOVIL_1,POS_X_INICAL_DE_AUTOMOVIL_CANHON,POS_Y_INICAL_DE_AUTOMOVIL_CANHON,AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,VELOCIDAD_INICIAL));
			
			limiteCarreteraDerecha=LIMITE_DERECHA_CANHON;
		    limiteCarreteraIzquierda=LIMITE_IZQUIERDA_CANHON;
		}
		
		
		automoviles[1] = new AutomovilCarretera(AutomovilCarretera.PLACA_CAMION_1,AutomovilCarretera.CAMION,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilCarretera.ANCHO_IMAGEN_CAMION,AutomovilCarretera.ALTO_IMAGEN_CAMION,0);
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AMARILLO_2,AutomovilCarretera.CARRO_AMARILLO,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AZUL_1,AutomovilCarretera.CARRO_AZUL,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_ROJO_2,AutomovilCarretera.CARRO_ROJO,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AMARILLO_1,AutomovilCarretera.CARRO_AMARILLO,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_ROJO_1,AutomovilCarretera.CARRO_ROJO,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CARRO_AZUL_2,AutomovilCarretera.CARRO_AZUL,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilJugador.ANCHO_IMAGEN_AUTOMOVIL,AutomovilJugador.ALTO_IMAGEN_AUTOMOVIL,0)) ;
		agregarAutomovilCarretera(new AutomovilCarretera(AutomovilCarretera.PLACA_CAMION_2,AutomovilCarretera.CAMION,((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda)),(int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA),AutomovilCarretera.ANCHO_IMAGEN_CAMION,AutomovilCarretera.ALTO_IMAGEN_CAMION,0)) ;
		
		
		iniciarAutoMoviles();
		cantidadAutomovilesJugador=3;
		cantidadAutomovilesCarretera=8;
		numeroCarretera=pNumeroCarretera;
		posYImagen1=0;
		posYImagen2=-TAMANHO_PANEL;
		avanza=false;
		
		
		
		
	}
	
	public String darTipo() {
		return tipo;
	}
	
	public long darVelocidad() {
		return velocidadCarretera;
	}

	public void cambiarTipo(String pTipo) {
		tipo = pTipo;
	}
	
	public int darPuntaje() {
		return puntaje;
	}

	public void cambiarPuntaje(int pPuntaje) {
		puntaje = pPuntaje;
	}
	
	public boolean darPausa() {
		return pausa;
	}
	
	public void cambiarPausa() {
		pausa = (pausa)? false:true;
	}
	
	public void avanzar() {
		avanza=true;
	}
	
	public void detener() {
		avanza=false;
	}
	
	public boolean darAvanza() {
		return avanza;
	}

	public void cambiarAvanza(boolean pAvanza) {
		avanza = pAvanza;
	}

	public int darCantidadAutomovilesJugador() {
		return cantidadAutomovilesJugador;
	}
	
	public long darVelocidadAutosCarretera() {
		return velocidadAutosCarretera;
	}

	public void cambiarCantidadAutomovilesJugador(int pCantidadAutomovilesJugador) {
		cantidadAutomovilesJugador = pCantidadAutomovilesJugador;
	}

	public int darCantidadAutomovilesCarretera() {
		return cantidadAutomovilesCarretera;
	}

	public void cambiarCantidadAutomovilesCarretera(int pCantidadAutomovilesCarretera) {
		cantidadAutomovilesCarretera = pCantidadAutomovilesCarretera;
	}

	public int darNumeroCarretera() {
		return numeroCarretera;
	}

	public void cambiarNumeroCarretera(int pNumeroCarretera) {
		numeroCarretera = pNumeroCarretera;
	}
	
	public void moverImagen1() {
		if(posYImagen1==TAMANHO_PANEL) {
			posYImagen1=-TAMANHO_PANEL;
		}else {
			posYImagen1+=1;
		}
		
		
		
	}

	public int darPosYImagen1() {
		return posYImagen1;
	}

	public void cambiarPosYImagen1(int pPosYImagen1) {
		posYImagen1 = pPosYImagen1;
	}
	
	public void moverImagen2() {
		if(posYImagen2==TAMANHO_PANEL) {
			posYImagen2=-TAMANHO_PANEL;
		}else {
			posYImagen2+=1;
		}
	
	}
	
	public int darPosYImagen2() {
		return posYImagen2;
	}

	public void cambiarPosYImagen2(int pPosYImagen2) {
		posYImagen2 = pPosYImagen2;
	}

	public int darLimiteCarreteraDerecha() {
		return limiteCarreteraDerecha;
	}

	public void cambiarLimiteCarreteraDerecha(int pLimiteCarreteraDerecha) {
		limiteCarreteraDerecha = pLimiteCarreteraDerecha;
	}

	public int darLimiteCarreteraIzquierda() {
		return limiteCarreteraIzquierda;
	}

	public void cambiarLimiteCarreteraIzquierda(int pLimiteCarreteraIzquierda) {
		limiteCarreteraIzquierda = pLimiteCarreteraIzquierda;
	}

	public AutomovilJugador darAutomovilSeleccionado() {
		return automovilSeleccionado;
	}
	
	public boolean laPartidaFinalizo() {
		return finDeLaPartida;
	}
	
	public void cambiarFinalizacionDeLaPartida(boolean pFinDeLaPartida) {
		finDeLaPartida=pFinDeLaPartida;
	}
	
	public boolean darPerdio() {
		return perdio;
	}

	public void cambiarPerdio(boolean pPerdio) {
		perdio = pPerdio;
	}

	public void cambiarAutomovilSeleccionado(String pAutomovil) {
		if(pAutomovil==AutomovilJugador.AUTOMOVIL_1) {
			automovilSeleccionado=buscarBinarioAutomovil(AutomovilJugador.PLACA_AUTO_1);
			
		}else if(pAutomovil==AutomovilJugador.AUTOMOVIL_2) {
			automovilSeleccionado=buscarBinarioAutomovil(AutomovilJugador.PLACA_AUTO_2);
		}else if(pAutomovil==AutomovilJugador.AUTOMOVIL_3) {
			automovilSeleccionado=buscarBinarioAutomovil(AutomovilJugador.PLACA_AUTO_3);
		}
	}

	public Carretera darCarreteraSiguiente() {
		return carreteraSiguiente;
	}

	public void cambiarCarreteraSiguiente(Carretera pCarreteraSiguiente) {
		carreteraSiguiente = pCarreteraSiguiente;
	}

	public Carretera darCarreteraAnterior() {
		return carreteraAnterior;
	}

	public void cambiarCarreteraAnterior(Carretera pCarreteraAnterior) {
		carreteraAnterior = pCarreteraAnterior;
	}
	
	public AutomovilCarretera darUltimoAutomovilCarretera() {
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		while(actual.darAutomovilSiguiente()!=null) {
			actual.darAutomovilSiguiente();
		}
		
		return actual;
	}

	public Automovil[] darAutomoviles() {
		return automoviles;
	}

	public void cambiarAutomoviles(Automovil[] pAutomoviles) {
		automoviles = pAutomoviles;
	}
	
	public void seleccionarAutomovil(int pPlaca) {
		automovilSeleccionado=buscarBinarioAutomovil(pPlaca);
	}

	
	public AutomovilCarretera darPrimerAutomovilListaCarretera() {
		AutomovilCarretera auto = null;
		for (int i = 0; i < automoviles.length; i++) {
			if(automoviles[i] instanceof ICarretera) {
				auto=(AutomovilCarretera) automoviles[i];
			}
		}
		return auto;
	}
	
	
	
	public AutomovilJugador darPrimerAutomovilListaJugador() {
		AutomovilJugador auto = null;
		for (int i = 0; i < automoviles.length; i++) {
			if(automoviles[i] instanceof IJugador) {
				auto=(AutomovilJugador) automoviles[i];
			}
		}
		return auto;
	}
	
	public void agregarAutomovilCarretera(AutomovilCarretera pAutomovilCarretera) {
		AutomovilCarretera actual = (AutomovilCarretera) automoviles[1];
		while(actual.darAutomovilSiguiente() != null) {
			actual=(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		actual.cambiarAutomovilSiguiente(pAutomovilCarretera);
	}
	
	public AutomovilJugador buscarBinarioAutomovil(int pPlaca) {
		ArrayList<AutomovilJugador> lista = darAutoMovilesJugadorOrdenadosSeleccion();
		AutomovilJugador auto = null;
		boolean encontrado = false;
		int inicio = 0;
		int fin = lista.size()-1;
		while (inicio <= fin && !encontrado ) {
			int medio = (inicio + fin ) / 2 ;
			if (lista.get(medio).darPlaca() == pPlaca ) {
				auto = lista.get(medio);
				encontrado=true;
			} else if (lista.get(medio).darPlaca()  > pPlaca) {
				fin = medio -1 ;
			} else {
				inicio = medio + 1;
			}
		}
		
		return auto;
	}
	
	public  ArrayList<AutomovilJugador> darAutoMovilesJugador() {
		AutomovilJugador actual = darPrimerAutomovilListaJugador();
		ArrayList<AutomovilJugador> lista = new ArrayList<AutomovilJugador>();
		while(actual != null) {
			lista.add(actual);
			actual = (AutomovilJugador) actual.darAutomovilSiguiente();
		}
		
		return lista;
	}
	
	public ArrayList<AutomovilJugador> darAutoMovilesJugadorOrdenadosSeleccion() {
		ArrayList<AutomovilJugador> lista = darAutoMovilesJugador();
		
		for (int i = 0; i < lista.size()-1; i++) {
			AutomovilJugador menor = lista.get(i); 
			int cual = i;
			for (int j = i + 1; j < lista.size(); j++  ) {
				if ( lista.get(j).darPlaca() < menor.darPlaca() ) {
					menor = lista.get(j);
					cual = j;
				}
			}
			AutomovilJugador temp = lista.get(i);
			lista.set(i, menor);
			lista.set(cual,temp);
			
		}
		
		return lista;
	}
	
	public ArrayList<AutomovilCarretera> darAutomovilesCarretera(){
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		ArrayList<AutomovilCarretera> lista = new ArrayList<AutomovilCarretera>();
		while(actual!=null) {
			lista.add(actual);
			actual=(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		
		return lista;
	}
	
	
	public void moverCarreteras() {
		if(avanza==true) {
			moverImagen2();
			moverImagen1();
		}else if(velocidadCarretera<VELOCIDAD_INICIAL) {
			moverImagen2();
			moverImagen1();
		}
		
		
	}
	
	public void nuevaPosAuto(AutomovilCarretera pAutomovil) {
		pAutomovil.cambiarPosX((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda));
		pAutomovil.cambiarPosY(((int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA))*-1);
	}
	public void posicionAleatoriaAutoCarretera(AutomovilCarretera pAutomovil) {
		AutomovilCarretera actual = pAutomovil;
		boolean posicionado = false;
		boolean contenido = false;
		
		while(!posicionado) {
			
			for (int i = 0; i < darAutomovilesCarretera().size() && !contenido; i++) {
				
				
				AutomovilCarretera actualComparar = darAutomovilesCarretera().get(i);
				
				if(actualComparar.darPlaca()!= actual.darPlaca()) {
					contenido = actualComparar.enLaMismaPosicion(actual);
				}
				
			}
			
			if (contenido) {
				actual.cambiarPosX((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda));
				actual.cambiarPosY(((int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA))*-1);
				System.out.println(actual.darPosX());
				System.out.println(actual.darPosY());
				
				contenido = false;
			}else {
				posicionado = true;
			}
			
		}
	}
	
//	public void reiniciarPosicionAutomovileFuera() {
//		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
//		while(actual!=null) {
//			if(actual.darPosY()>=550) {
//				posicionAleatoriaAutoCarretera(actual);
//			}
//			actual =(AutomovilCarretera) actual.darAutomovilSiguiente();
//		}
//	}
	
	public int darPosMayor() {
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		int posicion = 0;
		while(actual!=null) {
			if(posicion<actual.darPosY()) {
				posicion = actual.darPosY();
			}
			actual =(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		return posicion;
	}
	public void moverAutomovilesCarreteraAdelante() {
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		while(actual!=null) {
			actual.moverAdelante();
			actual =(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
	}
	
	public void moverAutomovilesCarreteraAtras() {
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		while(actual!=null) {
			actual.moverAtras();
			if(actual.darPosY()>500) {
				nuevaPosAuto(actual);
				posicionAleatoriaAutoCarretera(actual);
				puntaje+=1;
			}
			

			actual =(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
	}
	public void moverAutomovilesCarretera() {
		if(avanza && velocidadCarretera==1) {
			moverAutomovilesCarreteraAtras();
		}else if(velocidadCarretera>2){
			moverAutomovilesCarreteraAdelante();
		}
	}
	
	public void iniciarAutoMoviles() {
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();

		
		while(actual!=null) {
			actual.cambiarPosX((int)(Math.random()*(limiteCarreteraDerecha-limiteCarreteraIzquierda)+limiteCarreteraIzquierda));
			actual.cambiarPosY(((int)(Math.random()*RANGO_DIBUJO_AUTOS_CARRETERA))*-1);
			
			posicionAleatoriaAutoCarretera(actual);
			
			actual=(AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		
	}
	
	public void velocidad() {
		if(avanza && velocidadCarretera>VELOCIDAD_MAXIMA_EN_CARRETERA) {
			velocidadCarretera-=AUMENTO_Y_DISMINUCION_DE_VELOCIDAD;		
		}else if(!avanza && velocidadCarretera<VELOCIDAD_INICIAL) {
			velocidadCarretera+=AUMENTO_Y_DISMINUCION_DE_VELOCIDAD;
		}
		
		
	}
	
	public void velocidadAutosCarretera() {
		
		if(avanza) {
			if(velocidadCarretera<=10 && velocidadCarretera>7 ) {
				velocidadAutosCarretera=1;	
			}else if(velocidadCarretera<=7 && velocidadCarretera>4) {
				velocidadAutosCarretera=2;
			}else {
				velocidadAutosCarretera=3;
			}
//				
//				if(velocidadCarretera<10 && velocidadCarretera>7) {
//				velocidadAutosCarretera=3;
//			}else {
//				velocidadAutosCarretera=1;
//			}
					
		}else{
			if(velocidadCarretera<4) {
				velocidadAutosCarretera=3;
			}else if(velocidadCarretera>=4 && velocidadCarretera<7 ) {
				velocidadAutosCarretera=2;
			}else {
				velocidadAutosCarretera=1;
			}
			
		}
//		
//		if( velocidadCarretera<=10 && velocidadCarretera>=7) {
//			if (avanza) {
//				velocidadAutosCarretera=8;	
//			}else {
//				velocidadAutosCarretera=2;
//			}
//				
//		}else if ( velocidadCarretera<7 && velocidadCarretera>=4) {
//			velocidadAutosCarretera=4;
//		} else if(velocidadCarretera<4 && velocidadCarretera>=1) {
//			velocidadAutosCarretera=2;
//		}

		
	}
	
	
	
	public void seEstrelloContraLaBarrera() {
		boolean estrellado = false;
		if(velocidadCarretera<3 && (automovilSeleccionado.darPosX()==limiteCarreteraDerecha||automovilSeleccionado.darPosX()==limiteCarreteraIzquierda)) {
			estrellado = true;
		}
		perdio=estrellado;
	}
	
	public void seEstrelloContraUnAutomovil() {
		boolean estrellado = false;
		AutomovilCarretera actual = darPrimerAutomovilListaCarretera();
		
		
		while(actual!=null && !estrellado) {
			estrellado = actual.coalicionAutoJugador(automovilSeleccionado);
			actual = (AutomovilCarretera) actual.darAutomovilSiguiente();
		}
		
		perdio=estrellado;
	}
	
	public int darAnchoAutoMovilSeleccionado() {
		return automovilSeleccionado.darAnchoImagenAutomovil() ;
	}

	public int darAlturaAutomovilSeleccionado() {
		return automovilSeleccionado.darAlturaImagenAutomovil() ;
	}

	public void moverDerecha() {
		automovilSeleccionado.seMueveDerecha(limiteCarreteraDerecha);
	}

	public void noMoverDerecha() {
		automovilSeleccionado.noSeMueveDerecha();
		
	}

	public void moverIzquierda() {
		automovilSeleccionado.seMueveIzquierda(limiteCarreteraIzquierda);
		
	}
	
	public void noMoverIzquierda() {
		automovilSeleccionado.noSeMueveIzquierda();
		
	}

	public void moverAuto() {
		automovilSeleccionado.moverAuto(limiteCarreteraDerecha,limiteCarreteraIzquierda);
		
	}
	
	public void finDePartida() {
		
		
		finDeLaPartida=false;
		perdio=false;
		pausa=false;
		puntaje=0;
		posYImagen1=0;
		posYImagen2=-TAMANHO_PANEL;
		
		reiniciarPosicionAutoJugador();
		iniciarAutoMoviles();
		
		velocidadCarretera=VELOCIDAD_INICIAL;
		velocidadAutosCarretera=VELOCIDAD_MAXIMA_EN_CARRETERA;
		avanza=false;
	}

	public String darImagenAutoJugador() {

		return automovilSeleccionado.darImagen();
	}

	public int darPosXAutomovilJugador() {
		return automovilSeleccionado.darPosX();
	}

	public int darPosYAutomovilJugador() {
		return automovilSeleccionado.darPosY();
	}
	
	public void reiniciarPosicionAutoJugador() {
		if(limiteCarreteraDerecha==LIMITE_DERECHA_CAMPO) {
			automovilSeleccionado.cambiarPosX(POS_X_INICAL_DE_AUTOMOVIL_CAMPO);
			automovilSeleccionado.cambiarPosY(POS_Y_INICAL_DE_AUTOMOVIL_CAMPO);
		}else if(limiteCarreteraDerecha==LIMITE_DERECHA_PUENTE) {
			automovilSeleccionado.cambiarPosX(POS_X_INICAL_DE_AUTOMOVIL_PUENTE);
			automovilSeleccionado.cambiarPosY(POS_Y_INICAL_DE_AUTOMOVIL_PUENTE);
		}else if(limiteCarreteraDerecha==LIMITE_DERECHA_PLAYA) {
			automovilSeleccionado.cambiarPosX(POS_X_INICAL_DE_AUTOMOVIL_PLAYA);
			automovilSeleccionado.cambiarPosY(POS_Y_INICAL_DE_AUTOMOVIL_PLAYA);
		}else if(limiteCarreteraDerecha==LIMITE_DERECHA_CANHON) {
			automovilSeleccionado.cambiarPosX(POS_X_INICAL_DE_AUTOMOVIL_CANHON);
			automovilSeleccionado.cambiarPosY(POS_Y_INICAL_DE_AUTOMOVIL_CANHON);
		}
	}
	
}
