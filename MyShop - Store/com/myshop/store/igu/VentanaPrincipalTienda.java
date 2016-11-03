package com.myshop.store.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import com.myshop.model.product.Category;
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
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
	private JPanel derecha;
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
	private JScrollPane scrollPane;
	private JPanel panelProductos;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane_1;

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
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getTienda(), "name_307605263018239");
		contentPane.add(getInicio(), "name_556038923677876");
		List<Product> pro = new ProductsController().getAll();

		Action action = new AbstractAction() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void actionPerformed(ActionEvent e) {
				TableCellListener tcl = (TableCellListener) e.getSource();
				if (comprobarEntero(tcl.getNewValue().toString())) {
					int referencia = (int) table.getValueAt(tcl.getRow(), 0);
					int stock = 0;
					double precio = 0;
					for (Product p : pro) {
						if (p.getID() == referencia) {
							stock = p.getStock();
							precio = p.getPrice();
						}
					}
					int nuevoValor = Integer.parseInt((String) tcl.getNewValue());
					if (nuevoValor > stock) {
						JOptionPane.showMessageDialog(derecha, "No hay tantos art�culos en stock", "Error",
								JOptionPane.ERROR_MESSAGE);
						table.setValueAt(stock, tcl.getRow(), tcl.getColumn());
						table.setValueAt(redondear(precio * stock), tcl.getRow(), 4);
					} else if (nuevoValor < 0) {
						JOptionPane.showMessageDialog(derecha, "No se pueden poner valores negativos", "Error",
								JOptionPane.ERROR_MESSAGE);
						table.setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
						// table.setValueAt(redondear((precio*viejoValor))
						// ,tcl.getRow(),4);
					} else if (nuevoValor == 0) {
						modelo.removeRow(tcl.getRow());
						table.repaint();
						table.revalidate();
					} else {
						table.setValueAt(redondear((precio * nuevoValor)), tcl.getRow(), 4);
					}
					actualizarTotal();
				} else {
					table.setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
					JOptionPane.showMessageDialog(derecha, "El valor introducido debe ser un entero", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		};

		new TableCellListener(getTable(), action);
	}

	private JPanel getTienda() {
		if (tienda == null) {
			tienda = new JPanel();
			tienda.setBackground(new Color(255, 255, 255));
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
			direccionTienda.setBorder(new MatteBorder(1, 1, 2, 1, (Color) new Color(0, 0, 0)));
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
			contenidoTienda.setBackground(new Color(255, 255, 255));
			contenidoTienda.setLayout(null);
			contenidoTienda.add(getDerecha());
			contenidoTienda.add(getIzquierda());
			contenidoTienda.add(getPanelNavegacion());
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
			derecha.setBackground(new Color(255, 255, 255));
			derecha.setBounds(720, 11, 333, 539);
			derecha.setLayout(null);
			derecha.add(getLblCarrito());
			derecha.add(getLblTotal());
			derecha.add(getTxtTotal());
			derecha.add(getBtnVaciar());
			derecha.add(getBtnContinuar());
			derecha.add(getScrollPane_1());
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
			lista.add(getScrollPane(), BorderLayout.CENTER);
		}
		return lista;
	}

	private JLabel getLblAtras() {
		if (lblAtras == null) {
			lblAtras = new JLabel("");
			lblAtras.setIcon(
					new ImageIcon(VentanaPrincipalTienda.class.getResource("/com/myshop/store/igu/img/fecha.jpg")));
		}
		return lblAtras;
	}

	private JLabel getLblCarrito() {
		if (lblCarrito == null) {
			lblCarrito = new JLabel("Lista de la compra:");
			lblCarrito.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblCarrito.setForeground(new Color(0, 0, 0));
			lblCarrito.setBounds(10, 11, 153, 14);
		}
		return lblCarrito;
	}

	private JLabel getLblTotal() {
		if (lblTotal == null) {
			lblTotal = new JLabel("Total:");
			lblTotal.setForeground(new Color(0, 0, 0));
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblTotal.setBounds(158, 430, 51, 20);
		}
		return lblTotal;
	}

	private JTextField getTxtTotal() {
		if (txtTotal == null) {
			txtTotal = new JTextField();
			txtTotal.setText("0");
			txtTotal.setEditable(false);
			txtTotal.setBounds(244, 430, 86, 20);
			txtTotal.setColumns(10);
		}
		return txtTotal;
	}

	private JButton getBtnVaciar() {
		if (btnVaciar == null) {
			btnVaciar = new JButton("Vaciar carrito");
			btnVaciar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
					modeloTabla.setRowCount(0);
					getTable().removeAll();
					getTable().repaint();
					getTable().revalidate();
					txtTotal.setText("0");
				}
			});
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
			contenidoInicio.setBackground(new Color(255, 255, 255));
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
		return table;
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
		return scrollPane_1;
	}

	private JButton getBtnElectronica() {
		if (btnElectronica == null) {
			btnElectronica = new JButton("Electr�nica");
			btnElectronica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					inferior.setVisible(true);
					((CardLayout) inferior.getLayout()).show(inferior, "panelElec");
				}
			});
			btnElectronica.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnElectronica.setContentAreaFilled(false);
			btnElectronica.setForeground(new Color(255, 255, 255));
			btnElectronica.setBackground(new Color(65, 105, 225));
			btnElectronica.setBorder(null);
		}
		txtTotal.setText(Double.toString((redondear(total))));
	}

	private JButton getBtnPapeleria() {
		if (btnPapeleria == null) {
			btnPapeleria = new JButton("Papeler�a");
			btnPapeleria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					inferior.setVisible(true);
					((CardLayout) inferior.getLayout()).show(inferior, "panelPap");
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
	}

	private JPanel getPap() {
		if (pap == null) {
			pap = new JPanel();
			pap.setBackground(new Color(65, 105, 225));
			pap.add(getBtnArchivadores());
			pap.add(getBtnPapel());
			pap.add(getBtnCuadernos());
		}
		return izquierda;
	}

	private JButton getBtnFotografa() {
		if (btnFotografa == null) {
			btnFotografa = new JButton("Fotograf�a");
			btnFotografa.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					limpiarProductos();
					cargarProductos(1, 1);
				}
			});
			btnFotografa.setContentAreaFilled(false);
			btnFotografa.setBackground(new Color(65, 105, 225));
			btnFotografa.setBorder(null);
			btnFotografa.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnFotografa.setForeground(new Color(255, 255, 255));
		}
		return scrollProductos;
	}

	private JButton getBtnGps() {
		if (btnGps == null) {
			btnGps = new JButton("GPS");
			btnGps.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1, 3);
				}
			});
			btnGps.setContentAreaFilled(false);
			btnGps.setBackground(new Color(65, 105, 225));
			btnGps.setBorder(null);
			btnGps.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnGps.setForeground(new Color(255, 255, 255));
		}
		return panelProductos;
	}

	private JButton getBtnTelefona() {
		if (btnTelefona == null) {
			btnTelefona = new JButton("Telefon�a");
			btnTelefona.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1, 2);
				}
			});
		}
		 adaptarPanel();
	}

	private JButton getBtnTv() {
		if (btnTv == null) {
			btnTv = new JButton("TV");
			btnTv.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1, 4);
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
			btnInformtica = new JButton("Inform�tica");
			btnInformtica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(1, 5);
				}
			});
			btnInformtica.setContentAreaFilled(false);
			btnInformtica.setBackground(new Color(65, 105, 225));
			btnInformtica.setBorder(null);
			btnInformtica.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnInformtica.setForeground(new Color(255, 255, 255));
		}
		else{
			getPanelProductos().removeAll();
			for (Category c:cat){
				JButton boton = new JButton();
				boton.setText(c.getCategoryName());
				boton.setContentAreaFilled(false);
				boton.setBackground(new Color(255, 255, 255));
				boton.setBorder(new EmptyBorder(0, 3, 5, 0));
				getPanelProductos().add(boton);
				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						List<Product> pro  = new ProductsController().getProductsByCategory(c.getCategoryName());
						if(pro.isEmpty()){
							cargarCategorias(c.getCategoryName());
						}
						else{
							cargarProductos(pro);
						}
						adaptarPanel();
					}
				});
			}
		}
		adaptarPanel();
	}

	private JButton getBtnArchivadores() {
		if (btnArchivadores == null) {
			btnArchivadores = new JButton("Archivadores");
			btnArchivadores.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2, 6);
				}
			});
			pan2.add(pvp,BorderLayout.CENTER);
			pan2.add(bot);
			pan.add(lab, BorderLayout.NORTH);
			pan.add(area, BorderLayout.CENTER);
			pan.add(pan2, BorderLayout.SOUTH);
			getPanelProductos().add(pan);
			
		}
		
	}

	private JButton getBtnPapel() {
		if (btnPapel == null) {
			btnPapel = new JButton("Papel");
			btnPapel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2, 7);
				}
			});
			btnPapel.setBackground(new Color(65, 105, 225));
			btnPapel.setForeground(new Color(255, 255, 255));
			btnPapel.setFont(new Font("Tahoma", Font.BOLD, 11));
			btnPapel.setBorder(null);
			btnPapel.setContentAreaFilled(false);
		}
		return panelNavegacion;
	}

	private JButton getBtnCuadernos() {
		if (btnCuadernos == null) {
			btnCuadernos = new JButton("Cuadernos");
			btnCuadernos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					limpiarProductos();
					cargarProductos(2, 8);
				}
			});
			btnInicio.setContentAreaFilled(false);
			btnInicio.setBackground(new Color(255, 255, 255));
			btnInicio.setBorder(new EmptyBorder(0, 0, 0, 3));
		}
		return btnInicio;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			scrollPane.setBackground(new Color(65, 105, 225));
			scrollPane.setViewportView(getPanelProductos());

		}
		return scrollPane;
	}

	private JPanel getPanelProductos() {
		if (panelProductos == null) {
			panelProductos = new JPanel();
			panelProductos.setBorder(null);
			panelProductos.setForeground(new Color(255, 255, 255));
			panelProductos.setBackground(new Color(65, 105, 225));
			panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		}
		return panelProductos;
	}

	private void cargarProductos(int categoria, int subcategoria) {
		List<Product> productos = new ProductsController().getAll(categoria, subcategoria);
		for (Product p : productos) {
			JPanel pan = new JPanel();
			pan.setBorder(new LineBorder(new Color(255, 255, 255), 2));
			pan.setLayout(new BorderLayout(0, 0));
			pan.setBackground(new Color(65, 105, 225));
			pan.setForeground(new Color(255, 255, 255));

			JLabel lab = new JLabel();
			lab.setForeground(new Color(255, 255, 255));
			lab.setHorizontalAlignment(JLabel.CENTER);
			lab.setText(p.getName());

			JTextArea area = new JTextArea();
			area.setWrapStyleWord(true);
			area.setEditable(false);
			area.setBorder(null);
			area.setBackground(new Color(65, 105, 225));
			area.setForeground(new Color(255, 255, 255));
			area.setLineWrap(true);
			area.setPreferredSize(new Dimension(60, 100));
			area.setText(p.getDescription());

			JPanel pan2 = new JPanel();
			pan2.setLayout(new GridLayout(2, 0, 0, 0));
			JTextField pvp = new JTextField();
			pvp.setBackground(new Color(65, 105, 225));
			pvp.setForeground(new Color(255, 255, 255));
			pvp.setEditable(false);
			pvp.setBorder(null);
			pvp.setText("Precio: " + Double.toString(p.getPrice()) + ". Stock: " + p.getStock());
			pvp.setHorizontalAlignment(JTextField.CENTER);
			JButton bot = new JButton();
			bot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod;
					int row = getTable().getRowCount();
					boolean seguir = true;
					if ((row > 0) && (seguir)) {
						for (int i = 0; i < row; i++) {
							cod = (int) table.getValueAt(i, 0);
							if (p.getID() == cod) {
								if (p.getStock() >= ((Integer) table.getValueAt(i, 2) + 1)) {
									Object cant = (Integer) table.getValueAt(i, 2) + 1;
									((DefaultTableModel) getTable().getModel()).setValueAt(cant, i, 2);
									Object pre = (double) redondear(
											((Integer) table.getValueAt(i, 2) * (double) table.getValueAt(i, 3)));
									((DefaultTableModel) getTable().getModel()).setValueAt(pre, i, 4);
									actualizarTotal();
								} else {
									JOptionPane.showMessageDialog(derecha, "No se pueden a�adir m�s art�culos", "Error",
											JOptionPane.ERROR_MESSAGE);
								}
								seguir = false;

							}
							if ((i == (row - 1)) && (seguir)) {
								Object[] nuevaFila = new Object[5];
								nuevaFila[0] = p.getID();
								nuevaFila[1] = p.getName();
								nuevaFila[2] = 1;
								nuevaFila[3] = p.getPrice();
								nuevaFila[4] = p.getPrice();
								((DefaultTableModel) getTable().getModel()).addRow(nuevaFila);
								actualizarTotal();
							}
						}
					} else {

						Object[] nuevaFila = new Object[5];
						nuevaFila[0] = p.getID();
						nuevaFila[1] = p.getName();
						nuevaFila[2] = 1;
						nuevaFila[3] = p.getPrice();
						nuevaFila[4] = p.getPrice();

						((DefaultTableModel) getTable().getModel()).addRow(nuevaFila);
						actualizarTotal();
					}
				}
			});
			bot.setText("A�adir");
			pan2.add(pvp);
			pan2.add(bot);
			pan.add(lab, BorderLayout.NORTH);
			pan.add(area, BorderLayout.CENTER);
			pan.add(pan2, BorderLayout.SOUTH);
			panelProductos.add(pan);
			getPanelProductos().revalidate();
			getPanelProductos().repaint();
			getScrollPane().revalidate();
			getScrollPane().repaint();

		}

	}

	private void limpiarProductos() {
		getPanelProductos().removeAll();
	}

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(65, 105, 225));
			table.setForeground(new Color(255, 255, 255));
			modelo = new DefaultTableModel(new Object[][] {},
					new String[] { "Referencia", "Nombre", "Cantidad", "Precio ud", "Precio" }) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 4352988190229278374L;
				/**
				 * 
				 */
				boolean[] columnEditables = new boolean[] { false, false, true, false, false };

				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
			table.setModel(modelo);
			table.getColumnModel().getColumn(0).setResizable(false);
			table.getColumnModel().getColumn(1).setResizable(false);
			table.getColumnModel().getColumn(2).setResizable(false);
			table.getColumnModel().getColumn(3).setResizable(false);
			table.getColumnModel().getColumn(4).setResizable(false);
			table.setCellSelectionEnabled(true);

		}
		return table;
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setForeground(new Color(255, 255, 255));
			scrollPane_1.setBackground(new Color(65, 105, 225));
			scrollPane_1.setBounds(20, 36, 377, 371);
			scrollPane_1.setViewportView(getTable());
			scrollPane_1.getViewport().setBackground(new Color(65, 105, 225));

		}
		return scrollPane_1;
	}

	private void actualizarTotal() {
		double total = 0;
		int filas = table.getRowCount();
		for (int i = 0; i < filas; i++) {
			total = total + (double) (table.getValueAt(i, 4));
		}
		txtTotal.setText(Double.toString((redondear(total))));
	}

	private double redondear(double cifra) {

		return BigDecimal.valueOf(cifra).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	private boolean comprobarEntero(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
