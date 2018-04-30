/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Cargo;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.CargoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("cargo")
public class CargoFacadeREST extends AbstractFacade<Cargo> {

    @EJB
    protected CargoFacadeLocal cargoEJB;
    
    @Override
    protected AbstractFacadeInterface<Cargo> entidad() {
        return cargoEJB;
    }

    @Override
    protected Cargo New() {
        return new Cargo();
    }
    
}
