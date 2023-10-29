/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.math.BigDecimal;
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

public class BeanProducto {

    private List listaProducto;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private Integer idProducto;


    
    
    public void prueba() {
        System.out.println("Prueba = " + getNombreProducto() + "cantidad = " + getCantidad() + "precio = " + getPrecio());
    }

    @PostConstruct
    public void mostrar() {
        setListaProducto(CRUDs.CRUDProducto.universo());
    }

    public void limpiar() {
        setNombreProducto("");
        setCantidad(null);
        setPrecio(null);

    }

    public void insertar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            boolean flag = CRUDs.CRUDProducto.insert(nombreProducto, cantidad, precio, 1);
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

    public void seleccionarDatos(POJOs.Producto producto) {
        setIdProducto(producto.getIdProducto());
        setNombreProducto(producto.getNombreProducto());
        setCantidad(producto.getCantidad());
        setPrecio(producto.getPrecio());

    }

    public void modificar() {
        FacesContext context = FacesContext.getCurrentInstance();

        try {

            boolean flag = CRUDs.CRUDProducto.update(idProducto, nombreProducto, precio, 1);
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

            boolean flag = CRUDs.CRUDProducto.anular(idProducto, 1);
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

    /**
     * @return the nombreProducto
     */
    public String getNombreProducto() {
        return nombreProducto;
    }

    /**
     * @param nombreProducto the nombreProducto to set
     */
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the precio
     */
    public BigDecimal getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public List getListaProducto() {
        return listaProducto;
    }

    public void setListaProducto(List ListaProducto) {
        this.listaProducto = ListaProducto;
    }

    /**
     * @return the idProducto
     */
    public Integer getIdProducto() {
        return idProducto;
    }

    /**
     * @param idProducto the idProducto to set
     */
    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

}
