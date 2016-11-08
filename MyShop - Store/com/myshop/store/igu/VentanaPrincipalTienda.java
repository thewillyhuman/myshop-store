package com.myshop.store.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;

import com.myshop.model.customer.Address;
import com.myshop.model.customer.Company;
import com.myshop.model.customer.CreditCards;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.order.Order;
import com.myshop.model.product.Category;
import com.myshop.model.product.Product;
import com.myshop.store.controller.ProductsController;
import com.myshop.store.controller.UsersController;

import java.awt.ComponentOrientation;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
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
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import java.awt.event.FocusAdapter;

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
	private JLabel lblUrlInicio;
	private JTable table;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane_1;
	private Map<Object, Object> treeMap;
	private JPanel izquierda;
	private JScrollPane scrollProductos;
	private List<Product> products;
	private JPanel panelProductos;
	private JPanel panelNavegacion;
	private JButton btnInicio;
	private JTextField textUser;
	private JTextField textPass;
	private JTextField textCalle;
	private JTextField textCiudad;
	private JTextField textProvinciaEstado;
	private JTextField textCodigoPostal;
	private JTextField textUserEmpresa;
	private JTextField textPassEmpresa;
	private boolean esEmpresa = false;
	private JPanel pago;
	private JPanel direccionPago;
	private JLabel lblHttpwwwmyshopestiendapago;
	private JPanel contenidoPago;
	private JPanel datos;
	private JPanel metodos;
	private JTextField textDireccionPago;
	private JTextField textCiudadPago;
	private JTextField textProvinciaPago;
	private JTextField textCodigoPostalPago;
	private JPanel panelMetodos;
	private JPanel panelRadioButtons;
	private JTextField textNumero;
	private JTextField textTitular;
	private JTextField textFecha;
	private JTextField textCVC;
	private JLabel lblNmeroDeCuenta;
	private JTextField textFNumeroCuenta;
	private JButton btnConfirmarTrans;
	private JPanel logueoPago;
	private JPanel direccionILogueoPago;
	private JPanel contenidoLogueoPago;

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
		contentPane.add(getTienda(), "tienda");
		contentPane.add(getLogueoPago(), "login");
		JPanel inicio = new JPanel();
		inicio.setBackground(Color.WHITE);
		contentPane.add(inicio, "name_381831475621552");
		inicio.setLayout(new BorderLayout(0, 0));
		products = new ProductsController().getAllView();
		cargarCategoriaInicial();

		JPanel direccionInicio = new JPanel();
		direccionInicio.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		direccionInicio.setBackground(Color.WHITE);
		inicio.add(direccionInicio, BorderLayout.NORTH);
		direccionInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel label = new JLabel("http://www.myshop.es");
		label.setPreferredSize(new Dimension(1011, 14));
		label.setBackground(Color.WHITE);
		direccionInicio.add(label);

		JPanel contenidoInicio = new JPanel();
		contenidoInicio.setLayout(null);
		contenidoInicio.setBackground(Color.WHITE);
		inicio.add(contenidoInicio, BorderLayout.CENTER);

		JPanel panelEmpresa = new JPanel();
		panelEmpresa.setLayout(null);
		panelEmpresa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Acceso a tienda de empresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEmpresa.setBackground(Color.WHITE);
		panelEmpresa.setBounds(12, 13, 492, 529);
		contenidoInicio.add(panelEmpresa);

		JLabel lblUsuarioNoEncontradoEmpresa = new JLabel("Usuario no encontrado");
		lblUsuarioNoEncontradoEmpresa.setVisible(false);
		lblUsuarioNoEncontradoEmpresa.setForeground(Color.RED);
		lblUsuarioNoEncontradoEmpresa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuarioNoEncontradoEmpresa.setBounds(33, 329, 253, 47);
		panelEmpresa.add(lblUsuarioNoEncontradoEmpresa);

		JLabel lblUsuarioEmpresa = new JLabel("Nombre de usuario");
		lblUsuarioEmpresa.setBounds(33, 169, 109, 16);
		panelEmpresa.add(lblUsuarioEmpresa);

		textUserEmpresa = new JTextField();
		textUserEmpresa.setColumns(10);
		textUserEmpresa.setBounds(33, 195, 253, 22);
		textUserEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUsuarioNoEncontradoEmpresa.setVisible(false);
			}
		});
		panelEmpresa.add(textUserEmpresa);

		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setBounds(33, 230, 65, 16);
		panelEmpresa.add(lblPassword);

		textPassEmpresa = new JTextField();
		textPassEmpresa.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUsuarioNoEncontradoEmpresa.setVisible(false);
			}
		});
		textPassEmpresa.setColumns(10);
		textPassEmpresa.setBounds(33, 252, 253, 22);
		panelEmpresa.add(textPassEmpresa);

		JButton btnAccederEmpresa = new JButton("Acceder");
		btnAccederEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersController uc = new UsersController();
				Company c = uc.getCompany(textUserEmpresa.getText(), textPassEmpresa.getText());
				if (c.getName() == null)
					lblUsuarioNoEncontradoEmpresa.setVisible(true);
				else {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "tienda");
					esEmpresa = true;
				}
			}
		});
		btnAccederEmpresa.setBounds(33, 291, 103, 25);
		panelEmpresa.add(btnAccederEmpresa);

		JPanel panelParticular = new JPanel();
		panelParticular.setLayout(null);
		panelParticular.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acceso a particulares",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParticular.setBackground(Color.WHITE);
		panelParticular.setBounds(518, 13, 533, 529);
		contenidoInicio.add(panelParticular);

		JButton btnAccederParticular = new JButton("Acceder");
		btnAccederParticular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) contentPane.getLayout();
				card.show(contentPane, "tienda");
			}
		});
		btnAccederParticular.setBounds(213, 254, 108, 25);
		panelParticular.add(btnAccederParticular);
		contentPane.add(inicio, "inicio");
		CardLayout card = (CardLayout) contentPane.getLayout();
		card.show(contentPane, "inicio");
		contentPane.add(getPago(), "pago");
	


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
					for (Product p : products) {
						if (p.getID() == referencia) {
							stock = p.getStock();
							precio = p.getPrice();
						}
					}
					int nuevoValor = Integer.parseInt((String) tcl.getNewValue());
					if (nuevoValor > stock) {
						JOptionPane.showMessageDialog(derecha, "No hay tantos artículos en stock", "Error",
								JOptionPane.ERROR_MESSAGE);
						table.setValueAt(stock, tcl.getRow(), tcl.getColumn());
						table.setValueAt(redondear(precio * stock), tcl.getRow(), 4);
					} else if (nuevoValor < 0) {
						JOptionPane.showMessageDialog(derecha, "No se pueden poner valores negativos", "Error",
								JOptionPane.ERROR_MESSAGE);
						table.setValueAt(tcl.getOldValue(), tcl.getRow(), tcl.getColumn());
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
			txtTotal.setBounds(219, 430, 86, 20);
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
			btnVaciar.setBounds(39, 493, 121, 35);

		}
		return btnVaciar;
	}

	private JButton getBtnContinuar() {
		if (btnContinuar == null) {
			btnContinuar = new JButton("Continuar");
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					treeMap = new TreeMap<Object, Object>();
					for(int i=0;i<table.getRowCount();i++){
						treeMap.put(table.getValueAt(i, 0),table.getValueAt(i, 2));
					}
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "login");
				}
			});

			btnContinuar.setBounds(202, 493, 121, 35);
		}
		return btnContinuar;
	}


	

	private JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setBackground(new Color(255, 255, 255));
			table.setForeground(new Color(0, 0, 0));
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
			scrollPane_1.setForeground(new Color(0, 0, 0));
			scrollPane_1.setBackground(new Color(255, 255, 255));
			scrollPane_1.setBounds(10, 53, 320, 337);
			scrollPane_1.setViewportView(getTable());
			scrollPane_1.getViewport().setBackground(new Color(255, 255, 255));

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
	private JPanel getIzquierda() {
		if (izquierda == null) {
			izquierda = new JPanel();
			izquierda.setBackground(new Color(255, 255, 255));
			izquierda.setBounds(10, 47, 700, 502);
			izquierda.setLayout(new BorderLayout(0, 0));
			izquierda.add(getScrollProductos(), BorderLayout.CENTER);
		}
		return izquierda;
	}
	private JScrollPane getScrollProductos() {
		if (scrollProductos == null) {
			scrollProductos = new JScrollPane();
			scrollProductos.setViewportView(getPanelProductos());
		}
		return scrollProductos;
	}
	private JPanel getPanelProductos() {
		if (panelProductos == null) {
			panelProductos = new JPanel();
			panelProductos.setBackground(new Color(255, 255, 255));
			panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		}
		return panelProductos;
	}

	private void cargarCategoriaInicial() {
		getPanelProductos().removeAll();
		List<Category> catRoot = new ProductsController().getCategorysRoot();
		for (Category c : catRoot) {
			JButton boton = new JButton();
			boton.setText(c.getCategoryName());
			boton.setContentAreaFilled(false);
			boton.setBackground(new Color(255, 255, 255));
			boton.setBorder(new EmptyBorder(0, 3, 5, 0));
			getPanelProductos().add(boton);
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarCategorias(c.getCategoryName());
				}
			});
		}
		 adaptarPanel();
	}

	public void adaptarPanel(){
		getPanelProductos().repaint();
		getScrollProductos().setViewportView(getPanelProductos());
		getScrollProductos().repaint();
	}
	
	public void cargarCategorias(String nombreCat){
		
		List<Category> cat  = new ProductsController().getCategorysChildren(nombreCat);
		if(cat.isEmpty()){
			JTextField texto = new JTextField();
			texto.setText("Esta categoría no contiene productos");
			getPanelProductos().removeAll();
			getPanelProductos().add(texto);
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
	public void cargarProductos(List<Product> listaPro){
		getPanelProductos().removeAll();
		for (Product p : listaPro) {
			JPanel pan = new JPanel();
			pan.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			pan.setLayout(new BorderLayout(0, 0));
			pan.setBackground(new Color(255, 255, 255));
			pan.setForeground(new Color(0, 0, 0));

			JLabel lab = new JLabel();
			lab.setForeground(new Color(0, 0, 0));
			lab.setHorizontalAlignment(JLabel.CENTER);
			lab.setText(p.getName());

			JTextArea area = new JTextArea();
			area.setWrapStyleWord(true);
			area.setEditable(false);
			area.setBorder(null);
			area.setBackground(new Color(255, 255, 255));
			area.setForeground(new Color(0, 0, 0));
			area.setLineWrap(true);
			area.setPreferredSize(new Dimension(60, 100));
			area.setText(p.getDescription());

			JPanel pan2 = new JPanel();
			pan2.setLayout(new GridLayout(2, 0, 0, 0));
			JTextField pvp = new JTextField();
			pvp.setBackground(new Color(255, 255, 255));
			pvp.setForeground(new Color(0, 0, 0));
			pvp.setEditable(false);
			pvp.setBorder(null);
			pvp.setText("Precio: " + Double.toString(p.getPrice()) + ". Stock: " + p.getStock()+ ". Ref: " + p.getID());
			pvp.setHorizontalAlignment(JTextField.CENTER);
			JButton bot = new JButton();
			bot.setText("Añadir");
			bot.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int cod;
					int row = getTable().getRowCount();
					boolean seguir = true;
					if ((row > 0) && (seguir)) {
						for (int i = 0; i < row; i++) {
							cod = (int) table.getValueAt(i, 0);
							if (p.getID() == cod) {
								if (p.getStock() > Integer.parseInt(table.getValueAt(i, 2).toString())) {
									Object cant = (Integer) table.getValueAt(i, 2) + 1;
									((DefaultTableModel) getTable().getModel()).setValueAt(cant, i, 2);
									Object pre = (double) redondear(
											((Integer) table.getValueAt(i, 2) * (double) table.getValueAt(i, 3)));
									((DefaultTableModel) getTable().getModel()).setValueAt(pre, i, 4);
									actualizarTotal();
								} else {
									JOptionPane.showMessageDialog(derecha, "No se pueden añadir más artículos", "Error",
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
			pan2.add(pvp,BorderLayout.CENTER);
			pan2.add(bot);
			pan.add(lab, BorderLayout.NORTH);
			pan.add(area, BorderLayout.CENTER);
			pan.add(pan2, BorderLayout.SOUTH);
			getPanelProductos().add(pan);
			
		}
		
	}
	private JPanel getPanelNavegacion() {
		if (panelNavegacion == null) {
			panelNavegacion = new JPanel();
			panelNavegacion.setLayout(new BoxLayout(panelNavegacion, BoxLayout.Y_AXIS));
			panelNavegacion.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelNavegacion.setAlignmentY(Component.CENTER_ALIGNMENT);
			panelNavegacion.setBackground(new Color(255, 255, 255));
			panelNavegacion.setBounds(10, 11, 700, 28);
			panelNavegacion.add(getBtnNewButton());
		}
		return panelNavegacion;
	}
	private JButton getBtnNewButton() {
		if (btnInicio == null) {
			btnInicio = new JButton("Inicio");
			btnInicio.setFocusPainted(false);
			btnInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarCategoriaInicial();
				}
			});
			btnInicio.setContentAreaFilled(false);
			btnInicio.setBackground(new Color(255, 255, 255));
			btnInicio.setBorder(new EmptyBorder(0, 0, 0, 3));
		}
		return btnInicio;
	}
	private JPanel getLogueoPago() {
		if (logueoPago == null) {
			logueoPago = new JPanel();
			logueoPago.setLayout(new BorderLayout(0, 0));
			logueoPago.add(getDireccionILogueoPago(), BorderLayout.NORTH);
			logueoPago.add(getContenidoLogueoPago(), BorderLayout.CENTER);
		}
		return logueoPago;
	}

	private JPanel getDireccionILogueoPago() {
		if (direccionILogueoPago == null) {
			direccionILogueoPago = new JPanel();
			direccionILogueoPago.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			direccionILogueoPago.setBackground(Color.WHITE);
			direccionILogueoPago.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			direccionILogueoPago.add(getLblUrlInicio());
		}
		return direccionILogueoPago;
	}
	private JLabel getLblUrlInicio() {
		if (lblUrlInicio == null) {
			lblUrlInicio = new JLabel("http://www.myshop.es/tienda/login");
			lblUrlInicio.setPreferredSize(new Dimension(1011, 14));
			lblUrlInicio.setBackground(Color.WHITE);
		}
		return lblUrlInicio;
	}

	private JPanel getContenidoLogueoPago() {
		if (contenidoLogueoPago == null) {
			contenidoLogueoPago = new JPanel();
			contenidoLogueoPago.setLayout(null);
			contenidoLogueoPago.setBackground(Color.WHITE);

			JPanel loginUsuario = new JPanel();
			loginUsuario.setBorder(
					new TitledBorder(null, "Inicio de sesion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			loginUsuario.setBackground(Color.WHITE);
			loginUsuario.setBounds(12, 13, 492, 529);
			contenidoLogueoPago.add(loginUsuario);

			JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
			lblNombreDeUsuario.setBounds(33, 169, 109, 16);

			JLabel lblUsuarioNoEncontrado = new JLabel("Usuario no encontrado");
			lblUsuarioNoEncontrado.setVisible(false);
			lblUsuarioNoEncontrado.setForeground(Color.RED);
			lblUsuarioNoEncontrado.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblUsuarioNoEncontrado.setBounds(33, 329, 253, 47);
			loginUsuario.add(lblUsuarioNoEncontrado);

			textUser = new JTextField();
			textUser.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblUsuarioNoEncontrado.setVisible(false);
				}
			});
			textUser.setBounds(33, 195, 253, 22);
			textUser.setColumns(10);

			JLabel lblContrasea = new JLabel("Contrase\u00F1a");
			lblContrasea.setBounds(33, 230, 65, 16);

			textPass = new JTextField();
			textPass.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					lblUsuarioNoEncontrado.setVisible(false);
				}
			});
			textPass.setBounds(33, 252, 253, 22);
			textPass.setColumns(10);
			loginUsuario.setLayout(null);
			loginUsuario.add(lblNombreDeUsuario);
			loginUsuario.add(textUser);
			loginUsuario.add(lblContrasea);
			loginUsuario.add(textPass);

			JButton btnContinuar_1 = new JButton("Continuar");
			btnContinuar_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					UsersController uc = new UsersController();
					IndividualCustomer ic = uc.getCustomerData(textUser.getText(), textPass.getText());
					if (ic.getName() == null)
						lblUsuarioNoEncontrado.setVisible(true);
				}
			});
			btnContinuar_1.setBounds(33, 291, 109, 25);
			loginUsuario.add(btnContinuar_1);

			JPanel panelNoRegistro = new JPanel();
			panelNoRegistro.setBorder(new TitledBorder(null, "Usuario no registrado", TitledBorder.LEADING,
					TitledBorder.TOP, null, null));
			panelNoRegistro.setBackground(Color.WHITE);
			panelNoRegistro.setBounds(518, 13, 533, 529);
			contenidoLogueoPago.add(panelNoRegistro);
			panelNoRegistro.setLayout(null);
			
			JLabel lblErroresDeTexto = new JLabel("Errores de texto");
			lblErroresDeTexto.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblErroresDeTexto.setVisible(false);
			lblErroresDeTexto.setForeground(Color.RED);
			lblErroresDeTexto.setBounds(29, 458, 431, 24);
			panelNoRegistro.add(lblErroresDeTexto);

			JLabel lblDatosDeEnvo = new JLabel("Datos de env\u00EDo:");
			lblDatosDeEnvo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDatosDeEnvo.setBounds(32, 109, 132, 24);
			panelNoRegistro.add(lblDatosDeEnvo);

			JLabel lblCalle = new JLabel("Calle");
			lblCalle.setBounds(34, 164, 106, 24);
			panelNoRegistro.add(lblCalle);

			textCalle = new JTextField();
			textCalle.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblErroresDeTexto.setVisible(false);
				}
			});
			textCalle.setBounds(32, 189, 474, 24);
			panelNoRegistro.add(textCalle);
			textCalle.setColumns(10);

			JLabel lblCiudad = new JLabel("Ciudad");
			lblCiudad.setBounds(32, 226, 84, 16);
			panelNoRegistro.add(lblCiudad);

			textCiudad = new JTextField();
			textCiudad.setBounds(32, 245, 474, 24);
			panelNoRegistro.add(textCiudad);
			textCiudad.setColumns(10);
			textCiudad.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblErroresDeTexto.setVisible(false);
				}
			});

			JLabel lblProvinciaestado = new JLabel("Provincia/Estado");
			lblProvinciaestado.setBounds(32, 283, 132, 24);
			panelNoRegistro.add(lblProvinciaestado);

			textProvinciaEstado = new JTextField();
			textProvinciaEstado.setBounds(32, 309, 474, 24);
			panelNoRegistro.add(textProvinciaEstado);
			textProvinciaEstado.setColumns(10);
			textProvinciaEstado.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblErroresDeTexto.setVisible(false);
				}
			});

			JLabel lblCodigoPostal = new JLabel("Codigo postal");
			lblCodigoPostal.setBounds(32, 346, 108, 24);
			panelNoRegistro.add(lblCodigoPostal);

			textCodigoPostal = new JTextField();
			textCodigoPostal.setBounds(32, 373, 474, 24);
			panelNoRegistro.add(textCodigoPostal);
			textCodigoPostal.setColumns(10);
			textCodigoPostal.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					lblErroresDeTexto.setVisible(false);
				}
			});
			
			
			JButton btnContinuar_2 = new JButton("Continuar");
			btnContinuar_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (compruebaCampos()) {
						textCiudadPago.setText(textCiudad.getText());
						textProvinciaPago.setText(textProvinciaEstado.getText());
						textDireccionPago.setText(textCalle.getText());
						textCodigoPostalPago.setText(textCodigoPostal.getText());
						CardLayout card = (CardLayout) contentPane.getLayout();
						card.show(contentPane, "pago");
					} else {
						
					}
				}

				private boolean compruebaCampos() {
					if (textCiudad.getText().isEmpty() || textProvinciaEstado.getText().isEmpty()
							|| textCalle.getText().isEmpty() || textCodigoPostal.getText().isEmpty()) {
						lblErroresDeTexto.setText("Hay alg¨²n campo vac¨ªo. No se deje ninguno");
						lblErroresDeTexto.setVisible(true);
						return false;
					} else {
						if (textCodigoPostal.getText().matches("[0-9]+"))
							return true;
						else{
							lblErroresDeTexto.setText("El codigo postal solo puede contener n¨²meros");
							lblErroresDeTexto.setVisible(true);
							return false;
						}
					}
				}
			});
			btnContinuar_2.setBounds(32, 418, 97, 25);
			panelNoRegistro.add(btnContinuar_2);
			
			
		}
		return contenidoLogueoPago;
	}
	private JPanel getPago() {
		if (pago == null) {
			pago = new JPanel();
			pago.setBackground(Color.WHITE);
			pago.setLayout(new BorderLayout(0, 0));
			pago.add(getDireccionPago(), BorderLayout.NORTH);
			pago.add(getContenidoPago(), BorderLayout.CENTER);
		}
		return pago;
	}

	private JPanel getDireccionPago() {
		if (direccionPago == null) {
			direccionPago = new JPanel();
			direccionPago.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			direccionPago.setBackground(Color.WHITE);
			direccionPago.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			direccionPago.add(getLblHttpwwwmyshopestiendapago());
		}
		return direccionPago;
	}

	private JLabel getLblHttpwwwmyshopestiendapago() {
		if (lblHttpwwwmyshopestiendapago == null) {
			lblHttpwwwmyshopestiendapago = new JLabel("http://www.myshop.es/tienda/pago");
			lblHttpwwwmyshopestiendapago.setPreferredSize(new Dimension(1011, 14));
			lblHttpwwwmyshopestiendapago.setBackground(Color.WHITE);
		}
		return lblHttpwwwmyshopestiendapago;
	}

	private JPanel getContenidoPago() {
		if (contenidoPago == null) {
			contenidoPago = new JPanel();
			contenidoPago.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			contenidoPago.setBackground(Color.WHITE);
			contenidoPago.setLayout(null);
			contenidoPago.add(getDatos());
			contenidoPago.add(getMetodos());

			JPanel carrito = new JPanel();
			carrito.setBackground(Color.WHITE);
			carrito.setBorder(new TitledBorder(null, "Carrito", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			carrito.setBounds(0, 0, 529, 271);
			contenidoPago.add(carrito);
		}
		return contenidoPago;
	}

	private JPanel getDatos() {
		if (datos == null) {
			datos = new JPanel();
			datos.setBackground(Color.WHITE);
			datos.setBorder(
					new TitledBorder(null, "Resumen datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			datos.setBounds(0, 276, 529, 279);
			datos.setLayout(new GridLayout(0, 1, 0, 0));

			JLabel lblNewLabel = new JLabel("Ciudad");
			datos.add(lblNewLabel);

			textCiudadPago = new JTextField();
			textCiudadPago.setEditable(false);
			datos.add(textCiudadPago);
			textCiudadPago.setColumns(10);

			JLabel lblProvincia = new JLabel("Provincia/Estado");
			datos.add(lblProvincia);

			textProvinciaPago = new JTextField();
			textProvinciaPago.setEditable(false);
			datos.add(textProvinciaPago);
			textProvinciaPago.setColumns(10);

			JLabel lblDireccin = new JLabel("Direcci\u00F3n");
			datos.add(lblDireccin);

			textDireccionPago = new JTextField();
			textDireccionPago.setEditable(false);
			datos.add(textDireccionPago);
			textDireccionPago.setColumns(10);

			JLabel lblCdigoPostal = new JLabel("C\u00F3digo postal");
			datos.add(lblCdigoPostal);

			textCodigoPostalPago = new JTextField();
			textCodigoPostalPago.setEditable(false);
			datos.add(textCodigoPostalPago);
			textCodigoPostalPago.setColumns(10);
		}
		return datos;
	}

	private JPanel getMetodos() {
		if (metodos == null) {
			metodos = new JPanel();
			metodos.setBackground(Color.WHITE);
			metodos.setBorder(
					new TitledBorder(null, "M\u00E9todo de pago", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			metodos.setBounds(541, 0, 522, 555);
			metodos.setLayout(new BorderLayout(0, 0));
			metodos.add(getPanelMetodos(), BorderLayout.CENTER);
			metodos.add(getPanelRadioButtons(), BorderLayout.NORTH);
		}
		return metodos;
	}
	private JPanel getPanelMetodos() {
		if (panelMetodos == null) {
			panelMetodos = new JPanel();
			panelMetodos.setBackground(new Color(65, 105, 225));
			panelMetodos.setLayout(new CardLayout(0, 0));
			
			JPanel panelTarjeta = new JPanel();
			panelTarjeta.setBackground(Color.WHITE);
			panelMetodos.add(panelTarjeta, "tarjeta");
			panelTarjeta.setLayout(null);
			
			JLabel lblNmeroTajeta = new JLabel("N\u00FAmero tajeta");
			lblNmeroTajeta.setBounds(12, 126, 149, 29);
			panelTarjeta.add(lblNmeroTajeta);
			
			textNumero = new JTextField();
			textNumero.setBounds(12, 149, 486, 29);
			panelTarjeta.add(textNumero);
			textNumero.setColumns(10);
			
			JLabel lblNombreTitular = new JLabel("Nombre del titular");
			lblNombreTitular.setBounds(12, 183, 172, 16);
			panelTarjeta.add(lblNombreTitular);
			
			textTitular = new JTextField();
			textTitular.setBounds(12, 199, 486, 29);
			panelTarjeta.add(textTitular);
			textTitular.setColumns(10);
			
			JLabel lblFechaCaducidad = new JLabel("Fecha caducidad");
			lblFechaCaducidad.setBounds(12, 229, 123, 29);
			panelTarjeta.add(lblFechaCaducidad);
			
			textFecha = new JTextField();
			textFecha.setBounds(12, 250, 486, 29);
			panelTarjeta.add(textFecha);
			textFecha.setColumns(10);
			
			JLabel lblCvc = new JLabel("CVC");
			lblCvc.setBounds(12, 285, 94, 16);
			panelTarjeta.add(lblCvc);
			
			textCVC = new JTextField();
			textCVC.setBounds(12, 299, 149, 29);
			panelTarjeta.add(textCVC);
			textCVC.setColumns(10);
			
			JButton btnConfirmarTarjeta = new JButton("Confirmar");
			btnConfirmarTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					IndividualCustomer ic = new IndividualCustomer();
					Address a = new Address();
					ic.setAddress(a);
					CreditCards cc = new CreditCards();
					ic.setCreditCard(cc);
					Order o = new Order();
					o.setCustomer(ic);
				}
			});
			btnConfirmarTarjeta.setBounds(12, 341, 94, 29);
			panelTarjeta.add(btnConfirmarTarjeta);
			
			JPanel panelTransferencia = new JPanel();
			panelTransferencia.setBackground(Color.WHITE);
			panelMetodos.add(panelTransferencia, "transferencia");
			panelTransferencia.setLayout(null);
			panelTransferencia.add(getLblNmeroDeCuenta());
			panelTransferencia.add(getTextFNumeroCuenta());
			panelTransferencia.add(getBtnConfirmarTrans());
		}
		return panelMetodos;
	}
	private JPanel getPanelRadioButtons() {
		if (panelRadioButtons == null) {
			panelRadioButtons = new JPanel();
			panelRadioButtons.setBackground(Color.WHITE);
			
			JRadioButton radioTarjeta = new JRadioButton("Tarjeta de cr\u00E9dito");
			radioTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) panelMetodos.getLayout();
					card.show(panelMetodos, "tarjeta");
				}
			});
			radioTarjeta.setSelected(true);
			radioTarjeta.setBackground(Color.WHITE);
			panelRadioButtons.add(radioTarjeta);
			
			JRadioButton radioTransferencia = new JRadioButton("Transferencia bancaria");
			radioTransferencia.setBackground(Color.WHITE);
			radioTransferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CardLayout card = (CardLayout) panelMetodos.getLayout();
					card.show(panelMetodos, "transferencia");
				}
			});
			panelRadioButtons.add(radioTransferencia);
			
			ButtonGroup group = new ButtonGroup();
			group.add(radioTarjeta);
			group.add(radioTransferencia);
		}
		return panelRadioButtons;
	}
	private JLabel getLblNmeroDeCuenta() {
		if (lblNmeroDeCuenta == null) {
			lblNmeroDeCuenta = new JLabel("N\u00FAmero de cuenta");
			lblNmeroDeCuenta.setBounds(12, 149, 137, 29);
		}
		return lblNmeroDeCuenta;
	}
	private JTextField getTextFNumeroCuenta() {
		if (textFNumeroCuenta == null) {
			textFNumeroCuenta = new JTextField();
			textFNumeroCuenta.setBounds(12, 180, 486, 29);
			textFNumeroCuenta.setColumns(10);
		}
		return textFNumeroCuenta;
	}
	private JButton getBtnConfirmarTrans() {
		if (btnConfirmarTrans == null) {
			btnConfirmarTrans = new JButton("Confirmar");
			btnConfirmarTrans.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			btnConfirmarTrans.setBounds(12, 227, 97, 25);
		}
		return btnConfirmarTrans;
	}
}
