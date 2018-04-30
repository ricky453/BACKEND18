/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import sv.edu.uesocc.ingenieria.tpi2018.extras.NombrePorEntidad;
import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Marca;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.MarcaFacadeLocal;

/**
 *
 * @author ricky
 */
@Path("marca")
public class MarcaFacadeREST extends AbstractFacade<Marca> implements NombrePorEntidad<Marca>{
    
    @EJB
    protected MarcaFacadeLocal marcaEJB;
    
    @Override
    protected AbstractFacadeInterface<Marca> entidad() {
        return marcaEJB;
    }

    @Override
    protected Marca New() {
        return new Marca();
    }

    @Override
    public AbstractFacadeInterface<Marca> getEntidad() {
        return marcaEJB;
    }
    
}
