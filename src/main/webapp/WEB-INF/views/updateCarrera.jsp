<%-- 
    Document   : updateCarrera
    Created on : 07/04/2017, 19:37:17
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
        <title>Carrera-Datos</title>
    </head>
    <body>
        <div class="container">
            
            <%@include file="menu.jsp" %>
            
            <div class="row">

                <form:form  modelAttribute="updateCarrera"  class="form-horizontal">
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="nombre">Nombre</label>
                        
                        <form:input 	id="nombre"	path="nombre" type="text" class="form:input-large"/>
                    </div>
                    <div class="form-group" >
                        
                        <label class="control-label col-md-2" for="canNivel">canNivel</label>
                        
                        <form:checkbox	id="canNivel" path="canNivel"  class="form:input-large"/>
                    </div>

                        <div class="form-group">
                            <input type="submit" class="btn btn-primary col-md-offset-2" value="Actualizar"/>
                        </div>
                        
                         
                </form:form >
            </div>

        </div>
            
            <script>
                $(document).ready(function(){
                       activarMenu("/Carreras");
                        
        
                });
               
            </script>
    </body>
</html>