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
import sv.edu.uesocc.ingenieria.tpi2018.extras.BuscarPorNombre;

/**
 *
 * @author ricky
 */

@Path("modelo")
public class ModeloFacadeREST extends AbstractFacade<Modelo> implements BuscarPorNombre<Modelo>{

    @EJB
    protected ModeloFacadeLocal modeloEJB;
    
    @Override
    protected AbstractFacadeInterface<Modelo> entidad() {
        return modeloEJB;
    }

    @Override
    protected Modelo New() {
        return new Modelo();
    }
    
    @Override
    public AbstractFacadeInterface<Modelo> getEntidad(){
        return modeloEJB;
    }
    
}
