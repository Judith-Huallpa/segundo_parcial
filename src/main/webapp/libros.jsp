<%-- 
    Document   : avisos
    Created on : 31-oct-2023, 21:01:59
    Author     : JudithEsther
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--
    List<Libro> libros = (List<Libro>) request.getAttribute("libros");

--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>LIBROS</h1>
        <p><a href="LibroController?action=add">Nuevo</a></p>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Titulo</th>
                <th>Autor</th>
                <th>Disponible</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${libros}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>            
                    <td>${item.disponible}</td>
                    <td>${item.categoria}</td>
                    <td><a href="LibroController?action=edit&id=${item.id}">Editar</a></td>
                    <td><a href="LibroController?action=delete&id=${item.id}" onclick="return(confirm('Esta seguro?'))">Eliminar</a></td>
                </tr>
            </c:forEach>                       
        </table>
    </body>
</html>