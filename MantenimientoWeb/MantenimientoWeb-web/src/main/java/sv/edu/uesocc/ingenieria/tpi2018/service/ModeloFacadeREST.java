/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Modelo;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.ModeloFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("modelo")
public class ModeloFacadeREST extends AbstractFacade<Modelo> {

    @EJB
    protected ModeloFacadeLocal dtEJB;
    
    @Override
    protected AbstractFacadeInterface<Modelo> entidad() {
        return dtEJB;
    }

    @Override
    protected Modelo New() {
        return new Modelo();
    }
    
}
