/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uesocc.edu.sv.tpi2018.web.exceptions;

import java.util.logging.Logger;
import java.util.logging.Level;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author danm
 */
@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {

    public EnumControllerException messages;
    
    @Override
    public Response toResponse(Throwable exception) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, exception.getMessage(), exception);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).header("server-exception", exception.getMessage()).build();
    }
}
