/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.sessions;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.BeforeClass;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author ricky
 */
public class EntityManagerProvider implements TestRule{
    
        protected static EntityManagerFactory emf;
        protected static EntityManager em;
        protected static EntityTransaction tx;
        public static EntityManagerProvider emp;

        public EntityManagerProvider(String man){
            this.em = Persistence.createEntityManagerFactory(man).createEntityManager();
            this.tx = this.em.getTransaction();
        }
        
        public static EntityManagerProvider persistenceUnit(String man){
            if(emp == null){
                emp = new EntityManagerProvider(man);
            }
            return emp;
        }
        
        @BeforeClass
        public static void init(){
            emf=Persistence.createEntityManagerFactory("mantenimiento");
            em=emf.createEntityManager();
            tx=em.getTransaction();
        }

        
        
        public EntityManager em(){
            return em;
        }
        
        public EntityTransaction tx() {
        return tx;
    }

    @Override
    public Statement apply(final Statement stmnt, Description d) {
        return new Statement() {

            @Override
            public void evaluate() throws Throwable {
                stmnt.evaluate();
                em.clear();
                em.close();
            }

        };
    }
    public static void setEmp(EntityManagerProvider emp) {
        EntityManagerProvider.emp = emp;
    }
    
}