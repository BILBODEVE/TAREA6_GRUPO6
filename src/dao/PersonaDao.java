package dao;

import entidad.Persona;

public interface PersonaDao
{
	public boolean insert(Persona persona);
	public boolean update(Persona persona);
	public Persona obtenerPersona(String dni);
}
