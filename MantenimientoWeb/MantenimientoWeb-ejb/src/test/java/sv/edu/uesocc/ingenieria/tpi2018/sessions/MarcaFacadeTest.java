/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.sessions;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.ClassRule;
import org.mockito.internal.util.reflection.Whitebox;
import sv.edu.uesocc.ingenieria.tpi2018.entities.Marca;

/**
 *
 * @author ricky
 */
public class MarcaFacadeTest {
    
  @ClassRule
    public static EntityManagerProvider emp;
    
    static MarcaFacade mf = new MarcaFacade();
   
    @BeforeClass
    public static void init() {
        emp = EntityManagerProvider.persistenceUnit("mantenimiento");
        Whitebox.setInternalState(mf, "em", emp.em());


    }
    public MarcaFacadeTest() {
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void start() {
        mf.getEntityManager().getTransaction().begin();
    }
    
    @After
    public void cleanup() {
            mf.getEntityManager().getTransaction().rollback();
    }

    /**
     * Test of findByName method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindByName() throws Exception {
        System.out.println("findByName");
        mf.getEntityManager().persist(new Marca(1, "Marca1"));
        mf.getEntityManager().persist(new Marca(2, "Modelo2"));
        mf.getEntityManager().persist(new Marca(3, "Marca3"));
        List<Marca> result = mf.findByName("Marca", 0, 3);
        
        System.out.println(result);
        
        assertEquals(2, result.size());
    }

    /**
     * Test of create method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void test_when_create_new_marca_expect_true() throws Exception {
        System.out.println("create true");
        Marca entity = new Marca();
        entity.setMarca("Prueba");
            
        mf.crear(entity);
        
        System.out.println(mf.findAll());
        
        assertEquals(1, mf.findAll().size());
    }
    @Test
    public void test_when_create_null_marca_expect_false() throws Exception {
        System.out.println("create null");

        mf.crear(null);
        
        System.out.println(mf.findAll());
        
        assertEquals(0, mf.findAll().size());
    }


    /**
     * Test of edit method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        mf.getEntityManager().persist(new Marca(1, "Marc1a1"));
        Marca entity = new Marca(1, "Marquita1");
        
        Marca result = mf.edit(entity);
        System.out.println(entity.getMarca() +" vs "+ result.getMarca());
        
        
        assertEquals(entity.getMarca(), result.getMarca());

    }

    /**
     * Test of remove method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemove() throws Exception {
        System.out.println("remove");
        mf.getEntityManager().persist(new Marca(null, "TE BORRARE"));
        mf.getEntityManager().persist(new Marca(null, "NO"));
        
        System.out.println(mf.findAll());
        Marca entity = new Marca(1);
        
        boolean result = mf.eliminar(entity);
        
        assertTrue(result);
    }

    /**
     * Test of findById method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindById() throws Exception {
        System.out.println("findById");
        mf.getEntityManager().persist(new Marca(1, "Marca1"));
        mf.getEntityManager().persist(new Marca(2, "Marca2"));
        mf.getEntityManager().persist(new Marca(3, "Marca3"));
        Marca result = mf.findById(2);
        
        System.out.println(result.getMarca());
        
        assertEquals("Marca2", result.getMarca());

    }

    /**
     * Test of findAll method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindAll() throws Exception {
        System.out.println("findAll");
        mf.getEntityManager().persist(new Marca(1, "Marca1"));
        mf.getEntityManager().persist(new Marca(2, "Marca2"));
        mf.getEntityManager().persist(new Marca(3, "Marca3"));
        mf.getEntityManager().persist(new Marca(4, "Marca4"));
        List<Marca> result = mf.findAll();
        
        System.out.println(mf.findAll());
        
        assertEquals(4, result.size());
    }

    /**
     * Test of count method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testCount() throws Exception {
        System.out.println("count");
        mf.getEntityManager().persist(new Marca(1, "Este es el primero"));
        mf.getEntityManager().persist(new Marca(2, "Este es el segundo"));
        assertEquals(2, mf.count());
    }

    /**
     * Test of findRange method, of class MarcaFacade.
     * @throws java.lang.Exception
     */
    @Test
    public void testFindRange() throws Exception {
        System.out.println("findRange");
        mf.getEntityManager().persist(new Marca(1, "Marca1"));
        mf.getEntityManager().persist(new Marca(2, "Marca2"));
        mf.getEntityManager().persist(new Marca(3, "Marca3"));

        List<Marca> result = mf.findRange(0, 3);
        
        System.out.println(mf.count() +" rango "+ mf.findRange(0, 3));
        
        
        assertEquals(3, result.size());
    }

    
}
