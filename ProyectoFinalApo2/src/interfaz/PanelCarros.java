package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import modelo.AutomovilJugador;

public class PanelCarros extends JPanel implements ActionListener{

	public final static String CARRO_1="carro1";
	public final static String CARRO_2="carro2";
	public final static String CARRO_3="carro3";
	
	
	private VentanaSeleccion ventanaSeleccion;
	
	private String seleccion;
	
	private JLabel carro1;
	private JLabel carro2;
	private JLabel carro3;
	
	private JRadioButton but_carro1;
	private JRadioButton but_carro2;
	private JRadioButton but_carro3;
	
	
	
	public PanelCarros(VentanaSeleccion v) {
		ventanaSeleccion=v;
		seleccion="";
		this.setPreferredSize(new Dimension(750,225));
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		
		carro1= new JLabel();
		ImageIcon img1= new ImageIcon("./imagenes/carro_1.png");
		Image img1_dimensionada= img1.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH);
		img1.setImage(img1_dimensionada);
		carro1.setIcon(img1);
	
		carro2= new JLabel();
		ImageIcon img2= new ImageIcon("./imagenes/carro_2.png");
		Image img2_dimensionada= img2.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH);
		img2.setImage(img2_dimensionada);
		carro2.setIcon(img2);
		
		carro3= new JLabel();
		ImageIcon img3= new ImageIcon("./imagenes/carro_3.png");
		Image img3_dimensionada= img3.getImage().getScaledInstance(130, 150, Image.SCALE_SMOOTH);
		img3.setImage(img3_dimensionada);
		carro3.setIcon(img3);
		
		
		but_carro1= new JRadioButton();
		but_carro1.setActionCommand(CARRO_1);
		but_carro1.addActionListener(this);
		but_carro1.setBackground(Color.BLACK);
		but_carro1.setForeground(Color.WHITE);
		but_carro1.setText("Rojo");
		but_carro1.setHorizontalAlignment(SwingConstants.CENTER);
		

		but_carro2= new JRadioButton();
		but_carro2.setBackground(Color.BLACK);
		but_carro2.setForeground(Color.WHITE);
		but_carro2.setText("Azul");
		but_carro2.setActionCommand(CARRO_2);
		but_carro2.addActionListener(this);
		but_carro2.setHorizontalAlignment(SwingConstants.CENTER);
	
		but_carro3= new JRadioButton();
		but_carro3.setForeground(Color.WHITE);
		but_carro3.setBackground(Color.BLACK);
		but_carro3.setText("Amarillo");
		but_carro3.setActionCommand(CARRO_3);
		but_carro3.addActionListener(this);
		but_carro3.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panelAux1= new JPanel();
		panelAux1.setPreferredSize(new Dimension(750,200));
		panelAux1.setLayout(new GridLayout(1,5));
		panelAux1.setBackground(Color.BLACK);
		panelAux1.add(new JLabel());
		panelAux1.add(carro1);
		panelAux1.add(carro2);
		panelAux1.add(carro3);
		panelAux1.add(new JLabel());
		
		
		JPanel panelAux2= new JPanel();
		panelAux2.setLayout(new GridLayout(1,5));
		panelAux2.setBackground(Color.BLACK);
		panelAux2.add(new JLabel());
		panelAux2.add(but_carro1);
		panelAux2.add(but_carro2);
		panelAux2.add(but_carro3);
		panelAux2.add(new JLabel());
		
		this.add(panelAux1,BorderLayout.NORTH);
		this.add(panelAux2,BorderLayout.SOUTH);
	
		
		
		
		
	}



	public String darSeleccion() {
		return seleccion;
	}



	@Override
	public void actionPerformed(ActionEvent evento) {
	String comando = evento.getActionCommand();
	if(comando.equals(CARRO_1)) {
		if(but_carro1.isSelected()) {
			but_carro2.setSelected(false);
			but_carro3.setSelected(false);
			seleccion=AutomovilJugador.AUTOMOVIL_1;
		}
		else {
			seleccion="";
		}
	}
	else if(comando.equals(CARRO_2)) {
		if(but_carro2.isSelected()) {
			but_carro1.setSelected(false);
			but_carro3.setSelected(false);
			seleccion=AutomovilJugador.AUTOMOVIL_2;
		}
		else {
			seleccion="";
		}
	}
	else if(comando.equals(CARRO_3)) {
		if(but_carro3.isSelected()) {
			but_carro1.setSelected(false);
			but_carro2.setSelected(false);
			seleccion=AutomovilJugador.AUTOMOVIL_3;
		}
		else {
			seleccion="";
		}
	}
	
		
	}
	
	
	
	
}
