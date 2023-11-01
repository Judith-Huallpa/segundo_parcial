package com.emergentes.controller;

import com.emergentes.dao.LibroDAO;
import com.emergentes.dao.LibroDAOimpl;
import com.emergentes.modelo.Libro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JudithEsther
 */
@WebServlet(name = "LibroController", urlPatterns = {"/LibroController"})
public class LibroController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LibroDAO dao = new LibroDAOimpl();
            int id = 0;
            Libro avi = new Libro();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("libro", avi);
                    request.getRequestDispatcher("frmLibros.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("libro", avi);
                    request.getRequestDispatcher("frmLibros.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/LibroController");
                    break;
                case "view":
                    List<Libro> lista = dao.getAll();
                    request.setAttribute("libros", lista);
                    request.getRequestDispatcher("libros.jsp").forward(request, response);
                    break;
                default:
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String disponible = request.getParameter("disponible");
        String categoria = request.getParameter("categoria") ;

        Libro avi = new Libro();

        avi.setId(id);
        avi.setTitulo(titulo);
        avi.setAutor(autor);
        avi.setDisponible(disponible);
        avi.setCategoria(categoria);

        if (id == 0) {
            //nuevo
            try {
                LibroDAO dao = new LibroDAOimpl();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/LibroController");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                LibroDAO dao = new LibroDAOimpl();
                dao.update(avi);
                response.sendRedirect(request.getContextPath()+"/LibroController");    
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
