/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.util.List;
import javax.ws.rs.core.Response;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;

/**
 *
 * @author ricky
 * @param <T>
 */
public abstract class AbstractFacadeTest<T>  {
    protected abstract AbstractFacade<T> resource();
    protected abstract T entity();
    protected abstract List<T> lista();
    protected abstract String nombre();

    
    public AbstractFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        Mockito.when(resource().findAll()).thenReturn(lista());
        Mockito.when(resource().findById(1)).thenReturn(entity());
        Mockito.when(resource().count()).thenReturn(2);
        Mockito.when(resource().findRange(1, 5)).thenReturn(lista());
        Mockito.when(resource().create(entity())).thenReturn(Response.status(Response.Status.CREATED).entity(entity()).build());
        Mockito.when(resource().editElement(entity())).thenReturn(Response.status(Response.Status.OK).build());
        Mockito.when(resource().deleteElement(1)).thenReturn(Response.status(Response.Status.OK).build());
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of create method, of class AbstractFacade.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        AbstractFacade resource = resource();
        Response result = resource.create(entity());
        assertEquals(Response.status(201).build().getStatus(), result.getStatus());
        Mockito.verify(resource, times(1)).create(entity());

    }

    /**
     * Test of findAll method, of class AbstractFacade.
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        AbstractFacade resources = resource();
        List<T> result = resources.findAll();
        System.out.println(result);
        assertThat(result, CoreMatchers.notNullValue());

    }

    /**
     * Test of findById method, of class AbstractFacade.
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        AbstractFacade resource = resource();
        T result = (T) resource.findById(1);
        assertEquals(entity(), result);

    }

    /**
     * Test of editElement method, of class AbstractFacade.
     */
    @Test
    public void testEditElement() throws Exception {
        System.out.println("editElement");
        AbstractFacade resource = resource();
        Response result = resource.editElement(entity());
        assertEquals(Response.status(200).build().getStatus(), result.getStatus());
        Mockito.verify(resource, times(1)).editElement(entity());

    }

    /**
     * Test of deleteElement method, of class AbstractFacade.
     */
    @Test
    public void testDeleteElement() throws Exception {
        System.out.println("deleteElement");
        AbstractFacade resource = resource();
        Response result = resource.deleteElement(1);
        assertEquals(Response.status(200).build().getStatus(), result.getStatus());
        Mockito.verify(resource, times(1)).deleteElement(1);

    }

    /**
     * Test of findRange method, of class AbstractFacade.
     */
        @Test
        public void testFindRange() {
            System.out.println("findRange");
            AbstractFacade resource = resource();
            List<T> result = resource.findRange(0, 2);
            assertThat(result, CoreMatchers.notNullValue());
    
        }

    /**
     * Test of count method, of class AbstractFacade.
     */
    @Test
    public void testCount() {
        System.out.println("count");
        AbstractFacade resource = resource();
        int result = resource.count();
        assertEquals(lista().size(), result);

    }
    
}
