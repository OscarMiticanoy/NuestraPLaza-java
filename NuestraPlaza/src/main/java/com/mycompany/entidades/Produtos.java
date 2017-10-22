/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Oscar
 */
@Entity
@Table(name = "produtos")
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p")
    , @NamedQuery(name = "Produtos.findByCodigo", query = "SELECT p FROM Produtos p WHERE p.codigo = :codigo")
    , @NamedQuery(name = "Produtos.findByNombre", query = "SELECT p FROM Produtos p WHERE p.nombre = :nombre")})
public class Produtos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Demanda> demandaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Ofertas> ofertasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProducto")
    private List<Ventas> ventasList;

    public Produtos() {
    }

    public Produtos(Integer codigo) {
        this.codigo = codigo;
    }

    public Produtos(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Demanda> getDemandaList() {
        return demandaList;
    }

    public void setDemandaList(List<Demanda> demandaList) {
        this.demandaList = demandaList;
    }

    public List<Ofertas> getOfertasList() {
        return ofertasList;
    }

    public void setOfertasList(List<Ofertas> ofertasList) {
        this.ofertasList = ofertasList;
    }

    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.entidades.Produtos[ codigo=" + codigo + " ]";
    }
    
}
