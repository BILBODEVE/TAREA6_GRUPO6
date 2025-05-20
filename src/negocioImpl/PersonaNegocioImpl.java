package negocioImpl;

import java.util.ArrayList;

import dao.PersonaDao;
import daoImpl.PersonaDaoImpl;
import entidad.Persona;
import negocio.PersonaNegocio;

public class PersonaNegocioImpl implements PersonaNegocio {

	PersonaDao pdao = new PersonaDaoImpl();

	@Override
	public boolean insert(Persona persona) {

		boolean estado = false;
		if (persona.getNombre().trim().length() > 0 && persona.getApellido().trim().length() > 0
				&& persona.getDNI().trim().length() > 0) {
			estado = pdao.insert(persona);
		}
		return estado;
	}

	@Override
	public boolean update(Persona persona) {

		boolean estado = false;
		if (persona.getNombre().trim().length() > 0 && persona.getApellido().trim().length() > 0) {
			estado = pdao.update(persona);
		}
		return estado;
	}

	@Override
	public boolean delete(Persona persona) {
		boolean estado = false;

		if (persona != null) {
			estado = pdao.delete(persona);
		}

		return estado;
	}

	@Override
	public boolean verificarPersonaExiste(String dni) {

		PersonaDaoImpl pdi = new PersonaDaoImpl();
		Persona p = pdi.obtenerPersona(dni);
		if (p == null) {
			return false;
		}
		return true;
	}

	@Override
	public ArrayList<Persona> obtenerPersonas() {
		return pdao.obtenerPersonas();
	}

}
