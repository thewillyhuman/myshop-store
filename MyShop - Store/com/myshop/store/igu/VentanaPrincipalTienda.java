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
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaPrincipalTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5667224737301596895L;
	private JPanel contentPane;
	private JPanel tienda;
	private JPanel direccionTienda;
	private JLabel lblUrlTienda;
	private JPanel contenidoTienda;
	private JPanel izquierda;
	private JPanel derecha;
	private JPanel categorias;
	private JPanel lista;
	private JLabel lblAtras;
	private JLabel lblCarrito;
	private JLabel lblTotal;
	private JTextField txtTotal;
	private JButton btnVaciar;
	private JButton btnContinuar;
	private JPanel inicio;
	private JPanel direccionInicio;
	private JLabel lblUrlInicio;
	private JPanel contenidoInicio;

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
		setBounds(100, 100, 1073, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(65, 105, 225), 2));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getInicio(), "name_556038923677876");
		contentPane.add(getTienda(), "name_307605263018239");
	}

	private JPanel getTienda() {
		if (tienda == null) {
			tienda = new JPanel();
			tienda.setLayout(new BorderLayout(0, 0));
			tienda.add(getDireccionTienda(), BorderLayout.NORTH);
			tienda.add(getContenidoTienda(), BorderLayout.CENTER);
		}
		return tienda;
	}
	private JPanel getDireccionTienda() {
		if (direccionTienda == null) {
			direccionTienda = new JPanel();
			direccionTienda.setBackground(Color.WHITE);
			direccionTienda.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			direccionTienda.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			direccionTienda.add(getLblAtras());
			direccionTienda.add(getLblUrlTienda());
		}
		return direccionTienda;
	}
	private JLabel getLblUrlTienda() {
		if (lblUrlTienda == null) {
			lblUrlTienda = new JLabel("http://www.myshop.es/tienda");
			lblUrlTienda.setPreferredSize(new Dimension(1011, 14));
			lblUrlTienda.setBackground(Color.WHITE);
		}
		return lblUrlTienda;
	}
	private JPanel getContenidoTienda() {
		if (contenidoTienda == null) {
			contenidoTienda = new JPanel();
			contenidoTienda.setBackground(new Color(65, 105, 225));
			contenidoTienda.setLayout(null);
			contenidoTienda.add(getIzquierda());
			contenidoTienda.add(getDerecha());
		}
		return contenidoTienda;
	}
	private JPanel getIzquierda() {
		if (izquierda == null) {
			izquierda = new JPanel();
			izquierda.setBounds(10, 11, 626, 539);
			izquierda.setLayout(new BorderLayout(0, 0));
			izquierda.add(getCategorias(), BorderLayout.NORTH);
			izquierda.add(getLista(), BorderLayout.CENTER);
		}
		return izquierda;
	}
	private JPanel getDerecha() {
		if (derecha == null) {
			derecha = new JPanel();
			derecha.setBackground(new Color(65, 105, 225));
			derecha.setBounds(646, 11, 407, 539);
			derecha.setLayout(null);
			derecha.add(getLblCarrito());
			derecha.add(getLblTotal());
			derecha.add(getTxtTotal());
			derecha.add(getBtnVaciar());
			derecha.add(getBtnContinuar());
		}
		return derecha;
	}
	private JPanel getCategorias() {
		if (categorias == null) {
			categorias = new JPanel();
			categorias.setBackground(new Color(65, 105, 225));
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
	
	private JLabel getLblAtras() {
		if (lblAtras == null) {
			lblAtras = new JLabel("");
			lblAtras.setIcon(new ImageIcon(VentanaPrincipalTienda.class.getResource("/com/myshop/store/igu/img/fecha.jpg")));
		}
		return lblAtras;
	}
	private JLabel getLblCarrito() {
		if (lblCarrito == null) {
			lblCarrito = new JLabel("Lista de la compra:");
			lblCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCarrito.setForeground(Color.WHITE);
			lblCarrito.setBounds(10, 11, 153, 14);
		}
		return lblCarrito;
	}
	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total:");
			lblTotal.setForeground(Color.WHITE);
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTotal.setBounds(183, 430, 51, 20);
		}
		return lblTotal;
	}
	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setEditable(false);
			txtTotal.setText("Total");
			txtTotal.setBounds(244, 430, 86, 20);
			txtTotal.setColumns(10);
		}
		return txtTotal;
	}
	private JButton getBtnVaciar() {
		if (btnVaciar == null) {
			btnVaciar = new JButton("Vaciar carrito");
			btnVaciar.setBounds(83, 493, 121, 35);
		}
		return btnVaciar;
	}
	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.setBounds(238, 493, 121, 35);
		}
		return btnContinuar;
	}
	private JPanel getInicio() {
		if (inicio == null) {
			inicio = new JPanel();
			inicio.setLayout(new BorderLayout(0, 0));
			inicio.add(getDireccionInicio(), BorderLayout.NORTH);
			inicio.add(getContenidoInicio(), BorderLayout.CENTER);
		}
		return inicio;
	}
	private JPanel getDireccionInicio() {
		if (direccionInicio == null) {
			direccionInicio = new JPanel();
			direccionInicio.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			direccionInicio.setBackground(Color.WHITE);
			direccionInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			direccionInicio.add(getLblUrlInicio());
		}
		return direccionInicio;
	}
	private JLabel getLblUrlInicio() {
		if (lblUrlInicio == null) {
			lblUrlInicio = new JLabel("http://www.myshop.es");
			lblUrlInicio.setPreferredSize(new Dimension(1011, 14));
			lblUrlInicio.setBackground(Color.WHITE);
		}
		return lblUrlInicio;
	}
	private JPanel getContenidoInicio() {
		if (contenidoInicio == null) {
			contenidoInicio = new JPanel();
			contenidoInicio.setLayout(null);
			contenidoInicio.setBackground(new Color(65, 105, 225));
		}
		return contenidoInicio;
	}
}
