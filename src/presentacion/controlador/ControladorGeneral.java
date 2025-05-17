package presentacion.controlador;

import presentancion.vista.VentanaPrincipal;
import javax.swing.DefaultListModel;
import entidad.Persona;

public class ControladorGeneral {

    private VentanaPrincipal ventanaPrincipal;
    private ControladorAgregar controladorAgregar;
    private ControladorModificar controladorModificar;
    private DefaultListModel<Persona> listaPersonas;

    public ControladorGeneral() {
        ventanaPrincipal = new VentanaPrincipal();
        listaPersonas = new DefaultListModel<>();

        controladorAgregar = new ControladorAgregar(ventanaPrincipal, listaPersonas);
        controladorModificar = new ControladorModificar(ventanaPrincipal, listaPersonas);

        inicializar();
    }

    public void inicializar() {
        ventanaPrincipal.setVisible(true);
    }
}
