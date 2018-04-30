/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.OrdenTrabajo;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.OrdenTrabajoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("ordenTrabajo")
public class OrdenTrabajoFacadeREST extends AbstractFacade<OrdenTrabajo> {

    @EJB
    protected OrdenTrabajoFacadeLocal otEJB;
    
    @Override
    protected AbstractFacadeInterface<OrdenTrabajo> entidad() {
        return otEJB;
    }

    @Override
    protected OrdenTrabajo New() {
        return new OrdenTrabajo();
    }
    
}
