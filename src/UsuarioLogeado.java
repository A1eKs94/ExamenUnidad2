
public class UsuarioLogeado {

	String nombre, apellido, correo, contraseña;
	int cont;
	
	public UsuarioLogeado(String nombre,String  apellido,String  correo,String  contraseña, int cont) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.cont = cont;
		
	}
	
	public void actualizarDatos(String nombre,String  apellido,String  correo,String  contraseña, int cont) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contraseña = contraseña;
		this.cont = cont;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public String getContraseña() {
		return contraseña;
	}

	public int getCont() {
		return cont;
	}
	
}
