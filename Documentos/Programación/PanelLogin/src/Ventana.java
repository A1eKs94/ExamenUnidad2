import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Ventana extends JFrame{

	public Ventana() {

		// Visibilidad
				this.setVisible(true);
				// Tamaño
				this.setSize(500, 700);
				// Titulo de la ventana
				this.setTitle("Titulo");	
				// En caso de cerrar ventana, detener programa
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				// Localizacion
				this.setLocationRelativeTo(null);
				// Distribucion o Plantilla
				this.setLayout(null);
				this.getContentPane().setBackground(Color.decode("#FFD8F7"));		
				
				JMenuBar barraMenu = new JMenuBar();
				barraMenu.setSize(this.getWidth(), 20);
				this.setJMenuBar(barraMenu);
				
				JMenu menu1 = new JMenu("Inicio");
				JMenu menu2 = new JMenu("Cuenta");
				JMenu menu3 = new JMenu("Estudiantes");
				JMenu menu4 = new JMenu("Ayuda");
				
				barraMenu.add(menu1);
				barraMenu.add(menu2);
				barraMenu.add(menu3);
				barraMenu.add(menu4);
				
				JMenuItem jmi1 = new JMenuItem("Acceder");
				JMenuItem jmi2 = new JMenuItem("Registro");
				
				menu2.add(jmi1);
				menu2.add(jmi2);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PANEL LOGIN
				JPanel login = new JPanel();
				login.setVisible(false);
				login.setSize(500,700);
				login.setBackground(Color.WHITE);
				login.setLayout(null);
				
				JButton botonL = new JButton("Inicio");
				botonL.setSize(90, 40);
				botonL.setLocation(190,180);
				login.add(botonL);
				
				// Etiqueta
				JLabel etiqueta = new JLabel("Bienvenido");
				etiqueta.setSize(160, 50);
				etiqueta.setLocation(190, 10);
				login.add(etiqueta);
				
				// Etiqueta de usuario
				JLabel user = new JLabel("Ingrese Usuario");
				user.setSize(160, 50);
				user.setLocation(30, 40);
				login.add(user);
				
				// Campo de texto
				JTextField texto = new JTextField();
				texto.setSize(420, 30);
				texto.setLocation(30, 80);
				texto.setBackground(Color.LIGHT_GRAY);
				texto.setOpaque(true);
				login.add(texto);
				
				// Etiqueta de password
				JLabel pass = new JLabel("Ingrese Contraseña");
				pass.setSize(160, 50);
				pass.setLocation(30, 100);
				login.add(pass);
				
				// Campo de texto con contraseña
				JPasswordField password = new JPasswordField();
				password.setSize(420, 30);
				password.setLocation(30, 140);
				password.setBackground(Color.LIGHT_GRAY);
				password.setOpaque(true);
				login.add(password);
				
				
				login.repaint();
				
				// Oyente de accion para eventos
				botonL.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String us = texto.getText();
						char [] pass = password.getPassword();
						
						System.out.println("Bienvenido");
						
					}
					
				});

// PANEL REGISTRO
				JPanel registro = new JPanel();
				registro.setVisible(false);
				registro.setSize(500,700);
				registro.setBackground(Color.BLUE);
				registro.setLayout(null);
				
				JLabel etiquetaR = new JLabel("Ingrese sus datos");
				etiquetaR.setSize(160, 50);
				etiquetaR.setLocation(190, 10);
				registro.add(etiquetaR);
				// NOMBRE Y APELLIDOS
				JLabel etiquetaNom = new JLabel("Ingrese su nombre(s)");
				etiquetaNom.setSize(160, 50);
				etiquetaNom.setLocation(30, 40);
				registro.add(etiquetaNom);
				JTextField nomR = new JTextField();
				nomR.setSize(420, 30);
				nomR.setLocation(30, 80);
				registro.add(nomR);
				JLabel etiquetaApP = new JLabel("Apellido Paterno");
				etiquetaApP.setSize(150, 50);
				etiquetaApP.setLocation(30, 100);
				registro.add(etiquetaApP);
				JTextField apPR = new JTextField();
				apPR.setSize(200, 30);
				apPR.setLocation(30, 140);				
				registro.add(apPR);
				JLabel etiquetaApM = new JLabel("Apellido Materno");
				etiquetaApM.setSize(150, 50);
				etiquetaApM.setLocation(250, 100);
				registro.add(etiquetaApM);
				JTextField apMR = new JTextField();
				apMR.setSize(200, 30);
				apMR.setLocation(250, 140);				
				registro.add(apMR);
				// CORREO ELECTRONICO
				JLabel etiquetaCorreo = new JLabel("Ingrese su correo");
				etiquetaCorreo.setSize(160, 50);
				etiquetaCorreo.setLocation(30, 180);
				registro.add(etiquetaCorreo);
				JTextField correo = new JTextField();
				correo.setSize(420, 30);
				correo.setLocation(30, 220);
				registro.add(correo);
				// CONTRASEÑA Y REPITE CONTRASEÑA
				JLabel etiquetaCR = new JLabel("Ingrese contraseña");
				etiquetaCR.setSize(160,50);
				etiquetaCR.setLocation(30, 260);
				registro.add(etiquetaCR);
				JPasswordField pass1 = new JPasswordField();
				pass1.setSize(420, 30);
				pass1.setLocation(30,300);
				registro.add(pass1);
				JLabel etiquetaC2R = new JLabel("Repita contraseña");
				etiquetaC2R.setSize(160,30);
				etiquetaC2R.setLocation(30, 340);
				registro.add(etiquetaC2R);
				JPasswordField pass2 = new JPasswordField();
				pass2.setSize(420, 30);
				pass2.setLocation(30,380);
				registro.add(pass2);
				// TERMINOS Y CONDICIONES
				JCheckBox terminos = new JCheckBox("Acepto terminos y condiciones");
				terminos.setSize(230,30);
				terminos.setLocation(30,420);
				registro.add(terminos);
				// BOTON REGISTRAR
				JButton registrarU = new JButton("Registrarse");
				registrarU.setSize(120,30);
				registrarU.setLocation(190,460);
				registro.add(registrarU);
				
				registro.repaint();
				// ACTION LISTENER //////////////////////////////////////////////////////////
				jmi1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						remove(registro);
						add(login);
						login.setVisible(true);
						registro.setVisible(false);
						repaint();
					}
					
				});
				
				jmi2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						remove(login);
						add(registro);
						login.setVisible(false);
						registro.setVisible(true);
						repaint();
					}
					
				});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
				
				this.revalidate();
				this.repaint();
	}
	
}
