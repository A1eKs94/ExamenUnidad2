import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;

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
import javax.swing.ImageIcon;

public class Ventana extends JFrame{

	File archivo = new File("users.txt");
	
	Ventana(){
		this.setVisible(true);
		// Tamaño
		this.setSize(500, 800);
		// Titulo de la ventana
		this.setTitle("Titulo");	
		// En caso de cerrar ventana, detener programa
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Localizacion
		this.setLocationRelativeTo(null);
		JMenuBar barraMenu = new JMenuBar();
		barraMenu.setSize(this.getWidth(), 20);
		this.setJMenuBar(barraMenu);
		
		// BARRA DE MENU
		JMenu menu1 = new JMenu("Cuenta");
		JMenu menu2 = new JMenu("Usuario");
		JMenu menu3 = new JMenu("Ayuda");
		
		barraMenu.add(menu1);
		barraMenu.add(menu2);
		barraMenu.add(menu3);

		// CUENTA
		JMenuItem jmi1 = new JMenuItem("Mi cuenta");
		JMenuItem jmi2 = new JMenuItem("Cerrar sesión");
		menu1.add(jmi1);
		menu1.add(jmi2);
		
		// USUARIO
		JMenuItem jmi3 = new JMenuItem("Lista de usuarios");
		JMenuItem jmi4 = new JMenuItem("Crear usuario");
		menu2.add(jmi3);
		menu2.add(jmi4);
		
		// AYUDA
		JMenuItem jmi5 = new JMenuItem("¿Como crear usuarios?");
		menu3.add(jmi5);

		if(archivo.exists()) {
			System.out.println("El documento " + archivo.getName() + " existe");
		}else {
			try {
				archivo.createNewFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		lobby();
	}
	
	private void inicio() {
		
		JPanel inicio = new JPanel();
		inicio.setVisible(false);
		inicio.setSize(500,800);
		inicio.setBackground(Color.decode("#E1D8FF"));
		inicio.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("macaco.jpg");
		JLabel imagenA = new JLabel(imagen);
		imagenA.setLocation(150, 150);
		imagenA.setSize(200, 150);
		inicio.add(imagenA);
		
		JLabel etiqueta = new JLabel("Hecho por Rubén Aleksey Unzon Melchor");
		etiqueta.setSize(250, 30);
		etiqueta.setLocation(125,720);
		inicio.add(etiqueta);
		
		JButton botonInicio = new JButton("Iniciar");
		botonInicio.setSize(100,40);
		botonInicio.setLocation(200, 350);
		inicio.add(botonInicio);
		
		this.add(inicio);
		inicio.setVisible(true);
		inicio.repaint();
	}
	
	private void login(){
		JPanel login = new JPanel();
		login.setVisible(false);
		login.setSize(500,800);
		login.setBackground(Color.decode("#C8B7FF"));
		login.setLayout(null);
		
		JButton botonL = new JButton("Inicio");
		botonL.setSize(90, 40);
		botonL.setLocation(100,180);
		login.add(botonL);
		
		JButton cancelarL = new JButton("Cancelar");
		cancelarL.setSize(90, 40);
		cancelarL.setLocation(280,180);
		login.add(cancelarL);
		
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
		password.setOpaque(true);
		login.add(password);
		
		// Agregar el panel al JFrame
		this.add(login); 
		
		// Hacer el panel visible
		login.setVisible(true); 
		login.repaint();
	}
	
	private void lobby() {

		JPanel lobby = new JPanel();
		lobby.setVisible(false);
		lobby.setSize(500,800);
		lobby.setBackground(Color.decode("#E1D8FF"));
		lobby.setLayout(null);
		
		ImageIcon imagen = new ImageIcon("macaco.jpg");
		JLabel imagenA = new JLabel(imagen);
		imagenA.setLocation(150, 300);
		imagenA.setSize(200, 150);
		lobby.add(imagenA);
		
		JLabel etiqueta = new JLabel("Bienvenido", JLabel.CENTER);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 40));
		etiqueta.setSize(250, 30);
		etiqueta.setLocation(125,120);
		lobby.add(etiqueta);

		this.add(lobby);
		lobby.setVisible(true);
		lobby.repaint();
	}
	
	private void registro() {
		JPanel registro = new JPanel();
		registro.setVisible(false);
		registro.setSize(500,800);
		registro.setBackground(Color.decode("#E1D8FF"));
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
		JLabel etiquetaAp = new JLabel("Ingrese sus apellidos");
		etiquetaAp.setSize(420, 30);
		etiquetaAp.setLocation(30, 110);
		registro.add(etiquetaAp);
		JTextField apR = new JTextField();
		apR.setSize(420, 30);
		apR.setLocation(30, 140);				
		registro.add(apR);
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
		terminos.setOpaque(true);
		terminos.setBackground(Color.decode("#E1D8FF"));
		registro.add(terminos);
		// BOTON REGISTRAR
		JButton registrarU = new JButton("Registrarse");
		registrarU.setSize(120,30);
		registrarU.setLocation(50,460);
		registro.add(registrarU);
		// BOTON CANCELAR
		JButton cancelarR = new JButton("Cancelar");
		cancelarR.setSize(120,30);
		cancelarR.setLocation(310,460);
		registro.add(cancelarR);
	
		this.add(registro);
		registro.setVisible(true);
		registro.repaint();
	}

	

}
