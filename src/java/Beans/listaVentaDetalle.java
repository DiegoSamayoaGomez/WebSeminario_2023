/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import java.math.BigDecimal;

/**
 *
 * @author Samayoa
 */
public class listaVentaDetalle {
    
    private Integer idVentaDetalle;
    private String nombreProducto;
    private Integer cantidad;
    private BigDecimal precio;
    private BigDecimal total;

    public listaVentaDetalle(Integer idVentaDetalle, String nombreProducto, Integer cantidad, BigDecimal precio, BigDecimal total) {
        this.idVentaDetalle = idVentaDetalle;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }
      

    /**
     * @return the idVentaDetalle
     */
    public Integer getIdVentaDetalle() {
        return idVentaDetalle;
    }

    /**
     * @param idVentaDetalle the idVentaDetalle to set
     */
    public void setIdVentaDetalle(Integer idVentaDetalle) {
        this.idVentaDetalle = idVentaDetalle;
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

    /**
     * @return the total
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }
    
    
    
}
