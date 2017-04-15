<%-- 
    Document   : menu
    Created on : 14-abr-2017, 17:58:49
    Author     : malky
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@	taglib	prefix="spring"	uri="http://www.springframework.org/tags"	%>

 <div class="row">
                <nav class="navbar navbar-inverse   navbar-static-top" 
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
                            
                         
                        </div>
                        
                        <div class="navbar-collapse collapse" id="ts-top-menu">
                            <ul class="nav navbar-nav">
                                <li>
                                    
                            <a class="navbar-brand  "	href="<spring:url	value="/"/>"	>
                                    Inicio
                                </a>
                                </li>
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
                                <li ><a	href="<spring:url	value="/Carreras"/>"	>
                                        Carreras
                                    </a>
                                </li>
                                <li ><a	href="<spring:url	value="/Materias"/>"	>
                                        Materias
                                    </a>
                                </li>
                                <li > <a	href="<spring:url	value="/Planes"/>"	>
                                        Planes
                                    </a>
                                </li>
                                 <li ><a	href="<spring:url	value="/MateriaAlumno"/>"	>
                                        Materia - Alumno
                                    </a>
                                </li>
                                 <li ><a	href="<spring:url	value="/Mensajes"/>"	>
                                        Mensajes
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
                                
                            </ul>
                        </div>
                    </div>
                </nav>
            </div>
