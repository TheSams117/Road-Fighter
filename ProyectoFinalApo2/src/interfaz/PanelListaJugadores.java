package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Jugador;

public class PanelListaJugadores extends JPanel implements ListSelectionListener{

	
	
	private JList listaJugadores;
	private JScrollPane scroll;
	private VentanaCargarPartida ventanaCargarPartida;
	
	
	public PanelListaJugadores(VentanaCargarPartida ventana) {
		this.setPreferredSize(new Dimension(400,300));
		this.setLayout(new BorderLayout());
		ventanaCargarPartida=ventana;
		listaJugadores= new JList();
		scroll=new JScrollPane(listaJugadores);
		listaJugadores.addListSelectionListener(this);
		this.add(scroll,BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		listaJugadores.setBackground(Color.BLACK);
		listaJugadores.setForeground(Color.WHITE);
		listaJugadores.setBorder(null);
		scroll.setBorder(null);
	}
	
	

	public void refrescarLista() {
		listaJugadores.setListData(ventanaCargarPartida.darJugadoresOrdenadosPorNombre().toArray());
	}
	
	public Jugador darSeleccionado() {
		return (Jugador)listaJugadores.getSelectedValue();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}



	public void cambiarSeleccion(Jugador pJugador) {
		listaJugadores.setSelectedValue(pJugador, true);
		
	}
	
	
	
	
	
	
	
	
}
