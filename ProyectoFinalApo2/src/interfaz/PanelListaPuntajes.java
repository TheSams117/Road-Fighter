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

public class PanelListaPuntajes extends JPanel implements ListSelectionListener {

	
	
	private JList listaPuntajes;
	private JScrollPane scroll;
	private VentanaPuntajes ventanaPuntajes;
	
	public PanelListaPuntajes(VentanaPuntajes ventana) {
		ventanaPuntajes= ventana;
		this.setPreferredSize(new Dimension(400,300));
		this.setLayout(new BorderLayout());		
		listaPuntajes= new JList();
		scroll=new JScrollPane(listaPuntajes);
		this.add(scroll,BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		listaPuntajes.addListSelectionListener(this);
		listaPuntajes.setBackground(Color.BLACK);
		listaPuntajes.setForeground(Color.WHITE);
		listaPuntajes.setBorder(null);
		scroll.setBorder(null);
	}
	
	
	
	public void refrescarLista() {
		listaPuntajes.setListData(ventanaPuntajes.darJugadoresOrdenadosPorPuntaje().toArray());
	}
	
	
	public Jugador darSeleccionado() {
		return (Jugador) listaPuntajes.getSelectedValue();
	}

	public void cambiarSeleccion(Jugador pJugador) {
		 listaPuntajes.setSelectedValue(pJugador, true);
	}


	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
