/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "demanda")
@NamedQueries({
    @NamedQuery(name = "Demanda.findAll", query = "SELECT d FROM Demanda d")
    , @NamedQuery(name = "Demanda.findByIdDemanda", query = "SELECT d FROM Demanda d WHERE d.idDemanda = :idDemanda")
    , @NamedQuery(name = "Demanda.findByCantidad", query = "SELECT d FROM Demanda d WHERE d.cantidad = :cantidad")
    , @NamedQuery(name = "Demanda.findByValor", query = "SELECT d FROM Demanda d WHERE d.valor = :valor")})
public class Demanda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_demanda")
    private Integer idDemanda;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "valor")
    private int valor;
    @JoinColumn(name = "codigo_comprador", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Usuarios codigoComprador;
    @JoinColumn(name = "id_producto", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Produtos idProducto;

    public Demanda() {
    }

    public Demanda(Integer idDemanda) {
        this.idDemanda = idDemanda;
    }

    public Demanda(Integer idDemanda, int cantidad, int valor) {
        this.idDemanda = idDemanda;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    public Integer getIdDemanda() {
        return idDemanda;
    }

    public void setIdDemanda(Integer idDemanda) {
        this.idDemanda = idDemanda;
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
        hash += (idDemanda != null ? idDemanda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Demanda)) {
            return false;
        }
        Demanda other = (Demanda) object;
        if ((this.idDemanda == null && other.idDemanda != null) || (this.idDemanda != null && !this.idDemanda.equals(other.idDemanda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Demanda[ idDemanda=" + idDemanda + " ]";
    }
    
}
