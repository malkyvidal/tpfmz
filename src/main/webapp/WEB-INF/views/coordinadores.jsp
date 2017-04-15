<%-- 
    Document   : coordinador
    Created on : Apr 9, 2017, 7:02:04 PM
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

        <title>Coordinadores</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">
                

                <div >
                    <div class="col-md-4">
                        <h4>Todos Los Coordinadores</h4>
                    </div>
                    <div class="col-md-offset-10">
                        <a class="btn btn-primary" href="<spring:url	value="/Coordinadores/nuevo"/>"  >Nuevo</a>
                    </div>
                    
                </div>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>legajo</th>
                <th>nroResolución</th>
                <th>especialidad</th>
                <th>plan</th>
                <th>perfil</th>
                <th>fechaAlta</th>
                <th>fechaBaja</th>
                <th>Acción</th>
            </tr>
            <c:forEach  items="${datos}" var="coordinador">
                <tr>                

                    <td>${coordinador.legajo}</td>
                    <td>${coordinador.nroResolucion}</td>
                    <td>${coordinador.especialidad}</td>
                    <td>${coordinador.plan.identificador}</td>
                    <td>${coordinador.perfil.codPerfil}</td>
                    <td>${coordinador.fechaAlta}</td>
                    <td>${coordinador.fechaBaja}</td>
                       <td>

                           <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url	value='/Coordinadores/eliminar/${coordinador.legajo}'/>">eliminar</a>
                           <a class="btn btn-default" href="<spring:url	value='/Coordinadores/update/${coordinador.legajo}'/>">editar</a>
                       </td>
                </tr>
            </c:forEach>
        </table>
                    
		

            </div>
        </div>
                    <script>
                $(document).ready(function(){
                       activarMenu("/Coordinadores");
                        
        
                });
               
            </script>
    </body>
</html>
