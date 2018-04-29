/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.sessions;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Trabajadores;

/**
 *
 * @author ricky
 */
@Stateless
public class TrabajadoresFacade extends AbstractFacade<Trabajadores> implements TrabajadoresFacadeLocal {

    @PersistenceContext(unitName = "sv.edu.uesocc.ingenieria.tpi2018_MantenimientoWeb-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TrabajadoresFacade() {
        super(Trabajadores.class);
    }
    
}
