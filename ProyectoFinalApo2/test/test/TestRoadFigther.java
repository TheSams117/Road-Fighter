package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.JugadorNoEncontradoException;
import modelo.RoadFigther;

class TestRoadFigther {

	private RoadFigther elRoad;
	
	public void escenarioUno() {
		
		elRoad = new  RoadFigther();
		elRoad.agregarJugadorPorNombre(new Jugador("Pepito Perez", 100, "desierto"));
		elRoad.agregarJugadorPorNombre(new Jugador("Juan", 150, "Cañon"));
		elRoad.agregarJugadorPorNombre(new Jugador("Camilo", 50, "Autopista"));
		elRoad.agregarJugadorPorNombre(new Jugador("Alguien", 125, "Desierto"));
		elRoad.agregarJugadorPorNombre(new Jugador("Valeria", 25, "Autopista"));
		
	}
	
	@Test
	public void darJugadoresOrdenadosPorNombreTest() {
		
		escenarioUno();
		ArrayList<Jugador> esperado = new ArrayList<Jugador>();
		esperado.add(elRoad.darJugador().darNodoIzquierdo().darNodoIzquierdo().darNodoIzquierdo());
		esperado.add(elRoad.darJugador().darNodoIzquierdo().darNodoIzquierdo());
		esperado.add(elRoad.darJugador().darNodoIzquierdo());
		esperado.add(elRoad.darJugador());
		esperado.add(elRoad.darJugador().darNodoDerecho());
		assertEquals(esperado, elRoad.darJugadoresOrdenadosPorNombre());
		
	}
	
	@Test
	public void ordenarJugadoresPorNombreTest() {
		
		escenarioUno();
		ArrayList<Jugador> esperado = new ArrayList<Jugador>();
		esperado.add(elRoad.darJugador().darNodoIzquierdo().darNodoIzquierdo().darNodoIzquierdo());
		esperado.add(elRoad.darJugador().darNodoIzquierdo().darNodoIzquierdo());
		esperado.add(elRoad.darJugador().darNodoIzquierdo());
		esperado.add(elRoad.darJugador());
		esperado.add(elRoad.darJugador().darNodoDerecho());
		assertEquals(esperado, elRoad.darJugadoresOrdenadosPorNombre());
		
	}
	
	@Test
	public void agregarJugadorPorNombreTest() {
		
		escenarioUno();
		Jugador esperado = new Jugador("Sergio", 200, "Cañon");
		elRoad.agregarJugadorPorNombre(esperado);
		assertEquals(esperado, elRoad.darJugador().darNodoDerecho().darNodoIzquierdo());
		
	}
	
	@Test
	public void eliminarJugadorPorNombreTest() {
		
		escenarioUno();
		Jugador esperado = elRoad.darJugador().darNodoDerecho();
		elRoad.eliminarJugadorPorNombre("Pepito Perez");
		assertEquals(esperado, elRoad.darJugador());
		
	}
	
	@Test
	public void buscarNombreTest() throws JugadorNoEncontradoException {
		
		escenarioUno();
		Jugador esperado = elRoad.darJugador().darNodoIzquierdo();
		assertEquals(esperado, elRoad.buscarNombre("Juan"));
		
	}

}
