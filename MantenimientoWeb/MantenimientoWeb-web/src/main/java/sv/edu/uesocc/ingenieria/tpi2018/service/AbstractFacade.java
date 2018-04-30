/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityExistsException;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.AbstractFacadeInterface;
import sv.edu.uesocc.ingenieria.tpi2018.extras.Excepciones;

/**
 *
 * @author ricky
 * @param <T>
 */
public abstract class AbstractFacade<T> {

    protected abstract AbstractFacadeInterface<T> entidad();
    protected abstract T New();
    

    @POST
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T create(T registro) throws Exception {
        if (registro != null) {
            if (entidad() != null) {
                try {
                    T r = entidad().create(registro);
                    if (r != null) {
                        return r;
                    }
                    throw new Excepciones(Excepciones.Message.NOTCREATED);
                } catch (EntityExistsException e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    throw new Excepciones(Excepciones.Message.REPEATED);
                }

            }
            throw new NullPointerException("NULO");
        }
        throw new Excepciones(Excepciones.Message.REQFIELD);
    }
    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<T> findAll(@QueryParam("first") @DefaultValue("0") int first,
            @QueryParam("pagesize") @DefaultValue("0") int pagesize) throws Exception {
        List<T> salida = null;
        if (entidad() != null) {
            if (pagesize == 0) {
                salida = entidad().findAll();
            } else if (pagesize > 0 && first >= 0) {
                salida = entidad().findRange(first, pagesize);
            }
            if (salida == null) {
                throw new Excepciones(Excepciones.Message.INVPAR);
            }
            return salida;
        }
        throw new NullPointerException("NULO");
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T findById(@PathParam("id") int id) throws Exception {
        if (entidad() != null) {
            T encontrado = entidad().findById(id);
            if (encontrado != null) {
                return encontrado;
            }
            throw new Excepciones(Excepciones.Message.IDNOTFOUND);
        }
        throw new NullPointerException("NULO");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T editElement(T registro) throws Exception {

        if (entidad() != null) {
            T salida;
            salida = entidad().edit(registro);
            System.out.println(salida+" es salida");
            if (salida != null) {
                return salida;
            }
           throw new Excepciones(Excepciones.Message.NOTEDITED);
        }
        throw new NullPointerException("NULO");
    }

    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public String deleteElement(@PathParam("id") Integer id) throws Exception {
        if (id > 0) {
            if (entidad() != null) {
                T encontrado = entidad().findById(id);
                if (encontrado != null) {
                    return String.valueOf(entidad().remove(encontrado));
                }
             throw new Excepciones(Excepciones.Message.NOTFOUND);
            }
            throw new NullPointerException("NULO");
        }
        throw new Excepciones(Excepciones.Message.INVPAR);
    }
    
}
