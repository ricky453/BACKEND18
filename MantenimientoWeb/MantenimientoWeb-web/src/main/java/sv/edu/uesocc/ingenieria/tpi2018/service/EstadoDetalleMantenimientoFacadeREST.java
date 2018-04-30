/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.EstadoDetalleMantenimiento;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.EstadoDetalleMantenimientoFacadeLocal;

/**
 *
 * @author ricky
 */
@Path("estadoDetalleMantenimiento")
public class EstadoDetalleMantenimientoFacadeREST extends AbstractFacade<EstadoDetalleMantenimiento> {

    @EJB
    protected EstadoDetalleMantenimientoFacadeLocal edmEJB;
    
    @Override
    protected AbstractFacadeInterface<EstadoDetalleMantenimiento> entidad() {
        return edmEJB;
    }

    @Override
    protected EstadoDetalleMantenimiento New() {
        return new EstadoDetalleMantenimiento();
    }
}
