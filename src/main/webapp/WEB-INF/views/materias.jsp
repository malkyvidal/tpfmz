<%-- 
    Document   : materias
    Created on : Apr 11, 2017, 6:18:56 PM
    Author     : silvina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Materias</title>
    </head>
    <body>
      <div class="container">
          
          <%@include file="menu.jsp" %>
          
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todas las Materias</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Materias/nueva"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>Código</th>
                <th>Nombre</th>
                <th>Carrera</th>
                <th>Modalidad</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="materia">
                <tr>
                 
                    

                       <td>${materia.codMateria}</td>
                       <td>${materia.nombreMateria}</td>
                       <td>${materia.carrera.codigoCarrera}</td>
                       <td>${materia.modalidad}</td>
                       <td>

                           <a class="btn btn-danger custom-width" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Materias/eliminar/${materia.codMateria}'/>">Eliminar</a>
                           <a class="btn btn-success custom-width" href="<spring:url	value='/Materias/update/${materia.codMateria}'/>">Editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                      <script>
                $(document).ready(function(){
                       activarMenu("/Materias");
                        
        
                });
               
            </script>
    </body>
</html>
