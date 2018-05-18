package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelBotonesAtras extends JPanel implements ActionListener{
	public static final String BUT_ATRAS= "atras";
	public static final String BUT_SIGUIENTE= "siguiente";
	
	
	private JButton butSiguiente;
	private JButton butAtras;
	
	
	private VentanaSeleccion ventanaSeleccion;
	
	public PanelBotonesAtras(VentanaSeleccion v) {
		this.setLayout(new GridLayout(1,2));
		this.setPreferredSize(new Dimension(750,50));
		this.setBackground(Color.BLACK);
		ventanaSeleccion=v;
		
		
		butSiguiente=new JButton();
		butSiguiente.setActionCommand(BUT_SIGUIENTE);
		butSiguiente.addActionListener(this);
		butSiguiente.setOpaque(false);
		butSiguiente.setContentAreaFilled(false); 
		butSiguiente.setFocusable(false);
		butSiguiente.setBorderPainted(false);
		butSiguiente.setIcon(new ImageIcon("./botones/nuevaPartida/siguiente.png"));
		butSiguiente.setRolloverIcon(new ImageIcon("./botones/nuevaPartida/siguiente_ampliada.gif"));
		
		butAtras=new JButton();
		butAtras.addActionListener(this);
		butAtras.setActionCommand(BUT_ATRAS);
		butAtras.setIcon(new ImageIcon("./botones/nuevaPartida/atras.png"));
		butAtras.setOpaque(false);
		butAtras.setContentAreaFilled(false); 
		butAtras.setFocusable(false);
		butAtras.setBorderPainted(false);
		butAtras.setIcon(new ImageIcon("./botones/nuevaPartida/atras.png"));
		butAtras.setRolloverIcon(new ImageIcon("./botones/nuevaPartida/atras_ampliada.gif"));
		
		this.add(butAtras);
		this.add(butSiguiente);
		
		
		
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(this.BUT_ATRAS)) {
			ventanaSeleccion.atras();
			
		}
		else if(comando.equals(this.BUT_SIGUIENTE)) {
			
		}
		
	}
	
	
	
	
	
	
	
}
