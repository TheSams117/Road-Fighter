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

import modelo.JugadorNoEncontradoException;
import modelo.JugadorYaRegistradoException;

public class PanelBotonesCargarPartida extends JPanel implements ActionListener{

	public static final String BUT_BUSCAR= "buscar";
	public static final String BUT_CARGAR= "cargar";
	public static final String BUT_ELIMINAR= "eliminar";
	public static final String BUT_VOLVER= "volver";
	
	private VentanaCargarPartida ventanaCargarPartida;
	
	private JButton butBuscar;
	private JButton butCargar;
	private JButton butEliminar;
	private JButton butVolver;
	
	public PanelBotonesCargarPartida(VentanaCargarPartida v) {
		ventanaCargarPartida=v;
		
		this.setPreferredSize(new Dimension(400,250));
		this.setLayout(new GridLayout(4,1));
		this.setBackground(Color.BLACK);
	
		
		butBuscar=new JButton();
		butBuscar.addActionListener(this);
		butBuscar.setActionCommand(BUT_BUSCAR);
		butBuscar.addActionListener(this);
		butBuscar.setOpaque(false);
		butBuscar.setContentAreaFilled(false); 
		butBuscar.setFocusable(false);
		butBuscar.setBorderPainted(false);
		butBuscar.setIcon(new ImageIcon("./botones/cargarPartida/buscar.png"));
		butBuscar.setRolloverIcon(new ImageIcon("./botones/cargarPartida/buscar_ampliada.gif"));
		
		
		butCargar=new JButton();
		butCargar.addActionListener(this);
		butCargar.setActionCommand(BUT_CARGAR);
		butCargar.addActionListener(this);
		butCargar.setOpaque(false);
		butCargar.setContentAreaFilled(false); 
		butCargar.setFocusable(false);
		butCargar.setBorderPainted(false);
		butCargar.setIcon(new ImageIcon("./botones/cargarPartida/cargar.png"));
		butCargar.setRolloverIcon(new ImageIcon("./botones/cargarPartida/cargar_ampliada.gif"));
		
		
		butEliminar=new JButton();
		butEliminar.addActionListener(this);
		butEliminar.setActionCommand(BUT_ELIMINAR);
		butEliminar.addActionListener(this);
		butEliminar.setOpaque(false);
		butEliminar.setContentAreaFilled(false); 
		butEliminar.setFocusable(false);
		butEliminar.setBorderPainted(false);
		butEliminar.setIcon(new ImageIcon("./botones/cargarPartida/eliminar.png"));
		butEliminar.setRolloverIcon(new ImageIcon("./botones/cargarPartida/eliminar_ampliada.gif"));
		
		
		butVolver=new JButton();
		butVolver.addActionListener(this);
		butVolver.setActionCommand(BUT_VOLVER);
		butVolver.addActionListener(this);
		butVolver.setOpaque(false);
		butVolver.setContentAreaFilled(false); 
		butVolver.setFocusable(false);
		butVolver.setBorderPainted(false);
		butVolver.setIcon(new ImageIcon("./botones/cargarPartida/volver.png"));
		butVolver.setRolloverIcon(new ImageIcon("./botones/cargarPartida/volver_ampliada.gif"));
		
		this.add(butBuscar);
		this.add(butCargar);
		this.add(butEliminar);
		this.add(butVolver);
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
	String comando= evento.getActionCommand();
	
	if(comando.equals(BUT_BUSCAR)) {
		String jugador = " ";
		boolean nombreCorrecto = false;
		
			jugador=JOptionPane.showInputDialog(ventanaCargarPartida, "Ingrese el nombre del jugador a buscar", "Buscar Partida", JOptionPane.INFORMATION_MESSAGE);
			if(jugador == null || jugador.equals("") || jugador.charAt(0) == ' ') {
				
			}else {
				try {
					ventanaCargarPartida.cambiarSeleccionEnLista(ventanaCargarPartida.buscarJugador(jugador));
				} catch (JugadorNoEncontradoException e) {
					JOptionPane.showMessageDialog(ventanaCargarPartida, "Jugador no encontrado", "Busqueda", JOptionPane.WARNING_MESSAGE);
				}	
			
			}
	}
	else if(comando.equals(BUT_CARGAR)) {
		if(ventanaCargarPartida.darSeleccion()!=null) {
			try {
				ventanaCargarPartida.cargarPartida(ventanaCargarPartida.darSeleccion());
			} catch (JugadorNoEncontradoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ventanaCargarPartida.iniciarCarga();
		}
		
		
	} else if(comando.equals(BUT_ELIMINAR)) {
		
		if(ventanaCargarPartida.darSeleccion()!=null) {
			
				ventanaCargarPartida.eliminar(ventanaCargarPartida.darSeleccion());
				ventanaCargarPartida.refrescarLista();
				ventanaCargarPartida.guardar();
		}
		
	} else if(comando.equals(BUT_VOLVER)) {
		ventanaCargarPartida.volver();
	}
	
		
	}
	
	
	
	
	
	
	
	
}
