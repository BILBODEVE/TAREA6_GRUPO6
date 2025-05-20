package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.PanelEliminarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorEliminar {

	private VentanaPrincipal ventanaPrincipal;
	private PanelEliminarPersona panelEliminarPersona;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();
	private ArrayList<Persona> listaPersonas;

	public ControladorEliminar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;

		this.panelEliminarPersona = new PanelEliminarPersona();
		ventanaPrincipal.getPanelContenido().add(panelEliminarPersona, "ELIMINAR");

		ventanaPrincipal.getMnitemEliminar().addActionListener(a -> EventoClickMenu_EliminarPersona(a));

		configurarListeners();
	}

	public void EventoClickMenu_EliminarPersona(ActionEvent a) {
		cargarTabla();
		ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanelContenido(), "ELIMINAR");
	}

	private void configurarListeners() {
<<<<<<< HEAD
		// Botón Eliminar
=======

		panelEliminarPersona.getListaPersonas().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					Persona personaSeleccionada = panelEliminarPersona.getPersonaSeleccionada();
					if (personaSeleccionada != null) {
						panelEliminarPersona.setPersonaSeleccionada(personaSeleccionada);
					}
				}
			}
		});

		// Btn Eliminar
>>>>>>> 676eed125df1db7cdc216da2bb4ce619d1daa282
		panelEliminarPersona.getBtnEliminarPersona().addActionListener(e -> {
			Persona personaSeleccionada = panelEliminarPersona.getPersonaSeleccionada();
			if (personaSeleccionada == null) {
				JOptionPane.showMessageDialog(null, "Debe seleccionar una persona para eliminar.", "Advertencia",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			EliminarPersona(personaSeleccionada);
		});
	}

	private void EliminarPersona(Persona persona) {
		boolean exito = personaNegocio.delete(persona);

		if (exito) {
			JOptionPane.showMessageDialog(null, "Persona eliminada con éxito.");
			cargarTabla(); // Refrescar tabla
		} else {
			JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void cargarTabla() {
		listaPersonas = personaNegocio.obtenerPersonas();
		DefaultTableModel modelo = panelEliminarPersona.getModeloTabla();
		modelo.setRowCount(0); // Limpia tabla

		for (Persona p : listaPersonas) {
			modelo.addRow(new Object[]{p.getNombre(), p.getApellido(), p.getDNI()});
		}
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}

}

