import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Ventana extends JFrame{

	File archivo = new File("users.txt");
	
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
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PANEL LOGIN
				JPanel login = new JPanel();
				login.setVisible(false);
				login.setSize(500,700);
				login.setBackground(Color.decode("#E1D8FF"));
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
				JLabel etiquetaUser = new JLabel("Ingrese correo");
				etiquetaUser.setSize(160, 50);
				etiquetaUser.setLocation(30, 40);
				login.add(etiquetaUser);
				
				// Campo de texto
				JTextField userL = new JTextField();
				userL.setSize(420, 30);
				userL.setLocation(30, 80);
				login.add(userL);
				
				// Etiqueta de password
				JLabel pass = new JLabel("Ingrese Contraseña");
				pass.setSize(160, 50);
				pass.setLocation(30, 100);
				login.add(pass);
				
				// Campo de texto con contraseña
				JPasswordField password = new JPasswordField();
				password.setSize(420, 30);
				password.setLocation(30, 140);
				login.add(password);
				
				
				login.repaint();
				
				// Oyente de accion para eventos
			/*	botonL.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						
						String us = etiquetaUser.getText();
						char [] pass = password.getPassword();
						
						System.out.println("Bienvenido");
						
					}
					
				}); */
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PANEL REGISTRO
				JPanel registro = new JPanel();
				registro.setVisible(false);
				registro.setSize(500,700);
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
				terminos.setBackground(Color.decode("#E1D8FF"));
				terminos.setOpaque(true);
				registro.add(terminos);
				// BOTON REGISTRAR
				JButton registrarU = new JButton("Registrarse");
				registrarU.setSize(120,30);
				registrarU.setLocation(190,460);
				registro.add(registrarU);
				
				registro.repaint();
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// PANEL ADMINISTRADOR
				JPanel admin = new JPanel();
				admin.setVisible(false);
				admin.setSize(500,700);
				admin.setBackground(Color.decode("#BCFFBB"));
				admin.setLayout(null);
				JLabel etiquetaAdmin = new JLabel("Interfaz de Administrador");
				etiquetaAdmin.setSize(700, 50);
				etiquetaAdmin.setLocation(100, 10);
				etiquetaAdmin.setFont(new Font("Times New Roman", Font.PLAIN, 28));
				admin.add(etiquetaAdmin);
				
		       /* ArrayList<String[]> datos2 = new ArrayList<>();
		        try (BufferedReader br = new BufferedReader(new FileReader("users.txt"))) {
		            String line;
		            while ((line = br.readLine()) != null) {
		                String[] fields = line.split(",");
		                datos2.add(fields);
		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		        
		        String[] nomCol = {"Nombre", "Apellido", "Correo", "Contraseña"};
		        DefaultTableModel modelo = new DefaultTableModel(datos2.toArray(new String[0][0]), nomCol);

		        JTable tabla = new JTable(modelo);
		        JScrollPane scrollPane = new JScrollPane(tabla);
		        scrollPane.setSize(400, 500);
		        scrollPane.setLocation(50, 100);
		        admin.add(scrollPane);
				*/
				admin.revalidate();
				admin.repaint();
// ACTION LISTENER //////////////////////////////////////////////////////////
				jmi1.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						remove(registro);
						remove(admin);
						add(login);
						login.setVisible(true);
						registro.setVisible(false);
						admin.setVisible(false);
						repaint();
					}
					
				});
				
				jmi2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						remove(login);
						remove(admin);
						add(registro);
						admin.setVisible(false);
						login.setVisible(false);
						registro.setVisible(true);
						repaint();
					}
					
				});
// BOTON LOGIN ACTION LISTENER
				botonL.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
// GET USER
						String userLogin = userL.getText();
// CONVERSION DEL ARREGLO DE CHAR A STRING 
						String chrPass = String.valueOf(password.getPassword());// LECTOR DE DOCUMENTOS						
						BufferedReader reader;
						
						try {
							reader = new BufferedReader(new FileReader("users.txt"));
							
							String line = reader.readLine();
/////////////////////// CICLO PARA LEER TODAS LAS LINEAS DEL DOCUMENTO
							while(line != null) {
								String [] datos = null;
								
								datos = line.split(",");
								
							/*	System.out.println(datos[2]);
								System.out.println(userLogin);
								System.out.println(datos[3]);
								System.out.println(chrPass);	*/
								
								if(datos[2].equals(userLogin)) {
									if(datos[3].equals(chrPass)) {
										// System.out.println("hola");
										JOptionPane.showMessageDialog(null, "Bienvenido", "Titulo", JOptionPane.PLAIN_MESSAGE);
										
										break;
									}
								}
								line = reader.readLine();
							}
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}			
						remove(login);
						remove(registro);
						add(admin);
						login.setVisible(false);
						registro.setVisible(false);
						admin.setVisible(true);
						repaint();
						
					}
					
				});
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// BOTON REGISTER
				registrarU.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							
							BufferedReader br = new BufferedReader(new FileReader("users.txt"));
							
							String line1 = br.readLine();
							
							if(!String.valueOf(pass1.getPassword()).equals(String.valueOf(pass2.getPassword()))){
								JOptionPane.showMessageDialog(null, "ERROR: La contraseña es distinta, repita contraseña", " ", JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							while(line1 != null) {
								String datos1 [] = null;
								datos1 = line1.split(",");
								if(datos1[2].equals(correo.getText())) {
									JOptionPane.showMessageDialog(null, "ERROR: Este correo ya esta en uso", " ", JOptionPane.PLAIN_MESSAGE);	
									return;
								}
								
								line1 = br.readLine();
							}
							br.close();
							
							if(!terminos.isSelected()) {
								JOptionPane.showMessageDialog(null, "Acepte los terminos y condiciones :)", " ", JOptionPane.PLAIN_MESSAGE);
								return;
							}
							
							BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt", true));
							bw.write(nomR.getText() + "," + apR.getText() + "," + correo.getText() + "," + String.valueOf(pass1.getPassword()));
							bw.newLine();
							bw.flush();
							bw.close();
							JOptionPane.showMessageDialog(null, "Cuenta registrada exitosamente", " ", JOptionPane.PLAIN_MESSAGE);
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
					} 
					
				});
				
				this.revalidate();
				this.repaint();
	}
	
}
