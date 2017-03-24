<%-- 
    Document   : welcome
    Created on : 11/03/2017, 17:16:32
    Author     : malky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <title></title>
    </head>
    <body>
          <section>
            <div class="jumbotron">
                <div class="container" >
                    <h1>Estados Materias</h1>
                    <p>En la base ahora hay  ${estados} Estados</p>                                      
                </div>
            </div>
            <div class="jumbotron">
                <div class="container" >
                    <h1>Planes</h1>
                    <p>En la base ahora hay  ${plan} planes</p>                                      
                </div>
            </div>
             <div class="jumbotron">
                <div class="container" >
                    <h1>Materias Plan</h1>
                    <p>En la base ahora hay  ${materiasAlumno} Materias de Planes</p>                                      
                </div>
            </div>   
        </section>
    </body>
</html>
