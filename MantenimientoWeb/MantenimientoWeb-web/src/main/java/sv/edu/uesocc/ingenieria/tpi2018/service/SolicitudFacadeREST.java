/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Solicitud;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.SolicitudFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("solicitud")
public class SolicitudFacadeREST extends AbstractFacade<Solicitud> {

    @EJB
    protected SolicitudFacadeLocal solicitudEJB;
    
    @Override
    protected AbstractFacadeInterface<Solicitud> entidad() {
        return solicitudEJB;
    }

    @Override
    protected Solicitud New() {
        return new Solicitud();
    }
}
