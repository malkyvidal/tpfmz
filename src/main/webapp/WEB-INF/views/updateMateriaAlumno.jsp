<%-- 
    Document   : updateMateriaAlumno
    Created on : 10/04/2017, 19:27:12
    Author     : franco
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib	prefix="spring"	uri="http://www.springframework.org/tags"%>
<%@	taglib	prefix="form"	uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
        <link href="<c:url value="/resources/css/app.css" />" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alumno-Datos</title>
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

                <form:form  modelAttribute="updateMateriaAlumno"  class="form-horizontal">
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="alumno">Alumno</label>
                       <td>${materiaalumno.alumno.legajo}</td>
                        <form:select id="alumno" path="alumno.legajo">
                            <form:options items="${datosAlumnos}" itemLabel="legajo" itemValue="legajo"></form:options>
                        </form:select>
                    </div>
                     <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="materia">Materia</label>
                       <td>${materiaalumno.materia.codMateria}</td>
                        <form:select id="materia" path="materia.codMateria">
                            <form:options items="${datosMaterias}" itemLabel="nombreMateria" itemValue="codMateria"></form:options>
                        </form:select>
                    </div>    
                    
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="estadoMateria">Estado</label>
                        <td>${materiaalumno.estadoMateria}</td>
                        <form:input	id="estadoMateria" path="estadoMateria" type="text" class="form:input-large"/>
                    </div>
                 

                   
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
    </body>
</html>