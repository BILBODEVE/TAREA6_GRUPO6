package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.VentanaAgregarPersona;
import presentancion.vista.VentanaEliminarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorEliminar implements ActionListener {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaEliminarPersona ventanaEliminarPersona;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();
	private ArrayList<Persona> listaPersonas;

	public ControladorEliminar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		ventanaEliminarPersona = VentanaEliminarPersona.getInstancia();

		ventanaPrincipal.getMnitemEliminar().addActionListener(a -> EventoClickMenu_EliminarPersona(a));

		configurarListeners();
	}

	public void EventoClickMenu_EliminarPersona(ActionEvent a) {
		cargarModal();
		ventanaEliminarPersona.cambiarVisibilidad(true);

	}

	private void configurarListeners() {
		// Si se selecciona una persona de la lista:
		ventanaEliminarPersona.getListaPersonas().addListSelectionListener(e -> {
			if (!e.getValueIsAdjusting()) {
				Persona personaSeleccionada = ventanaEliminarPersona.getPersonaSeleccionada();
				if (personaSeleccionada != null) {
					ventanaEliminarPersona.setPersonaSeleccionada(personaSeleccionada);
				}
			}
		});

		// Btn Eliminar
		ventanaEliminarPersona.getBtnEliminarPersona().addActionListener(e -> {
			Persona personaSeleccionada = ventanaEliminarPersona.getPersonaSeleccionada();
			if (personaSeleccionada == null) {
				JOptionPane.showMessageDialog(ventanaEliminarPersona, "Debe seleccionar una persona para eliminar.",
						"Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			}
			EliminarPersona(personaSeleccionada);
		});
	}

	private void EliminarPersona(Persona persona) {

		boolean exito = personaNegocio.delete(persona);

		if (exito) {
			JOptionPane.showMessageDialog(ventanaEliminarPersona, "Persona eliminada con éxito.");
			cargarModal();
		} else {
			JOptionPane.showMessageDialog(ventanaEliminarPersona, "Error, no se pudo eliminar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
		;
	}

	private void cargarModal() {
		listaPersonas = personaNegocio.obtenerPersonas();
		ControladorGeneral.cargarModal(listaPersonas, ventanaEliminarPersona.getModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
