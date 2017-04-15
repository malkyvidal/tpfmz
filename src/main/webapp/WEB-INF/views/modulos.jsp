<%-- 
    Document   : modulos
    Created on : Apr 6, 2017, 3:35:42 PM
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

        <title>Modulos</title>
    </head>
    <body>
        <div class="container">
            <%@include file="menu.jsp" %>
            
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos Los Modulos</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Modulos/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>codModulo</th>
                <th>codPermiso</th>
                <th>descripción</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="modulo">
                <tr>
                 
                    

                    <td>${modulo.codModulo}</td>
                       <td>${modulo.permiso.codPermiso}</td>
                       <td>${modulo.descripcion}</td>
                       <td>

                           <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Modulos/eliminar/${modulo.codModulo}'/>">eliminar</a>
                           <a class="btn btn-default" href="<spring:url	value='/Modulos/update/${modulo.codModulo}'/>">editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    <script>
                $(document).ready(function(){
                       activarMenu("/Modulos");
                        
        
                });
               
            </script>
    </body>
</html>
