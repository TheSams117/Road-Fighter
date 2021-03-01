package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;

class testPrueba {

	private Jugador elJugador;

	public void escenarioUnoPuntaje() {
		
		elJugador = new Jugador("Pepito Perez", 100, "desierto");
		elJugador.setNodoDerecho(new Jugador("Juan", 150, "Cañon"));
		elJugador.setNodoIzquierdo(new Jugador("Camilo", 50, "Autopista"));
		elJugador.darNodoDerecho().setNodoIzquierdo(new Jugador("Alguien", 125, "Desierto"));
		elJugador.darNodoIzquierdo().setNodoIzquierdo(new Jugador("Valeria", 25, "Autopista"));
		
	}
	
	public void escenarioDosNombre() {
		
		elJugador = new Jugador("Pepito Perez", 100, "desierto");
		elJugador.setNodoIzquierdo(new Jugador("Juan", 150, "Cañon"));
		elJugador.darNodoIzquierdo().setNodoIzquierdo(new Jugador("Camilo", 50, "Autopista"));
		elJugador.darNodoIzquierdo().darNodoIzquierdo().setNodoIzquierdo(new Jugador("Alguien", 125, "Desierto"));
		elJugador.setNodoDerecho(new Jugador("Valeria", 25, "Autopista"));
		
	}
	
	@Test
	public void darJugadorConPuntajeMenorTest() {
		
		escenarioUnoPuntaje();
		Jugador menorPuntaje = elJugador.darNodoIzquierdo().darNodoIzquierdo();
		assertEquals(menorPuntaje, elJugador.darJugadorConPuntajeMenor());
		
	}
	
	@Test
	public void darJugadorConPuntajeMayorTest() {
		
		escenarioUnoPuntaje();
		Jugador mayorPuntaje = elJugador.darNodoDerecho();
		assertEquals(mayorPuntaje, elJugador.darJugadorConPuntajeMayor());
		
	}
	
	@Test
	public void insertarPorPuntajeTest() {
		
		escenarioUnoPuntaje();
		Jugador insertar = new Jugador("Peter" , 70, "Cañon");
		elJugador.insertarPorPuntaje(insertar);
		assertEquals(insertar, elJugador.darNodoIzquierdo().darNodoDerecho());
		
	}
	
	@Test
	public void insertarPorNombreTest() {
		
		escenarioDosNombre();
		Jugador insertar = new Jugador("Zain" , 70, "Cañon");
		elJugador.insertarPorNombre(insertar);
		assertEquals(insertar, elJugador.darNodoDerecho().darNodoDerecho());
		
	}

	@Test
	public void eliminarPorPuntajeTest() {
		
		escenarioUnoPuntaje();
		assertEquals(elJugador.darNodoDerecho().darNodoIzquierdo(), elJugador.eliminarPorPuntaje(100));
		
	}
	
	@Test
	public void elimininarPorNombreTest() {
		
		escenarioDosNombre();
		assertEquals(elJugador, elJugador.elimininarPorNombre("Camilo"));
		
	}
	
	@Test
	public void buscarJugadorPorPuntajeTest() {
		
		escenarioUnoPuntaje();
		assertEquals(elJugador.darNodoIzquierdo().darNodoIzquierdo(), elJugador.buscarJugadorPorPuntaje(25));
		
	}
	
	@Test
	public void buscarJugadorPorNombreTest() {
		
		escenarioDosNombre();
		assertEquals(elJugador.darNodoIzquierdo().darNodoIzquierdo().darNodoIzquierdo(), elJugador.buscarJugadorPorNombre("Alguien"));
		
	}
	
}

