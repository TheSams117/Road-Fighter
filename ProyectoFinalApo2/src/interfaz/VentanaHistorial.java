package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VentanaHistorial extends JFrame {

	private PanelListaHistorial listaHistorial;
	private PanelBotonesHistorial botonesHistorial;
	
	private VentanaPrincipal principal;
	
	public VentanaHistorial(VentanaPrincipal v) {
		principal=v;
		this.setSize(450,600);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.setTitle("Historial");
		listaHistorial= new PanelListaHistorial();
		botonesHistorial=new PanelBotonesHistorial(this);
		this.add(botonesHistorial,BorderLayout.SOUTH);
		this.add(listaHistorial, BorderLayout.NORTH);
		JPanel panelAux= new JPanel();
		panelAux.setBackground(Color.BLACK);
		this.add(panelAux,BorderLayout.CENTER);
		
		
		
	}

	public void volver() {
		this.setVisible(false);
		principal.setVisible(true);
		
	}
	
	public PanelListaHistorial darListaHistorial() {
		return listaHistorial;
		
	}
	
	
	
	
}
