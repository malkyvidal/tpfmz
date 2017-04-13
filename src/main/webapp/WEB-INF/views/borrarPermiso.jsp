<%-- 
    Document   : borrarPermiso
    Created on : Apr 8, 2017, 6:42:50 PM
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Eliminación de un Permiso</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <nav class="navbar navbar-inverse navbar-static-top"
                     role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#ts-top-menu">
                                <span class="sr-only">
                                    Navigation buttons
                                </span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                                <span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand "	href="<spring:url	value="/"/>"	>
                                Inicio
                            </a>
                        </div>

                        <div class="navbar-collapse collapse" id="ts-top-menu">
                            <ul class="nav navbar-nav">
                                <li class="active"><a	href="<spring:url	value="/Alumnos"/>"	>
                                        Alumnos
                                    </a>
                                </li>
                                <li class="active"><a	href="<spring:url	value="/Coordinadores"/>"	>
                                        Coordinadores
                                    </a>
                                </li>
                                
                                <li class="active"><a	href="<spring:url	value="/Carreras"/>"	>
                                        Carreras
                                    </a>
                                </li>
                                <li class="active"><a	href="<spring:url	value="/Materias"/>"	>
                                        Materias
                                    </a>
                                </li>
                                <li class="active"><a	href="<spring:url	value="/Planes"/>"	>
                                        Planes
                                    </a>
                                </li>
                                <li class="active"><a	href="<spring:url	value="/Perfiles"/>"	>
                                        Perfiles
                                    </a>
                                </li>
                               <li class="active"><a	href="<spring:url	value="/Permisos"/>"	>
                                        Permisos
                                    </a>
                                </li>
                                <li class="active"><a	href="<spring:url	value="/Modulos"/>"	>
                                        Modulos
                                    </a>
                                </li>
                                <li><a href="#">Category 3</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="row">
                

               
                    <div class="col-md-4">
                        <h4>Todos Los Modulos que serán eliminados</h4>
                    </div>
                       <a class="btn btn-default" onclick="return confirm('Seguro que desea eliminar?')" href="<spring:url value='/Permisos/borrar/${codPermi}'/>">eliminar</a>
                 <table class="table table-striped">
                     
            <tr>
                
                <th>codModulo</th>
                <th>codPermiso</th>
                <th>descripción</th>
                
            </tr>
            <c:forEach  items="${detalleModulos}" var="modulo">
                <tr>
                                     
                    <td>${modulo.codModulo}</td>
                       <td>${modulo.permiso.codPermiso}</td>
                       <td>${modulo.descripcion}</td>

                           
       
                       </td>
                </tr>
            </c:forEach>
                
        </table>
                    
	    </div>
        </div>
    </body>
</html>

