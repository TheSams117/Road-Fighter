package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesHistorial extends JPanel implements ActionListener{

	public static final String BUT_ORDENAR_POR_HORA= "ordenar por hora";
	public static final String BUT_ORDENAR_POR_FECHA= "ordenar por fecha";
	public static final String BUT_BUSCAR_FECHA= "buscar fecha";
	public static final String BUT_VOLVER= "volver";
	
	private VentanaHistorial ventanaHistorial;
	
	private JButton butOrdenarHora;
	private JButton butOrdenarFecha;
	private JButton butBuscarFecha;
	private JButton butVolver;
	
	public PanelBotonesHistorial(VentanaHistorial v) {
		ventanaHistorial=v;
		this.setPreferredSize(new Dimension(450,250));
		this.setLayout(new GridLayout(4,1));
		this.setBackground(Color.BLACK);
		
		
		butOrdenarHora=new JButton();
		butOrdenarHora.addActionListener(this);
		butOrdenarHora.setActionCommand(BUT_ORDENAR_POR_HORA);
		butOrdenarHora.addActionListener(this);
		butOrdenarHora.setOpaque(false);
		butOrdenarHora.setContentAreaFilled(false); 
		butOrdenarHora.setFocusable(false);
		butOrdenarHora.setBorderPainted(false);
		butOrdenarHora.setIcon(new ImageIcon("./botones/historial/ordenar_por_hora.png"));
		butOrdenarHora.setRolloverIcon(new ImageIcon("./botones/historial/ordenar_por_hora_ampliada.gif"));
		
		
		butOrdenarFecha=new JButton();
		butOrdenarFecha.addActionListener(this);
		butOrdenarFecha.setActionCommand(BUT_ORDENAR_POR_FECHA);
		butOrdenarFecha.addActionListener(this);
		butOrdenarFecha.setOpaque(false);
		butOrdenarFecha.setContentAreaFilled(false); 
		butOrdenarFecha.setFocusable(false);
		butOrdenarFecha.setBorderPainted(false);
		butOrdenarFecha.setIcon(new ImageIcon("./botones/historial/ordenar_por_fecha.png"));
		butOrdenarFecha.setRolloverIcon(new ImageIcon("./botones/historial/ordenar_por_fecha_ampliada.gif"));
		
		
		butBuscarFecha=new JButton();
		butBuscarFecha.addActionListener(this);
		butBuscarFecha.setActionCommand(BUT_BUSCAR_FECHA);
		butBuscarFecha.addActionListener(this);
		butBuscarFecha.setOpaque(false);
		butBuscarFecha.setContentAreaFilled(false); 
		butBuscarFecha.setFocusable(false);
		butBuscarFecha.setBorderPainted(false);
		butBuscarFecha.setIcon(new ImageIcon("./botones/historial/buscar_fecha.png"));
		butBuscarFecha.setRolloverIcon(new ImageIcon("./botones/historial/buscar_fecha_ampliada.gif"));
		
		
		butVolver=new JButton();
		butVolver.addActionListener(this);
		butVolver.setActionCommand(BUT_VOLVER);
		butVolver.addActionListener(this);
		butVolver.setOpaque(false);
		butVolver.setContentAreaFilled(false); 
		butVolver.setFocusable(false);
		butVolver.setBorderPainted(false);
		butVolver.setIcon(new ImageIcon("./botones/historial/volver.png"));
		butVolver.setRolloverIcon(new ImageIcon("./botones/historial/volver_ampliada.gif"));
		
		this.add(butOrdenarHora);
		this.add(butOrdenarFecha);
		this.add(butBuscarFecha);
		this.add(butVolver);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	String comando= evento.getActionCommand();
	
	if(comando.equals(this.BUT_ORDENAR_POR_HORA)) {
		
	}
	else if(comando.equals(this.BUT_ORDENAR_POR_FECHA)) {
		
	}
	else if(comando.equals(this.BUT_BUSCAR_FECHA)) {
		
	}
	else if(comando.equals(BUT_VOLVER)) {
		ventanaHistorial.volver();
	}
	
		
	}
	
	
	
}
