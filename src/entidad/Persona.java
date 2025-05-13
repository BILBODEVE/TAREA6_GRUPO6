package entidad;

public class Persona {
	private String nombre;
	private String apellido;
	private int DNI;

	public Persona() {
	}

	public Persona(String nombre, String apellido, int dNI) {
		this.nombre = nombre;
		this.apellido = apellido;
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDNI() {
		return DNI;
	}

	public void setDNI(int dNI) {
		DNI = dNI;
	}

	@Override
	public String toString() {
		return nombre + " " + apellido + " " + DNI;
	}
	
	
}
