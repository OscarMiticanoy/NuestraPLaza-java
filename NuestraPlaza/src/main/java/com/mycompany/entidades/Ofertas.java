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
@Table(name = "ofertas")
@NamedQueries({
    @NamedQuery(name = "Ofertas.findAll", query = "SELECT o FROM Ofertas o")
    , @NamedQuery(name = "Ofertas.findByIdOfertas", query = "SELECT o FROM Ofertas o WHERE o.idOfertas = :idOfertas")
    , @NamedQuery(name = "Ofertas.findByFechaCosecha", query = "SELECT o FROM Ofertas o WHERE o.fechaCosecha = :fechaCosecha")
    , @NamedQuery(name = "Ofertas.findByCantidad", query = "SELECT o FROM Ofertas o WHERE o.cantidad = :cantidad")
    , @NamedQuery(name = "Ofertas.findByValor", query = "SELECT o FROM Ofertas o WHERE o.valor = :valor")})
public class Ofertas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_ofertas")
    private Integer idOfertas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_cosecha")
    @Temporal(TemporalType.DATE)
    private Date fechaCosecha;
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
    @JoinColumn(name = "id_producto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produtos idProducto;

    public Ofertas() {
    }

    public Ofertas(Integer idOfertas) {
        this.idOfertas = idOfertas;
    }

    public Ofertas(Integer idOfertas, Date fechaCosecha, int cantidad, int valor) {
        this.idOfertas = idOfertas;
        this.fechaCosecha = fechaCosecha;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Integer getIdOfertas() {
        return idOfertas;
    }

    public void setIdOfertas(Integer idOfertas) {
        this.idOfertas = idOfertas;
    }

    public Date getFechaCosecha() {
        return fechaCosecha;
    }

    public void setFechaCosecha(Date fechaCosecha) {
        this.fechaCosecha = fechaCosecha;
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

    public Produtos getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Produtos idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idOfertas != null ? idOfertas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ofertas)) {
            return false;
        }
        Ofertas other = (Ofertas) object;
        if ((this.idOfertas == null && other.idOfertas != null) || (this.idOfertas != null && !this.idOfertas.equals(other.idOfertas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Ofertas[ idOfertas=" + idOfertas + " ]";
    }
    
}
