package negocio;

import java.util.ArrayList;
import entidad.Persona;

public interface PersonaNegocio {
	public boolean insert(Persona persona);

	public boolean update(Persona persona);

	public boolean verificarPersonaExiste(String dni);

	public boolean delete(Persona persona);

	public ArrayList<Persona> obtenerPersonas();
}
