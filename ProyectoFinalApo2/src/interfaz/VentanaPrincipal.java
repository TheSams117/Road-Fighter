package interfaz;



import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class VentanaPrincipal extends JFrame {
	
	
	private PanelBotones panelBotones;
	
	
	

	public VentanaPrincipal() {
		this.setSize(500,500);
		this.setTitle("Proyecto apo Carritos");
		this.setLayout(new BorderLayout());
		this.setResizable(false);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		panelBotones= new PanelBotones(this);
		
		this.add(panelBotones,BorderLayout.CENTER);
		
		
		
		
		
		
	}
	

	
	
	
	
	
	
	
	
	public static void main(String[] args) {
	 VentanaPrincipal vp= new VentanaPrincipal();
	 vp.setVisible(true);

	}










	public void nuevaPartida() {
		VentanaSeleccion ventana= new VentanaSeleccion(this);
		ventana.setVisible(true);
		this.setVisible(false);
		
	}

}
