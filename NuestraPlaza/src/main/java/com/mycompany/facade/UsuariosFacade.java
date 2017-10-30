/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.facade;

import com.mycompany.entidades.Usuarios;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Oscar
 */
@Stateless
public class UsuariosFacade extends AbstractFacade<Usuarios> {

    @PersistenceContext(unitName = "com.mycompany_proyecto1_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosFacade() {
        super(Usuarios.class);
    }
    
    public Usuarios iniciarSesion(Usuarios us){
        Usuarios usuario = null;
        String consulta;
        try{
            consulta = "SELECT u FROM Usuarios u WHERE u.codigo = ?1 and u.contraseña = ?2";
            Query query =em.createQuery(consulta);
            query.setParameter(1, us.getCodigo());
            query.setParameter(2, us.getContraseña());
            List<Usuarios> lista = query.getResultList();
            System.out.print(consulta);
            if(!lista.isEmpty()){
                usuario = lista.get(0);
            }
        }catch(Exception e){
            System.out.print(e);
        }
        return usuario;
    }
}
