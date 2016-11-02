package com.myshop.store.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.myshop.model.customer.IndividualCustomer;
import com.myshop.store.controller.UsersController;

import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaPagoLoginTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPagoLoginTienda frame = new VentanaPagoLoginTienda();
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
	public VentanaPagoLoginTienda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 777, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setForeground(Color.BLUE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 771, 20);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHttpwwwmyshopestiendalogin = new JLabel("http://www.myshop.es/tienda/login");
		lblHttpwwwmyshopestiendalogin.setPreferredSize(new Dimension(1011, 14));
		lblHttpwwwmyshopestiendalogin.setBackground(Color.WHITE);
		panel.add(lblHttpwwwmyshopestiendalogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaPagoLoginTienda.class.getResource("/com/myshop/store/igu/img/fecha.jpg")));
		panel.add(lblNewLabel, BorderLayout.WEST);
		
		JPanel panelNoLogin = new JPanel();
		panelNoLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inicio de sesi\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelNoLogin.setBackground(new Color(65, 105, 225));
		panelNoLogin.setBounds(10, 33, 352, 497);
		contentPane.add(panelNoLogin);
		panelNoLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de usuario");
		lblNewLabel_2.setBounds(27, 105, 115, 22);
		panelNoLogin.add(lblNewLabel_2);
		
		JLabel lblUsuarioNoEncontrado = new JLabel("Usuario no encontrado");
		lblUsuarioNoEncontrado.setVisible(false);
		lblUsuarioNoEncontrado.setForeground(new Color(255, 255, 0));
		lblUsuarioNoEncontrado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuarioNoEncontrado.setBounds(26, 242, 272, 36);
		panelNoLogin.add(lblUsuarioNoEncontrado);
		
		textUser = new JTextField();
		textUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblUsuarioNoEncontrado.setVisible(false);
			}
		});
		textUser.setBounds(28, 136, 207, 22);
		panelNoLogin.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(27, 163, 115, 22);
		panelNoLogin.add(lblContrasea);
		
		textPass = new JTextField();
		textPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUsuarioNoEncontrado.setVisible(false);
			}
		});
		textPass.setBounds(27, 193, 208, 22);
		panelNoLogin.add(textPass);
		textPass.setColumns(10);
		
		JButton btnInicio = new JButton("Continuar");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsersController u = new UsersController();
				IndividualCustomer ic = u.getCustomerData(textUser.getText(), textPass.getText());
				if(ic.getName() == null){
					lblUsuarioNoEncontrado.setVisible(true);
				}
			}
		});
		btnInicio.setBounds(27, 459, 97, 25);
		panelNoLogin.add(btnInicio);
		
		JPanel panelLogin = new JPanel();
		panelLogin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuario sin registro", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLogin.setBackground(new Color(65, 105, 225));
		panelLogin.setBounds(375, 33, 384, 497);
		contentPane.add(panelLogin);
		panelLogin.setLayout(null);
		
		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setBounds(27, 459, 97, 25);
		panelLogin.add(btnContinuar);
		
		JLabel lblDatosDeEnvo = new JLabel("Datos de env\u00EDo");
		lblDatosDeEnvo.setBounds(22, 72, 102, 16);
		panelLogin.add(lblDatosDeEnvo);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setBounds(22, 101, 56, 16);
		panelLogin.add(lblCalle);
		
		textField_2 = new JTextField();
		textField_2.setBounds(22, 128, 339, 22);
		panelLogin.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Ciudad");
		lblNewLabel_3.setBounds(22, 163, 56, 16);
		panelLogin.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(22, 192, 339, 22);
		panelLogin.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblZip = new JLabel("Provincia/Estado");
		lblZip.setBounds(22, 230, 97, 16);
		panelLogin.add(lblZip);
		
		textField_4 = new JTextField();
		textField_4.setBounds(22, 259, 339, 22);
		panelLogin.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblCdigoPostal = new JLabel("C\u00F3digo postal");
		lblCdigoPostal.setBounds(17, 294, 97, 16);
		panelLogin.add(lblCdigoPostal);
		
		textField_5 = new JTextField();
		textField_5.setBounds(22, 323, 116, 22);
		panelLogin.add(textField_5);
		textField_5.setColumns(10);
	}
}
