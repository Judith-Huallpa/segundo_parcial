<%-- 
    Document   : categorias
    Created on : 31-oct-2023, 21:03:15
    Author     : Judith Esther
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.emergentes.modelo.Categoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Categoria categoria = (Categoria)request.getAttribute("categoria");
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Nuevo Registro</h1>
        <form action="CategoriaController" method="post">
            <input type="hidden" name="id" value="${categoria.id}" />
            <table>
                <tr>
                    <td>Categoria:</td>
                    <td><input type="text" name="categorias" value="${categoria.categoria}"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit"/></td>
                </tr>              
            </table>            
        </form> 

    </body>

</html>
