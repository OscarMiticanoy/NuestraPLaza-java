/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "ventas")
@NamedQueries({
    @NamedQuery(name = "Ventas.findAll", query = "SELECT v FROM Ventas v")
    , @NamedQuery(name = "Ventas.findByIdVenta", query = "SELECT v FROM Ventas v WHERE v.idVenta = :idVenta")
    , @NamedQuery(name = "Ventas.findByFechaVenta", query = "SELECT v FROM Ventas v WHERE v.fechaVenta = :fechaVenta")
    , @NamedQuery(name = "Ventas.findByCantidad", query = "SELECT v FROM Ventas v WHERE v.cantidad = :cantidad")
    , @NamedQuery(name = "Ventas.findByValor", query = "SELECT v FROM Ventas v WHERE v.valor = :valor")})
public class Ventas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_venta")
    private Integer idVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_venta")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "codigo_vendedor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuarios codigoVendedor;
    @JoinColumn(name = "codigo_comprador", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuarios codigoComprador;
    @JoinColumn(name = "id_producto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produtos idProducto;

    public Ventas() {
    }

    public Ventas(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Ventas(Integer idVenta, Date fechaVenta, int cantidad, int valor) {
        this.idVenta = idVenta;
        this.fechaVenta = fechaVenta;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Usuarios getCodigoVendedor() {
        return codigoVendedor;
    }

    public void setCodigoVendedor(Usuarios codigoVendedor) {
        this.codigoVendedor = codigoVendedor;
    }

    public Usuarios getCodigoComprador() {
        return codigoComprador;
    }

    public void setCodigoComprador(Usuarios codigoComprador) {
        this.codigoComprador = codigoComprador;
    }

    public Produtos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Produtos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ventas)) {
            return false;
        }
        Ventas other = (Ventas) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Ventas[ idVenta=" + idVenta + " ]";
    }
    
}
