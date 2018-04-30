/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;


import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.DetalleEquipo;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.DetalleEquipoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("detalleEquipo")
public class DetalleEquipoFacadeREST extends AbstractFacade<DetalleEquipo> {
    @EJB
    protected DetalleEquipoFacadeLocal dtEJB;
    
    @Override
    protected AbstractFacadeInterface<DetalleEquipo> entidad() {
        return dtEJB;
    }

    @Override
    protected DetalleEquipo New() {
        return new DetalleEquipo();
    }

    
}
