package com.emergentes.dao;

import com.emergentes.modelo.Categoria;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JudithEsther
 */
public class CategoriaDAOimp extends ConexionBD implements CategoriaDAO{

    @Override
    public void insert(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO categorias (categoria) VALUES (?);");
            ps.setString(1, categoria.getCategoria());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Categoria categoria) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE categorias SET categoria = ? WHERE id = ?;");
            ps.setString(1, categoria.getCategoria());  
            ps.setInt(2, categoria.getId());            

            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("delete from categorias  where id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Categoria getById(int id) throws Exception {
        Categoria cat = new Categoria();
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("select * from categorias where id = ? limit 1");

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cat.setId(rs.getInt("id"));
                cat.setCategoria(rs.getString("categoria"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cat;
    }

    @Override
    public List<Categoria> getAll() throws Exception {
        List<Categoria> lista = null;
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM categorias");

            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Categoria>();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setCategoria(rs.getString("categoria"));

                lista.add(cat);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }
    
}
