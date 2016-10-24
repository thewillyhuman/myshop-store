package com.myshop.store.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.ComponentOrientation;
import javax.swing.JComboBox;
import java.awt.Dimension;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipalTienda extends JFrame {

	private JPanel contentPane;
	private JPanel inicio;
	private JPanel direccion;
	private JLabel lblUrl;
	private JPanel contenido;
	private JPanel izquierda;
	private JPanel derecha;
	private JPanel categorias;
	private JPanel lista;
	private JComboBox<String> cBCat;
	private JComboBox<String> cbSubCat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipalTienda frame = new VentanaPrincipalTienda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipalTienda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 940, 565);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getInicio(), "name_307605263018239");
	}

	private JPanel getInicio() {
		if (inicio == null) {
			inicio = new JPanel();
			inicio.setLayout(new BorderLayout(0, 0));
			inicio.add(getDireccion(), BorderLayout.NORTH);
			inicio.add(getContenido(), BorderLayout.CENTER);
		}
		return inicio;
	}
	private JPanel getDireccion() {
		if (direccion == null) {
			direccion = new JPanel();
			direccion.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			direccion.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			direccion.add(getLblUrl());
		}
		return direccion;
	}
	private JLabel getLblUrl() {
		if (lblUrl == null) {
			lblUrl = new JLabel("http://www.myshop.es");
			lblUrl.setPreferredSize(new Dimension(920, 14));
			lblUrl.setBackground(Color.WHITE);
		}
		return lblUrl;
	}
	private JPanel getContenido() {
		if (contenido == null) {
			contenido = new JPanel();
			contenido.setBackground(new Color(65, 105, 225));
			contenido.setLayout(null);
			contenido.add(getIzquierda());
			contenido.add(getDerecha());
		}
		return contenido;
	}
	private JPanel getIzquierda() {
		if (izquierda == null) {
			izquierda = new JPanel();
			izquierda.setBounds(10, 11, 438, 476);
			izquierda.setLayout(new BorderLayout(0, 0));
			izquierda.add(getCategorias(), BorderLayout.NORTH);
			izquierda.add(getLista(), BorderLayout.CENTER);
		}
		return izquierda;
	}
	private JPanel getDerecha() {
		if (derecha == null) {
			derecha = new JPanel();
			derecha.setBounds(458, 11, 462, 476);
		}
		return derecha;
	}
	private JPanel getCategorias() {
		if (categorias == null) {
			categorias = new JPanel();
			categorias.setBackground(new Color(65, 105, 225));
			categorias.add(getCBCat());
			categorias.add(getCbSubCat());
		}
		return categorias;
	}
	private JPanel getLista() {
		if (lista == null) {
			lista = new JPanel();
			lista.setBackground(new Color(65, 105, 225));
		}
		return lista;
	}
	
	private JComboBox<String> getCBCat() {
		if (cBCat == null) {
			cBCat = new JComboBox<String>();
			cBCat.setModel(new DefaultComboBoxModel<String>(new String[] {"Todos", "Electr\u00F3nica", "Papeler\u00EDa"}));
			cBCat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 rellenaCombo2((String) cBCat.getSelectedItem());
				}
			});
			
		}
		return cBCat;
	}
	private JComboBox<String> getCbSubCat() {
		if (cbSubCat == null) {
			cbSubCat = new JComboBox<String>();
		}
		rellenaCombo2 ((String) cBCat.getSelectedItem());
		return cbSubCat;
	}
	
	private void rellenaCombo2(String seleccionEnCombo1) {
		   // Se borran los valores previos
		cbSubCat.removeAllItems();

		   // Se rellena según la opción en combo1
		   if (seleccionEnCombo1.equals("Todos")) {
			   cbSubCat.addItem("Todos");
			   cbSubCat.addItem("Fotografía");
			   cbSubCat.addItem("Telefonía");
			   cbSubCat.addItem("GPS");
			   cbSubCat.addItem("TV");
			   cbSubCat.addItem("Informática");
			   cbSubCat.addItem("Archivadores");
			   cbSubCat.addItem("Papel");
			   cbSubCat.addItem("Cuadernos");
		   } else if (seleccionEnCombo1.equals("Electr\u00F3nica")) {
			   cbSubCat.addItem("Todos");
			   cbSubCat.addItem("Fotografía");
			   cbSubCat.addItem("Telefonía");
			   cbSubCat.addItem("GPS");
			   cbSubCat.addItem("TV");
			   cbSubCat.addItem("Informática");
		}else if (seleccionEnCombo1.equals("Papeler\u00EDa")) {
				cbSubCat.addItem("Todos");
			   cbSubCat.addItem("Archivadores");
			   cbSubCat.addItem("Papel");
			   cbSubCat.addItem("Cuadernos");
		}
	}
}
