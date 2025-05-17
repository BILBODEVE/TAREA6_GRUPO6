package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.VentanaModificar;
import presentancion.vista.VentanaPrincipal;

public class ControladorModificar implements ActionListener{
	private VentanaPrincipal ventanaPrincipal;
	private VentanaModificar ventanaModificar;
	private DefaultListModel<Persona> listaPersonas;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();

	    public ControladorModificar(VentanaPrincipal ventanaPrincipal, DefaultListModel<Persona> listaPersonas) {
	        this.ventanaPrincipal = ventanaPrincipal;
	        this.listaPersonas = listaPersonas;
	        this.ventanaModificar = VentanaModificar.getInstancia(listaPersonas);

	        ventanaPrincipal.getMnitemModificar().addActionListener(e -> {
	            ventanaModificar.setVisible(true);  // o ventanaModificar.setVisible(true);
	        });

	        configurarListeners();
	    }

	    private void configurarListeners() {
	        // Si se selecciona una persona de la lista:
	        ventanaModificar.getListaPersonas().addListSelectionListener(e -> {
	            if (!e.getValueIsAdjusting()) {
	                Persona personaSeleccionada = ventanaModificar.getListaPersonas().getSelectedValue();
	                if (personaSeleccionada != null) {
	                    ventanaModificar.setPersonaSeleccionada(personaSeleccionada);
	                    cargarDatosPersona(personaSeleccionada);
	                }
	            }
	        });

	        // Btn Modificar
	        ventanaModificar.getBtnModificar().addActionListener(e -> {
	            Persona personaSeleccionada = ventanaModificar.getPersonaSeleccionada();
	            if (personaSeleccionada == null) {
	                JOptionPane.showMessageDialog(ventanaModificar, "Debe seleccionar una persona para modificar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	                return;
	            }
	            modificarPersona(personaSeleccionada);
	        });
	    }

	    private void cargarDatosPersona(Persona persona) {
	        ventanaModificar.getTxtNombre().setText(persona.getNombre());
	        ventanaModificar.getTxtApellido().setText(persona.getApellido());
	        ventanaModificar.getTxtDni().setText(persona.getDNI());
	    }

	    private void modificarPersona(Persona persona) {
	        String nombre = ventanaModificar.getTxtNombre().getText();
	        String apellido = ventanaModificar.getTxtApellido().getText();
	        String dni = ventanaModificar.getTxtDni().getText();

	        if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty()) {
	            JOptionPane.showMessageDialog(ventanaModificar, "Todos los campos son obligatorios.", "Advertencia", JOptionPane.WARNING_MESSAGE);
	            return;
	        }

	        persona.setNombre(nombre);
	        persona.setApellido(apellido);
	        persona.setDNI(dni);

	        boolean exito = personaNegocio.update(persona);

	        if (exito) {
	            JOptionPane.showMessageDialog(ventanaModificar, "Persona modificada con éxito.");
	            ventanaModificar.dispose();
	        } else {
	            JOptionPane.showMessageDialog(ventanaModificar, "Error al modificar la persona.", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	    }
	
	public void inicializar()
	{
		ventanaPrincipal.setVisible(true);;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void limpiarCampos() {
        ventanaModificar.getTxtNombre().setText("");
        ventanaModificar.getTxtApellido().setText("");
        ventanaModificar.getTxtDni().setText("");
    }


}
