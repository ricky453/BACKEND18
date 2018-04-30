/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author ricky
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.cors.CorsFilters.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.AsuetosFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.CalendarioFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.CargoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.DetalleEquipoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.DetalleMantenimientoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.DiagnosticoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.DiagnosticoParteFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.EquipoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.EstadoDetalleMantenimientoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.MarcaFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.ModeloFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.OrdenTrabajoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.OrdenTrabajoPorTrabajadoresFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.PasosFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.ProcedimientoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.SolicitudFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.TipoMantenimientoFacadeREST.class);
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.TrabajadoresFacadeREST.class);
    }
    
}
