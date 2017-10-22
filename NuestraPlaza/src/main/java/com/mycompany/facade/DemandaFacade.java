/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.entidades.Demanda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Oscar
 */
@Stateless
public class DemandaFacade extends AbstractFacade<Demanda> {

    @PersistenceContext(unitName = "com.mycompany_NuestraPlaza_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DemandaFacade() {
        super(Demanda.class);
    }
    
}
