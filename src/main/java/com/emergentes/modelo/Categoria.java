package com.emergentes.modelo;

/**
 *
 * @author JudithEsther
 */
public class Categoria {

    int id;
    String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", categoria=" + categoria + '}';
    }
}
