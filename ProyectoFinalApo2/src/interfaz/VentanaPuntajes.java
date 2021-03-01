package interfaz;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import modelo.Jugador;
import modelo.PuntajeNoRegistradoException;

public class VentanaPuntajes extends JFrame{

	private PanelListaPuntajes listaPuntajes;
	private PanelBotonesPuntajes botonesPuntajes;
	
	private VentanaPrincipal principal;
	
	public VentanaPuntajes(VentanaPrincipal v) {
		principal=v;
		this.setSize(400,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Puntajes");
		listaPuntajes= new PanelListaPuntajes(this);
		botonesPuntajes=new PanelBotonesPuntajes(this);
		this.add(botonesPuntajes,BorderLayout.SOUTH);
		this.add(listaPuntajes, BorderLayout.NORTH);
		JPanel panelAux= new JPanel();
		panelAux.setBackground(Color.BLACK);
		this.add(panelAux,BorderLayout.CENTER);
		
		
		
	}

	public void volver() {
		this.setVisible(false);
		this.dispose();
		principal.setVisible(true);
		
	}

	public ArrayList<Jugador> darJugadoresOrdenadosPorPuntaje() {
		return principal.darJugadoresOrdenadosPorPuntaje();
	}
	
	public void refrescarLista() {
		listaPuntajes.refrescarLista();
	}

	public Jugador buscarJugadorPuntaje(int puntaje) throws PuntajeNoRegistradoException  {
		return principal.buscarJugadorPuntaje(puntaje);
	}

	public void cambiarSeleccionEnLista(Jugador buscarJugadorPuntaje) {
		listaPuntajes.cambiarSeleccion(buscarJugadorPuntaje);
		
	}

	public Jugador darJugadorConPuntajeMayor() {
		return principal.darJugadorConPuntajeMayor();
	}

	public Jugador darJugadorConPuntajeMenor() {
		return principal.darJugadorConPuntajeMenor();
	}
	
	
	
	
	
}

