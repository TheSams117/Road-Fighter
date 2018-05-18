package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesPuntajes extends JPanel implements ActionListener{
	
	public static final String BUT_BUSCAR_JUGADOR_POR_PUNTAJE= "buscar";
	public static final String BUT_BUSCAR_JUGADOR_MAYOR_PUNTAJE= "jugador mayor puntaje";
	public static final String BUT_BUSCAR_JUGADOR_MENOR_PUNTAJE= "jugador menor puntaje";
	public static final String BUT_VOLVER= "volver";
	
	private VentanaPuntajes ventanaPuntajes;
	
	private JButton butBuscar;
	private JButton butBuscarMayorPuntaje;
	private JButton butBuscarMenorPuntaje;
	private JButton butVolver;
	
	public PanelBotonesPuntajes(VentanaPuntajes v) {
		ventanaPuntajes=v;
		this.setPreferredSize(new Dimension(400,250));
		this.setLayout(new GridLayout(4,1));
		this.setBackground(Color.BLACK);
		
		
		butBuscar=new JButton();
		butBuscar.addActionListener(this);
		butBuscar.setActionCommand(BUT_BUSCAR_JUGADOR_POR_PUNTAJE);
		butBuscar.addActionListener(this);
		butBuscar.setOpaque(false);
		butBuscar.setContentAreaFilled(false); 
		butBuscar.setFocusable(false);
		butBuscar.setBorderPainted(false);
		butBuscar.setIcon(new ImageIcon("./botones/puntajes/buscar.png"));
		butBuscar.setRolloverIcon(new ImageIcon("./botones/puntajes/buscar_ampliada.gif"));
		
		
		butBuscarMayorPuntaje=new JButton();
		butBuscarMayorPuntaje.addActionListener(this);
		butBuscarMayorPuntaje.setActionCommand(BUT_BUSCAR_JUGADOR_MAYOR_PUNTAJE);
		butBuscarMayorPuntaje.addActionListener(this);
		butBuscarMayorPuntaje.setOpaque(false);
		butBuscarMayorPuntaje.setContentAreaFilled(false); 
		butBuscarMayorPuntaje.setFocusable(false);
		butBuscarMayorPuntaje.setBorderPainted(false);
		butBuscarMayorPuntaje.setIcon(new ImageIcon("./botones/puntajes/mayor_puntaje.png"));
		butBuscarMayorPuntaje.setRolloverIcon(new ImageIcon("./botones/puntajes/mayor_puntaje_ampliada.gif"));
		
		
		butBuscarMenorPuntaje=new JButton();
		butBuscarMenorPuntaje.addActionListener(this);
		butBuscarMenorPuntaje.setActionCommand(BUT_BUSCAR_JUGADOR_MENOR_PUNTAJE);
		butBuscarMenorPuntaje.addActionListener(this);
		butBuscarMenorPuntaje.setOpaque(false);
		butBuscarMenorPuntaje.setContentAreaFilled(false); 
		butBuscarMenorPuntaje.setFocusable(false);
		butBuscarMenorPuntaje.setBorderPainted(false);
		butBuscarMenorPuntaje.setIcon(new ImageIcon("./botones/puntajes/menor_puntaje.png"));
		butBuscarMenorPuntaje.setRolloverIcon(new ImageIcon("./botones/puntajes/menor_puntaje_ampliada.gif"));
		
		
		butVolver=new JButton();
		butVolver.addActionListener(this);
		butVolver.setActionCommand(BUT_VOLVER);
		butVolver.addActionListener(this);
		butVolver.setOpaque(false);
		butVolver.setContentAreaFilled(false); 
		butVolver.setFocusable(false);
		butVolver.setBorderPainted(false);
		butVolver.setIcon(new ImageIcon("./botones/puntajes/volver.png"));
		butVolver.setRolloverIcon(new ImageIcon("./botones/puntajes/volver_ampliada.gif"));
		
		this.add(butBuscar);
		this.add(butBuscarMayorPuntaje);
		this.add(butBuscarMenorPuntaje);
		this.add(butVolver);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	String comando= evento.getActionCommand();
	
	if(comando.equals(BUT_BUSCAR_JUGADOR_POR_PUNTAJE)) {
		
	}
	else if(comando.equals(this.BUT_BUSCAR_JUGADOR_MAYOR_PUNTAJE)) {
		
	}
	else if(comando.equals(this.BUT_BUSCAR_JUGADOR_MENOR_PUNTAJE)) {
		
	}
	else if(comando.equals(BUT_VOLVER)) {
		ventanaPuntajes.volver();
	}
	
		
	}
	
	
}
