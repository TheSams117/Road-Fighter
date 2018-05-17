package interfaz;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class PanelBotones extends JPanel implements ActionListener{

	public static final String BOTON_NUEVA_PARTIDA= "nueva partida";
	public static final String BOTON_CARGAR_PARTIDA= "cargar partida";
	public static final String BOTON_HISTORIAL= "historial";
	public static final String BOTON_PUNTAJES= "puntajes";
	public static final ImageIcon IMAGEN_LOGO= new ImageIcon("./imagenes/logo.jpg");
	
	private JButton butNuevaPartida;
	private JButton butCargarPartida;
	private JButton butHistorial;	
	private JButton butPuntajes;
	
	private VentanaPrincipal principal;
	
	public PanelBotones(VentanaPrincipal v) {
		principal=v;
		this.setLayout(new GridLayout(6,1));
		
		

		
		butNuevaPartida= new JButton();
		butNuevaPartida.setActionCommand(BOTON_NUEVA_PARTIDA);
		butNuevaPartida.addActionListener(this);
		butNuevaPartida.setOpaque(false);
		butNuevaPartida.setContentAreaFilled(false); 
		butNuevaPartida.setFocusable(false);
		butNuevaPartida.setBorderPainted(false);
		butNuevaPartida.setIcon(new ImageIcon("./botones/nueva_partida.png"));
		butNuevaPartida.setRolloverIcon(new ImageIcon("./botones/nueva_partida_ampliada.gif"));
		

		
	
		butCargarPartida= new JButton();
		butCargarPartida.setActionCommand(BOTON_CARGAR_PARTIDA);
		butCargarPartida.addActionListener(this);
		butCargarPartida.setOpaque(false);
		butCargarPartida.setContentAreaFilled(false);
		butCargarPartida.setFocusable(false);
		butCargarPartida.setBorderPainted(false);
		butCargarPartida.setIcon(new ImageIcon("./botones/cargar.png"));
		butCargarPartida.setRolloverIcon(new ImageIcon("./botones/cargar_ampliada.gif"));

	
		butHistorial= new JButton();
		butHistorial.setActionCommand(BOTON_HISTORIAL);
		butHistorial.addActionListener(this);
		butHistorial.setOpaque(false);
		butHistorial.setContentAreaFilled(false);
		butHistorial.setFocusable(false);
		butHistorial.setBorderPainted(false);
		butHistorial.setIcon(new ImageIcon("./botones/historial.png"));
		butHistorial.setRolloverIcon(new ImageIcon("./botones/historial_ampliada.gif"));

		
		


		butPuntajes= new JButton();
		butPuntajes.addActionListener(this);
		butPuntajes.setActionCommand(BOTON_PUNTAJES);
		butPuntajes.setOpaque(false);
		butPuntajes.setContentAreaFilled(false);
		butPuntajes.setFocusable(false);
		butPuntajes.setBorderPainted(false);
		butPuntajes.setIcon(new ImageIcon("./botones/puntajes.png"));
		butPuntajes.setRolloverIcon(new ImageIcon("./botones/puntajes_ampliada.gif"));


		this.add(new JLabel(""));
		this.add(new JLabel(""));

		this.add(butNuevaPartida);

		this.add(butCargarPartida);

		this.add(butHistorial);

		this.add(butPuntajes);

	

	}
	
	
	
	public void paintComponent(Graphics g) {
		g.drawImage(this.IMAGEN_LOGO.getImage(),0,0, this);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(BOTON_NUEVA_PARTIDA)) {
			principal.nuevaPartida();
		}
		else if(comando.equals(BOTON_CARGAR_PARTIDA)) {
			
		}
		else if(comando.equals(BOTON_HISTORIAL)) {
			
		}
		else if(comando.equals(BOTON_PUNTAJES)) {
			
		}
		
	}



	
	
	
	
	
	
	
	
	
	
	
}
