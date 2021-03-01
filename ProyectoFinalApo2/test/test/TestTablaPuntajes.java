package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.PuntajeNoRegistradoException;
import modelo.TablaPuntajes;

class TestTablaPuntajes {

	private TablaPuntajes laTabla;
	
	public void escenarioUno() {
		
		laTabla = new TablaPuntajes();
		laTabla.agregarJugadorATablaDePuntajes(new Jugador("Pepito Perez", 100, "desierto"));
		laTabla.agregarJugadorATablaDePuntajes(new Jugador("Juan", 150, "Cañon"));
		laTabla.agregarJugadorATablaDePuntajes(new Jugador("Camilo", 50, "Autopista"));
		laTabla.agregarJugadorATablaDePuntajes(new Jugador("Alguien", 125, "Desierto"));
		laTabla.agregarJugadorATablaDePuntajes(new Jugador("Valeria", 25, "Autopista"));
		
	}
	
	@Test
	public void buscarPuntajeTest() throws PuntajeNoRegistradoException {
		
		escenarioUno();
		assertEquals(laTabla.getJugadorRaiz().darNodoIzquierdo(), laTabla.buscarPuntaje(50));
		
	}
	
	@Test
	public void eliminarJugadorTablaTest() {
		
		escenarioUno();
		Jugador esperado = laTabla.getJugadorRaiz().darNodoDerecho().darNodoIzquierdo();
		laTabla.eliminarJugadorTabla(100);
		assertEquals(esperado, laTabla.getJugadorRaiz());
		
	}
	
	public void agregarJugadorATablaDePuntajesTest() {
		
		escenarioUno();
		Jugador esperado = new Jugador("Sergio", 200, "Cañon");
		laTabla.agregarJugadorATablaDePuntajes(esperado);
		assertEquals(esperado, laTabla.getJugadorRaiz().darNodoDerecho().darNodoDerecho());
		
	}
	
	@Test
	public void ordenarJugadoresMayorAMenorTest() {
		
		escenarioUno();
		ArrayList<Jugador> esperado = new ArrayList<Jugador>();
		esperado.add(laTabla.getJugadorRaiz().darNodoDerecho());
		esperado.add(laTabla.getJugadorRaiz().darNodoDerecho().darNodoIzquierdo());
		esperado.add(laTabla.getJugadorRaiz());
		esperado.add(laTabla.getJugadorRaiz().darNodoIzquierdo());
		esperado.add(laTabla.getJugadorRaiz().darNodoIzquierdo().darNodoIzquierdo());
		assertEquals(esperado, laTabla.darJugadoresOrdenadosMayorAMenor());
		
	}
	
	@Test
	public void darJugadoresOrdenadosMayorAMenorTest() {
		
		escenarioUno();
		ArrayList<Jugador> esperado = new ArrayList<Jugador>();
		esperado.add(laTabla.getJugadorRaiz().darNodoDerecho());
		esperado.add(laTabla.getJugadorRaiz().darNodoDerecho().darNodoIzquierdo());
		esperado.add(laTabla.getJugadorRaiz());
		esperado.add(laTabla.getJugadorRaiz().darNodoIzquierdo());
		esperado.add(laTabla.getJugadorRaiz().darNodoIzquierdo().darNodoIzquierdo());
		assertEquals(esperado, laTabla.darJugadoresOrdenadosMayorAMenor());
		
	}
	
}
