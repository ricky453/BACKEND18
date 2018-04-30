/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;


import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Equipo;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.EquipoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("equipo")
public class EquipoFacadeREST extends AbstractFacade<Equipo> {

    @EJB
    protected EquipoFacadeLocal cargoEJB;
    
    @Override
    protected AbstractFacadeInterface<Equipo> entidad() {
        return cargoEJB;
    }

    @Override
    protected Equipo New() {
        return new Equipo();
    }
    
}
