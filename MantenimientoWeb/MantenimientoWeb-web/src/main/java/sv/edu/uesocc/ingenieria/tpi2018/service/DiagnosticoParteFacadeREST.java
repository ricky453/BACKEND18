/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import javax.ejb.EJB;
import javax.ws.rs.Path;
import sv.edu.uesocc.ingenieria.tpi2018.entities.DiagnosticoParte;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.DiagnosticoParteFacadeLocal;

/**
 *
 * @author ricky
 */

@Path("diagnosticoparte")
public class DiagnosticoParteFacadeREST extends AbstractFacade<DiagnosticoParte> {

    @EJB
    protected DiagnosticoParteFacadeLocal dfEJB;
    
    @Override
    protected AbstractFacadeInterface<DiagnosticoParte> entidad() {
        return dfEJB;
    }

    @Override
    protected DiagnosticoParte New() {
        return new DiagnosticoParte();
    }
    
}
