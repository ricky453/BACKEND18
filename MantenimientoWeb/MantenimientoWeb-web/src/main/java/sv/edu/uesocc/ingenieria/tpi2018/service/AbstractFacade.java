/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    private final ArrayList<T> lista = new ArrayList<>();


    @POST
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(T registro) {
        if(entidad()!=null){
            T salida = entidad().create(registro);
            if(salida!=null){
                return Response.status(Response.Status.CREATED).entity(registro).build();
            }
            return Response.status(Response.Status.NOT_FOUND)
                .entity(registro).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Entidad nula", this).build();
    }


    @GET
    @Produces({MediaType.APPLICATION_JSON + "; charset=utf-8"})
    public List<T> findAll(){
        if (entidad() != null) {
            return entidad().findAll();
            }
            return lista;
        }   

    
    @GET
    @Path("buscar/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public T findById(@PathParam("id") int id) {
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
    @Path("editar")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response edit(T registro) {
        T salida;
        if(entidad()!=null){
            salida = entidad().edit(registro);
            if(salida !=null){
                return Response.status(Response.Status.OK)
                    .entity(registro).build();
            }
            return Response.status(Response.Status.NOT_FOUND).header("NO EDITADO", this).build();
        }
        return Response.status(Response.Status.NOT_FOUND).header("Entidad nula", this).build();
    }


    @DELETE
    @Path("borrar/{id}")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public String delete(@PathParam("id") Integer id) {
        if (entidad() != null) {
            T encontrado = entidad().findById(id);
            if (encontrado != null) {
              return String.valueOf(entidad().remove(encontrado));                }
         throw new Excepciones(Excepciones.Message.NOTFOUND);
        }
        throw new NullPointerException("NULO");
    }
    
    @GET
    @Path("findRange")
    @Produces(MediaType.APPLICATION_JSON + "; charset=utf-8")
    public List<T> findRange(
           @QueryParam("lower") int low,
           @QueryParam("higher") int high
        ){
        if(entidad()!=null){
            return entidad().findRange(low, high);
        }
        return null;
    }
    
    @GET
    @Path("count")
    @Produces({MediaType.TEXT_PLAIN})
    public int count(){
        if(entidad()!=null){
        return entidad().count();
        }
        return 0;
    }
    
}
