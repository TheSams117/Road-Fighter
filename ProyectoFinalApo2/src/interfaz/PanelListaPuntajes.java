package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelListaPuntajes extends JPanel {

	
	
	private JList listaPuntajes;
	private DefaultListModel modeloLista;
	private JScrollPane scroll;
	
	
	public PanelListaPuntajes() {
		this.setPreferredSize(new Dimension(400,300));
		this.setLayout(new BorderLayout());		
		modeloLista=new DefaultListModel();
		listaPuntajes= new JList(modeloLista);
		scroll=new JScrollPane(listaPuntajes);
		this.add(scroll,BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		listaPuntajes.setBackground(Color.BLACK);
		listaPuntajes.setForeground(Color.WHITE);
		listaPuntajes.setBorder(null);
		for (int i = 0; i < 50; i++) {
			modeloLista.addElement("Sergio");
		}
		scroll.setBorder(null);
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
		return listaPuntajes.getSelectedValue();
	}
	
	
	
	
	
	
	
}
