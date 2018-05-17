package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaCargarPartida extends JFrame{

	private PanelListaJugadores listaJugadores;
	private PanelBotonesCargarPartida botonesCargar;
	
	private VentanaPrincipal principal;
	
	public VentanaCargarPartida(VentanaPrincipal v) {
		principal=v;
		this.setSize(400,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Cargar Partida");
		listaJugadores= new PanelListaJugadores();
		botonesCargar=new PanelBotonesCargarPartida(this);
		this.add(botonesCargar,BorderLayout.SOUTH);
		this.add(listaJugadores, BorderLayout.NORTH);
		JPanel panelAux= new JPanel();
		panelAux.setBackground(Color.BLACK);
		this.add(panelAux,BorderLayout.CENTER);
		
		
		
	}

	public void volver() {
		this.setVisible(false);
		principal.setVisible(true);
		
	}
	
	
	
	
	
}
