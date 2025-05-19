package dao;

import java.util.ArrayList;
import entidad.Persona;

public interface PersonaDao {
	public boolean insert(Persona persona);

	public boolean update(Persona persona);

	public boolean delete(Persona persona);

	public Persona obtenerPersona(String dni);

	public ArrayList<Persona> obtenerPersonas();
}
