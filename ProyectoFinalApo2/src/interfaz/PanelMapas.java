package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class PanelMapas extends JPanel implements ActionListener  {

	public final static String MAPA_1= "mapa1";
	public final static String MAPA_2= "mapa2";
	public final static String MAPA_3= "mapa3";
	public final static String MAPA_4= "mapa4";
	
	private String seleccion;

	private JLabel mapa1;
	private JLabel mapa2;
	private JLabel mapa3;
	private JLabel mapa4;
	
	private JRadioButton but_mapa1;
	private JRadioButton but_mapa2;
	private JRadioButton but_mapa3;
	private JRadioButton but_mapa4;
	
	
	
	
	private VentanaSeleccion ventanaSeleccion;
	
	public PanelMapas(VentanaSeleccion v) {
		
		this.setBackground(Color.BLACK);
		ventanaSeleccion=v;
		this.setPreferredSize(new Dimension(750,225));
		this.setLayout(new BorderLayout());
		
		but_mapa1=new JRadioButton("Campo");
		but_mapa1.setBackground(Color.BLACK);
		but_mapa1.setForeground(Color.WHITE);
		but_mapa1.setHorizontalAlignment(SwingConstants.CENTER);
		but_mapa1.addActionListener(this);
		but_mapa1.setActionCommand(this.MAPA_1);
		
		but_mapa2=new JRadioButton("Puente");
		but_mapa2.setBackground(Color.BLACK);
		but_mapa2.setForeground(Color.WHITE);
		but_mapa2.setHorizontalAlignment(SwingConstants.CENTER);
		but_mapa2.addActionListener(this);
		but_mapa2.setActionCommand(this.MAPA_2);
		
		but_mapa3=new JRadioButton("Playa");
		but_mapa3.setBackground(Color.BLACK);
		but_mapa3.setForeground(Color.WHITE);
		but_mapa3.setHorizontalAlignment(SwingConstants.CENTER);
		but_mapa3.addActionListener(this);
		but_mapa3.setActionCommand(this.MAPA_3);
		
		but_mapa4=new JRadioButton("Cañon");
		but_mapa4.setBackground(Color.BLACK);
		but_mapa4.setForeground(Color.WHITE);
		but_mapa4.setHorizontalAlignment(SwingConstants.CENTER);
		but_mapa4.addActionListener(this);
		but_mapa4.setActionCommand(this.MAPA_4);
		
		
		
		mapa1= new JLabel();
		mapa1.setIcon(new ImageIcon("./imagenes/mapa_1_miniatura.jpg"));
		
		mapa2= new JLabel();
		mapa2.setIcon(new ImageIcon("./imagenes/mapa_2_miniatura.jpg"));
		
		
		mapa3= new JLabel();
		mapa3.setIcon(new ImageIcon("./imagenes/mapa_3_miniatura.jpg"));

		
		
		mapa4= new JLabel();
		mapa4.setIcon(new ImageIcon("./imagenes/mapa_4_miniatura.jpg"));
		

		JPanel panelAux1= new JPanel();
		panelAux1.setPreferredSize(new Dimension(750,200));
		panelAux1.setLayout(new GridLayout(1,4));
		panelAux1.add(mapa1);
		panelAux1.add(mapa2);
		panelAux1.add(mapa3);
		panelAux1.add(mapa4);
		panelAux1.setBackground(Color.BLACK);
		
		JPanel panelAux2= new JPanel();
		panelAux2.setLayout(new GridLayout(1,4));
		panelAux2.add(but_mapa1);
		panelAux2.add(but_mapa2);
		panelAux2.add(but_mapa3);
		panelAux2.add(but_mapa4);
		panelAux2.setBackground(Color.BLACK);
		
		this.add(panelAux1, BorderLayout.NORTH);
		this.add(panelAux2, BorderLayout.SOUTH);
		

		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(MAPA_1)) {
			if(but_mapa1.isSelected()) {
				but_mapa2.setSelected(false);
				but_mapa3.setSelected(false);
				but_mapa4.setSelected(false);
				seleccion=MAPA_1;
			}
			else {
				seleccion="";
			}
			
		}
		else if(comando.equals(MAPA_2)) {
			if(but_mapa2.isSelected()) {
				but_mapa1.setSelected(false);
				but_mapa3.setSelected(false);
				but_mapa4.setSelected(false);
				seleccion=MAPA_2;
			}
			else {
				seleccion="";
			}
		}
		else if(comando.equals(MAPA_3)) {
			if(but_mapa3.isSelected()) {
				but_mapa1.setSelected(false);
				but_mapa2.setSelected(false);
				but_mapa4.setSelected(false);
				seleccion=MAPA_3;
			}
			else {
				seleccion="";
			}
		}
		else if(comando.equals(MAPA_4)) {
			if(but_mapa4.isSelected()) {
				but_mapa1.setSelected(false);
				but_mapa2.setSelected(false);
				but_mapa3.setSelected(false);
				seleccion=MAPA_1;
			}
			else {
				seleccion="";
			}
		}
		
	}
	
	
	

	
	
	
}
