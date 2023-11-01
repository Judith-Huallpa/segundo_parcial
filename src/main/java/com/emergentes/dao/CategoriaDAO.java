package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import java.util.List;

/**
 *
 * @author JudithEsther
 */
public interface CategoriaDAO {
       public void insert(Categoria categoria) throws Exception;
    public void update(Categoria categoria) throws Exception;
    public void delete(int id) throws Exception;
    public Categoria getById(int id) throws Exception;
    public List<Categoria> getAll() throws Exception;  
}
