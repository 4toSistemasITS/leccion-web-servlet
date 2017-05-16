<%-- 
    Document   : index
    Created on : 13-may-2017, 19:04:25
    Author     : Bianca_Valentina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form action="Ms_Servlet_aplicacion" method="POST">
        <h1>Hello World!</h1>
        Especialidad: <input type="text" name="Identificacion"/></br>
        Nombre: <input type="text" name="Nombre"/></br>
        <input type="submit" value="Guardar Usuario"/></br>
        </form>
       
         <form action="Ms_Servlet_aplicacion" method="GET">
             
             
        <input type="submit" value="Consultar"/>
        
         
         </form>
       
        
    </body>
</html>
