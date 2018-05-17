package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelListaJugadores extends JPanel{

	
	
	private JList listaJugadores;
	private DefaultListModel modeloLista;
	private JScrollPane scroll;
	
	
	public PanelListaJugadores() {
		this.setPreferredSize(new Dimension(400,300));
		this.setLayout(new BorderLayout());		
		modeloLista=new DefaultListModel();
		listaJugadores= new JList(modeloLista);
		scroll=new JScrollPane(listaJugadores);
		this.add(scroll,BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		listaJugadores.setBackground(Color.BLACK);
		listaJugadores.setForeground(Color.WHITE);
		listaJugadores.setBorder(null);
	}
	
	public void borrarLista() {
		modeloLista.removeAllElements();
	}
	
	
	public void agregarElemento(String elemento) {
		modeloLista.addElement(elemento);
	}
	
	
	public void refrescarLista(String[] elementos) {
		for (int i = 0; i < elementos.length; i++) {
			agregarElemento(elementos[i]);
		}
	}
	
	
	public Object darSeleccionado() {
		return listaJugadores.getSelectedValue();
	}
	
	
	
	
	
	
	
	
}
