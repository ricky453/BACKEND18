/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.uesocc.ingenieria.tpi2018.sessions;

import java.util.List;

/**
 *
 * @author ricky
 */
public interface AbstractFacadeInterface<T> {
        
    public T create(T entity);
    
    public T edit(T entity);
    
    public T remove(T entity);
    
    public boolean crear (T entity);
       
    public boolean editar (T entity);
    
    public boolean eliminar(T entity);

    public T findById(Object id);
    
    public List<T> findByName(String name, int first, int pagesize);

    public List<T> findAll();
    
    public List<T> findRange(int first, int pageSize);

    public int count();
}
