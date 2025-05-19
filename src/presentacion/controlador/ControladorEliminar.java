package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.PanelEliminarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorEliminar implements ActionListener {

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
		cargarModal();
		ventanaPrincipal.getCardLayout().show(ventanaPrincipal.getPanelContenido(), "ELIMINAR");
	}

	private void configurarListeners() {

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
			cargarModal(); // Refrescar la lista
		} else {
			JOptionPane.showMessageDialog(null, "Error, no se pudo eliminar la persona.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}

	private void cargarModal() {
		listaPersonas = personaNegocio.obtenerPersonas();
		ControladorGeneral.cargarModal(listaPersonas, panelEliminarPersona.getModel());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
