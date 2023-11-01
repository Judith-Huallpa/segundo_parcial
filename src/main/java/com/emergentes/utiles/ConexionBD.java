package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JudithEsther
 */
public class ConexionBD {
    static String driver="com.mysql.cj.jdbc.Driver";
    static String url="jdbc:mysql://localhost:3306/bd_biblioteca";
    static String usuario="root";
    static String password="";
    
    protected Connection conn=null;
    public ConexionBD(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn!= null) {
                System.out.println("Conexion OK: "+conn);
            }
        } catch (SQLException e) {
            System.out.println("Error al conectar "+ e.getMessage());
        }catch(ClassNotFoundException ex){
            System.out.println("Error en driver "+ ex.getMessage());
        }
    }
    public Connection conectar(){
        return conn;
    }
    public void desconectar(){
        System.out.println("Cerrando la BD "+ conn);
        try {
            conn.close();
        } catch (SQLException e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
