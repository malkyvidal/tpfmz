<%-- 
    Document   : welcome
    Created on : 11/03/2017, 17:16:32
    Author     : malky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"	%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>

        <title>Inicio</title>
    </head>
    <body>
        <div class="container" >
            
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
                                <li > <a	href="<spring:url	value="/Alumnos"/>"	>
                                        Alumnos
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/Coordinadores"/>"	>
                                        Coordinadores
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/AdminAlumno"/>"	>
                                        Admnistrador Alumno
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
                                <li > <a	href="<spring:url	value="/Planes"/>"	>
                                        Planes
                                    </a>
                                </li>
                                 <li class="active"><a	href="<spring:url	value="/MateriaAlumno"/>"	>
                                        Materia - Alumno
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/Perfiles"/>"	>
                                        Perfiles
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/Permisos"/>"	>
                                        Permisos
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/Modulos"/>"	>
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
                <div class="app jumbotron">
                    <h1>Sistema de Seguimiento de Alumnos</h1>
                </div>

            </div>
            
        </div>
    </body>
</html>
