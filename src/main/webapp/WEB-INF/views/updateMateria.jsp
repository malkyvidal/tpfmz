<%-- 
    Document   : updateMateria
    Created on : Apr 12, 2017, 6:53:17 PM
    Author     : silvina
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
        <title>Materia-Datos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            
            <div class="row">

                <form:form  modelAttribute="updateMateria"  class="form-horizontal">
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="nombreMateria">Nombre</label>
                        
                        <form:input 	id="nombreMateria"	path="nombreMateria" type="text" class="form:input-large"/>
                    </div>
                    
                     <div class="form-group" >

                        <label class="control-label col-md-2" for="carrera">Carrera</label>
                        <form:select id="carrera" path="carrera.codigoCarrera">
                            <form:options items="${datosCarrera}" itemLabel="nombre" itemValue="codigoCarrera"></form:options>
                        </form:select>
                    </div>
                    <div class="form-group" >
                                               
                        <label class="control-label col-md-2" for="telefono">Modalidad</label>
                        
                        <form:input	id="modalidad" path="modalidad" type="number" name="quantity" min="0" max="2"/>
                    </div>
                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            <script>
                $(document).ready(function(){
                       activarMenu("/Materias");
                        
        
                });
               
            </script>
    </body>
</html>