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
        resources.add(sv.edu.uesocc.ingenieria.tpi2018.service.MarcaFacadeREST.class);
        resources.add(uesocc.edu.sv.tpi2018.web.exceptions.ControllerExceptionMapper.class);
        resources.add(uesocc.edu.sv.tpi2018.web.exceptions.ExceptionMapper.class);
        resources.add(uesocc.edu.sv.tpi2018.web.exceptions.NotFoundMapper.class);
        resources.add(uesocc.edu.sv.tpi2018.web.filters.cors.CorsFilters.class);
    }
    
}
