/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;


import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Asuetos;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AsuetosFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("asuetos")
public class AsuetosFacadeREST extends AbstractFacade<Asuetos>{

    @EJB
    protected AsuetosFacadeLocal afl;
    
    @Override
    protected AbstractFacadeInterface<Asuetos> entidad() {
        return afl;
    }

    @Override
    protected Asuetos New() {
        return new Asuetos();
    }

    
}
