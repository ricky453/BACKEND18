/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.util.ArrayList;
import java.util.List;
import org.mockito.Mockito;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Marca;

/**
 *
 * @author ricky
 */
public class MarcaFacadeRESTTest extends AbstractFacadeTest<Marca>{
    
    final MarcaFacadeREST mockMFR = Mockito.mock(MarcaFacadeREST.class);
    final Marca mockMarca = Mockito.mock(Marca.class);
    Marca m1 = new Marca(1);
    Marca m2 = new Marca(2);

    public MarcaFacadeRESTTest() {
    }
    
    @Override
    protected AbstractFacade<Marca> resource() {
        return mockMFR;
    }

    @Override
    protected Marca entity() {
        return new Marca(1);
    }

    @Override
    protected List<Marca> lista() {
        List<Marca> listaMarca = new ArrayList<>();
        listaMarca.add(m1);
        listaMarca.add(m2);
        return listaMarca;
    }

    @Override
    protected String nombre() {
        return "nombre"; //To change body of generated methods, choose Tools | Templates.
    }


    
}
