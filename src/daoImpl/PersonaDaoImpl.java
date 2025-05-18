package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dao.PersonaDao;
import entidad.Persona;

public class PersonaDaoImpl implements PersonaDao {
	private static final String insert = "INSERT INTO Personas(Nombre, Apellido,Dni) VALUES(?, ?, ?)";
	private static final String update = "UPDATE Personas SET Nombre = ?, Apellido = ? WHERE Dni = ?";
	private static final String select = "SELECT DNI, Nombre, Apellido FROM personas where dni= ?;";
	private static final String delete = "DELETE FROM personas WHERE Nombre= ? AND Apellido= ? AND Dni= ?";
	private static final String selectAll = "SELECT * FROM personas";

	@Override
	public boolean insert(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isInsertExitoso = false;
		try {
			statement = conexion.prepareStatement(insert);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDNI());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isInsertExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isInsertExitoso;
	}

	public boolean update(Persona persona) {
		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isUpdateExitoso = false;
		try {
			statement = conexion.prepareStatement(update);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDNI());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isUpdateExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isUpdateExitoso;
	}

	@Override
	public Persona obtenerPersona(String dni) {

		PreparedStatement st;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		Persona p = null;

		try {
			st = conexion.prepareStatement(select);
			st.setString(1, dni);

			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				p = new Persona();
				p.setDNI(rs.getString("DNI"));
				p.setNombre(rs.getString("Nombre"));
				p.setApellido(rs.getString("Apellido"));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return p;
	}

	public boolean delete(Persona persona) {

		PreparedStatement statement;
		Connection conexion = Conexion.getConexion().getSQLConexion();
		boolean isDeleteExitoso = false;
		try {
			statement = conexion.prepareStatement(delete);
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDNI());
			if (statement.executeUpdate() > 0) {
				conexion.commit();
				isDeleteExitoso = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		return isDeleteExitoso;
	}

	public ArrayList<Persona> obtenerPersonas() {
		ResultSet resultSet;
		ArrayList<Persona> personas = new ArrayList<Persona>();

		try {

			Connection conexion = Conexion.getConexion().getSQLConexion();
			Statement statement = conexion.createStatement();
			resultSet = statement.executeQuery(selectAll);

			while (resultSet.next()) {
				Persona persona = new Persona();
				persona.setDNI(Integer.toString(resultSet.getInt(1)));
				persona.setNombre(resultSet.getString(2));
				persona.setApellido(resultSet.getString(3));
				personas.add(persona);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return personas;
	}

}
