package com.myshop.store.igu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.border.TitledBorder;

import com.myshop.model.customer.Company;
import com.myshop.store.controller.UsersController;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class LoginEmpresaTienda extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginEmpresaTienda frame = new LoginEmpresaTienda();
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
	public LoginEmpresaTienda() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 501);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(65, 105, 225));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelEmpresas = new JPanel();
		panelEmpresas.setBorder(new TitledBorder(null, "Empresas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEmpresas.setBackground(new Color(65, 105, 225));
		panelEmpresas.setBounds(12, 54, 290, 399);
		contentPane.add(panelEmpresas);
		panelEmpresas.setLayout(null);
		
		JLabel label = new JLabel("Nombre de usuario");
		label.setBounds(36, 88, 115, 22);
		panelEmpresas.add(label);

		JLabel lblUsuarioNoEncontrado = new JLabel("Usuario no encontrado");
		lblUsuarioNoEncontrado.setVisible(false);
		lblUsuarioNoEncontrado.setForeground(new Color(255, 255, 0));
		lblUsuarioNoEncontrado.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsuarioNoEncontrado.setBounds(35, 215, 183, 55);
		panelEmpresas.add(lblUsuarioNoEncontrado);
		
		textUser = new JTextField();
		textUser.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				lblUsuarioNoEncontrado.setVisible(false);
			}
		});
		textUser.setBounds(35, 112, 194, 22);
		panelEmpresas.add(textUser);
		textUser.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(36, 142, 91, 16);
		panelEmpresas.add(lblContrasea);
		
		textPass = new JTextField();
		textPass.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				lblUsuarioNoEncontrado.setVisible(false);
			}
		});
		textPass.setBounds(35, 160, 194, 22);
		panelEmpresas.add(textPass);
		textPass.setColumns(10);
		
		JButton btnContinuar = new JButton("Acceder a tienda");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UsersController uc = new UsersController();
				Company c = uc.getCompany(textUser.getText(), textPass.getText());
				if(c.getName() == null)
					lblUsuarioNoEncontrado.setVisible(true);
			}
		});
		btnContinuar.setBounds(36, 195, 135, 25);
		panelEmpresas.add(btnContinuar);
		
		JPanel panelParticulares = new JPanel();
		panelParticulares.setBorder(new TitledBorder(null, "Particulares", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelParticulares.setBackground(new Color(65, 105, 225));
		panelParticulares.setBounds(320, 54, 298, 399);
		contentPane.add(panelParticulares);
		panelParticulares.setLayout(null);
		
		JButton btnAccederATienda = new JButton("Acceder a tienda");
		btnAccederATienda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipalTienda frame = new VentanaPrincipalTienda();
				frame.setVisible(true);
			}
		});
		btnAccederATienda.setBounds(81, 192, 147, 25);
		panelParticulares.add(btnAccederATienda);
		
		JPanel panelURL = new JPanel();
		panelURL.setBounds(0, 0, 630, 20);
		contentPane.add(panelURL);
		panelURL.setLayout(new BorderLayout(0, 0));
		
		JLabel lblHttpwwwmyshopes = new JLabel("http://www.myshop.es/");
		lblHttpwwwmyshopes.setPreferredSize(new Dimension(1011, 14));
		lblHttpwwwmyshopes.setBackground(Color.WHITE);
		panelURL.add(lblHttpwwwmyshopes, BorderLayout.CENTER);
	}
}
