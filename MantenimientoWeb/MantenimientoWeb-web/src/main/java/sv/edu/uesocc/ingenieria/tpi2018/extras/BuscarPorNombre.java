/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.extras;

import java.util.List;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;

/**
 *
 * @author ricky
 * @param <T>
 */
public interface BuscarPorNombre<T>{
    
    AbstractFacadeInterface<T> getEntidad();
    
    @GET
    @Path("nombre/{name}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    default List<T> findByName(@PathParam("name") String name,
        @QueryParam("first") @DefaultValue("0") int first,
        @QueryParam("pagesize") @DefaultValue("50") int pagesize) {
        if (getEntidad() != null) {
            if (pagesize > 0 && first >= 0) {
                List<T> salida = getEntidad().findByName(name, first, pagesize);
                if (salida != null) {
                    return salida;
                }
            }
        }
        throw new NullPointerException("NULO");
    }
}
