<%-- 
    Document   : frmLibros
    Created on : 31-oct-2023, 21:02:35
    Author     : JudithEsther
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Libro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.emergentes.modelo.Libro" %>
<%
    Libro libro = (Libro) request.getAttribute("libro");
%>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
    <h1>Nuevo Registro</h1>
    <form action="LibroController" method="post">
        <input type="hidden" name="id" value="${libro.getId()}" />
        <table>
            <tr>
                <td>Titulo:</td>
                <td><input type="text" name="titulo" value="${libro.getTitulo()}"/></td>
            </tr>
            <tr>
                <td>Autor:</td>
                <td><input type="text" name="autor" value="${libro.getAutor()}"/></td>
            </tr>
            <tr>
                <td>Disponible:</td>
                <td><input type="text" name="disponible" value="${libro.getDisponible()}"/></td>
            </tr>
            <tr>
                <td>Categoria:</td>
                <td><input type="text" name="categoria" value="${libro.getCategoria()}"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit"/></td>
            </tr>
        </table>
    </form>
</body>
</html>