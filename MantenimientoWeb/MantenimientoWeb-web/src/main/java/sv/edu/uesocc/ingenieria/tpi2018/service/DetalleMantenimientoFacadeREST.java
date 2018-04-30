/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.DetalleMantenimiento;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.DetalleMantenimientoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("detalleMantenimiento")
public class DetalleMantenimientoFacadeREST extends AbstractFacade<DetalleMantenimiento> {
    @EJB
    protected DetalleMantenimientoFacadeLocal dmEJB;
    
    @Override
    protected AbstractFacadeInterface<DetalleMantenimiento> entidad() {
        return dmEJB;
    }

    @Override
    protected DetalleMantenimiento New() {
        return new DetalleMantenimiento();
    }

}
