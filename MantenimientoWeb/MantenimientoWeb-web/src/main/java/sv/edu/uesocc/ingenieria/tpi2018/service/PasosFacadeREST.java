/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Pasos;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.PasosFacadeLocal;
import sv.edu.uesocc.ingenieria.tpi2018.extras.BuscarPorNombre;
/**
 *
 * @author ricky
 */
@Path("pasos")
public class PasosFacadeREST extends AbstractFacade<Pasos> implements BuscarPorNombre<Pasos>{

    @EJB
    protected PasosFacadeLocal pasosEJB;
    
    @Override
    protected AbstractFacadeInterface<Pasos> entidad() {
        return pasosEJB;
    }

    @Override
    protected Pasos New() {
        return new Pasos();
    }
    
    @Override
    public AbstractFacadeInterface<Pasos> getEntidad(){
        return pasosEJB;
    }
    
}
