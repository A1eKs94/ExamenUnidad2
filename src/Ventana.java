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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

public class Ventana extends JFrame{

	File archivo = new File("users.txt");
	
	private String actual = "inicio";
	private String anterior = "inicio";
	private JPanel gran_panel = null;
	private UsuarioLogeado usuarioLog;
	
	Ventana(){
		this.setVisible(true);
		// Tamaño
		this.setSize(500, 800);
		// Titulo de la ventana
		this.setTitle("ExamenUnidad2");	
		// En caso de cerrar ventana, detener programa
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Localizacion
		this.setLocationRelativeTo(null);
		// Lockeo de ventana
		setResizable(false);
		
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
		// ACTION LISTENER
		jmi1.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							anterior = actual;
							actual = "cuenta";
							
							route();
						}
						
					});
		JMenuItem jmi2 = new JMenuItem("Cerrar sesión");
		jmi2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "login";
				
				route();
			}
			
		});
		menu1.add(jmi1);
		menu1.add(jmi2);
		
		// USUARIO
		JMenuItem jmi3 = new JMenuItem("Lista de usuarios");
		jmi3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "usuarios";
				
				route();
			}
			
		});
		JMenuItem jmi4 = new JMenuItem("Crear usuario");
		jmi4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "registro";
				
				route();
			}
			
		});
		menu2.add(jmi3);
		menu2.add(jmi4);
		
		// AYUDA
		JMenuItem jmi5 = new JMenuItem("¿Como crear usuarios?");
		jmi5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "ayuda";
				
				route();
			}
			
		});
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
		this.route();
		//usuarios();
	}
	
	public void route() {
			
			if(gran_panel!=null) {
				this.remove(gran_panel);
			}
			
			if(actual.equals("splash")) { 
				gran_panel = login();  
			}
			if(actual.equals("inicio")) {
				gran_panel = inicio();
			}
			if(actual.equals("login")) { 
				gran_panel = login();  
			}
			if(actual.equals("lobby")) { 
				gran_panel = lobby();  
			}
			if(actual.equals("registro")) { 
				gran_panel = registro();  
			}
			if(actual.equals("ayuda")) { 
				gran_panel = ayuda();  
			}
			if(actual.equals("cuenta")) { 
				gran_panel = cuenta();  
			}
			if(actual.equals("usuarios")) { 
				gran_panel = usuarios();  
			}
			
			this.add(gran_panel);
			this.revalidate();
			this.repaint(); 
			
		}
	
	private JPanel inicio() {
		
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
		etiqueta.setLocation(125,700);
		inicio.add(etiqueta);
		
		JButton botonInicio = new JButton("Iniciar");
		botonInicio.setSize(100,40);
		botonInicio.setLocation(200, 350);
		inicio.add(botonInicio);
		
		// ACTION LISTENER
		botonInicio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "login";
				
				route();
			}
			
		});
		
		this.add(inicio);
		inicio.setVisible(true);
		inicio.repaint();
		return inicio;
	}
	
	private JPanel login(){
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
		
		// ACTION LISTENER
			cancelarL.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						anterior = actual;
						actual = "login";
						
						route();
					}
					
				});
		
		// Etiqueta
		JLabel etiqueta = new JLabel("Bienvenido");
		etiqueta.setSize(160, 50);
		etiqueta.setLocation(175, 10);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 25));
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
		login.add(password);
		// ACTION LISTENER
				botonL.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
// GET USER
						String userLogin = texto.getText();
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
								
								if(datos[2].equals(userLogin)) {
									if(datos[3].equals(chrPass)) {
										JOptionPane.showMessageDialog(null, "Bienvenido", " ", JOptionPane.PLAIN_MESSAGE);
										
										break;
									}else {
										JOptionPane.showMessageDialog(null, "Contraseña incorrecta", " ", JOptionPane.PLAIN_MESSAGE);
										return;
									}
								}else {
									JOptionPane.showMessageDialog(null, "Usuario incorrecto", " ", JOptionPane.PLAIN_MESSAGE);
									return;
								}
								
							}
							line = reader.readLine();
							
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}			
						anterior = actual;
						actual = "lobby";
						
						route();
						repaint();
						
					}
				});
		// Agregar el panel al JFrame
		this.add(login); 
		
		// Hacer el panel visible
		login.setVisible(true); 
		login.repaint();
		return login;
	}
	
	private JPanel lobby() {

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
		return lobby;
	}
	
	private JPanel cuenta() {
		JPanel cuenta = new JPanel();
		cuenta.setVisible(false);
		cuenta.setSize(500,800);
		cuenta.setBackground(Color.decode("#E1D8FF"));
		cuenta.setLayout(null);
		
		JLabel titulo = new JLabel("Mi Cuenta");
		titulo.setFont(new Font("Arial", Font.BOLD, 45));
		titulo.setSize(300, 40);
		titulo.setLocation(130, 30);
		cuenta.add(titulo);
		
		ImageIcon imagen = new ImageIcon("user.png");
		JLabel imagenA = new JLabel(imagen);
		imagenA.setLocation(150, 70);
		imagenA.setSize(200, 150);
		cuenta.add(imagenA);
		
		JLabel etiqueta1 = new JLabel("Nombre");
		etiqueta1.setSize(160, 50);
		etiqueta1.setLocation(30, 200);
		cuenta.add(etiqueta1);

		JTextField nombre = new JTextField();
		nombre.setSize(420, 30);
		nombre.setLocation(30, 240);
		cuenta.add(nombre);
		
		JLabel etiqueta2 = new JLabel("Apellidos");
		etiqueta2.setSize(160, 50);
		etiqueta2.setLocation(30, 280);
		cuenta.add(etiqueta2);

		JTextField apellido = new JTextField();
		apellido.setSize(420, 30);
		apellido.setLocation(30, 320);
		cuenta.add(apellido);
		
		JLabel etiqueta3 = new JLabel("Correo");
		etiqueta3.setSize(160, 50);
		etiqueta3.setLocation(30, 360);
		cuenta.add(etiqueta3);

		JTextField correo = new JTextField();
		correo.setSize(420, 30);
		correo.setLocation(30, 400);
		cuenta.add(correo);
		
		JLabel etiqueta4 = new JLabel("Contraseña");
		etiqueta4.setSize(160, 50);
		etiqueta4.setLocation(30, 440);
		cuenta.add(etiqueta4);

		JPasswordField pass = new JPasswordField();
		pass.setSize(420, 30);
		pass.setLocation(30, 480);
		cuenta.add(pass);
///////////////////////////////////////////////////////////////////////////		
		JButton edit = new JButton("Guardar");
		edit.setSize(120, 30);
		edit.setLocation(80, 550);
		edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				List<String> userList = new ArrayList<>();
				BufferedReader br;
				try {
					br = new BufferedReader(new FileReader("users.txt"));
					String line1 = br.readLine();
					while(line1 != null) {
						userList.add(line1);
						String datos1 [] = null;
						datos1 = line1.split(",");
						if(datos1[2].equals(correo.getText()) && !datos1[2].equals(usuarioLog.getCorreo())) {
							JOptionPane.showMessageDialog(null, "ERROR: Este correo ya esta en uso", " ", JOptionPane.PLAIN_MESSAGE);	
							return;
						}
						
						line1 = br.readLine();
					}
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				userList.set(usuarioLog.getCont(), nombre.getText() + "," + apellido.getText() + "," + correo.getText() + "," + String.valueOf(pass.getPassword()));
				
				try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("users.txt"));
					for(int i = 0; i < userList.size(); i++) {
						bw.write(userList.get(i));
						bw.flush();
						bw.newLine();
					}
					bw.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				anterior = actual;
				actual = "usuarios";
				
				route();
			}
			
		});
		cuenta.add(edit);
/////////////////////////////////////////////////////////////////////////////
		JButton cancelar = new JButton("Cancelar");
		cancelar.setSize(120, 30);
		cancelar.setLocation(270, 550);
		cancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				anterior = actual;
				actual = "cuenta";
				
				route();
			}
			
		});
		cuenta.add(cancelar);
		
		nombre.setText(usuarioLog.getNombre());
		apellido.setText(usuarioLog.getApellido());
		correo.setText(usuarioLog.getCorreo());
		pass.setText(usuarioLog.getContraseña());
		
		this.add(cuenta);
		cuenta.setVisible(true);
		cuenta.repaint();
		return cuenta;
	}
	
	private JPanel usuarios() {
		JPanel usuarios = new JPanel();
		usuarios.setVisible(false);
		usuarios.setSize(500,800);
		usuarios.setBackground(Color.decode("#E1D8FF"));
		usuarios.setLayout(null);
		
		JLabel titulo = new JLabel("Lista de Usuarios");
		titulo.setSize(220, 40);
		titulo.setLocation(135, 30);
		titulo.setFont(new Font("Arial", Font.BOLD, 25));
		usuarios.add(titulo);
		
		JLabel etiqueta1 = new JLabel("Editar");
		etiqueta1.setSize(150, 30);
		etiqueta1.setLocation(20, 80);
		etiqueta1.setFont(new Font("Arial", Font.BOLD, 15));
		usuarios.add(etiqueta1);
		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// LISTA COMBOBOX
		JComboBox lista = new JComboBox();
		lista.setSize(400,40);
		lista.setLocation(50, 110);
		List<String> userList = new ArrayList<>();

		try {
		    BufferedReader br = new BufferedReader(new FileReader("users.txt"));
		    String line;
		    while ((line = br.readLine()) != null) {
		    	String[] separador = line.split(",");
		        userList.add(separador[2]);
		    }
		    br.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		for (String user : userList) {
			lista.addItem(user);
		}
		usuarios.add(lista);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		JButton edit = new JButton("Editar");
		edit.setSize(400,40);
		edit.setLocation(50, 160);
		edit.setFont(new Font("Arial", Font.BOLD, 25));
		edit.addActionListener(new ActionListener(){
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String correoUser = (String)lista.getSelectedItem();
				
				try {
				    BufferedReader br = new BufferedReader(new FileReader("users.txt"));
				    String line;
				    int cont = 0;
				    while ((line = br.readLine()) != null) {
				    	String[] separador = line.split(",");
				      if(separador[2].equals(correoUser)) {
				    	  usuarioLog = new UsuarioLogeado(separador[0], separador[1], separador[2], separador[3], cont);
				    	  break;
				      }
				      cont++;
				    }
				    br.close();
				} catch (IOException e1) {
				    e1.printStackTrace();
				}
				actual = "cuenta";
				route();
			}
			
		});
		usuarios.add(edit);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		 ArrayList<String[]> datos2 = new ArrayList<>();
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
	        scrollPane.setLocation(50, 220);
	        usuarios.add(scrollPane);
        
		this.add(usuarios);
		usuarios.setVisible(true);
		usuarios.repaint();
		return usuarios;
	}
	
	private JPanel registro() {
		JPanel registro = new JPanel();
		registro.setVisible(false);
		registro.setSize(500,800);
		registro.setBackground(Color.decode("#E1D8FF"));
		registro.setLayout(null);
		
		JLabel etiquetaR = new JLabel("Ingrese sus datos");
		etiquetaR.setSize(300, 50);
		etiquetaR.setLocation(135, 10);
		etiquetaR.setFont(new Font("Arial", Font.BOLD, 25));
		registro.add(etiquetaR);
		
		ImageIcon imagen = new ImageIcon("file.png");
		JLabel imagenA = new JLabel(imagen);
		imagenA.setLocation(150, 70);
		imagenA.setSize(200, 150);
		registro.add(imagenA);
		
		// NOMBRE Y APELLIDOS
		JLabel etiquetaNom = new JLabel("Ingrese su nombre(s)");
		etiquetaNom.setSize(160, 50);
		etiquetaNom.setLocation(30, 220);
		registro.add(etiquetaNom);
		JTextField nomR = new JTextField();
		nomR.setSize(420, 30);
		nomR.setLocation(30, 260);
		registro.add(nomR);
		JLabel etiquetaAp = new JLabel("Ingrese sus apellidos");
		etiquetaAp.setSize(420, 30);
		etiquetaAp.setLocation(30, 310);
		registro.add(etiquetaAp);
		JTextField apR = new JTextField();
		apR.setSize(420, 30);
		apR.setLocation(30, 340);				
		registro.add(apR);
		// CORREO ELECTRONICO
		JLabel etiquetaCorreo = new JLabel("Ingrese su correo");
		etiquetaCorreo.setSize(160, 50);
		etiquetaCorreo.setLocation(30, 380);
		registro.add(etiquetaCorreo);
		JTextField correo = new JTextField();
		correo.setSize(420, 30);
		correo.setLocation(30, 420);
		registro.add(correo);
		// CONTRASEÑA Y REPITE CONTRASEÑA
		JLabel etiquetaCR = new JLabel("Ingrese contraseña");
		etiquetaCR.setSize(160,50);
		etiquetaCR.setLocation(30, 460);
		registro.add(etiquetaCR);
		JPasswordField pass1 = new JPasswordField();
		pass1.setSize(420, 30);
		pass1.setLocation(30,500);
		registro.add(pass1);
		JLabel etiquetaC2R = new JLabel("Repita contraseña");
		etiquetaC2R.setSize(160,30);
		etiquetaC2R.setLocation(30, 540);
		registro.add(etiquetaC2R);
		JPasswordField pass2 = new JPasswordField();
		pass2.setSize(420, 30);
		pass2.setLocation(30,580);
		registro.add(pass2);
		// TERMINOS Y CONDICIONES
		JCheckBox terminos = new JCheckBox("Acepto terminos y condiciones");
		terminos.setSize(230,30);
		terminos.setLocation(30,620);
		terminos.setOpaque(true);
		terminos.setBackground(Color.decode("#E1D8FF"));
		registro.add(terminos);
		// BOTON REGISTRAR
		JButton registrarU = new JButton("Crear");
		registrarU.setSize(120,30);
		registrarU.setLocation(50,660);
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
					anterior = actual;
					actual = "login";
					route();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			} 
			
		});
		registro.add(registrarU);
		// BOTON CANCELAR
		JButton cancelarR = new JButton("Cancelar");
		cancelarR.setSize(120,30);
		cancelarR.setLocation(310,660);
		cancelarR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "registro";
				
				route();
			}
			
		});
		registro.add(cancelarR);
		this.add(registro);
		registro.setVisible(true);
		registro.repaint();
		return registro;
	}
	
	private JPanel ayuda() {
		JPanel ayuda = new JPanel();
		ayuda.setVisible(false);
		ayuda.setSize(500,800);
		ayuda.setBackground(Color.decode("#E1D8FF"));
		ayuda.setLayout(null);
		
		// Etiqueta titulo
		JLabel titulo = new JLabel("¿Como crear un usuario?");
		titulo.setFont(new Font("Arial", Font.BOLD, 35));
		titulo.setSize(500, 45);
		titulo.setLocation(30, 20);
		ayuda.add(titulo);
		// Icono
		ImageIcon imagen = new ImageIcon("help.png");
		JLabel imagenA = new JLabel(imagen);
		imagenA.setLocation(150, 80);
		imagenA.setSize(200, 150);
		ayuda.add(imagenA);
		
		JLabel renglon1 = new JLabel("1.- Hacer click en la opcion 'Usuarios' en el menú superior");
		renglon1.setSize(500, 30);
		renglon1.setLocation(10, 300);
		renglon1.setFont(new Font("Arial", Font.BOLD, 15));
		ayuda.add(renglon1);
		JLabel renglon2 = new JLabel("2.- Hacer click en la opción 'Crear Usuario' en el menú desplegado");
		renglon2.setSize(500, 30);
		renglon2.setLocation(10, 330);
		renglon2.setFont(new Font("Arial", Font.BOLD, 15));
		ayuda.add(renglon2);
		JLabel renglon3 = new JLabel("3.- Llenas los campos solicitados");
		renglon3.setSize(500, 30);
		renglon3.setLocation(10, 360);
		renglon3.setFont(new Font("Arial", Font.BOLD, 15));
		ayuda.add(renglon3);
		JLabel renglon4 = new JLabel("4.- Pulsar el botón 'Crear Usuario'");
		renglon4.setSize(500, 30);
		renglon4.setLocation(10, 390);
		renglon4.setFont(new Font("Arial", Font.BOLD, 15));
		ayuda.add(renglon4);
		JLabel renglon5 = new JLabel("5.- Listo, el usuario se ha creado");
		renglon5.setSize(500, 30);
		renglon5.setLocation(10, 420);
		renglon5.setFont(new Font("Arial", Font.BOLD, 15));
		ayuda.add(renglon5);
		
		JButton botonAyuda = new JButton("Crear un usuario ahora");
		botonAyuda.setSize(200,30);
		botonAyuda.setLocation(150, 470);
		botonAyuda.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				anterior = actual;
				actual = "registro";
				
				route();
			}
			
		});
		ayuda.add(botonAyuda);

		this.add(ayuda);
		ayuda.setVisible(true);
		ayuda.repaint();
		return ayuda;
	}
}
