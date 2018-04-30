/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Procedimiento;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.ProcedimientoFacadeLocal;

/**
 *
 * @author ricky
 */
@Path("procedimiento")
public class ProcedimientoFacadeREST extends AbstractFacade<Procedimiento> {

    @EJB
    protected ProcedimientoFacadeLocal procedimientoEJB;
    
    @Override
    protected AbstractFacadeInterface<Procedimiento> entidad() {
        return procedimientoEJB;
    }

    @Override
    protected Procedimiento New() {
        return new Procedimiento();
    }
    
}
