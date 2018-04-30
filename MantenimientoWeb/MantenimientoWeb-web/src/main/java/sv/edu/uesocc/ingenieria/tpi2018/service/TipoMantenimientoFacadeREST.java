/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.TipoMantenimiento;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.TipoMantenimientoFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.extras.BuscarPorNombre;

/**
 *
 * @author ricky
 */
@Path("tipoMantenimiento")
public class TipoMantenimientoFacadeREST extends AbstractFacade<TipoMantenimiento> implements BuscarPorNombre<TipoMantenimiento>{

    @EJB
    protected TipoMantenimientoFacadeLocal tmEJB;
    
    @Override
    protected AbstractFacadeInterface<TipoMantenimiento> entidad() {
        return tmEJB;
    }

    @Override
    protected TipoMantenimiento New() {
        return new TipoMantenimiento();
    }
    
    @Override
    public AbstractFacadeInterface<TipoMantenimiento> getEntidad(){
        return tmEJB;
    }
    
}
