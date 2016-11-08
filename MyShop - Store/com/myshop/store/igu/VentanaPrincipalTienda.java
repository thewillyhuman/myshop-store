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

import com.myshop.model.customer.Company;
import com.myshop.model.customer.IndividualCustomer;
import com.myshop.model.product.Product;
import com.myshop.store.controller.ProductsController;
import com.myshop.store.controller.UsersController;

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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	private JPanel logueoPago;
	private JPanel direccionILogueoPago;
	private JLabel lblUrlInicio;
	private JPanel contenidoLogueoPago;
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
		contentPane.add(getTienda(), "tienda");
		contentPane.add(getLogueoPago(), "login");
		
		JPanel inicio = new JPanel();
		contentPane.add(inicio, "name_381831475621552");
		inicio.setLayout(new BorderLayout(0, 0));
		
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
		contenidoInicio.setBackground(new Color(65, 105, 225));
		inicio.add(contenidoInicio, BorderLayout.CENTER);
		
		JPanel panelEmpresa = new JPanel();
		panelEmpresa.setLayout(null);
		panelEmpresa.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acceso a tienda de empresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelEmpresa.setBackground(new Color(65, 105, 225));
		panelEmpresa.setBounds(12, 13, 492, 529);
		contenidoInicio.add(panelEmpresa);
		
		JLabel lblUsuarioNoEncontradoEmpresa = new JLabel("Usuario no encontrado");
		lblUsuarioNoEncontradoEmpresa.setVisible(false);
		lblUsuarioNoEncontradoEmpresa.setForeground(Color.YELLOW);
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
				if(c.getName() == null)
					lblUsuarioNoEncontradoEmpresa.setVisible(true);
				else{
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
		panelParticular.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Acceso a particulares", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelParticular.setBackground(new Color(65, 105, 225));
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
			btnContinuar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "login");
				}
			});
			btnContinuar.setBounds(238, 493, 121, 35);
		}
		return btnContinuar;
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
			contenidoLogueoPago.setBackground(new Color(65, 105, 225));
			
			JPanel loginUsuario = new JPanel();
			loginUsuario.setBorder(new TitledBorder(null, "Inicio de sesion", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			loginUsuario.setBackground(new Color(65, 105, 225));
			loginUsuario.setBounds(12, 13, 492, 529);
			contenidoLogueoPago.add(loginUsuario);
			
			JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario");
			lblNombreDeUsuario.setBounds(33, 169, 109, 16);
			
			JLabel lblUsuarioNoEncontrado = new JLabel("Usuario no encontrado");
			lblUsuarioNoEncontrado.setVisible(false);
			lblUsuarioNoEncontrado.setForeground(new Color(255, 255, 0));
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
					if(ic.getName() == null)
						lblUsuarioNoEncontrado.setVisible(true);
				}
			});
			btnContinuar_1.setBounds(33, 291, 109, 25);
			loginUsuario.add(btnContinuar_1);
			
			JPanel panelNoRegistro = new JPanel();
			panelNoRegistro.setBorder(new TitledBorder(null, "Usuario no registrado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelNoRegistro.setBackground(new Color(65, 105, 225));
			panelNoRegistro.setBounds(518, 13, 533, 529);
			contenidoLogueoPago.add(panelNoRegistro);
			panelNoRegistro.setLayout(null);
			
			JLabel lblDatosDeEnvo = new JLabel("Datos de env\u00EDo:");
			lblDatosDeEnvo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			lblDatosDeEnvo.setBounds(32, 109, 132, 24);
			panelNoRegistro.add(lblDatosDeEnvo);
			
			JLabel lblCalle = new JLabel("Calle");
			lblCalle.setBounds(34, 164, 106, 24);
			panelNoRegistro.add(lblCalle);
			
			textCalle = new JTextField();
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
			
			JLabel lblProvinciaestado = new JLabel("Provincia/Estado");
			lblProvinciaestado.setBounds(32, 283, 132, 24);
			panelNoRegistro.add(lblProvinciaestado);
			
			textProvinciaEstado = new JTextField();
			textProvinciaEstado.setBounds(32, 309, 474, 24);
			panelNoRegistro.add(textProvinciaEstado);
			textProvinciaEstado.setColumns(10);
			
			JLabel lblCodigoPostal = new JLabel("Codigo postal");
			lblCodigoPostal.setBounds(32, 346, 108, 24);
			panelNoRegistro.add(lblCodigoPostal);
			
			textCodigoPostal = new JTextField();
			textCodigoPostal.setBounds(32, 373, 474, 24);
			panelNoRegistro.add(textCodigoPostal);
			textCodigoPostal.setColumns(10);
			
			JButton btnContinuar_2 = new JButton("Continuar");
			btnContinuar_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					textCiudadPago.setText(textCiudad.getText());
					textProvinciaPago.setText(textProvinciaEstado.getText());
					textDireccionPago.setText(textCalle.getText());
					textCodigoPostalPago.setText(textCodigoPostal.getText());
					CardLayout card = (CardLayout) contentPane.getLayout();
					card.show(contentPane, "pago");
				}
			});
			btnContinuar_2.setBounds(32, 418, 97, 25);
			panelNoRegistro.add(btnContinuar_2);
		}
		return contenidoLogueoPago;
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
			if(!esEmpresa)
				modeloTabla.addRow(new Object[]{ p.getName(), p.getDescription(), p.getPrice(), p.getStock()});
			else{
				modeloTabla.addRow(new Object[]{ p.getName(), p.getDescription(), p.getCompanyPrice(), p.getStock()});					
			}
		}
	}
	private void limpiarProductos(){
		int rowCount = modeloTabla.getRowCount();
		for (int i = rowCount - 1; i >= 0; i--) {
			modeloTabla.removeRow(i);
		}
	}
	private JPanel getPago() {
		if (pago == null) {
			pago = new JPanel();
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
			contenidoPago.setBackground(new Color(65, 105, 225));
			contenidoPago.setLayout(null);
			contenidoPago.add(getDatos());
			contenidoPago.add(getMetodos());
			
			JPanel carrito = new JPanel();
			carrito.setBackground(new Color(65, 105, 225));
			carrito.setBorder(new TitledBorder(null, "Carrito", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			carrito.setBounds(0, 0, 529, 271);
			contenidoPago.add(carrito);
		}
		return contenidoPago;
	}
	private JPanel getDatos() {
		if (datos == null) {
			datos = new JPanel();
			datos.setBackground(new Color(65, 105, 225));
			datos.setBorder(new TitledBorder(null, "Resumen datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
			metodos.setBackground(new Color(65, 105, 225));
			metodos.setBorder(new TitledBorder(null, "M\u00E9todo de pago", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			metodos.setBounds(541, 0, 522, 555);
		}
		return metodos;
	}
}
