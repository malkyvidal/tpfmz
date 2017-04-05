<%-- 
    Document   : nuevoAlumno
    Created on : 30-mar-2017, 20:31:05
    Author     : malky
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
                                <li><a href="#">Category 2</a>
                                </li>
                                <li><a href="#">Category 3</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
            <div class="row">

                <form:form  modelAttribute="nuevoAlumno"  class="form-horizontal">
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="email">Email</label>

                        <form:input 	id="email"	path="email" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="telefono">Telefono</label>
                        <form:input	id="telefono" path="telefono" type="text" class="form:input-large"/>
                    </div>


                    <div class="form-group" >
                        <label class="control-label col-md-2" for="contrasenia">Password</label>
                        <form:input	id="contrasenia" path="contrasenia" type="password" class="form:input-large"/>

                    </div>

                   

                    <div class="form-group" >

                        <label class="control-label col-md-2" for="plan">Password</label>
                        <form:select id="plan" path="plan.identificador">
                            <form:options items="${datosPlanes}" itemLabel="nombre" itemValue="identificador"></form:options>
                        </form:select>
                    </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Crear"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
    </body>
</html>