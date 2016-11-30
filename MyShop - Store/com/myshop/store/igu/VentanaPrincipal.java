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

import com.myshop.model.customer.Company;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.product.Category;
import com.myshop.model.product.Product;
import com.myshop.store.controller.PaymentsController;
import com.myshop.store.controller.ProductsController;
import com.myshop.store.controller.UsersController;

import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.AbstractAction;
import javax.swing.AbstractButton;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;

public class VentanaPrincipal extends JFrame {

	public static final Color blue_code = Color.decode("#0079ff");
	final static String newline = "\n";
	final static String tab = "\t";
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel Tienda;
	private JPanel panelSuperior;
	private JPanel panelContenido;
	private JPanel panelDireccion;
	private JPanel panelLogo;
	private JLabel lbLogo;
	private JLabel lbUrl;
	private JButton btIzquierda;
	private JLabel lbDerecha;
	private JLabel lbRecargar;
	private JPanel panelIquierda;
	private JPanel panelDerecha;
	private JPanel panelNavegacion;
	private JScrollPane scrollPaneProductos;
	private JPanel panelProductos;
	private JButton BtnInicio;
	private JPanel Inicio;
	private JPanel panelSuperiorInicio;
	private JPanel panelDireccionInicio;
	private JButton btIzquierdaInicio;
	private JLabel lbDerechaInicio;
	private JLabel lbRecargarInicio;
	private JLabel lbUrlInicio;
	private JPanel panelLogoInicio;
	private JLabel lbLogoInicio;
	private JSplitPane panelContenidoInicio;
	private JPanel panelIzquierdaInicio;
	private JPanel panelDerechaInicio;
	private JLabel lbParticularesInicio;
	private JTextField txtUsuarioRegistradosInicio;
	private JPasswordField passwordFieldRegistradosInicio;
	private JButton btEntrarRegistradosInicio;
	private boolean esEmpresa;
	private IndividualCustomer individualCustomer;
	private Company company;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lbTotal;
	private JLabel lbTotalTexto;
	private JButton btContinuarTienda;
	private DefaultTableModel modelo;
	private List<Product> products;
	private JPanel Envio;
	private JPanel panelSuperiorEnvio;
	private JPanel panelDireccionEnvio;
	private JButton btIzquierdaEnvio;
	private JLabel lbDerechaEnvio;
	private JLabel lbRecargarEnvio;
	private JLabel lbUrlEnvio;
	private JPanel panelLogoEnvio;
	private JLabel lbShopEnvio;
	private JPanel panelContenidoEnvio;
	private JPanel panelPago;
	private JPanel panelDatos;
	private JLabel lbDatosEnvio;
	private JLabel lbDatosPago;
	private JLabel lbNombre;
	private JLabel lbApellidos;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JLabel lbDireccion;
	private JTextField txtDireccion;
	private JLabel lbCiudad;
	private JTextField txtCiudad;
	private JLabel lbPostal;
	private JTextField txtPostal;
	private JLabel lbProvincia;
	private JTextField txtProvincia;
	private JPanel panelMetodoPago;
	private JButton btComprobar;
	private JPanel panelTarjeta;
	private JLabel lbNombreTitular;
	private JLabel lbNumero;
	private JLabel lbCvc;
	private JTextField txtNombreTitular;
	private JTextField txtNumero;
	private JTextField txtCvc;
	private JPanel panelTransferencia;
	private JLabel lbTextoTransferencia;
	private JPanel panelContrareembolso;
	private JPanel Comprobacion;
	private JPanel panelSuperiorComprobacion;
	private JPanel panelDireccionComprobacion;
	private JButton btIzquierdaComprobacion;
	private JLabel lbDerechaComprobacion;
	private JLabel lbRecargarComprobacion;
	private JLabel lbUrlComprobacion;
	private JPanel panelLogoComprobacion;
	private JLabel lbShopComprobacion;
	private JPanel panelContenidoComprobacion;
	private JScrollPane scrollCarritoComprobacion;
	private Map<Object, Object> treeMap;
	private JPanel panelPrecios;
	private JButton btPagar;
	private JLabel lbSubtotal;
	private JLabel lbImpuestos;
	private JLabel lbTotalComprobacion;
	private JLabel lbSubtotalTexto;
	private JLabel lbImpuestosText;
	private JLabel lbTotalComprobacionTexto;
	private JPanel panelDatosComprobacion;
	private JLabel lbDireccionComprobacion;
	private JLabel lbPersonaComprobacion;
	private JLabel lbFecha;
	private JSpinner spinnerFecha;
	private JLabel lbMetodoComprobacion;
	private JLabel lblAccesoSinRegistro;
	private JButton btnEntrar;
	private JRadioButton rbTarjeta;
	private JRadioButton rbTransferencia;
	private JRadioButton rbContrareembolso;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lbContrareembolso;
	private JTable tableComprobacion;
	private JLabel lbMetodosEnvio;
	private JRadioButton rdbtn24;
	private JRadioButton rdbtn48;
	private JRadioButton rdbtn5;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JLabel lbCarrito;
	private JLabel lbTipoEnvio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
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
	public VentanaPrincipal() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1013, 633);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		contentPane.add(getInicio(), "panelRegistro");
		contentPane.add(getTienda(), "panelTiendaInicio");
		contentPane.add(getEnvio(), "panelEnvio");
		contentPane.add(getComprobacion(), "panelComprobacion");
		esEmpresa = false;
		individualCustomer = null;
		company = null;
		cargarCategoriaInicial();
		products = new ProductsController().getAll();
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
							if (esEmpresa == false) {
								precio = p.getPrice();
							} else {
								precio = p.getCompanyPrice();
							}
						}
					}
					int nuevoValor = Integer.parseInt((String) tcl.getNewValue());
					if (nuevoValor > stock) {
						JOptionPane.showMessageDialog(panelDerecha, "No hay tantos artículos en stock.", "Error",
								JOptionPane.ERROR_MESSAGE);
						table.setValueAt(stock, tcl.getRow(), tcl.getColumn());
						table.setValueAt(redondear(precio * stock), tcl.getRow(), 4);
					} else if (nuevoValor < 0) {
						JOptionPane.showMessageDialog(panelDerecha, "No se pueden poner valores negativos.", "Error",
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
					JOptionPane.showMessageDialog(panelDerecha, "El valor introducido debe ser un entero.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		};
		new TableCellListener(getTable(), action);

	}

	private boolean comprobarEntero(String text) {
		try {
			Integer.parseInt(text);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private JPanel getTienda() {
		if (Tienda == null) {
			Tienda = new JPanel();
			Tienda.setLayout(new BorderLayout(0, 0));
			Tienda.add(getPanelSuperior(), BorderLayout.NORTH);
			Tienda.add(getPanelContenido(), BorderLayout.CENTER);

		}
		return Tienda;
	}

	private JPanel getPanelSuperior() {
		if (panelSuperior == null) {
			panelSuperior = new JPanel();
			panelSuperior.setLayout(new BorderLayout(0, 0));
			panelSuperior.add(getPanelDireccion(), BorderLayout.NORTH);
			panelSuperior.add(getPanelLogo(), BorderLayout.SOUTH);
		}
		return panelSuperior;
	}

	private JPanel getPanelContenido() {
		if (panelContenido == null) {
			panelContenido = new JPanel();
			panelContenido.setLayout(null);
			panelContenido.add(getPanelIquierda());
			panelContenido.add(getPanelDerecha());
		}
		return panelContenido;
	}

	private JPanel getPanelDireccion() {
		if (panelDireccion == null) {
			panelDireccion = new JPanel();
			panelDireccion.setBackground(Color.WHITE);
			panelDireccion.add(getBtIzquierda());
			panelDireccion.add(getLbDerecha());
			panelDireccion.add(getLbRecargar());
			panelDireccion.add(getLbUrl());
		}
		return panelDireccion;
	}

	private JPanel getPanelLogo() {
		if (panelLogo == null) {
			panelLogo = new JPanel();
			panelLogo.setBackground(Color.DARK_GRAY);
			panelLogo.setLayout(new BorderLayout(0, 0));
			panelLogo.add(getLbLogo(), BorderLayout.WEST);
		}
		return panelLogo;
	}

	private void cambiarPanelLogoTienda() {
		getPanelLogo().removeAll();

		if (esEmpresa && company != null) {
			panelLogo.add(getLbLogo(), BorderLayout.WEST);
			JLabel lbLogoBusiness = new JLabel("business");
			lbLogoBusiness.setBorder(new EmptyBorder(15, 0, 0, 0));
			lbLogoBusiness.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBusiness.setBackground(Color.DARK_GRAY);
			lbLogoBusiness.setForeground(Color.WHITE);
			getPanelLogo().add(lbLogoBusiness);
			JLabel lbLogoBienvenida = new JLabel();
			lbLogoBienvenida.setText("Bienvenido, " + company.getName());
			lbLogoBienvenida.setBounds(10, 250, getWidth(), getHeight());
			lbLogoBienvenida.setBorder(new EmptyBorder(5, 0, 0, 15));
			lbLogoBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBienvenida.setBackground(Color.DARK_GRAY);
			lbLogoBienvenida.setForeground(Color.WHITE);
			getPanelLogo().add(lbLogoBienvenida, BorderLayout.EAST);
		}
		if (individualCustomer != null) {
			panelLogo.add(getLbLogo(), BorderLayout.WEST);
			JLabel lbLogoBienvenida = new JLabel();
			lbLogoBienvenida.setText("Bienvenido, " + individualCustomer.getName());
			lbLogoBienvenida.setBounds(10, 250, getWidth(), getHeight());
			lbLogoBienvenida.setBorder(new EmptyBorder(5, 0, 0, 15));
			lbLogoBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBienvenida.setBackground(Color.DARK_GRAY);
			lbLogoBienvenida.setForeground(Color.WHITE);
			getPanelLogo().add(lbLogoBienvenida, BorderLayout.EAST);
		}
		if (individualCustomer == null && !esEmpresa) {
			panelLogo.add(getLbLogo(), BorderLayout.WEST);
		}

	}

	private void cambiarPanelLogoEnvio() {
		getPanelLogoEnvio().removeAll();

		if (individualCustomer != null) {
			panelLogoEnvio.add(getLabel_3(), BorderLayout.WEST);
			JLabel lbLogoBienvenida = new JLabel();
			lbLogoBienvenida.setText("Bienvenido, " + individualCustomer.getName());
			lbLogoBienvenida.setBounds(10, 250, getWidth(), getHeight());
			lbLogoBienvenida.setBorder(new EmptyBorder(5, 0, 0, 15));
			lbLogoBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBienvenida.setBackground(Color.DARK_GRAY);
			lbLogoBienvenida.setForeground(Color.WHITE);
			getPanelLogoEnvio().add(lbLogoBienvenida, BorderLayout.EAST);
		}
		if (individualCustomer == null) {
			panelLogoEnvio.add(getLabel_3(), BorderLayout.WEST);
		}

	}

	private void cambiarPanelLogoComprobacion() {
		getPanelLogoComprobacion().removeAll();
		if (esEmpresa) {
			panelLogoComprobacion.add(getLbShopComprobacion(), BorderLayout.WEST);
			JLabel lbLogoBusiness = new JLabel("business");
			lbLogoBusiness.setBorder(new EmptyBorder(15, 0, 0, 0));
			lbLogoBusiness.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBusiness.setBackground(Color.DARK_GRAY);
			lbLogoBusiness.setForeground(Color.WHITE);
			getPanelLogoComprobacion().add(lbLogoBusiness);
			JLabel lbLogoBienvenida = new JLabel();
			lbLogoBienvenida.setText("Bienvenido, " + company.getName());
			lbLogoBienvenida.setBounds(10, 250, getWidth(), getHeight());
			lbLogoBienvenida.setBorder(new EmptyBorder(5, 0, 0, 15));
			lbLogoBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBienvenida.setBackground(Color.DARK_GRAY);
			lbLogoBienvenida.setForeground(Color.WHITE);
			getPanelLogoComprobacion().add(lbLogoBienvenida, BorderLayout.EAST);
		}
		if (individualCustomer != null) {
			panelLogoComprobacion.add(getLbShopComprobacion(), BorderLayout.WEST);
			JLabel lbLogoBienvenida = new JLabel();
			lbLogoBienvenida.setText("Bienvenido, " + individualCustomer.getName());
			lbLogoBienvenida.setBounds(10, 250, getWidth(), getHeight());
			lbLogoBienvenida.setBorder(new EmptyBorder(5, 0, 0, 15));
			lbLogoBienvenida.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lbLogoBienvenida.setBackground(Color.DARK_GRAY);
			lbLogoBienvenida.setForeground(Color.WHITE);
			getPanelLogoComprobacion().add(lbLogoBienvenida, BorderLayout.EAST);
		}
		if (individualCustomer == null && !esEmpresa) {
			panelLogoComprobacion.add(getLbShopComprobacion(), BorderLayout.WEST);
		}

	}

	public void resetearTienda() {
		esEmpresa = false;
		individualCustomer = null;
		company = null;
		vaciarCarrito();
		getPanelLogo().removeAll();
		getPanelLogo().add(getLbLogo(), BorderLayout.WEST);
		getPanelLogo().repaint();
		cargarCategoriaInicial();
		borrarBotonesNavegacion();

	}

	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo = new JLabel("MyShop");
			lbLogo.setBorder(new EmptyBorder(4, 19, 4, 0));
			lbLogo.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lbLogo.setBackground(Color.DARK_GRAY);
			lbLogo.setForeground(Color.WHITE);
		}
		return lbLogo;
	}

	private JLabel getLbUrl() {
		if (lbUrl == null) {
			lbUrl = new JLabel("  http://www.myshop.es/tienda");
			lbUrl.setPreferredSize(new Dimension(920, 22));
			lbUrl.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbUrl;
	}

	private JButton getBtIzquierda() {
		if (btIzquierda == null) {
			btIzquierda = new JButton("");
			btIzquierda.setBorder(null);
			btIzquierda.setBackground(Color.WHITE);
			btIzquierda.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/iz.jpg")));
		}
		return btIzquierda;
	}

	private JLabel getLbDerecha() {
		if (lbDerecha == null) {
			lbDerecha = new JLabel("");
			lbDerecha.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/de.jpg")));
		}
		return lbDerecha;
	}

	private JLabel getLbRecargar() {
		if (lbRecargar == null) {
			lbRecargar = new JLabel("");
			lbRecargar.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/re.jpg")));
		}
		return lbRecargar;
	}

	private JPanel getPanelIquierda() {
		if (panelIquierda == null) {
			panelIquierda = new JPanel();
			panelIquierda.setBounds(0, 0, 649, 507);
			panelIquierda.setLayout(new BorderLayout(0, 0));
			panelIquierda.add(getPanelNavegacion(), BorderLayout.NORTH);
			panelIquierda.add(getScrollPaneProductos(), BorderLayout.CENTER);
		}
		return panelIquierda;
	}

	private JPanel getPanelDerecha() {
		if (panelDerecha == null) {
			panelDerecha = new JPanel();
			panelDerecha.setBounds(648, 0, 339, 507);
			panelDerecha.setLayout(null);
			panelDerecha.add(getScrollPane());
			panelDerecha.add(getLbTotal());
			panelDerecha.add(getLbTotalTexto());
			panelDerecha.add(getBtContinuarTienda());
			panelDerecha.add(getLbCarrito());
		}
		return panelDerecha;
	}

	private JPanel getPanelNavegacion() {
		if (panelNavegacion == null) {
			panelNavegacion = new JPanel();
			panelNavegacion.setLayout(new BoxLayout(panelNavegacion, BoxLayout.X_AXIS));
			panelNavegacion.setAlignmentX(Component.LEFT_ALIGNMENT);
			panelNavegacion.add(getBtnInicio());
		}
		return panelNavegacion;
	}

	private JScrollPane getScrollPaneProductos() {
		if (scrollPaneProductos == null) {
			scrollPaneProductos = new JScrollPane();
			scrollPaneProductos.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY));
			scrollPaneProductos.setViewportView(getPanelProductos());
		}
		return scrollPaneProductos;
	}

	private JPanel getPanelProductos() {
		if (panelProductos == null) {
			panelProductos = new JPanel();
			panelProductos.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY));
			panelProductos.setLayout(new BoxLayout(panelProductos, BoxLayout.Y_AXIS));
		}
		return panelProductos;
	}

	private void cargarCategoriaInicial() {
		getPanelProductos().removeAll();
		List<Category> catRoot = new ProductsController().getCategorysRoot();
		for (Category c : catRoot) {
			JButton boton = new JButton();
			boton.setText(c.getName());
			boton.setContentAreaFilled(false);
			boton.setBackground(new Color(255, 255, 255));
			boton.setBorder(new EmptyBorder(7, 9, 7, 0));
			getPanelProductos().add(boton);
			boton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cargarCategorias(c.getName());
				}
			});
		}
		adaptarPanel();
	}

	public void adaptarPanel() {
		getPanelProductos().repaint();
		getScrollPaneProductos().setViewportView(getPanelProductos());
		getScrollPaneProductos().repaint();
	}

	public void cargarCategorias(String nombreCat) {

		List<Category> cat = new ProductsController().getCategorysChildren(nombreCat);
		botonesNavegacion(nombreCat);
		if (cat.isEmpty()) {
			JTextField texto = new JTextField();
			texto.setBorder(new EmptyBorder(0, 9, 0, 0));
			texto.setText("Esta categoría no contiene productos.");
			getPanelProductos().removeAll();
			getPanelProductos().add(texto);
		} else {
			getPanelProductos().removeAll();
			for (Category c : cat) {
				JButton boton = new JButton();
				boton.setText(c.getName());
				boton.setContentAreaFilled(false);
				boton.setBackground(new Color(255, 255, 255));
				boton.setBorder(new EmptyBorder(7, 9, 7, 0));
				getPanelProductos().add(boton);
				boton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						List<Product> pro = new ProductsController().getProductsByCategory(c.getName());
						if (pro.isEmpty()) {
							cargarCategorias(c.getName());
						} else {
							botonesNavegacion(c.getName());
							cargarProductos(pro);
						}
						adaptarPanel();
					}
				});
			}
		}
		adaptarPanel();
	}

	public void botonesNavegacion(String nombreCat) {
		JButton b = new JButton();
		b.setText("/ " + nombreCat);
		b.setBorder(null);
		b.setHorizontalAlignment(SwingConstants.CENTER);
		b.setFocusPainted(false);
		b.setContentAreaFilled(false);
		b.setForeground(blue_code);
		b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		b.setBackground(new Color(255, 255, 255));
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Component[] component = getPanelNavegacion().getComponents();
				int posicion = 0;
				int total = component.length;
				for (int i = 0; i < total; i++) {
					if (component[i] instanceof JButton) {
						JButton button = (JButton) component[i];
						if (button.getText().equals(b.getText())) {
							posicion = i;
						}
					}

				}
				int borrar = total - posicion;
				for (int j = 0; j < borrar; j++) {
					getPanelNavegacion().remove(posicion);
				}

				List<Product> pro = new ProductsController().getProductsByCategory(b.getText());
				if (pro.isEmpty()) {
					cargarCategorias(quitarBlancos(b.getText()));
				} else {
					botonesNavegacion(quitarBlancos(b.getText()));
					cargarProductos(pro);
				}
				adaptarPanel();
			}
		});
		getPanelNavegacion().add(b);
		getPanelNavegacion().repaint();
		getPanelNavegacion().revalidate();
	}

	public String quitarBlancos(String texto) {
		return texto.replaceAll("/ ", "");
	}

	public void borrarBotonesNavegacion() {
		getPanelNavegacion().removeAll();
		getPanelNavegacion().add(getBtnInicio());
		getPanelNavegacion().repaint();
		getPanelNavegacion().revalidate();
	}

	public void cargarProductos(List<Product> listaPro) {
		getPanelProductos().removeAll();
		JPanel panelTitulo = new JPanel();
		panelTitulo.setLayout(new GridLayout(1, 4));
		panelTitulo.setBackground(new Color(255, 255, 255));
		panelTitulo.setForeground(new Color(0, 0, 0));
		JLabel labNombreTitulo = new JLabel();
		labNombreTitulo.setForeground(new Color(0, 0, 0));
		labNombreTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labNombreTitulo.setText("Nombre");
		labNombreTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labPrecioTitulo = new JLabel();
		labPrecioTitulo.setForeground(new Color(0, 0, 0));
		labPrecioTitulo.setBorder(new EmptyBorder(9, 9, 9, 0));
		labPrecioTitulo.setText("Precio");
		labPrecioTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labPrecioTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labStockTitulo = new JLabel();
		labStockTitulo.setForeground(new Color(0, 0, 0));
		labStockTitulo.setBorder(new EmptyBorder(9, 9, 9, 0));
		labStockTitulo.setText("Stock");
		labStockTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		labStockTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labAddTitulo = new JLabel();
		labAddTitulo.setForeground(new Color(0, 0, 0));
		labAddTitulo.setBorder(new EmptyBorder(9, 9, 9, 0));
		labAddTitulo.setText("");
		labAddTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		panelTitulo.add(labNombreTitulo);
		panelTitulo.add(labPrecioTitulo);
		panelTitulo.add(labStockTitulo);
		panelTitulo.add(labAddTitulo);
		getPanelProductos().add(panelTitulo);
		
		for (Product p : listaPro) {
			JPanel pan = new JPanel();
			pan.setLayout(new GridLayout(1, 4));
			pan.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));

			
			pan.setBackground(new Color(255, 255, 255));
			pan.setForeground(new Color(0, 0, 0));

			JLabel labNombre = new JLabel();
			labNombre.setForeground(new Color(0, 0, 0));
			labNombre.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			//labNombre.setBorder(new EmptyBorder(9, 9, 9, 0));
			labNombre.setText(p.getName());
			labNombre.setHorizontalAlignment(SwingConstants.CENTER);

			JLabel labPrecio = new JLabel();
			labPrecio.setForeground(new Color(0, 0, 0));
			if (esEmpresa == false) {
				labPrecio.setText(Double.toString(p.getPrice()));
			}
			if (esEmpresa == true) {
				labPrecio.setText(Double.toString(p.getCompanyPrice()));
			}
			labPrecio.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			labPrecio.setHorizontalAlignment(SwingConstants.CENTER);
			if (p.getStock() > 0) {
				JLabel labStock = new JLabel();
				labStock.setForeground(new Color(0, 0, 0));
				labStock.setText(String.valueOf(p.getStock()));
				labStock.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				labStock.setHorizontalAlignment(SwingConstants.CENTER);
				JPanel panAdd = new JPanel();
				panAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panAdd.setBackground(Color.WHITE);
				panAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				JLabel labx = new JLabel();
				labx.setText("x");
				JSpinner spinnerCant = new JSpinner();
				spinnerCant.setModel(new SpinnerNumberModel(1, 1, p.getStock(), 1));
				( (DefaultEditor) spinnerCant.getEditor()).getTextField().setColumns(3);
				( (DefaultEditor) spinnerCant.getEditor()).getTextField().setEditable(false);
				JButton botAdd = new JButton();
				botAdd.setFocusPainted(false);
				botAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				botAdd.setText("Añadir");
				botAdd.setBorder(new LineBorder(blue_code, 1, true));
				botAdd.setForeground(Color.WHITE);
				botAdd.setBackground(blue_code);
				botAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int cod;
						int row = getTable().getRowCount();
						boolean seguir = true;
						if ((row > 0) && (seguir)) {
							for (int i = 0; i < row; i++) {
								cod = (int) table.getValueAt(i, 0);
								if (p.getID() == cod) {
									if (p.getStock() >= (Integer.valueOf( table.getValueAt(i, 2).toString()) + Integer.valueOf(spinnerCant.getValue().toString()))) {
										Object cant = Integer.valueOf(table.getValueAt(i, 2).toString()) + Integer.valueOf(spinnerCant.getValue().toString());
										((DefaultTableModel) getTable().getModel()).setValueAt(cant, i, 2);
										Object pre = (double) redondear(
												(Integer.valueOf(table.getValueAt(i, 2).toString()) * (double) table.getValueAt(i, 3)));
										((DefaultTableModel) getTable().getModel()).setValueAt(pre, i, 4);
										actualizarTotal();
									} else {
										JOptionPane.showMessageDialog(panelContenido,
												"No se pueden añadir tantos artículos.", "Error",
												JOptionPane.ERROR_MESSAGE);
									}
									seguir = false;

								}
								if ((i == (row - 1)) && (seguir)) {
									Object[] nuevaFila = new Object[5];
									nuevaFila[0] = p.getID();
									nuevaFila[1] = p.getName();
									nuevaFila[2] = spinnerCant.getValue();
									if (esEmpresa == false) {
										nuevaFila[3] = p.getPrice();
										nuevaFila[4] = redondear((int)spinnerCant.getValue()*p.getPrice());
									} else {
										nuevaFila[3] = p.getCompanyPrice();
										nuevaFila[4] = redondear((int)spinnerCant.getValue()*p.getCompanyPrice());
									}
									((DefaultTableModel) getTable().getModel()).addRow(nuevaFila);
									actualizarTotal();
								}
							}
						} else {

							Object[] nuevaFila = new Object[5];
							nuevaFila[0] = p.getID();
							nuevaFila[1] = p.getName();
							nuevaFila[2] = spinnerCant.getValue();
							if (esEmpresa == false) {
								nuevaFila[3] = p.getPrice();
								nuevaFila[4] = redondear((int)spinnerCant.getValue()*p.getPrice());
							} else {
								nuevaFila[3] = p.getCompanyPrice();
								nuevaFila[4] = redondear((int)spinnerCant.getValue()*p.getCompanyPrice());
							}

							((DefaultTableModel) getTable().getModel()).addRow(nuevaFila);
							actualizarTotal();
						}
					}
				});
				panAdd.add(spinnerCant);
				panAdd.add(labx);
				panAdd.add(botAdd);
				pan.add(labNombre);
				pan.add(labPrecio);
				pan.add(labStock);
				pan.add(panAdd);
			} else {
				JLabel labStock = new JLabel();
				labStock.setForeground(new Color(0, 0, 0));
				labStock.setForeground(Color.RED);
				labStock.setText("Sin stock");
				labStock.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				labStock.setHorizontalAlignment(SwingConstants.CENTER);
				JPanel panAdd = new JPanel();
				panAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				panAdd.setBackground(Color.WHITE);
				panAdd.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
				JLabel labVacia = new JLabel("");
				labVacia.setBorder(new EmptyBorder(10, 0, 10, 0));
				panAdd.add(labVacia);
				pan.add(labNombre);
				pan.add(labPrecio);
				pan.add(labStock);
				pan.add(panAdd);
			}

			getPanelProductos().add(pan);

		}

	}

	private void actualizarTotal() {
		double total = 0;
		int filas = table.getRowCount();
		for (int i = 0; i < filas; i++) {
			total = total + (double) (table.getValueAt(i, 4));
		}
		lbTotalTexto.setText(Double.toString((redondear(total))));
	}

	private double redondear(double cifra) {

		return BigDecimal.valueOf(cifra).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	private JButton getBtnInicio() {
		if (BtnInicio == null) {
			BtnInicio = new JButton("Inicio");
			BtnInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					cargarCategoriaInicial();
					borrarBotonesNavegacion();
				}
			});
			BtnInicio.setForeground(blue_code);
			BtnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			BtnInicio.setFocusPainted(false);
			BtnInicio.setBorder(new EmptyBorder(9, 0, 9, 0));
			BtnInicio.setContentAreaFilled(false);
		}
		return BtnInicio;
	}

	private JPanel getInicio() {
		if (Inicio == null) {
			Inicio = new JPanel();
			Inicio.setLayout(new BorderLayout(0, 0));
			Inicio.add(getPanelSuperiorInicio(), BorderLayout.NORTH);
			Inicio.add(getPanelContenidoInicio(), BorderLayout.CENTER);
		}
		return Inicio;
	}

	private JPanel getPanelSuperiorInicio() {
		if (panelSuperiorInicio == null) {
			panelSuperiorInicio = new JPanel();
			panelSuperiorInicio.setLayout(new BorderLayout(0, 0));
			panelSuperiorInicio.add(getPanelDireccionInicio(), BorderLayout.NORTH);
			panelSuperiorInicio.add(getPanelLogoInicio(), BorderLayout.SOUTH);
		}
		return panelSuperiorInicio;
	}

	private JPanel getPanelDireccionInicio() {
		if (panelDireccionInicio == null) {
			panelDireccionInicio = new JPanel();
			panelDireccionInicio.setBackground(Color.WHITE);
			panelDireccionInicio.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelDireccionInicio.add(getBtIzquierdaInicio());
			panelDireccionInicio.add(getLbDerechaInicio());
			panelDireccionInicio.add(getLbRecargarInicio());
			panelDireccionInicio.add(getLbUrlInicio());
		}
		return panelDireccionInicio;
	}

	private JButton getBtIzquierdaInicio() {
		if (btIzquierdaInicio == null) {
			btIzquierdaInicio = new JButton("");
			btIzquierdaInicio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/iz.jpg")));
			btIzquierdaInicio.setBorder(null);
			btIzquierdaInicio.setBackground(Color.WHITE);
		}
		return btIzquierdaInicio;
	}

	private JLabel getLbDerechaInicio() {
		if (lbDerechaInicio == null) {
			lbDerechaInicio = new JLabel("");
			lbDerechaInicio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/de.jpg")));
		}
		return lbDerechaInicio;
	}

	private JLabel getLbRecargarInicio() {
		if (lbRecargarInicio == null) {
			lbRecargarInicio = new JLabel("");
			lbRecargarInicio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/re.jpg")));
		}
		return lbRecargarInicio;
	}

	private JLabel getLbUrlInicio() {
		if (lbUrlInicio == null) {
			lbUrlInicio = new JLabel("  http://www.myshop.es/login");
			lbUrlInicio.setPreferredSize(new Dimension(920, 22));
			lbUrlInicio.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbUrlInicio;
	}

	private JPanel getPanelLogoInicio() {
		if (panelLogoInicio == null) {
			panelLogoInicio = new JPanel();
			panelLogoInicio.setBackground(Color.DARK_GRAY);
			panelLogoInicio.setLayout(new BorderLayout(0, 0));
			panelLogoInicio.add(getLbLogoInicio(), BorderLayout.NORTH);
		}
		return panelLogoInicio;
	}

	private JLabel getLbLogoInicio() {
		if (lbLogoInicio == null) {
			lbLogoInicio = new JLabel("MyShop");
			lbLogoInicio.setForeground(Color.WHITE);
			lbLogoInicio.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lbLogoInicio.setBorder(new EmptyBorder(4, 19, 4, 0));
			lbLogoInicio.setBackground(Color.DARK_GRAY);
		}
		return lbLogoInicio;
	}

	private JSplitPane getPanelContenidoInicio() {
		if (panelContenidoInicio == null) {
			panelContenidoInicio = new JSplitPane();
			panelContenidoInicio.setResizeWeight(.5d);
			panelContenidoInicio.setEnabled(false);
			panelContenidoInicio.setLeftComponent(getPanelIzquierdaInicio());
			panelContenidoInicio.setRightComponent(getPanelDerechaInicio());
		}
		return panelContenidoInicio;
	}

	private JPanel getPanelIzquierdaInicio() {
		if (panelIzquierdaInicio == null) {
			panelIzquierdaInicio = new JPanel();
			panelIzquierdaInicio.setLayout(null);
			panelIzquierdaInicio.add(getLbParticularesInicio());
			panelIzquierdaInicio.add(getTxtUsuarioRegistradosInicio());
			panelIzquierdaInicio.add(getPasswordFieldRegistradosInicio());
			panelIzquierdaInicio.add(getBtEntrarRegistradosInicio());
		}
		return panelIzquierdaInicio;
	}

	private JPanel getPanelDerechaInicio() {
		if (panelDerechaInicio == null) {
			panelDerechaInicio = new JPanel();
			panelDerechaInicio.setLayout(null);
			panelDerechaInicio.add(getLblAccesoSinRegistro());
			panelDerechaInicio.add(getBtnEntrar());
		}
		return panelDerechaInicio;
	}

	private JLabel getLbParticularesInicio() {
		if (lbParticularesInicio == null) {
			lbParticularesInicio = new JLabel("Clientes registrados");
			lbParticularesInicio.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lbParticularesInicio.setForeground(Color.DARK_GRAY);
			lbParticularesInicio.setBounds(124, 118, 224, 49);
		}
		return lbParticularesInicio;
	}

	private JTextField getTxtUsuarioRegistradosInicio() {
		if (txtUsuarioRegistradosInicio == null) {
			txtUsuarioRegistradosInicio = new JTextField();
			txtUsuarioRegistradosInicio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					txtUsuarioRegistradosInicio.setText("");
					txtUsuarioRegistradosInicio.setForeground(Color.BLACK);
				}
			});
			txtUsuarioRegistradosInicio.setForeground(Color.LIGHT_GRAY);
			txtUsuarioRegistradosInicio.setHorizontalAlignment(SwingConstants.CENTER);
			txtUsuarioRegistradosInicio.setText("Usuario");
			txtUsuarioRegistradosInicio.setBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
			txtUsuarioRegistradosInicio.setBounds(152, 254, 155, 23);
			txtUsuarioRegistradosInicio.setColumns(10);
		}
		return txtUsuarioRegistradosInicio;
	}

	private JPasswordField getPasswordFieldRegistradosInicio() {
		if (passwordFieldRegistradosInicio == null) {
			passwordFieldRegistradosInicio = new JPasswordField();
			passwordFieldRegistradosInicio.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					passwordFieldRegistradosInicio.setText("");
					passwordFieldRegistradosInicio.setForeground(Color.BLACK);
					passwordFieldRegistradosInicio.setEchoChar('*');
				}
			});
			passwordFieldRegistradosInicio.setForeground(Color.LIGHT_GRAY);
			passwordFieldRegistradosInicio.setHorizontalAlignment(SwingConstants.CENTER);
			passwordFieldRegistradosInicio.setEchoChar((char) 0);
			passwordFieldRegistradosInicio.setText("Contraseña");
			passwordFieldRegistradosInicio.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
			passwordFieldRegistradosInicio.setBounds(152, 276, 132, 23);
		}
		return passwordFieldRegistradosInicio;
	}

	private JButton getBtEntrarRegistradosInicio() {
		if (btEntrarRegistradosInicio == null) {
			btEntrarRegistradosInicio = new JButton("");
			btEntrarRegistradosInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					company = null;
					individualCustomer = null;
					UsersController uc = new UsersController();
					IndividualCustomer ic = uc.getCustomerData(getTxtUsuarioRegistradosInicio().getText(),
							getPasswordFieldRegistradosInicio().getPassword());
					if (ic == null) {
						Company co = uc.getCompany(getTxtUsuarioRegistradosInicio().getText(),
								getPasswordFieldRegistradosInicio().getPassword());
						if (co == null) {
							JOptionPane.showMessageDialog(panelIzquierdaInicio,
									"El usuario o la contraseña no existen.", "Error", JOptionPane.ERROR_MESSAGE);
							actualizarTextoRegistro();
						}
						esEmpresa = true;
						company = co;
						vaciarCarrito();
						cargarCategoriaInicial();
						borrarBotonesNavegacion();
						cambiarPanelLogoTienda();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelTiendaInicio");
					}
					if (ic != null) {
						esEmpresa = false;
						individualCustomer = ic;
						vaciarCarrito();
						cargarCategoriaInicial();
						borrarBotonesNavegacion();
						cambiarPanelLogoTienda();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelTiendaInicio");
					}
				}
			});
			btEntrarRegistradosInicio.setBackground(Color.WHITE);
			btEntrarRegistradosInicio.setIcon(
					new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/flechaAzul.jpg")));
			btEntrarRegistradosInicio.setBounds(282, 276, 25, 23);
			btEntrarRegistradosInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		}
		return btEntrarRegistradosInicio;
	}

	private void actualizarTextoRegistro() {

		txtUsuarioRegistradosInicio.setForeground(Color.LIGHT_GRAY);
		txtUsuarioRegistradosInicio.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsuarioRegistradosInicio.setText("Usuario");
		passwordFieldRegistradosInicio.setForeground(Color.LIGHT_GRAY);
		passwordFieldRegistradosInicio.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldRegistradosInicio.setEchoChar((char) 0);
		passwordFieldRegistradosInicio.setText("Contraseña");
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane
					.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(64, 64, 64), new Color(192, 192, 192)));
			scrollPane.setBounds(10, 33, 329, 290);
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
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

	private void vaciarCarrito() {
		DefaultTableModel modeloTabla = (DefaultTableModel) table.getModel();
		modeloTabla.setRowCount(0);
		getTable().removeAll();
		getTable().repaint();
		getTable().revalidate();
		lbTotalTexto.setText("0");
	}
	private void vaciarComprobacion() {
		DefaultTableModel modeloTabla = (DefaultTableModel) tableComprobacion.getModel();
		modeloTabla.setRowCount(0);
		getTable().removeAll();
		getTable().repaint();
		getTable().revalidate();
	}

	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("Total:");
			lbTotal.setBounds(124, 399, 46, 14);
		}
		return lbTotal;
	}

	private JLabel getLbTotalTexto() {
		if (lbTotalTexto == null) {
			lbTotalTexto = new JLabel("0");
			lbTotalTexto.setBounds(180, 399, 73, 14);
		}
		return lbTotalTexto;
	}

	private JButton getBtContinuarTienda() {
		if (btContinuarTienda == null) {
			btContinuarTienda = new JButton("Comprar");
			btContinuarTienda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (table.getRowCount() != 0) {
						if (comprobarStock()) {
							treeMap = new TreeMap<Object, Object>();
							for (int i = 0; i < table.getRowCount(); i++) {
								treeMap.put(table.getValueAt(i, 0), table.getValueAt(i, 2));
							}
							if (individualCustomer != null && esEmpresa == false) {
								txtNombre.setEditable(false);
								txtNombre.setText(individualCustomer.getName());
								txtApellidos.setEditable(false);
								txtApellidos.setText(individualCustomer.getSurname());
								txtDireccion.setEditable(false);
								txtDireccion.setText(individualCustomer.getAddress().getStreet());
								txtCiudad.setEditable(false);
								txtCiudad.setText(individualCustomer.getAddress().getCity());
								txtPostal.setEditable(false);
								txtPostal.setText(individualCustomer.getAddress().getCip_code());
								txtProvincia.setEditable(false);
								txtProvincia.setText(individualCustomer.getAddress().getState());
								getLbContrareembolso()
										.setText("El transportista contactará con usted para entregar el paquete. "
												+ "Tenga preparados los " + lbTotalTexto.getText()
												+ "\u20AC para abonárselos a él en efectivo.");
								getLbTextoTransferencia().setText(
										"Debe realizar un ingreso de " + lbTotalTexto.getText() + "\u20AC en la"
												+ " cuenta 1245-4145-82-7154325135 indicando como concepto REF"
												+ new Random().nextInt(10000));
								cambiarPanelLogoEnvio();
								CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
								cardLayout.show(contentPane, "panelEnvio");
							}
							if (individualCustomer == null && esEmpresa == false) {
								txtNombre.setEditable(true);
								txtApellidos.setEditable(true);
								txtDireccion.setEditable(true);
								txtCiudad.setEditable(true);
								txtPostal.setEditable(true);
								txtProvincia.setEditable(true);
								getLbContrareembolso()
										.setText("El transportista contactará con usted para entregar el paquete. "
												+ "Tenga preparados los " + lbTotalTexto.getText()
												+ "\u20AC para abonárselos a él en efectivo.");
								getLbTextoTransferencia().setText(
										"Debe realizar un ingreso de " + lbTotalTexto.getText() + "\u20AC en la"
												+ " cuenta 1245-4145-82-7154325135 indicando como concepto REF"
												+ new Random().nextInt(10000));
								cambiarPanelLogoEnvio();
								CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
								cardLayout.show(contentPane, "panelEnvio");
							}
							if (company != null && esEmpresa == true) {
								vaciarComprobacion();
								ProductsController pc = new ProductsController();
								double totalSinIva=0.0;
								double impuestos=0.0;
								double total=0.0;
								int iva=0;
								for (int i = 0; i < table.getRowCount(); i++) {
									iva= pc.getIvaPorRef((int)table.getValueAt(i, 0));
									int cantidad = (int)table.getValueAt(i, 2);
									double imp = ((double)table.getValueAt(i, 3)*(iva/100.0f));
									double pu = ((double)table.getValueAt(i, 3))-(imp);
									double st = pu*cantidad;
									Object[] nuevaFila = new Object[6];
									nuevaFila[0] = table.getValueAt(i, 1);
									nuevaFila[1] = redondear(pu);
									nuevaFila[2] = cantidad;
									nuevaFila[3] = redondear(st);
									nuevaFila[4] = iva;
									nuevaFila[5] = redondear(st+(imp*cantidad));
									((DefaultTableModel) getTableComprobacion().getModel()).addRow(nuevaFila);
									totalSinIva = totalSinIva + st;
									impuestos=impuestos+imp;
									total = total + (st+(imp*cantidad));
									
								}
								lbSubtotalTexto.setText(
										Double.toString(redondear(totalSinIva)));
								lbImpuestosText
										.setText(Double.toString(redondear(total-totalSinIva)));
								lbTotalComprobacionTexto.setText(Double.toString(redondear(total)));
								lbPersonaComprobacion
										.setText("Facturado a: " + company.getName());
								cambiarPanelLogoComprobacion();
								CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
								cardLayout.show(contentPane, "panelComprobacion");
							}
						}
						if (!comprobarStock()) {
							JOptionPane.showMessageDialog(panelDerecha,
									"Hay un problema con el stock. Por favor, revise su pedido.", "Error",
									JOptionPane.ERROR_MESSAGE);
							products = new ProductsController().getAll();
							cargarCategoriaInicial();
							CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
							cardLayout.show(contentPane, "panelTiendaInicio");

						}
					}
				}
			});
			btContinuarTienda.setBorder(new LineBorder(blue_code, 1, true));
			btContinuarTienda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btContinuarTienda.setForeground(Color.WHITE);
			btContinuarTienda.setBackground(blue_code);
			btContinuarTienda.setBounds(72, 467, 210, 29);
		}
		return btContinuarTienda;
	}

	private JPanel getEnvio() {
		if (Envio == null) {
			Envio = new JPanel();
			Envio.setLayout(new BorderLayout(0, 0));
			Envio.add(getPanelSuperiorEnvio(), BorderLayout.NORTH);
			Envio.add(getPanelContenidoEnvio(), BorderLayout.CENTER);
		}
		return Envio;
	}

	private JPanel getPanelSuperiorEnvio() {
		if (panelSuperiorEnvio == null) {
			panelSuperiorEnvio = new JPanel();
			panelSuperiorEnvio.setLayout(new BorderLayout(0, 0));
			panelSuperiorEnvio.add(getPanelDireccionEnvio(), BorderLayout.NORTH);
			panelSuperiorEnvio.add(getPanelLogoEnvio(), BorderLayout.SOUTH);
		}
		return panelSuperiorEnvio;
	}

	private JPanel getPanelDireccionEnvio() {
		if (panelDireccionEnvio == null) {
			panelDireccionEnvio = new JPanel();
			panelDireccionEnvio.setBackground(Color.WHITE);
			panelDireccionEnvio.add(getBtIzquierdaEnvio());
			panelDireccionEnvio.add(getLbDerechaEnvio());
			panelDireccionEnvio.add(getLbRecargarEnvio());
			panelDireccionEnvio.add(getLbUrlEnvio());
		}
		return panelDireccionEnvio;
	}

	private JButton getBtIzquierdaEnvio() {
		if (btIzquierdaEnvio == null) {
			btIzquierdaEnvio = new JButton("");
			btIzquierdaEnvio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/iz.jpg")));
			btIzquierdaEnvio.setBorder(null);
			btIzquierdaEnvio.setBackground(Color.WHITE);
		}
		return btIzquierdaEnvio;
	}

	private JLabel getLbDerechaEnvio() {
		if (lbDerechaEnvio == null) {
			lbDerechaEnvio = new JLabel("");
			lbDerechaEnvio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/de.jpg")));
		}
		return lbDerechaEnvio;
	}

	private JLabel getLbRecargarEnvio() {
		if (lbRecargarEnvio == null) {
			lbRecargarEnvio = new JLabel("");
			lbRecargarEnvio
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/re.jpg")));
		}
		return lbRecargarEnvio;
	}

	private JLabel getLbUrlEnvio() {
		if (lbUrlEnvio == null) {
			lbUrlEnvio = new JLabel("  http://www.myshop.es/envio-pago");
			lbUrlEnvio.setPreferredSize(new Dimension(920, 22));
			lbUrlEnvio.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbUrlEnvio;
	}

	private JPanel getPanelLogoEnvio() {
		if (panelLogoEnvio == null) {
			panelLogoEnvio = new JPanel();
			panelLogoEnvio.setBackground(Color.DARK_GRAY);
			panelLogoEnvio.setLayout(new BorderLayout(0, 0));
			panelLogoEnvio.add(getLabel_3(), BorderLayout.NORTH);
		}
		return panelLogoEnvio;
	}

	private JLabel getLabel_3() {
		if (lbShopEnvio == null) {
			lbShopEnvio = new JLabel("MyShop");
			lbShopEnvio.setForeground(Color.WHITE);
			lbShopEnvio.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lbShopEnvio.setBorder(new EmptyBorder(4, 19, 4, 0));
			lbShopEnvio.setBackground(Color.DARK_GRAY);
		}
		return lbShopEnvio;
	}

	private JPanel getPanelContenidoEnvio() {
		if (panelContenidoEnvio == null) {
			panelContenidoEnvio = new JPanel();
			panelContenidoEnvio.setBorder(null);
			panelContenidoEnvio.setLayout(new GridLayout(2, 1, 0, 0));
			panelContenidoEnvio.add(getPanelDatos());
			panelContenidoEnvio.add(getPanelPago());
		}
		return panelContenidoEnvio;
	}

	private JPanel getPanelPago() {
		if (panelPago == null) {
			panelPago = new JPanel();
			panelPago.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.DARK_GRAY, Color.LIGHT_GRAY));
			panelPago.setLayout(null);
			panelPago.add(getLbDatosPago());
			panelPago.add(getPanelMetodoPago());
			panelPago.add(getBtComprobar());
			panelPago.add(getRbTarjeta());
			panelPago.add(getRbTransferencia());
			panelPago.add(getRbContrareembolso());
		}
		return panelPago;
	}

	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.DARK_GRAY, Color.LIGHT_GRAY));
			panelDatos.setLayout(null);
			panelDatos.add(getLbDatosEnvio());
			panelDatos.add(getLbNombre());
			panelDatos.add(getLbApellidos());
			panelDatos.add(getTxtNombre());
			panelDatos.add(getTxtApellidos());
			panelDatos.add(getLbDireccion());
			panelDatos.add(getTxtDireccion());
			panelDatos.add(getLbCiudad());
			panelDatos.add(getTxtCiudad());
			panelDatos.add(getLbPostal());
			panelDatos.add(getTxtPostal());
			panelDatos.add(getLbProvincia());
			panelDatos.add(getTxtProvincia());
			panelDatos.add(getLbMetodosEnvio());
			panelDatos.add(getRdbtn24());
			panelDatos.add(getRdbtn48());
			panelDatos.add(getRdbtn5());
		}
		return panelDatos;
	}

	private JLabel getLbDatosEnvio() {
		if (lbDatosEnvio == null) {
			lbDatosEnvio = new JLabel("Datos de envío");
			lbDatosEnvio.setForeground(Color.DARK_GRAY);
			lbDatosEnvio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbDatosEnvio.setBounds(50, 11, 103, 22);
		}
		return lbDatosEnvio;
	}

	private JLabel getLbDatosPago() {
		if (lbDatosPago == null) {
			lbDatosPago = new JLabel("Datos de pago");
			lbDatosPago.setForeground(Color.DARK_GRAY);
			lbDatosPago.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbDatosPago.setBounds(50, 11, 103, 22);
		}
		return lbDatosPago;
	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre:");
			lbNombre.setBounds(89, 44, 77, 14);
		}
		return lbNombre;
	}

	private JLabel getLbApellidos() {
		if (lbApellidos == null) {
			lbApellidos = new JLabel("Apellidos:");
			lbApellidos.setBounds(268, 44, 77, 14);
		}
		return lbApellidos;
	}

	private JTextField getTxtNombre() {
		if (txtNombre == null) {
			txtNombre = new JTextField();
			txtNombre.setText("");
			txtNombre.setBounds(89, 69, 137, 20);
			txtNombre.setColumns(10);
		}
		return txtNombre;
	}

	private JTextField getTxtApellidos() {
		if (txtApellidos == null) {
			txtApellidos = new JTextField();
			txtApellidos.setText("");
			txtApellidos.setColumns(10);
			txtApellidos.setBounds(268, 69, 199, 20);
		}
		return txtApellidos;
	}

	private JLabel getLbDireccion() {
		if (lbDireccion == null) {
			lbDireccion = new JLabel("Dirección:");
			lbDireccion.setBounds(511, 44, 77, 14);
		}
		return lbDireccion;
	}

	private JTextField getTxtDireccion() {
		if (txtDireccion == null) {
			txtDireccion = new JTextField();
			txtDireccion.setText("");
			txtDireccion.setColumns(10);
			txtDireccion.setBounds(511, 69, 384, 20);
		}
		return txtDireccion;
	}

	private JLabel getLbCiudad() {
		if (lbCiudad == null) {
			lbCiudad = new JLabel("Ciudad:");
			lbCiudad.setBounds(268, 100, 77, 14);
		}
		return lbCiudad;
	}

	private JTextField getTxtCiudad() {
		if (txtCiudad == null) {
			txtCiudad = new JTextField();
			txtCiudad.setText("");
			txtCiudad.setColumns(10);
			txtCiudad.setBounds(268, 125, 199, 20);
		}
		return txtCiudad;
	}

	private JLabel getLbPostal() {
		if (lbPostal == null) {
			lbPostal = new JLabel("Código postal:");
			lbPostal.setBounds(89, 100, 86, 14);
		}
		return lbPostal;
	}

	private JTextField getTxtPostal() {
		if (txtPostal == null) {
			txtPostal = new JTextField();
			txtPostal.setText("");
			txtPostal.setColumns(10);
			txtPostal.setBounds(89, 125, 137, 20);
		}
		return txtPostal;
	}

	private JLabel getLbProvincia() {
		if (lbProvincia == null) {
			lbProvincia = new JLabel("Provincia:");
			lbProvincia.setBounds(511, 100, 77, 14);
		}
		return lbProvincia;
	}

	private JTextField getTxtProvincia() {
		if (txtProvincia == null) {
			txtProvincia = new JTextField();
			txtProvincia.setText("");
			txtProvincia.setColumns(10);
			txtProvincia.setBounds(511, 125, 158, 20);
		}
		return txtProvincia;
	}

	private JPanel getPanelMetodoPago() {
		if (panelMetodoPago == null) {
			panelMetodoPago = new JPanel();
			panelMetodoPago.setBounds(95, 79, 795, 115);
			panelMetodoPago.setLayout(new CardLayout(0, 0));
			panelMetodoPago.add(getPanelTarjeta(), "panelTarjeta");
			panelMetodoPago.add(getPanelTransferencia(), "panelTransferencia");
			panelMetodoPago.add(getPanelContrareembolso(), "panelContrareembolso");
		}
		return panelMetodoPago;
	}

	private JButton getBtComprobar() {
		if (btComprobar == null) {
			btComprobar = new JButton("Comprobar compra");
			btComprobar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (comprobarDatos() && comprobarStock()) {
						ProductsController pc = new ProductsController();
						double totalSinIva=0.0;
						double impuestos=0.0;
						double total=0.0;
						int iva=0;
						for (int i = 0; i < table.getRowCount(); i++) {
							iva= pc.getIvaPorRef((int)table.getValueAt(i, 0));
							int cantidad = (int)table.getValueAt(i, 2);
							double imp = ((double)table.getValueAt(i, 3)*(iva/100.0f));
							double pu = ((double)table.getValueAt(i, 3))-(imp);
							double st = pu*cantidad;
							Object[] nuevaFila = new Object[6];
							nuevaFila[0] = table.getValueAt(i, 1);
							nuevaFila[1] = redondear(pu);
							nuevaFila[2] = cantidad;
							nuevaFila[3] = redondear(st);
							nuevaFila[4] = iva;
							nuevaFila[5] = redondear(st+(imp*cantidad));
							((DefaultTableModel) getTableComprobacion().getModel()).addRow(nuevaFila);
							totalSinIva = totalSinIva + st;
							impuestos=impuestos+imp;
							total = total + (st+(imp*cantidad));
						
						}
						lbSubtotalTexto.setText(
								Double.toString(redondear(totalSinIva)));
						lbImpuestosText
								.setText(Double.toString(redondear(total-totalSinIva)));
						lbTotalComprobacionTexto.setText(Double.toString(redondear(total)));
						lbDireccionComprobacion
								.setText("Enviado a: " + txtDireccion.getText() + ", " + txtCiudad.getText());
						lbMetodoComprobacion.setText("Método de pago: " + getSelectedButtonText(buttonGroup));
						lbPersonaComprobacion
								.setText("Facturado a: " + txtNombre.getText() + " " + txtApellidos.getText());
						lbTipoEnvio
						.setText("Tipo de envío: " + getSelectedButtonText(buttonGroup_1));
						cambiarPanelLogoComprobacion();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelComprobacion");
					}
					if (!comprobarStock()) {
						JOptionPane.showMessageDialog(panelDerecha,
								"Hay un problema con el stock. Por favor, revise su pedido.", "Error",
								JOptionPane.ERROR_MESSAGE);
						products = new ProductsController().getAll();
						cargarCategoriaInicial();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelTiendaInicio");

					}
				}
			});
			btComprobar.setBorder(new LineBorder(blue_code, 1, true));
			btComprobar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			btComprobar.setForeground(Color.WHITE);
			btComprobar.setBackground(blue_code);
			btComprobar.setBounds(780, 213, 148, 29);
		}
		return btComprobar;
	}

	private boolean comprobarDatos() {
		StringBuilder textoError = new StringBuilder();
		if (!txtNombre.getText().matches("^[ A-z]+$")) {
			textoError.append("El nombre solo puede contener letras." + newline);

		}
		if (!txtApellidos.getText().matches("^[ A-z]+$")) {
			textoError.append("Los apellidos solo pueden contener letras." + newline);

		}
		if (!txtCiudad.getText().matches("^[ A-z]+$")) {
			textoError.append("La ciudad solo puede contener letras." + newline);

		}
		if (!txtProvincia.getText().matches("^[ A-z]+$")) {
			textoError.append("La provincia solo puede contener letras." + newline);
		}
		if (!(txtPostal.getText().matches("[0-9]+") && (txtPostal.getText().length() == 5))) {
			textoError.append("El código postal tiene que ser 5 números." + newline);

		}
		if (txtNombre.getText().isEmpty() || txtApellidos.getText().isEmpty() || txtCiudad.getText().isEmpty()
				|| txtProvincia.getText().isEmpty() || txtPostal.getText().isEmpty()
				|| txtDireccion.getText().isEmpty()) {
			textoError.append("No puede haber campos vacíos." + newline);

		}

		if (getSelectedButtonText(buttonGroup).equals("Tarjeta")) {
			if (!txtNombreTitular.getText().matches("^[ A-z]+$")) {
				textoError.append("El nombre del titular solo puede contener letras." + newline);
			}
			if (!(txtNumero.getText().matches("[0-9]+") && (txtNumero.getText().length() == 20))) {
				textoError.append("El n��mero de la tarjeta tienen que ser 20 caracteres num��ricos." + newline);
			}
			if (!(txtCvc.getText().matches("[0-9]+") && (txtCvc.getText().length() == 3))) {
				textoError.append("El CVC de la tarjeta tienen que ser 3 caracteres num��ricos." + newline);
			}
			Date fechaTarjeta = (Date) spinnerFecha.getValue();
			Date fechaHoy = new Date();
			if (fechaTarjeta.after(fechaHoy)) {
				textoError.append("La tarjeta no tiene una fecha v��lida." + newline);
			}

		}
		if (textoError.length() > 0) {
			JOptionPane.showMessageDialog(Envio, textoError.toString(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}

		return true;

	}

	private JPanel getPanelTarjeta() {
		if (panelTarjeta == null) {
			panelTarjeta = new JPanel();
			panelTarjeta.setLayout(null);
			panelTarjeta.add(getLbNombreTitular());
			panelTarjeta.add(getLbNumero());
			panelTarjeta.add(getLbCvc());
			panelTarjeta.add(getTxtNombreTitular());
			panelTarjeta.add(getTxtNumero());
			panelTarjeta.add(getTxtCvc());
			panelTarjeta.add(getLbFecha());
			panelTarjeta.add(getSpinnerFecha());
		}
		return panelTarjeta;
	}

	private JLabel getLbNombreTitular() {
		if (lbNombreTitular == null) {
			lbNombreTitular = new JLabel("Nombre titular:");
			lbNombreTitular.setBounds(49, 29, 95, 14);
		}
		return lbNombreTitular;
	}

	private JLabel getLbNumero() {
		if (lbNumero == null) {
			lbNumero = new JLabel("Nº tarjeta:");
			lbNumero.setBounds(267, 29, 95, 14);
		}
		return lbNumero;
	}

	private JLabel getLbCvc() {
		if (lbCvc == null) {
			lbCvc = new JLabel("CVC:");
			lbCvc.setBounds(624, 29, 95, 14);
		}
		return lbCvc;
	}

	private JTextField getTxtNombreTitular() {
		if (txtNombreTitular == null) {
			txtNombreTitular = new JTextField();
			txtNombreTitular.setBounds(49, 54, 177, 20);
			txtNombreTitular.setColumns(10);
		}
		return txtNombreTitular;
	}

	private JTextField getTxtNumero() {
		if (txtNumero == null) {
			txtNumero = new JTextField();
			txtNumero.setColumns(10);
			txtNumero.setBounds(264, 54, 188, 20);
		}
		return txtNumero;
	}

	private JTextField getTxtCvc() {
		if (txtCvc == null) {
			txtCvc = new JTextField();
			txtCvc.setColumns(10);
			txtCvc.setBounds(624, 54, 72, 20);
		}
		return txtCvc;
	}

	private JPanel getPanelTransferencia() {
		if (panelTransferencia == null) {
			panelTransferencia = new JPanel();
			panelTransferencia.setLayout(null);
			panelTransferencia.add(getLbTextoTransferencia());
		}
		return panelTransferencia;
	}

	private JLabel getLbTextoTransferencia() {
		if (lbTextoTransferencia == null) {
			lbTextoTransferencia = new JLabel("");
			lbTextoTransferencia.setBounds(52, 42, 674, 28);
		}
		return lbTextoTransferencia;
	}

	private JPanel getPanelContrareembolso() {
		if (panelContrareembolso == null) {
			panelContrareembolso = new JPanel();
			panelContrareembolso.setLayout(null);
			panelContrareembolso.add(getLbContrareembolso());
		}
		return panelContrareembolso;
	}

	private JPanel getComprobacion() {
		if (Comprobacion == null) {
			Comprobacion = new JPanel();
			Comprobacion.setLayout(new BorderLayout(0, 0));
			Comprobacion.add(getPanelSuperiorComprobacion(), BorderLayout.NORTH);
			Comprobacion.add(getPanelContenidoComprobacion(), BorderLayout.CENTER);
		}
		return Comprobacion;
	}

	private JPanel getPanelSuperiorComprobacion() {
		if (panelSuperiorComprobacion == null) {
			panelSuperiorComprobacion = new JPanel();
			panelSuperiorComprobacion.setLayout(new BorderLayout(0, 0));
			panelSuperiorComprobacion.add(getPanelDireccionComprobacion(), BorderLayout.NORTH);
			panelSuperiorComprobacion.add(getPanelLogoComprobacion(), BorderLayout.SOUTH);
		}
		return panelSuperiorComprobacion;
	}

	private JPanel getPanelDireccionComprobacion() {
		if (panelDireccionComprobacion == null) {
			panelDireccionComprobacion = new JPanel();
			panelDireccionComprobacion.setBackground(Color.WHITE);
			panelDireccionComprobacion.add(getBtIzquierdaComprobacion());
			panelDireccionComprobacion.add(getLbDerechaComprobacion());
			panelDireccionComprobacion.add(getLbRecargarComprobacion());
			panelDireccionComprobacion.add(getLabel_3_1());
		}
		return panelDireccionComprobacion;
	}

	private JButton getBtIzquierdaComprobacion() {
		if (btIzquierdaComprobacion == null) {
			btIzquierdaComprobacion = new JButton("");
			btIzquierdaComprobacion
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/iz.jpg")));
			btIzquierdaComprobacion.setBorder(null);
			btIzquierdaComprobacion.setBackground(Color.WHITE);
		}
		return btIzquierdaComprobacion;
	}

	private JLabel getLbDerechaComprobacion() {
		if (lbDerechaComprobacion == null) {
			lbDerechaComprobacion = new JLabel("");
			lbDerechaComprobacion
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/de.jpg")));
		}
		return lbDerechaComprobacion;
	}

	private JLabel getLbRecargarComprobacion() {
		if (lbRecargarComprobacion == null) {
			lbRecargarComprobacion = new JLabel("");
			lbRecargarComprobacion
					.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/com/myshop/store/igu/img/re.jpg")));
		}
		return lbRecargarComprobacion;
	}

	private JLabel getLabel_3_1() {
		if (lbUrlComprobacion == null) {
			lbUrlComprobacion = new JLabel("  http://www.myshop.es/check");
			lbUrlComprobacion.setPreferredSize(new Dimension(920, 22));
			lbUrlComprobacion.setBorder(new LineBorder(new Color(0, 0, 0)));
		}
		return lbUrlComprobacion;
	}

	private JPanel getPanelLogoComprobacion() {
		if (panelLogoComprobacion == null) {
			panelLogoComprobacion = new JPanel();
			panelLogoComprobacion.setBackground(Color.DARK_GRAY);
			panelLogoComprobacion.setLayout(new BorderLayout(0, 0));
			panelLogoComprobacion.add(getLbShopComprobacion(), BorderLayout.NORTH);
		}
		return panelLogoComprobacion;
	}

	private JLabel getLbShopComprobacion() {
		if (lbShopComprobacion == null) {
			lbShopComprobacion = new JLabel("MyShop");
			lbShopComprobacion.setForeground(Color.WHITE);
			lbShopComprobacion.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lbShopComprobacion.setBorder(new EmptyBorder(4, 19, 4, 0));
			lbShopComprobacion.setBackground(Color.DARK_GRAY);
		}
		return lbShopComprobacion;
	}

	private JPanel getPanelContenidoComprobacion() {
		if (panelContenidoComprobacion == null) {
			panelContenidoComprobacion = new JPanel();
			panelContenidoComprobacion.setBorder(null);
			panelContenidoComprobacion.setLayout(null);
			panelContenidoComprobacion.add(getScrollCarritoComprobacion());
			panelContenidoComprobacion.add(getPanelPrecios());
			panelContenidoComprobacion.add(getBtPagar());
			panelContenidoComprobacion.add(getPanel_1_1());
		}
		return panelContenidoComprobacion;
	}

	private JScrollPane getScrollCarritoComprobacion() {
		if (scrollCarritoComprobacion == null) {
			scrollCarritoComprobacion = new JScrollPane();
			scrollCarritoComprobacion.setBounds(68, 21, 854, 300);
			scrollCarritoComprobacion.setViewportView(getTableComprobacion());
		}
		return scrollCarritoComprobacion;
	}

	private JPanel getPanelPrecios() {
		if (panelPrecios == null) {
			panelPrecios = new JPanel();
			panelPrecios.setBounds(738, 344, 184, 112);
			panelPrecios.setLayout(null);
			panelPrecios.add(getLbSubtotal());
			panelPrecios.add(getLbImpuestos());
			panelPrecios.add(getLbTotalComprobacion());
			panelPrecios.add(getLbSubtotalTexto());
			panelPrecios.add(getLbImpuestosText());
			panelPrecios.add(getLbTotalComprobacionTexto());
		}
		return panelPrecios;
	}

	private JButton getBtPagar() {
		if (btPagar == null) {
			btPagar = new JButton("Confirmar y pagar");
			btPagar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (comprobarStock()) {
						pagarPedido();
						JOptionPane.showMessageDialog(panelDerecha,
								"Su pedido ha sido realizado con éxito.", "Pedido realizado",
								JOptionPane.OK_OPTION);
						actualizarTextoRegistro();
						resetearEnvio();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelRegistro");
					}
					if (!comprobarStock()) {
						JOptionPane.showMessageDialog(panelDerecha,
								"Hay un problema con el stock. Por favor, revise su pedido.", "Error",
								JOptionPane.ERROR_MESSAGE);
						products = new ProductsController().getAll();
						cargarCategoriaInicial();
						CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
						cardLayout.show(contentPane, "panelTiendaInicio");

					}

				}
			});
			btPagar.setForeground(Color.WHITE);
			btPagar.setBorder(new LineBorder(blue_code, 1, true));
			btPagar.setBackground(new Color(0, 121, 255));
			btPagar.setBounds(748, 467, 163, 29);
		}
		return btPagar;
	}
	private void pagarPedido() {
        List<Product> productos = new ArrayList<Product>();
        List<Integer> cantidades = new ArrayList<Integer>();
        for (int i = 0; i < table.getRowCount(); i++) {
            Product p = new Product();
            p.setID((int) table.getValueAt(i, 0));
            productos.add(p);
            cantidades.add((Integer) table.getValueAt(i, 2));
        }
        PaymentsController pc = new PaymentsController();
        if (esEmpresa) {
            pc.payCompanyTransfer(company, productos, cantidades);
        } else {
            if (rbTarjeta.isSelected()) {
                pc.payCreditCard(individualCustomer, individualCustomer.getAddress(), individualCustomer.getCreditCard(), productos, cantidades);
            }
            if (rbTransferencia.isSelected()) {
                pc.payBankTransfer(individualCustomer, individualCustomer.getAddress(), productos, cantidades);
            }
            if (rbContrareembolso.isSelected()) {
                pc.payContrarreembolso(individualCustomer, individualCustomer.getAddress(), productos, cantidades);
            }
        }
    }

	private JLabel getLbSubtotal() {
		if (lbSubtotal == null) {
			lbSubtotal = new JLabel("Subtotal");
			lbSubtotal.setForeground(Color.GRAY);
			lbSubtotal.setBounds(10, 11, 67, 14);
		}
		return lbSubtotal;
	}

	private JLabel getLbImpuestos() {
		if (lbImpuestos == null) {
			lbImpuestos = new JLabel("Impuestos");
			lbImpuestos.setForeground(Color.GRAY);
			lbImpuestos.setBounds(10, 36, 67, 14);
		}
		return lbImpuestos;
	}

	private JLabel getLbTotalComprobacion() {
		if (lbTotalComprobacion == null) {
			lbTotalComprobacion = new JLabel("Total");
			lbTotalComprobacion.setBounds(10, 75, 67, 14);
		}
		return lbTotalComprobacion;
	}

	private JLabel getLbSubtotalTexto() {
		if (lbSubtotalTexto == null) {
			lbSubtotalTexto = new JLabel("");
			lbSubtotalTexto.setForeground(Color.GRAY);
			lbSubtotalTexto.setBounds(106, 11, 68, 14);
		}
		return lbSubtotalTexto;
	}

	private JLabel getLbImpuestosText() {
		if (lbImpuestosText == null) {
			lbImpuestosText = new JLabel("");
			lbImpuestosText.setForeground(Color.GRAY);
			lbImpuestosText.setBounds(106, 36, 68, 14);
		}
		return lbImpuestosText;
	}

	private JLabel getLbTotalComprobacionTexto() {
		if (lbTotalComprobacionTexto == null) {
			lbTotalComprobacionTexto = new JLabel("");
			lbTotalComprobacionTexto.setBounds(106, 75, 67, 14);
		}
		return lbTotalComprobacionTexto;
	}

	private JPanel getPanel_1_1() {
		if (panelDatosComprobacion == null) {
			panelDatosComprobacion = new JPanel();
			panelDatosComprobacion.setBounds(65, 349, 636, 112);
			panelDatosComprobacion.setLayout(null);
			panelDatosComprobacion.add(getLbDireccionComprobacion());
			panelDatosComprobacion.add(getLbPersonaComprobacion());
			panelDatosComprobacion.add(getLbMetodoComprobacion());
			panelDatosComprobacion.add(getLbTipoEnvio());
		}
		return panelDatosComprobacion;
	}

	private JLabel getLbDireccionComprobacion() {
		if (lbDireccionComprobacion == null) {
			lbDireccionComprobacion = new JLabel("");
			lbDireccionComprobacion.setBounds(10, 11, 605, 14);
		}
		return lbDireccionComprobacion;
	}

	private JLabel getLbPersonaComprobacion() {
		if (lbPersonaComprobacion == null) {
			lbPersonaComprobacion = new JLabel("");
			lbPersonaComprobacion.setBounds(10, 36, 605, 14);
		}
		return lbPersonaComprobacion;
	}

	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha de caducidad:");
			lbFecha.setBounds(480, 29, 118, 14);
		}
		return lbFecha;
	}

	private JSpinner getSpinnerFecha() {
		if (spinnerFecha == null) {
			SpinnerDateModel spinMod = new SpinnerDateModel();
			spinnerFecha = new JSpinner(spinMod);
			spinnerFecha.setValue(new Date());
			spinnerFecha.setEditor(new JSpinner.DateEditor(spinnerFecha, "dd/MM/yyyy"));
			spinnerFecha.setBounds(480, 54, 118, 20);
		}
		return spinnerFecha;
	}

	private JLabel getLbMetodoComprobacion() {
		if (lbMetodoComprobacion == null) {
			lbMetodoComprobacion = new JLabel("");
			lbMetodoComprobacion.setBounds(10, 65, 360, 14);
		}
		return lbMetodoComprobacion;
	}

	private JLabel getLblAccesoSinRegistro() {
		if (lblAccesoSinRegistro == null) {
			lblAccesoSinRegistro = new JLabel("Acceso sin registro");
			lblAccesoSinRegistro.setForeground(Color.DARK_GRAY);
			lblAccesoSinRegistro.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblAccesoSinRegistro.setBounds(144, 115, 224, 49);
		}
		return lblAccesoSinRegistro;
	}

	private JButton getBtnEntrar() {
		if (btnEntrar == null) {
			btnEntrar = new JButton("Entrar");
			btnEntrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					resetearTienda();
					individualCustomer = new IndividualCustomer(0).setName("Anónimo");
					CardLayout cardLayout = (CardLayout) (contentPane.getLayout());
					cardLayout.show(contentPane, "panelTiendaInicio");
				}
			});
			btnEntrar.setForeground(Color.WHITE);
			btnEntrar.setBorder(new LineBorder(blue_code, 1, true));
			btnEntrar.setBackground(new Color(0, 121, 255));
			btnEntrar.setBounds(172, 269, 148, 29);
		}
		return btnEntrar;
	}

	private void resetearEnvio() {
		txtNombre.setText("");
		txtApellidos.setText("");
		txtDireccion.setText("");
		txtCiudad.setText("");
		txtPostal.setText("");
		txtProvincia.setText("");
		txtNombreTitular.setText("");
		txtNumero.setText("");
		txtCvc.setText("");
	}

	private JRadioButton getRbTarjeta() {
		if (rbTarjeta == null) {
			rbTarjeta = new JRadioButton("Tarjeta");
			rbTarjeta.setSelected(true);
			rbTarjeta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) (panelMetodoPago.getLayout());
					cardLayout.show(panelMetodoPago, "panelTarjeta");
				}
			});
			buttonGroup.add(rbTarjeta);
			rbTarjeta.setBounds(262, 42, 109, 23);
		}
		return rbTarjeta;
	}

	private JRadioButton getRbTransferencia() {
		if (rbTransferencia == null) {
			rbTransferencia = new JRadioButton("Transferencia");
			rbTransferencia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) (panelMetodoPago.getLayout());
					cardLayout.show(panelMetodoPago, "panelTransferencia");
				}
			});
			buttonGroup.add(rbTransferencia);
			rbTransferencia.setBounds(384, 42, 109, 23);
		}
		return rbTransferencia;
	}

	private JRadioButton getRbContrareembolso() {
		if (rbContrareembolso == null) {
			rbContrareembolso = new JRadioButton("Contrareembolso");
			rbContrareembolso.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout cardLayout = (CardLayout) (panelMetodoPago.getLayout());
					cardLayout.show(panelMetodoPago, "panelContrareembolso");
				}
			});
			buttonGroup.add(rbContrareembolso);
			rbContrareembolso.setBounds(520, 42, 148, 23);
		}
		return rbContrareembolso;
	}

	public String getSelectedButtonText(ButtonGroup buttonGroup) {
		for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
			AbstractButton button = buttons.nextElement();

			if (button.isSelected()) {
				return button.getText();
			}
		}

		return null;
	}

	private JLabel getLbContrareembolso() {
		if (lbContrareembolso == null) {
			lbContrareembolso = new JLabel("");
			lbContrareembolso.setBounds(10, 34, 775, 35);
		}
		return lbContrareembolso;
	}

	private boolean comprobarStock() {
		if (table.getRowCount() != 0) {
			for (int i = 0; i < table.getRowCount(); i++) {
				ProductsController pc = new ProductsController();
				int stock = pc.getStock((Integer) table.getValueAt(i, 0));
				int cantidad = pc.getStock((Integer) table.getValueAt(i, 2));
				if (stock >= cantidad) {
					return true;
				}
			}

		}
		return false;
	}
	private JTable getTableComprobacion() {
		if (tableComprobacion == null) {
			tableComprobacion = new JTable();
			tableComprobacion.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Nombre", "P.U.", "Cantidad", "Subtotal", "IVA", "Total"
				}
			) {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
				Class[] columnTypes = new Class[] {
					String.class, Double.class, Integer.class, Double.class, Integer.class, Double.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
				boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
			tableComprobacion.getColumnModel().getColumn(0).setResizable(false);
			tableComprobacion.getColumnModel().getColumn(1).setResizable(false);
			tableComprobacion.getColumnModel().getColumn(2).setResizable(false);
			tableComprobacion.getColumnModel().getColumn(3).setResizable(false);
			tableComprobacion.getColumnModel().getColumn(4).setResizable(false);
			tableComprobacion.getColumnModel().getColumn(5).setResizable(false);
		}
		return tableComprobacion;
	}
	private JLabel getLbMetodosEnvio() {
		if (lbMetodosEnvio == null) {
			lbMetodosEnvio = new JLabel("Tipo de envío");
			lbMetodosEnvio.setForeground(Color.DARK_GRAY);
			lbMetodosEnvio.setFont(new Font("Tahoma", Font.BOLD, 14));
			lbMetodosEnvio.setBounds(50, 156, 148, 22);
		}
		return lbMetodosEnvio;
	}
	private JRadioButton getRdbtn24() {
		if (rdbtn24 == null) {
			rdbtn24 = new JRadioButton("Entrega al día siguiente (24h)");
			buttonGroup_1.add(rdbtn24);
			rdbtn24.setBounds(138, 203, 225, 23);
		}
		return rdbtn24;
	}
	private JRadioButton getRdbtn48() {
		if (rdbtn48 == null) {
			rdbtn48 = new JRadioButton("Entrega urgente (48h)");
			buttonGroup_1.add(rdbtn48);
			rdbtn48.setBounds(397, 203, 175, 23);
		}
		return rdbtn48;
	}
	private JRadioButton getRdbtn5() {
		if (rdbtn5 == null) {
			rdbtn5 = new JRadioButton("Entrega ordinaria (5-7 días)");
			rdbtn5.setSelected(true);
			buttonGroup_1.add(rdbtn5);
			rdbtn5.setBounds(596, 203, 199, 23);
		}
		return rdbtn5;
	}
	private JLabel getLbCarrito() {
		if (lbCarrito == null) {
			lbCarrito = new JLabel("Cesta de la compra:");
			lbCarrito.setBounds(10, 11, 193, 14);
		}
		return lbCarrito;
	}
	private JLabel getLbTipoEnvio() {
		if (lbTipoEnvio == null) {
			lbTipoEnvio = new JLabel("");
			lbTipoEnvio.setBounds(10, 90, 360, 14);
		}
		return lbTipoEnvio;
	}
}
