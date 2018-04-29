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
import uesocc.edu.sv.tpi2018.web.exceptions.ControllerException;

/**
 *
 * @author ricky
 */
public abstract class AbstractFacade<T> {

    protected abstract AbstractFacadeInterface<T> entidad();
    protected T entity;
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
                    throw new ControllerException(ControllerException.Message.REGISTRO_NO_CREADO);
                } catch (EntityExistsException e) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
                    throw new ControllerException(ControllerException.Message.REGISTRO_REPETIDO);
                }

            }
            throw new NullPointerException("Facade null");
        }
        throw new ControllerException(ControllerException.Message.FALTA_CAMPO_REQUERIDO);
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
                throw new ControllerException(ControllerException.Message.PARAMETRO_INVALIDO);
            }
            return salida;
        }
        throw new NullPointerException("Facade null");
    }
    
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T findById(@PathParam("id") int id) throws Exception {
        if (entidad() != null) {
            T salida;
            salida = entidad().findById(id);
            if (salida != null) {
                return salida;
            }
            throw new ControllerException(ControllerException.Message.ID_NO_ENCONTRADO);
        }
        throw new NullPointerException("Facade null");
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T editElement(T registro) throws Exception {
        T salida;
        if (entidad() != null) {
            salida = entidad().edit(registro);
            if (salida != null) {
                return salida;
            }
           throw new ControllerException(ControllerException.Message.REGISTRO_NO_EDITADO);
        }
        throw new NullPointerException("Facade null");
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
             throw new ControllerException(ControllerException.Message.REGISTRO_NO_ENCONTRADO);
            }
            throw new NullPointerException("Facade null");
        }
        throw new ControllerException(ControllerException.Message.PARAMETRO_INVALIDO);
    }
    
}
