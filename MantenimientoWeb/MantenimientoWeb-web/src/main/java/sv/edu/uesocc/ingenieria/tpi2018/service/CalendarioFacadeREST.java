/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Calendario;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.CalendarioFacadeLocal;

/**
 *
 * @author ricky
 */
@Path("calendario")
public class CalendarioFacadeREST extends AbstractFacade<Calendario> {

    @EJB
    protected CalendarioFacadeLocal calendarioEJB;
    
    @Override
    protected AbstractFacadeInterface<Calendario> entidad() {
        return calendarioEJB;
    }

    @Override
    protected Calendario New() {
        return new Calendario();
    }
    
}
