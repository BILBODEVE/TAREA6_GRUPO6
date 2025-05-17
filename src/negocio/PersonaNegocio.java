package negocio;

import entidad.Persona;

public interface PersonaNegocio
{
	public boolean insert(Persona persona);
	public boolean update(Persona persona);
	public boolean verificarPersonaExiste(String dni);
}
