<%-- 
    Document   : nuevaMateriaAlumno
    Created on : 09/04/2017, 20:08:04
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
        <script src="${pageContext.request.contextPath}/resources/js/app.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Materia-Alumno-Datos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">

                <form:form  modelAttribute="nuevaMateriaAlumno"  class="form-horizontal">
                    <h2 align="center"> Agregar Nueva Materia - Alumno </h2>
                    
                    <div class="form-group" >

                        <label class="control-label col-md-2" for="alumno">Alumno</label>
                        <form:select id="alumno" path="alumno.legajo">
                            <form:options items="${datosAlumnos}" itemLabel="legajo" itemValue="legajo"></form:options>
                        </form:select>
                    </div>
                    <div class="form-group" >

                        <label class="control-label col-md-2" for="materia">Materia</label>
                        <form:select id="materia" path="materia.codMateria">
                            <form:options items="${datosMaterias}" itemLabel="nombreMateria" itemValue="codMateria"></form:options>
                        </form:select>
                    </div>
                    <div class="form-group" >
                        <label class="control-label col-md-2" for="estadoMateria">Estado</label>

                        <form:input 	id="estadoMateria"	path="estadoMateria" type="text" class="form:input-large"/>
                    </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Crear"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            
            <script>
                $(document).ready(function(){
                       activarMenu("/MateriaAlumno");
                        
        
                });
               
            </script>
    </body>
</html>
