/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Diagnostico;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.DiagnosticoFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("diagnostico")
public class DiagnosticoFacadeREST extends AbstractFacade<Diagnostico> {

    @EJB
    protected DiagnosticoFacadeLocal diagnosticoEJB;
    
    @Override
    protected AbstractFacadeInterface<Diagnostico> entidad() {
        return diagnosticoEJB;
    }

    @Override
    protected Diagnostico New() {
        return new Diagnostico();
    }
    
}
