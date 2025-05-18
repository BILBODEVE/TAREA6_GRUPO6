package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import entidad.Persona;
import negocio.PersonaNegocio;
import negocioImpl.PersonaNegocioImpl;
import presentancion.vista.VentanaListarPersona;
import presentancion.vista.VentanaPrincipal;

public class ControladorListar {
	private VentanaPrincipal ventanaPrincipal;
	private VentanaListarPersona ventanaListarPersona;
	private PersonaNegocio personaNegocio = new PersonaNegocioImpl();
	private ArrayList<Persona> listaPersonas;

	public ControladorListar(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
		ventanaListarPersona = VentanaListarPersona.getInstancia();

		ventanaPrincipal.getMnitemListar().addActionListener(a -> EventoClickMenu_ListarPersona(a));
	}

	public void EventoClickMenu_ListarPersona(ActionEvent e) {
		cargarModal();
        cargarPersonasEnTabla();
        ventanaListarPersona.setVisible(true);
    }

    private void cargarPersonasEnTabla() {
    	ArrayList<Persona> personas;
		try {
			personas = personaNegocio.obtenerPersonas();
			
			DefaultTableModel modelo = ventanaListarPersona.getModeloTabla();

	        for (Persona p : personas) {
	            Object[] fila = {
	                p.getNombre(),
	                p.getApellido(),
	                p.getDNI()
	            };
	            modelo.addRow(fila);
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
	public void inicializar() {
		ventanaPrincipal.setVisible(true);
	}

	private void cargarModal() {
		listaPersonas = personaNegocio.obtenerPersonas();
		ControladorGeneral.cargarModal(listaPersonas, ventanaListarPersona.getModel());
	}

}
