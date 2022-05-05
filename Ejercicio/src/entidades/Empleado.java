package entidades;

public class Empleado {
	
	private int dni;
	private int sueldoBase;	
	private String apellido;
	private String nombre;
	private String email;
	
	public Empleado() {
		this.setDni(0);
		this.setNombre("");
		this.setApellido("");
		this.setEmail("");
		this.setSueldobase(0);		
	}
	
	public Empleado(int dni, String nombre, String apellido, String email, int sueldoBase) {
		this();
		this.setDni(dni);
		this.setNombre(nombre);
		this.setApellido(apellido);		
		this.setEmail(email);
		this.setSueldobase(sueldoBase);
	}

	public int getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldobase(int sueldobase) {
		this.sueldoBase = sueldobase;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	
	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getDatos() {
		String datos = this.getApellido()+", "+this.getNombre();
		return datos;
	}

}
