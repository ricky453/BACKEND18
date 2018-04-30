/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Trabajadores;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.TrabajadoresFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("trabajadores")
public class TrabajadoresFacadeREST extends AbstractFacade<Trabajadores> {

    @EJB
    protected TrabajadoresFacadeLocal trabajadoresEJB;
    
    @Override
    protected AbstractFacadeInterface<Trabajadores> entidad() {
        return trabajadoresEJB;
    }

    @Override
    protected Trabajadores New() {
        return new Trabajadores();
    }
    
}
