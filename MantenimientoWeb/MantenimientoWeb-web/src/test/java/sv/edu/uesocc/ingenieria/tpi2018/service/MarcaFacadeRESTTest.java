/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Marca;
import sv.edu.uesocc.ingenieria.tpi2018.extras.Excepciones;
import sv.edu.uesocc.ingenieria.tpi2018.sessions.MarcaFacadeLocal;

/**
 *
 * @author ricky
 */
@RunWith(MockitoJUnitRunner.Silent.class)
public class MarcaFacadeRESTTest{
    
    public MarcaFacadeRESTTest(){
        
    }
     
    @InjectMocks
    public static MarcaFacadeREST marcaFacade = new MarcaFacadeREST();
    public static InMemoryRestServer server;
    public final  Marca marca = new Marca(1, "HP", true);
    
    @Mock
    MarcaFacadeLocal mfl;

    
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        //server = InMemoryRestServer.create(marcaFacade);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
        server = InMemoryRestServer.create(marcaFacade);
    }
    
    @After
    public void tearDown() {
        server.close();
    }
    
    /**
     * Test of findByName method, of class MarcaFacadeREST.
     */
    @Test
    public void testFindByName() {
        System.out.println("testFindByName");
        List<Marca> list = new ArrayList<>();
        list.add(new Marca(2, "MARCA", true));
        list.add(new Marca(3, "MARCA", true));
        Mockito.when(this.mfl.findByName(Matchers.anyString(), Matchers.anyInt(), Matchers.anyInt())).thenReturn(list);
        Response response = server.newRequest("/marca/nombre/Marca").request().buildGet().invoke();
        List<Marca> lista = response.readEntity(new GenericType<List<Marca>>() {
        });
        int result = lista.size();
        assertEquals(2, result);
    }
    
    /**
     * Test of create method, of class MarcaFacadeREST.
     */
    @Test
    public void testCreate() {
        System.out.println("testCreate");
        Mockito.when(this.mfl.create(Matchers.any(Marca.class))).thenReturn(marca);
        Marca nmarca = new Marca(null, "Marca 2", true);
        Response response = server.newRequest("/marca").request().buildPost(Entity.entity(nmarca, MediaType.APPLICATION_JSON)).invoke();
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }
        
    /**
     * Test of findById method, of class MarcaFacadeREST.
     */
    @Test
    public void testFindById() {
        System.out.println("testFindById");
        Marca nmarca = new Marca(4, "Marca 4", true);
        server.newRequest("/marca").request().buildPost(Entity.entity(nmarca, MediaType.APPLICATION_JSON)).invoke();
        Mockito.when(this.mfl.findById(Matchers.anyInt())).thenReturn(nmarca);
        Response response = server.newRequest("/marca/buscar/4").request().buildGet().invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    @Test
    public void test_find_by_id_null() {
        System.out.println("testFindById");
        server.newRequest("/marca").request().buildPost(Entity.entity(null, MediaType.APPLICATION_JSON)).invoke();
        Mockito.when(this.mfl.findById(Matchers.anyInt())).thenReturn(null);
        Response response = server.newRequest("/marca/buscar/4").request().buildGet().invoke();
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }
     /**
     * Test of findById method, of class MarcaFacadeREST.
     */
    @Test
    public void testEdit() {
        System.out.println("testEdit");
        Marca newMarca = new Marca(1, "Marco", true);
        Mockito.when(this.mfl.edit(Matchers.any(Marca.class))).thenReturn(newMarca);
        Response response = server.newRequest("/marca/editar").request().buildPut(Entity.entity(newMarca, MediaType.APPLICATION_JSON)).invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }
    /**
     * Test of delete method, of class MarcaFacadeREST.
     */
   @Test
    public void test_delete_if_not_exists() {
        Mockito.when(this.mfl.findById(Matchers.anyInt())).thenReturn(null);
        Response response = server.newRequest("/marca/borrar/1").request().buildDelete().invoke();
        assertEquals(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), response.getStatus());
    }

    @Test
    public void test_delete_if_exists() {
        Mockito.when(this.mfl.findById(Matchers.anyInt())).thenReturn(marca);
        Mockito.when(this.mfl.remove(Matchers.any(Marca.class))).thenReturn(true);
        Response response = server.newRequest("/marca/borrar/1").request(MediaType.APPLICATION_JSON).buildDelete().invoke();
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    /**
     * Test of findByRange method, of class MarcaFacadeREST.
     */
    @Test
    public void testFindAll() {
        System.out.println("testFindAll");
        List<Marca> list = new ArrayList<>();
        list.add(marca);
        list.add(new Marca(2, "LENOVO", true));
        list.add(new Marca(3, "ASUS", true));
        Mockito.when(this.mfl.findAll()).thenReturn(list);
        Response response = server.newRequest("/marca").request().buildGet().invoke();      
        List<Marca> lista = response.readEntity(new GenericType<List<Marca>>() {
        });
        assertEquals(lista.size(), 3);
        assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
    }
        /**
     * Test of testFindByRange method, of class MarcaFacadeREST.
     */
    @Test
    public void testFindByRange() {
        System.out.println("testFindByRange");
        List<Marca> list = new ArrayList<>();
        list.add(marca);
        list.add(new Marca(2, "LENOVO", true));
        list.add(new Marca(3, "ASUS", false));
        Mockito.when(this.mfl.findRange(Matchers.anyInt(), Matchers.anyInt())).thenReturn(list);
        Response response = server.newRequest("/marca/findRange?lower=0&higher=3").request().buildGet().invoke();
        List<Marca> count = response.readEntity(new GenericType<List<Marca>>() {
        });
        int result = count.size();
        assertEquals(3, result);
    }
    
}
