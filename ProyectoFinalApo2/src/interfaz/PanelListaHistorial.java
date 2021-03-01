package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelListaHistorial extends JPanel {

	private JList listaHistorial;
	private JScrollPane scroll;
	
	
	public PanelListaHistorial() {
		this.setPreferredSize(new Dimension(450,300));
		this.setLayout(new BorderLayout());		
		listaHistorial= new JList();
		scroll=new JScrollPane(listaHistorial);
		this.add(scroll,BorderLayout.CENTER);
		this.setBackground(Color.BLACK);
		listaHistorial.setBackground(Color.BLACK);
		listaHistorial.setForeground(Color.WHITE);
		listaHistorial.setBorder(null);
	}
	
	
	
	public void refrescarLista(ArrayList<String> historial) {
		listaHistorial.setListData(historial.toArray());
	}
	
	
	public Object darSeleccionado() {
		return listaHistorial.getSelectedValue();
	}
	
	
	
	
	
	
	
}
