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
import javax.swing.table.DefaultTableModel;

import com.myshop.model.product.Product;
import com.myshop.store.controller.ProductsController;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

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
	private JPanel superior;
	private JPanel inferior;
	private JButton btnElectronica;
	private JButton btnPapeleria;
	private JPanel elec;
	private JPanel pap;
	private JButton btnFotografa;
	private JButton btnGps;
	private JButton btnTelefona;
	private JButton btnTv;
	private JButton btnInformtica;
	private JButton btnArchivadores;
	private JButton btnPapel;
	private JButton btnCuadernos;
	private JTable tableProductos;
	private ModeloNoEditable modeloTabla;
	private ProductsController pc;

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
		contentPane.add(getTienda(), "name_307605263018239");
		contentPane.add(getInicio(), "name_556038923677876");
	}

	private JPanel getTienda() {
		if (tienda == null) {
			tienda = new JPanel();
			tienda.setFocusTraversalKeysEnabled(false);
			tienda.setFocusable(false);
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
			categorias.setLayout(new GridLayout(2, 0, 0, 0));
			categorias.add(getSuperior());
			categorias.add(getInferior());
		}
		return categorias;
	}
	private JPanel getLista() {
		if (lista == null) {
			lista = new JPanel();
			lista.setBackground(new Color(65, 105, 225));
			lista.setLayout(new BorderLayout(0, 0));
			lista.add(getTableProductos(), BorderLayout.CENTER);
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
	private JPanel getSuperior() {
		if (superior == null) {
			superior = new JPanel();
			superior.setBackground(new Color(65, 105, 225));
			superior.add(getBtnElectronica());
			superior.add(getBtnPapeleria());
		}
		return superior;
	}
	private JPanel getInferior() {
		if (inferior == null) {
			inferior = new JPanel();
			inferior.setVisible(false);
			inferior.setBackground(new Color(65, 105, 225));
			inferior.setLayout(new CardLayout(0, 0));
			inferior.add(getElec(), "panelElec");
			inferior.add(getPap(), "panelPap");
		}
		return inferior;
	}
	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("Electrónica");
			btnElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inferior.setVisible(true);
					((CardLayout)inferior.getLayout()).show(inferior,"panelElec");
				}
			});
			btnElectronica.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnElectronica.setContentAreaFilled(false);
			btnElectronica.setForeground(new Color(255, 255, 255));
			btnElectronica.setBackground(new Color(65, 105, 225));
			btnElectronica.setBorder(null);
		}
		return btnElectronica;
	}
	private JButton getBtnPapeleria() {
		if (btnPapeleria == null) {
			btnPapeleria = new JButton("Papelería");
			btnPapeleria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inferior.setVisible(true);
					((CardLayout)inferior.getLayout()).show(inferior,"panelPap");
				}
			});
			btnPapeleria.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnPapeleria.setForeground(new Color(255, 255, 255));
			btnPapeleria.setContentAreaFilled(false);
			btnPapeleria.setBackground(new Color(65, 105, 225));
			btnPapeleria.setBorder(null);
		}
		return btnPapeleria;
	}
	private JPanel getElec() {
		if (elec == null) {
			elec = new JPanel();
			elec.setBackground(new Color(65, 105, 225));
			elec.add(getBtnFotografa());
			elec.add(getBtnGps());
			elec.add(getBtnTelefona());
			elec.add(getBtnTv());
			elec.add(getBtnInformtica());
		}
		return elec;
	}
	private JPanel getPap() {
		if (pap == null) {
			pap = new JPanel();
			pap.setBackground(new Color(65, 105, 225));
			pap.add(getBtnArchivadores());
			pap.add(getBtnPapel());
			pap.add(getBtnCuadernos());
		}
		return pap;
	}
	private JButton getBtnFotografa() {
		if (btnFotografa == null) {
			btnFotografa = new JButton("Fotografía");
			btnFotografa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					limpiarProductos();
					cargarProductos(1,1);
				}
			});
			btnFotografa.setContentAreaFilled(false);
			btnFotografa.setBackground(new Color(65, 105, 225));
			btnFotografa.setBorder(null);
			btnFotografa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnFotografa.setForeground(new Color(255, 255, 255));
		}
		return btnFotografa;
	}
	private JButton getBtnGps() {
		if (btnGps == null) {
			btnGps = new JButton("GPS");
			btnGps.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1,3);
				}
			});
			btnGps.setContentAreaFilled(false);
			btnGps.setBackground(new Color(65, 105, 225));
			btnGps.setBorder(null);
			btnGps.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnGps.setForeground(new Color(255, 255, 255));
		}
		return btnGps;
	}
	private JButton getBtnTelefona() {
		if (btnTelefona == null) {
			btnTelefona = new JButton("Telefonía");
			btnTelefona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1,2);
				}
			});
			btnTelefona.setContentAreaFilled(false);
			btnTelefona.setBackground(new Color(65, 105, 225));
			btnTelefona.setBorder(null);
			btnTelefona.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnTelefona.setForeground(new Color(255, 255, 255));
		}
		return btnTelefona;
	}
	private JButton getBtnTv() {
		if (btnTv == null) {
			btnTv = new JButton("TV");
			btnTv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1,4);
				}
			});
			btnTv.setContentAreaFilled(false);
			btnTv.setBackground(new Color(65, 105, 225));
			btnTv.setBorder(null);
			btnTv.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnTv.setForeground(new Color(255, 255, 255));
		}
		return btnTv;
	}
	private JButton getBtnInformtica() {
		if (btnInformtica == null) {
			btnInformtica = new JButton("Informática");
			btnInformtica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1,5);
				}
			});
			btnInformtica.setContentAreaFilled(false);
			btnInformtica.setBackground(new Color(65, 105, 225));
			btnInformtica.setBorder(null);
			btnInformtica.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnInformtica.setForeground(new Color(255, 255, 255));
		}
		return btnInformtica;
	}
	private JButton getBtnArchivadores() {
		if (btnArchivadores == null) {
			btnArchivadores = new JButton("Archivadores");
			btnArchivadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2,6);
				}
			});
			btnArchivadores.setBackground(new Color(65, 105, 225));
			btnArchivadores.setForeground(new Color(255, 255, 255));
			btnArchivadores.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnArchivadores.setBorder(null);
			btnArchivadores.setContentAreaFilled(false);
		}
		return btnArchivadores;
	}
	private JButton getBtnPapel() {
		if (btnPapel == null) {
			btnPapel = new JButton("Papel");
			btnPapel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2,7);
				}
			});
			btnPapel.setBackground(new Color(65, 105, 225));
			btnPapel.setForeground(new Color(255, 255, 255));
			btnPapel.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnPapel.setBorder(null);
			btnPapel.setContentAreaFilled(false);
		}
		return btnPapel;
	}
	private JButton getBtnCuadernos() {
		if (btnCuadernos == null) {
			btnCuadernos = new JButton("Cuadernos");
			btnCuadernos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2,8);
				}
			});
			btnCuadernos.setBackground(new Color(65, 105, 225));
			btnCuadernos.setForeground(new Color(255, 255, 255));
			btnCuadernos.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnCuadernos.setBorder(null);
			btnCuadernos.setContentAreaFilled(false);
		}
		return btnCuadernos;
	}
	private JTable getTableProductos() {
		if (tableProductos == null) {
			String[]nombreColumnas = {"Nombre", "Descripcion", "Precio", "Stock"};
			modeloTabla=new ModeloNoEditable(nombreColumnas,0);
			tableProductos=new JTable(modeloTabla);
			tableProductos.setForeground(new Color(255, 255, 255));
			tableProductos.setBackground(new Color(65, 105, 225));
			
		}
		return tableProductos;
	}
	private void cargarProductos(int categoria, int subcategoria){
		List<Product> aux =  new ProductsController().getAll(categoria,subcategoria);
		for (Product p:aux){
			modeloTabla.addRow(new Object[]{ p.getName(), p.getDescription(), p.getPrice(), p.getStock()});
		}
	}
	private void limpiarProductos(){
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}
}
