package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Samayoa
 */
@ManagedBean
@ViewScoped
public class BeanCliente {

    private List listaCliente;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String nit;
    private String direccion;
    private String telefono;
    private Integer idCliente;

    public void prueba() {
        System.out.println("Prueba = " + getNombre1() + "n2 = " + getNombre2() + "ap1 = " + getApellido1() + "ap2" + getApellido2() + "nit" + getNit() + "direccion" + getDireccion() + "telefono" + getTelefono());
    }

    public void limpiar() {
        setNombre1("");
        setNombre2("");
        setApellido1("");
        setApellido2("");
        setNit("");
        setDireccion("");
        setTelefono("");

    }

    @PostConstruct
    public void mostrar() {
        setListaCliente(CRUDs.CRUDCliente.universo());
    }

    public void insertar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            boolean flag = CRUDs.CRUDCliente.insert(nombre1, nombre2, apellido1, apellido2, nit, direccion, telefono, 1);
            if (flag) {
                context.addMessage(null, new FacesMessage("Exito", "Registro Ingresado"));
                mostrar();
                limpiar();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Registro fallido"));

            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error", "Error"));
            System.out.println("Error = " + e);

        }

    }

    public void seleccionarDatos(POJOs.Cliente cliente) {
        setIdCliente(cliente.getIdCliente());
        setNombre1(cliente.getNombre1());
        setNombre2(cliente.getNombre2());

        setApellido1(cliente.getApellido1());
        setApellido2(cliente.getApellido2());

        setNit(cliente.getNit());
        setDireccion(cliente.getDireccion());
        setTelefono(cliente.getTelefono());

    }

    public void modificar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            boolean flag = CRUDs.CRUDCliente.update(idCliente, nombre1, nombre2, apellido1, apellido2, nit, direccion, telefono, 1);
            if (flag) {
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro modificado"));
                limpiar();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Registro fallido"));

            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error", "Error"));
            System.out.println("Error = " + e);

        }

    }

    public void anular() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            boolean flag = CRUDs.CRUDCliente.anular(idCliente, 1);
            if (flag) {
                mostrar();
                context.addMessage(null, new FacesMessage("Exito", "Registro anulado"));
                limpiar();
            } else {
                context.addMessage(null, new FacesMessage("Error", "Anulación fallida"));

            }

        } catch (Exception e) {
            context.addMessage(null, new FacesMessage("Error", "Error"));
            System.out.println("Error = " + e);

        }

    }

    public List getListaCliente() {
        return listaCliente;
    }

    public void setListaCliente(List listaCliente) {
        this.listaCliente = listaCliente;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}
