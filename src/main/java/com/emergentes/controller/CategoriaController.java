package com.emergentes.controller;

import com.emergentes.dao.CategoriaDAO;
import com.emergentes.dao.CategoriaDAOimp;
import com.emergentes.modelo.Categoria;
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
@WebServlet(name = "CategoriaController", urlPatterns = {"/CategoriaController"})
public class CategoriaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            CategoriaDAO dao = new CategoriaDAOimp();
            int id = 0;
            Categoria avi = new Categoria();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            switch (action) {
                case "add":
                    request.setAttribute("categoria", avi);

                    request.getRequestDispatcher("frmCategorias.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    avi = dao.getById(id);
                    System.out.println(avi);
                    request.setAttribute("categoria", avi);
                    request.getRequestDispatcher("frmCategorias.jsp").forward(request, response);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect(request.getContextPath() + "/CategoriaController");
                    break;
                case "view":
                    List<Categoria> lista = dao.getAll();
                    request.setAttribute("categorias", lista);

                    request.getRequestDispatcher("categorias.jsp").forward(request, response);
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
        String categoria = request.getParameter("categoria");
        Categoria avi = new Categoria();

        avi.setId(id);
        avi.setCategoria(categoria);

        if (id == 0) {
            //nuevo
            try {
                CategoriaDAO dao = new CategoriaDAOimp();
                dao.insert(avi);
                response.sendRedirect(request.getContextPath() + "/CategoriaController");
            } catch (Exception ex) {
                System.out.println("Error " + ex.getMessage());
            }
        } else {
            //edicion
            try {
                CategoriaDAO dao = new CategoriaDAOimp();
                dao.update(avi);
                response.sendRedirect(request.getContextPath() + "/CategoriaController");
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
