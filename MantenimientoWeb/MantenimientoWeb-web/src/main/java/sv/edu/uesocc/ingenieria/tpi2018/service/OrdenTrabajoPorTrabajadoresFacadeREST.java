/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;


import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.OrdenTrabajoPorTrabajadores;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.OrdenTrabajoPorTrabajadoresFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("ordenTrabajoPorTrabajadores")
public class OrdenTrabajoPorTrabajadoresFacadeREST extends AbstractFacade<OrdenTrabajoPorTrabajadores> {

    @EJB
    protected OrdenTrabajoPorTrabajadoresFacadeLocal otptEJB;
    
    @Override
    protected AbstractFacadeInterface<OrdenTrabajoPorTrabajadores> entidad() {
        return otptEJB;
    }

    @Override
    protected OrdenTrabajoPorTrabajadores New() {
        return new OrdenTrabajoPorTrabajadores();
    }
}
